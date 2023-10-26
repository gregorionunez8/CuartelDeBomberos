/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.BrigadaData;
import AccesoADatos.CuartelData;
import Entidades.Emergencia;
import java.util.ArrayList;
import AccesoADatos.EmergenciaData;
import Entidades.Brigada;
import Entidades.Cuartel;
import javax.swing.JOptionPane;

public class AgregarBrigada extends javax.swing.JDialog {

    public void cargarComboboxEspecia() {
        ComboBoxEspecialidad.removeAllItems();
        jComboBoxCuartel.removeAllItems();
        
        EmergenciaData emergenciaData = new EmergenciaData();
        ArrayList<Emergencia> listaEmergencia = new ArrayList<>();
        listaEmergencia = emergenciaData.listarEmergencia();
        for (Emergencia eme : listaEmergencia) {
            ComboBoxEspecialidad.addItem(eme);
        }

        CuartelData cuartelData = new CuartelData();
        ArrayList<Cuartel> listaCuartel = new ArrayList<>();
        listaCuartel = cuartelData.listarCuarteles();
        for (Cuartel cuartel : listaCuartel) {
            if(cuartel.isEstado()){
            jComboBoxCuartel.addItem(cuartel);
            }
        }

    }

    /**
     * Creates new form AgregarBrigada
     */
    public AgregarBrigada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboboxEspecia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLNombre = new javax.swing.JLabel();
        JLEspecialidad = new javax.swing.JLabel();
        JLCuarel = new javax.swing.JLabel();
        jBGuadar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        JTFNombre = new javax.swing.JTextField();
        ComboBoxEspecialidad = new javax.swing.JComboBox<>();
        jComboBoxCuartel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Brigada");
        setPreferredSize(new java.awt.Dimension(570, 332));
        setResizable(false);

        JLNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLNombre.setText("Nombre");

        JLEspecialidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLEspecialidad.setText("Especialidad");

        JLCuarel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLCuarel.setText("Cuatel");

        jBGuadar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBGuadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-guardar-50.png"))); // NOI18N
        jBGuadar.setText("Guardar");
        jBGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuadarActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salir-50.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        JTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNombreActionPerformed(evt);
            }
        });

        ComboBoxEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEspecialidadActionPerformed(evt);
            }
        });

        jComboBoxCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCuartelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLCuarel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLEspecialidad)
                    .addComponent(JLNombre)
                    .addComponent(jLabel1)
                    .addComponent(jBGuadar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboBoxEspecialidad, 0, 235, Short.MAX_VALUE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTFNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxCuartel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNombre)
                    .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLEspecialidad)
                    .addComponent(ComboBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLCuarel)
                    .addComponent(jComboBoxCuartel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGuadar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void JTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNombreActionPerformed

    private void ComboBoxEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEspecialidadActionPerformed


    }//GEN-LAST:event_ComboBoxEspecialidadActionPerformed

    private void jComboBoxCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCuartelActionPerformed


    }//GEN-LAST:event_jComboBoxCuartelActionPerformed

    private void jBGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuadarActionPerformed
        if (JTFNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BrigadaData brigadaData = new BrigadaData();
        Cuartel cuartel = new Cuartel();
        Emergencia emergencia = new Emergencia();
        cuartel = (Cuartel) jComboBoxCuartel.getSelectedItem();
        emergencia = (Emergencia) ComboBoxEspecialidad.getSelectedItem();
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Deseas agregar la brigada?\nNombre brigada: " + JTFNombre.getText() + "\nTipo de emergencia: " + ComboBoxEspecialidad.getSelectedItem().toString()
                + "\nCuartel: " + cuartel.getNombreCuartel(),
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            Brigada brigada = new Brigada();
            brigada.setNombreBrigada(JTFNombre.getText());
            brigada.setEspecialidad(emergencia);
            brigada.setEstado(true);
            brigada.setLibre(true);
            brigada.setNumeroCuartel(cuartel.getCodCuartel());
            brigadaData.agregarBrigada(brigada);
        }
        this.dispose();
    }//GEN-LAST:event_jBGuadarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Emergencia> ComboBoxEspecialidad;
    private javax.swing.JLabel JLCuarel;
    private javax.swing.JLabel JLEspecialidad;
    private javax.swing.JLabel JLNombre;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuadar;
    private javax.swing.JComboBox<Cuartel> jComboBoxCuartel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
