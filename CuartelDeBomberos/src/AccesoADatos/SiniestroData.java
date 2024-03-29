package AccesoADatos;

import Entidades.Emergencia;
import Entidades.Siniestro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SiniestroData {

    private Connection con = null;
    private Emergencia emergencia;

    public SiniestroData() {
    }

    public void agregarSiniestro(Siniestro siniestro) {

        emergencia = siniestro.getTipoEmergencia();

        String sql = "INSERT INTO siniestro(tipo, fecha_siniestro, cod_x, cod_y, detalle, cod_brigada, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = Conexion.getConexion();

            PreparedStatement ps;
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, emergencia.getId());
            ps.setDate(2, java.sql.Date.valueOf(siniestro.getFecha()));
            ps.setInt(3, siniestro.getCoordX());
            ps.setInt(4, siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
            ps.setInt(6, siniestro.getCodBrigada());
            ps.setBoolean(7, true);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Siniestro agregado con el ID: " + rs.getInt(1), "Información", 1);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro.", "Error", 0);
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    public void eliminarSiniestro(int id) {

        String sql = "UPDATE siniestro SET estado = ? WHERE codigo = ?";

        try {
            con = Conexion.getConexion();

            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int fm = ps.executeUpdate();

            if (fm > 0) {
                JOptionPane.showMessageDialog(null, "Siniestro eliminado.", "Información", 1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro.", "Error", 0);
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    public void modificarSiniestro(Siniestro siniestro) {

        emergencia = siniestro.getTipoEmergencia();

        String sql = "UPDATE siniestro SET tipo = ?, fecha_siniestro = ?, cod_x = ?, cod_y = ?"
                + ",detalle = ?, fecha_resol = ?, puntuacion = ?, cod_brigada = ?, estado = ? WHERE codigo = ?";

        try {
            con = Conexion.getConexion();

            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ps.setInt(1, emergencia.getId());
            ps.setDate(2, java.sql.Date.valueOf(siniestro.getFecha()));
            ps.setInt(3, siniestro.getCoordX());
            ps.setInt(4, siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());

            if (siniestro.getFechaResolucion() != null) {
                ps.setDate(6, java.sql.Date.valueOf(siniestro.getFechaResolucion()));
            } else {
                ps.setDate(6, null);
            }
            ps.setInt(7, siniestro.getPuntuacion());
            ps.setInt(8, siniestro.getCodBrigada());
            ps.setBoolean(9, siniestro.isEstado());
            ps.setInt(10, siniestro.getCodigo());

            int fm = ps.executeUpdate();

            if (siniestro.getPuntuacion() > 0) {
                JOptionPane.showMessageDialog(null, "Siniestro ID: " + siniestro.getCodigo() + ". Se cerro con éxito.", "Información", 1);
                return;
            }

            if (fm > 0) {
                JOptionPane.showMessageDialog(null, "Siniestro ID: " + siniestro.getCodigo() + ". Se modificó con éxito.", "Información", 1);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro.", "Error", 0);
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    public ArrayList<Siniestro> mostrarPorFecha(LocalDate fecha) {

        emergencia = null;
        EmergenciaData emergData = new EmergenciaData();

        ArrayList<Siniestro> listadoPorFecha = new ArrayList<>();

        String sql = "SELECT * FROM siniestro WHERE fecha_siniestro = ?";

        try {
            con = Conexion.getConexion();

            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ps.setDate(1, java.sql.Date.valueOf(fecha));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                emergencia = emergData.buscarEmergencia(rs.getInt("tipo"));

                LocalDate fecha_resol = null;

                if (rs.getDate("fecha_resol") != null) {
                    fecha_resol = rs.getDate("fecha_resol").toLocalDate();
                }

                listadoPorFecha.add(new Siniestro(
                        rs.getInt("codigo"),
                        emergencia,
                        rs.getDate("fecha_siniestro").toLocalDate(),
                        rs.getInt("cod_x"),
                        rs.getInt("cod_y"),
                        rs.getString("detalle"),
                        fecha_resol,
                        rs.getInt("puntuacion"),
                        rs.getInt("cod_brigada"), rs.getBoolean("estado")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro.", "Error", 0);
        } finally {
            Conexion.cerrarConexion(con);
        }

        return listadoPorFecha;
    }

    public ArrayList<Siniestro> listarSiniestro() {
        emergencia = null;
        EmergenciaData emergData = new EmergenciaData();

        ArrayList<Siniestro> listadoSiniestros = new ArrayList<>();

        String sql = "SELECT * FROM siniestro";

        try {
            con = Conexion.getConexion();

            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                emergencia = emergData.buscarEmergencia(rs.getInt("tipo"));

                LocalDate fecha_resol = null;

                if (rs.getDate("fecha_resol") != null) {
                    fecha_resol = rs.getDate("fecha_resol").toLocalDate();
                }

                listadoSiniestros.add(new Siniestro(
                        rs.getInt("codigo"),
                        emergencia,
                        rs.getDate("fecha_siniestro").toLocalDate(),
                        rs.getInt("cod_x"),
                        rs.getInt("cod_y"),
                        rs.getString("detalle"),
                        fecha_resol,
                        rs.getInt("puntuacion"),
                        rs.getInt("cod_brigada"), rs.getBoolean("estado")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro.", "Error", 0);
        } finally {
            Conexion.cerrarConexion(con);
        }
        return listadoSiniestros;
    }

    public Siniestro siniestroPorID(int id) {
        emergencia = null;
        EmergenciaData emergData = new EmergenciaData();
        Siniestro siniestro = new Siniestro();

        String sql = "SELECT * FROM siniestro WHERE codigo = ?";

        try {
            con = Conexion.getConexion();

            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                emergencia = emergData.buscarEmergencia(rs.getInt("tipo"));

                LocalDate fecha_resol = null;

                if (rs.getDate("fecha_resol") != null) {
                    fecha_resol = rs.getDate("fecha_resol").toLocalDate();
                }
                
                siniestro.setCodigo(id);
                siniestro.setTipoEmergencia(emergencia);
                siniestro.setFecha(rs.getDate("fecha_siniestro").toLocalDate());
                siniestro.setCoordX(rs.getInt("cod_x"));
                siniestro.setCoordY(rs.getInt("cod_y"));
                siniestro.setDetalles(rs.getString("detalle"));
                siniestro.setFechaResolucion(fecha_resol);
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
                siniestro.setCodBrigada(rs.getInt("cod_brigada"));
                siniestro.setEstado(rs.getBoolean("estado"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro.", "Error", 0);
        } finally {
            Conexion.cerrarConexion(con);
        }
        return siniestro;
    }

}
