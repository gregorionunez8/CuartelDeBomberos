/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Bombero;
import Entidades.Brigada;
import Entidades.Emergencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Natasha
 */
public class BrigadaData{
        // se creo la variable de tipo conexion
        private Connection con = null; 
        Emergencia emergencia= new Emergencia ();
                
    public void agregarBrigada(Brigada brigada){
        // sentencia sql
       
        String sql = "INSET INTO brigada (nombre_br,especialidad,libre,numeroCuartel)VALUE(?,?,?,? )";
       
        // creo una conexion con mi base de dato
        try{
        con = Conexion.getConexion ();
       
        // consulta sql
        PreparedStatement ps = con.prepareStatement(sql);
        // le asigno los valores
        ps.setString(1, brigada.getNombreBrigada());
        ps.setInt(2, brigada.getEspecialidad().getId());
        ps.setBoolean(3,true);
        ps.setInt(4, brigada.getNumeroCuartel());
        ps.executeUpdate(); // Ejecutar PreparedStatement
        JOptionPane.showMessageDialog(null, "brigada se exitosamente.", "Información", 1);
        ps.close();

        }catch(SQLException  ex){
       JOptionPane.showMessageDialog(null, "Error al insertar brigada" + ex.getMessage(), "Error", 0);
       }finally{
            
      
       
        // cierro mi conexion
        Conexion.cerrarConexion(con);
    }
}
    // modificar brigada
    public void modificarBrigada(Brigada brigada) {
        String sql = "UPDATE brigada SET nombre_br=?,especialidad=?,libre=?,numeroCuartel=? WHERE id -brigada=?";
        try {
            //creo una conexion con mi base de datos
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            // le asigno los valores 
            ps.setString(1, brigada.getNombreBrigada());
        ps.setInt(2, brigada.getEspecialidad().getId());
        ps.setBoolean(3,true);
        ps.setInt(4, brigada.getNumeroCuartel());
        ps.executeUpdate(); // Ejecutar PreparedStatement
        JOptionPane.showMessageDialog(null, "brigada se modifico exitosamente.", "Información", 1);
        ps.close();
            
            
            
         
            ps.executeUpdate(); // Ejecutar PreparedStatement
            JOptionPane.showMessageDialog(null, "brigada modificada con éxito", "Información", 1);
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el brigada", "Error", 0);
        }
        //cierro mi conexion 
        Conexion.cerrarConexion(con);
    }
    
       // elimino brigada
    public void eliminarBrigada(int id) {
        //ESTA VARIBLE REPRESENTA MI SENTENCIA SQL
        String sql = "UPDATE brigada SET estado=false WHERE id_brigada=" + id;
        try {
            //CREO UNA CONEXION CON MI BASE DE DATOS
            con = Conexion.getConexion();
            //ENVIO LA SENTENCIA SQL Y LA EJECUTO
            PreparedStatement ps = con.prepareStatement(sql);
            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Brigada eliminado", "Información", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Imposible eliminar el Brigada", "Información", 1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar" + ex.getMessage(), "Error", 0);
        }
        //cierro onexion 
        Conexion.cerrarConexion(con);
      }
     //RETORNO UNA LISTA DE BRIGADAS
    public ArrayList<Brigada> listarBrigadasSegunEstado(boolean estado) {
        //CREO MI LISTA DE BRIGADAS
        EmergenciaData emergenciaData=new EmergenciaData ();
        ArrayList<Brigada> brigadas = new ArrayList<>();
        try {
            //CREO LA CONEXION
            con = Conexion.getConexion();
            String sql = "SELECT * FROM brigada WHERE estado =" + estado; //EJECUTO EL SELECT
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //CREO UN BOMBERO Y LO VOY CARGANDO
                Brigada brigada = new Brigada();
                
                brigada.setCodigoBrigada(rs.getInt("cod_brigada"));
               
                
                brigada.setNombreBrigada(rs.getString("nombre_br"));
                emergencia= emergenciaData.buscarEmergencia(rs.getInt("especialidad"));
                brigada.setEspecialidad(emergencia);
                brigada.setLibre(rs.getBoolean("libre"));
                brigada.setNumeroCuartel(rs.getInt("nro_cuartel"));
               
                
               
                //AGREGO EL BOMBERO A LA LISTA
                brigadas.add(brigada);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada " + ex.getMessage(), "Error", 0);
        }
        //CUANDO TERMINA TODO CIERRO MI CONEXION
        Conexion.cerrarConexion(con);
        return brigadas ;
        }

   
 public ArrayList<Brigada> listarBrigadas() {
        //CREO MI LISTA DE BRIGADAS
        EmergenciaData emergenciaData=new EmergenciaData ();
        ArrayList<Brigada> brigadas = new ArrayList<>();
        try {
            //CREO LA CONEXION
            con = Conexion.getConexion();
            String sql = "SELECT * FROM brigada "; //EJECUTO EL SELECT
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //CREO UN BOMBERO Y LO VOY CARGANDO
                Brigada brigada = new Brigada();
                
                brigada.setCodigoBrigada(rs.getInt("cod_brigada"));
               
                
                brigada.setNombreBrigada(rs.getString("nombre_br"));
                emergencia= emergenciaData.buscarEmergencia(rs.getInt("especialidad"));
                brigada.setEspecialidad(emergencia);
                brigada.setLibre(rs.getBoolean("libre"));
                brigada.setNumeroCuartel(rs.getInt("nro_cuartel"));
               
                
               
                //AGREGO EL BOMBERO A LA LISTA
                brigadas.add(brigada);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada " + ex.getMessage(), "Error", 0);
        }
        //CUANDO TERMINA TODO CIERRO MI CONEXION
        Conexion.cerrarConexion(con);
        return brigadas ;
        }

