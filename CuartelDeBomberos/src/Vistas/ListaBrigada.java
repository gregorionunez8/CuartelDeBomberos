/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.BrigadaData;
import Entidades.Brigada;
import com.sun.javafx.collections.ArrayListenerHelper;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Natasha
 */
public class ListaBrigada extends javax.swing.JInternalFrame {
private DefaultTableModel modelo=new DefaultTableModel();
    /**
     * Creates new form Brigada
     */
    public ListaBrigada() {
        initComponents();
        armarCabecera();
    }
// cargo info en la tabla 
    public void cargoTabla(){
         BrigadaData brigadaData = new BrigadaData();
         ArrayList<Brigada> listaBrigada = new ArrayList();
         listaBrigada= brigadaData.listarBrigadas();
        for (Brigada brigada : listaBrigada) {
          modelo.addRow(new Object[]{brigada.getCodigoBrigada(),brigada.getNombreBrigada(),brigada.getEspecialidad(),
          brigada.isEstado(),brigada.getNumeroCuartel(),
          
          
          
          });
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

        jMenu1 = new javax.swing.JMenu();
        jLBrigada = new javax.swing.JLabel();
        JLListas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDeBrigada = new javax.swing.JTable();
        jBAgregar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jLBrigada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLBrigada.setText("Brigada");

        JLListas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLListas.setText("LISTA DE BRIGADAS");

        jTablaDeBrigada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaDeBrigada);

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLListas)
                            .addComponent(jLBrigada, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jBAgregar)
                        .addGap(43, 43, 43)
                        .addComponent(jBModificar)
                        .addGap(50, 50, 50)
                        .addComponent(jBEliminar)
                        .addGap(39, 39, 39)
                        .addComponent(jBSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLBrigada)
                .addGap(18, 18, 18)
                .addComponent(JLListas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBModificar)
                    .addComponent(jBEliminar)
                    .addComponent(jBSalir))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
         Frame f = JOptionPane.getFrameForComponent(this); 
        ModificarBrigada ventaAgregar = new ModificarBrigada(f,true);
        ventaAgregar.setVisible (true);
        
                
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        Frame f = JOptionPane.getFrameForComponent(this); 
        AgregarBrigada ventaAgregar = new AgregarBrigada (f,true);
        ventaAgregar.setVisible (
                true);
        
      
        
    }//GEN-LAST:event_jBAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLListas;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLBrigada;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDeBrigada;
    // End of variables declaration//GEN-END:variables
private void armarCabecera (){
    
    modelo.addColumn("id");
    modelo.addColumn("nombre");
    modelo.addColumn("especialidad");
    modelo.addColumn("estado");
    modelo.addColumn("cuartel");
    jTablaDeBrigada.setModel(modelo);
}


}



