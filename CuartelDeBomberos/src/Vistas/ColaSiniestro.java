/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.BrigadaData;
import AccesoADatos.EmergenciaData;
import AccesoADatos.SiniestroData;
import Entidades.Brigada;
import Entidades.Emergencia;
import Entidades.Siniestro;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Gregorio
 */
public class ColaSiniestro extends javax.swing.JInternalFrame {

    /**
     * Creates new form CerrarSiniestro
     */
    //CREO UN OBJETO DEFAULTABLEMODEL PARA DARLE UN MODELO A LA TABLA
    private final DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) { //SOBREESCRIBO EL METODO PARA QUE NO SE PUEDA EDITAR
            return false;
        }
    };

    // Crea un renderizador de filas personalizado para asignar el color
    DefaultTableCellRenderer rowRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Boolean dato = (Boolean) table.getModel().getValueAt(row, 8);
            if (!dato) {
                c.setForeground(Color.LIGHT_GRAY); // Cambia el color del texto para la primera fila
                return c;
            } else {
                c.setForeground(Color.BLACK);
                return c;
            }
        }
    };

    SiniestroData siniestroData = new SiniestroData();
    BrigadaData brigadaData = new BrigadaData();

    public ColaSiniestro() {
        initComponents();
        jLFecha.setText(LocalDate.now().toString());
        cargarCabecera();
        cargarTabla();
        jBAsignarSiniestro.setEnabled(false);
    }

    // METODO PARA CENTRAR LOS ENCABEZADOS DE LAS COLUMNAS
    private void centrarEncabezado(JTable table) {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    }

    //METODO PARA CARGAR CABECERA DE LA TABLA
    private void cargarCabecera() {
        tabla.addColumn("ID"); //Creo columna
        tabla.addColumn("Fecha"); //Creo columna
        tabla.addColumn("Tipo de emergencia");
        tabla.addColumn("Coodenada X"); //Creo columna
        tabla.addColumn("Coodenada Y"); //Creo columna
        tabla.addColumn("Detalle"); //Creo columna
        tabla.addColumn("Brigada"); //Creo columna
        tabla.addColumn("Disponibilidad"); //Creo columna
        jTSiniestro.setModel(tabla); //CARGO LAS COLUMNAS A LA TABLA
        centrarEncabezado(jTSiniestro); //Centro los encabezados
        TableColumnModel columnModel = jTSiniestro.getColumnModel();//Determino el ancho de cada columna
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(350);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(350);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(7).setPreferredWidth(200);

    }

    public void cargarTabla() {
        ArrayList<Siniestro> listadoSiniestro = new ArrayList<>();
        listadoSiniestro = siniestroData.listarSiniestro();

        for (Siniestro siniestro : listadoSiniestro) {
            Brigada brigada = brigadaData.brigadaPorId(siniestro.getCodBrigada());
            String disponible;

            if (brigada.isLibre()) {
                disponible = "Desocupada";
            } else {
                disponible = "Ocupada";
            }

            Emergencia emergencia = siniestro.getTipoEmergencia();
            if (siniestro.isEstado()) {
                tabla.addRow(new Object[]{siniestro.getCodigo(), siniestro.getFecha().toString(), emergencia.getEmergencia(), siniestro.getCoordX(), siniestro.getCoordY(), siniestro.getDetalles(), brigada.getNombreBrigada(), disponible});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTSiniestro = new javax.swing.JTable();
        jBAsignarSiniestro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cola de Siniestros");
        setPreferredSize(new java.awt.Dimension(1200, 635));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLFecha.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLFecha.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jLFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 6, 299, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Cola de Siniestros");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1150, 10));

        jTSiniestro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTSiniestro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTSiniestroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTSiniestro);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1150, -1));

        jBAsignarSiniestro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBAsignarSiniestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-más-50.png"))); // NOI18N
        jBAsignarSiniestro.setText("Asignar Siniestro");
        jBAsignarSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAsignarSiniestroActionPerformed(evt);
            }
        });
        getContentPane().add(jBAsignarSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salir-50.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 560, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAsignarSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAsignarSiniestroActionPerformed
        int idSiniestro;
        int filaSeleccionada = -1;
        filaSeleccionada = jTSiniestro.getSelectedRow();
        if (filaSeleccionada != -1) {
            idSiniestro = (Integer) jTSiniestro.getValueAt(filaSeleccionada, 0);
        } else {
            idSiniestro = -1;
        }

        Siniestro siniestro = siniestroData.siniestroPorID(idSiniestro);
        Brigada brigada = brigadaData.brigadaPorId(siniestro.getCodBrigada());
        
        if(brigada.isLibre()){
        brigadaData.dispBrigada(siniestro.getCodBrigada(), false);
        JOptionPane.showMessageDialog(null, "Siniestro asignado.", "Información", 1);
        }else{
            JOptionPane.showMessageDialog(null, "La brigada esta ocupada con otro Siniestro.", "Información", 1);
        }

        borrarFilas();
        cargarTabla();
        jBAsignarSiniestro.setEnabled(false);
    }//GEN-LAST:event_jBAsignarSiniestroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTSiniestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSiniestroMouseClicked
        int filaSeleccionada = -1;
        filaSeleccionada = jTSiniestro.getSelectedRow();
        if (filaSeleccionada != -1) {
            jBAsignarSiniestro.setEnabled(true);
        }
    }//GEN-LAST:event_jTSiniestroMouseClicked

    private void borrarFilas() {

        int filas = jTSiniestro.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            tabla.removeRow(f);

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAsignarSiniestro;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTSiniestro;
    // End of variables declaration//GEN-END:variables
}