       // listar brigadas por  

         public ArrayList<Brigada> listarBrigadasPorCuartel(int idCuartel){
         
        //CREO MI LISTA DE BRIGADAS
        EmergenciaData emergenciaData=new EmergenciaData ();
        ArrayList<Brigada> brigadas = new ArrayList<>();
        try {
            //CREO LA CONEXION
            con = Conexion.getConexion();
            String sql = "SELECT * FROM brigada WHERE nro_cuartel= "+ idCuartel ; //EJECUTO EL SELECT
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //creo una brigada Y lo voy cargando
                Brigada brigada = new Brigada();
                
                brigada.setCodigoBrigada(rs.getInt("cod_brigada"));
               
                
                brigada.setNombreBrigada(rs.getString("nombre_br"));
                
                emergencia= emergenciaData.buscarEmergencia(rs.getInt("especialidad"));
                brigada.setEspecialidad(emergencia);
                brigada.setLibre(rs.getBoolean("libre"));
                brigada.setNumeroCuartel(rs.getInt("nro_cuartel"));
               
                
               
                //agrego brigada a la lista 
                brigadas.add(brigada);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada " + ex.getMessage(), "Error", 0);
        }
        //CUANDO TERMINA TODO CIERRO MI CONEXION
        Conexion.cerrarConexion(con);
        return brigadas ;
        }
         
         
         
         public ArrayList<Brigada> listarBomerosPorBrigadas(int idBrigada){
         
        //CREO MI LISTA DE BRIGADAS
        EmergenciaData emergenciaData=new EmergenciaData ();
        ArrayList<Brigada> brigadas = new ArrayList<>();
        try {
            //CREO LA CONEXION
            con = Conexion.getConexion();
            String sql = "SELECT* FROM bombero WHERE codigoBrigada = "+ idBrigada ; //EJECUTO EL SELECT
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //creo una brigada Y lo voy cargando
                Brigada brigada = new Brigada();
                
                brigada.setCodigoBrigada(rs.getInt("cod_brigada"));
               
                
                brigada.setNombreBrigada(rs.getString("nombre_br"));
                
                emergencia= emergenciaData.buscarEmergencia(rs.getInt("especialidad"));
                brigada.setEspecialidad(emergencia);
                brigada.setLibre(rs.getBoolean("libre"));
                brigada.setNumeroCuartel(rs.getInt("nro_cuartel"));
               
                
               
                //agrego brigada a la lista 
                brigadas.add(brigada);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Bombero " + ex.getMessage(), "Error", 0);
        }
        //CUANDO TERMINA TODO CIERRO MI CONEXION
        Conexion.cerrarConexion(con);
        return brigadas ;
        }
          
         
         
         
    }
    
    
  
   
    

