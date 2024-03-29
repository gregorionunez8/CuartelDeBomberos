/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Bombero;

import AccesoADatos.BomberoData;
import AccesoADatos.BrigadaData;
import Entidades.Bombero;
import Entidades.Brigada;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListaDeBomberos extends javax.swing.JInternalFrame {

    int idBombero; //Variable donde se guardara el id de bombero seleccionado

    private DefaultTableModel modeloTabla = new DefaultTableModel() { // Creo un modelo de tabla
        public boolean isCellEditable(int f, int c) {
            return false; // Indica que todas las celdas de la tabla no son editables
        }
    };

    /**
     * Creates new form ListaDeBomberos
     */
    public ListaDeBomberos() {
        initComponents();
        cabeceraDeTabla();
        limpiarTabla();
        cargarTabla();
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Bomberos");
        setDoubleBuffered(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Lista de Bomberos");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jbAgregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-más-50.png"))); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbAgregarMousePressed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-editar-50.png"))); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbModificarMousePressed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-basura-501.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salir-50.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbSalirMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar al Bombero seleccionado? ", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            
            BomberoData bomberoData = new BomberoData();
            BrigadaData brigadaData = new BrigadaData();
            Bombero bomberoa = bomberoData.getBomberoPorId(idBombero);
            
            bomberoData.eliminarBombero(idBombero);
            
            int cantidadBombero1 = brigadaData.cantBomberos(bomberoa.getCodigoBrigada());
            brigadaData.actualizarCantBomberos(bomberoa.getCodigoBrigada(), cantidadBombero1 - 1);

            limpiarTabla();
            cargarTabla();
            jbModificar.setEnabled(false);
            jbEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMousePressed
        // TODO add your handling code here:
        dispose(); //Salir
    }//GEN-LAST:event_jbSalirMousePressed

    private void jbAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAgregarMousePressed
        // TODO add your handling code here:
        ArrayList<Brigada> listaBrigadas = new ArrayList<Brigada>();
        BrigadaData brigadaData = new BrigadaData();
        listaBrigadas = brigadaData.brigadasPorEstadoYDisponibilidad(true, true);
        if (listaBrigadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero debe tener Brigadas cargadas", "Información", 1);
        } else {
            Frame f = JOptionPane.getFrameForComponent(this);
            Alta ventana = new Alta(f, true);
            ventana.setVisible(true);
            this.setVisible(true);
            //Centro el popup
            int x = (this.getWidth() - ventana.getWidth()) / 2;
            int y = (this.getHeight() - ventana.getHeight()) / 2;
            ventana.setLocation(x, y);
            limpiarTabla();
            cargarTabla();
            jbModificar.setEnabled(false);
            jbEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jbAgregarMousePressed

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMousePressed
        // TODO add your handling code here:
        int filaSeleccionada = -1;
        filaSeleccionada = jTable.getSelectedRow();
        if (filaSeleccionada != -1) { //Se selecciono una fila
            idBombero = (Integer) jTable.getValueAt(filaSeleccionada, 0);
            jbModificar.setEnabled(true); //Activar Boton Modificar
            String estado = (String) jTable.getValueAt(filaSeleccionada, 8);
            if (estado.equals("Activo")) {
                jbEliminar.setEnabled(true); //Activar Boton Eliminar
            } else {
                jbEliminar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jTableMousePressed

    private void jbModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificarMousePressed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        Modificar ventana = new Modificar(f, true, idBombero);
        ventana.setVisible(true);
        this.setVisible(true);
        //Centro el popup
        int x = (this.getWidth() - ventana.getWidth()) / 2;
        int y = (this.getHeight() - ventana.getHeight()) / 2;
        ventana.setLocation(x, y);
        limpiarTabla();
        cargarTabla();
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }//GEN-LAST:event_jbModificarMousePressed

    private void cabeceraDeTabla() {
        //Nombre de columnas
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Celular");
        modeloTabla.addColumn("Grupo Sanguineo");
        modeloTabla.addColumn("Fecha de Nacimiento");
        modeloTabla.addColumn("Brigada");
        modeloTabla.addColumn("Estado");
        jTable.setModel(modeloTabla);
        //Ancho de columnas
        jTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(8).setPreferredWidth(40);
    }

    private void cargarDatosEnLaTabla(Bombero bombero) {
        modeloTabla.addRow(new Object[]{bombero.getId(), bombero.getDni(), bombero.getNombre(), bombero.getApellido(), bombero.getCelular(), bombero.getGrupoSanguineo(), bombero.getFechaNacimiento(), brigada(bombero.getCodigoBrigada()), (bombero.isEstado()) ? "Activo" : "Inactivo"});
    }

    public Brigada brigada(int codigo) {
        BrigadaData brigadaData = new BrigadaData();
        return brigadaData.brigadaPorId(codigo);
    }
    
    public void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int filas = jTable.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            model.removeRow(model.getRowCount() - 1);
        }
    }

    public void cargarTabla() {
        ArrayList<Bombero> listaBomberos = new ArrayList<Bombero>();
        BomberoData bomberoData = new BomberoData();
        listaBomberos = bomberoData.listarTodosLosBomberos();
        if (listaBomberos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen bomberos en la base de datos", "MENSAJE", 1);
        } else {
            for (Bombero bombero : listaBomberos) {
                cargarDatosEnLaTabla(bombero);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
