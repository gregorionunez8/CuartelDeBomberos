/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.BrigadaData;
import AccesoADatos.CuartelData;
import AccesoADatos.EmergenciaData;
import AccesoADatos.SiniestroData;
import Entidades.Brigada;
import Entidades.Coordenada;
import Entidades.Cuartel;
import Entidades.Emergencia;
import Entidades.Siniestro;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Gregorio
 */
public class AltaSiniestro extends javax.swing.JInternalFrame {

    CuartelData cuartelData = new CuartelData();
    EmergenciaData emergenciaData = new EmergenciaData();
    BrigadaData brigadaData = new BrigadaData();
    DecimalFormat formato = new DecimalFormat("0.00");

    public AltaSiniestro() {
        initComponents();
        rellenarComboBoxEmergencia();
        configDocumentListener();
        jLFecha.setText(LocalDate.now().toString());
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADetalle = new javax.swing.JTextArea();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jCBEmergencia = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFX = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFY = new javax.swing.JTextField();
        jLCuartel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jCBBrigada = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Alta de Siniestro");
        setPreferredSize(new java.awt.Dimension(730, 645));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLFecha.setBackground(new java.awt.Color(204, 204, 204));
        jLFecha.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLFecha.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jLFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de emergencia:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Coordenadas:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Brigada:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Detalles:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jTADetalle.setColumns(20);
        jTADetalle.setRows(5);
        jScrollPane1.setViewportView(jTADetalle);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 650, 120));

        jBGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-guardar-50.png"))); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, -1, -1));

        jBCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salir-50.png"))); // NOI18N
        jBCancelar.setText("Salir");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, -1, -1));

        jCBEmergencia.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jCBEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEmergenciaActionPerformed(evt);
            }
        });
        getContentPane().add(jCBEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 490, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Cuartel:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel11.setText("X");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 30, 30));

        jTFX.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jTFX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFXActionPerformed(evt);
            }
        });
        jTFX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFXKeyTyped(evt);
            }
        });
        getContentPane().add(jTFX, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 90, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel12.setText("Y");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 20, 30));

        jTFY.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jTFY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFYActionPerformed(evt);
            }
        });
        jTFY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFYKeyTyped(evt);
            }
        });
        getContentPane().add(jTFY, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 90, 30));

        jLCuartel.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLCuartel.setText("Cuartel no definido.");
        getContentPane().add(jLCuartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 380, 50));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Alta de Siniestro");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 320, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 650, 10));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("-");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jCBBrigada.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jCBBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBrigadaActionPerformed(evt);
            }
        });
        getContentPane().add(jCBBrigada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 500, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        Brigada brigadaGuardar = new Brigada();
        brigadaGuardar = (Brigada) jCBBrigada.getSelectedItem();
        BrigadaData brigadaData = new BrigadaData();

        if (jTFX.getText().isEmpty() || jTFY.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar coordenadas correctas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (jLCuartel.getText().equals("Cuartel no definido.")) {
            JOptionPane.showMessageDialog(this, "No se puede dar de alta un siniestro sin un Cuartel.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (brigadaGuardar == null) {
            JOptionPane.showMessageDialog(this, "No se puede dar de alta un siniestro sin una Brigada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int respuestaBrigada;

        if (!brigadaGuardar.getEspecialidad().toString().equals(jCBEmergencia.getSelectedItem().toString())) {
            respuestaBrigada = JOptionPane.showConfirmDialog(
                    null, "La brigada '" + brigadaGuardar.getNombreBrigada() + "' no tiene la especialidad del Siniestro. ¿Desea continuar?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            respuestaBrigada = 0;
        }

        if (respuestaBrigada == JOptionPane.NO_OPTION) {
            return;
        }

        int respuestaBrigadaDisp;

        if (!brigadaGuardar.isLibre()) {
            respuestaBrigadaDisp = JOptionPane.showConfirmDialog(
                    null, "La brigada '" + brigadaGuardar.getNombreBrigada() + "' Está resolviendo un siniestro. ¿Desea colocarlo en la cola de espera?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            respuestaBrigadaDisp = 0;
        }

        if (respuestaBrigadaDisp == JOptionPane.NO_OPTION) {
            return;
        }

        int respuesta;

        if (jTADetalle.getText().isEmpty()) {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea confirmar el siniestro?\nTipo de emergencia: " + jCBEmergencia.getSelectedItem().toString()
                    + "\nCoordenadas: " + jTFX.getText() + " - " + jTFY.getText() + "\nCuartel: " + jLCuartel.getText()
                    + "\nBrigada: " + brigadaGuardar.getNombreBrigada() + "\nDetalle:\nSin detalle.",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea confirmar el siniestro?\nTipo de emergencia: " + jCBEmergencia.getSelectedItem().toString()
                    + "\nCoordenadas: " + jTFX.getText() + " - " + jTFY.getText() + "\nCuartel: " + jLCuartel.getText()
                    + "\nBrigada: " + brigadaGuardar.getNombreBrigada() + "\nDetalle:\n" + jTADetalle.getText(),
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
        }

        if (respuesta == JOptionPane.YES_OPTION) {
            brigadaData.dispBrigada(brigadaGuardar.getCodigoBrigada(), false);
            
            Siniestro siniestro = new Siniestro();
            siniestro.setTipoEmergencia((Emergencia) jCBEmergencia.getSelectedItem());
            siniestro.setFecha(LocalDate.now());
            siniestro.setCoordX(Integer.parseInt(jTFX.getText()));
            siniestro.setCoordY(Integer.parseInt(jTFY.getText()));
            if (!jTADetalle.getText().isEmpty()) {
                siniestro.setDetalles(jTADetalle.getText());
            } else {
                siniestro.setDetalles("Sin detalle.");
            }
            siniestro.setCodBrigada(brigadaGuardar.getCodigoBrigada());
            siniestro.setEstado(true);

            SiniestroData siniestroData = new SiniestroData();

            siniestroData.agregarSiniestro(siniestro);
            jCBEmergencia.setSelectedIndex(0);
            jTFX.setText("");
            jTFY.setText("");
            jTADetalle.setText("");
            jCBBrigada.removeAllItems();
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTFXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFXActionPerformed

    private void jTFYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFYActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Deseas Salir?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jCBEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEmergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBEmergenciaActionPerformed

    private void jTFXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFXKeyTyped
        if (jTFX.getText().length() >= 6) {
            evt.consume(); // Esto evita que se ingrese más caracteres
        }

        int key = evt.getKeyChar();
        if (key > 57 || key < 48) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFXKeyTyped

    private void jTFYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFYKeyTyped
        if (jTFY.getText().length() >= 6) {
            evt.consume(); // Esto evita que se ingrese más caracteres
        }

        int key = evt.getKeyChar();
        if (key > 57 || key < 48) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFYKeyTyped

    private void jCBBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBrigadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBBrigadaActionPerformed

    private void rellenarComboBoxEmergencia() {
        ArrayList<Emergencia> listaEmergencia = new ArrayList<>();
        listaEmergencia = emergenciaData.listarEmergencia();

        for (Emergencia eme : listaEmergencia) {
            jCBEmergencia.addItem(eme);
        }

    }

    public void configDocumentListener() {
        // ------------------------------ Y -------------------------
        jTFY.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {

                if (!jTFX.getText().isEmpty()) {
                    //----------CUARTEL-------------//
                    int x = Integer.parseInt(jTFX.getText());
                    int y = Integer.parseInt(jTFY.getText());
                    Cuartel cuartel = new Cuartel();

                    HashMap<Integer, Cuartel> listarCuarteles = new HashMap<>();
                    listarCuarteles = cuartelData.listarCuartelesCercanos(x, y);

                    for (Map.Entry<Integer, Cuartel> entry : listarCuarteles.entrySet()) {
                        cuartel = entry.getValue();
                        Coordenada cordenadas = new Coordenada(cuartel.getCoordX(), cuartel.getCoordY());
                        Coordenada cordenadasSiniestro = new Coordenada(Integer.parseInt(jTFX.getText()), Integer.parseInt(jTFY.getText()));
                        String distancia = formato.format(cuartelData.calcularDistancia(cordenadas, cordenadasSiniestro));

                        jLCuartel.setText(cuartel.getNombreCuartel() + " - " + distancia + " Km");
                        break;
                    }

                    //----------BRIGADA-------------//
                    if (!jLCuartel.equals("Cuartel no definido.")) {
                        int idCuartel = cuartel.getCodCuartel();

                        jCBBrigada.removeAllItems();

                        ArrayList<Brigada> listarBrigadas = new ArrayList<>();
                        listarBrigadas = brigadaData.listarBrigadasPorCuartel(idCuartel);

                        for (Brigada listarBrigada : listarBrigadas) {
                            if (listarBrigada.isEstado() == true) {
                                jCBBrigada.addItem(listarBrigada);
                            }
                        }
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (jTFY.getText().isEmpty() || jTFX.getText().isEmpty()) {
                    jLCuartel.setText("Cuartel no definido.");
                } else {
                    int x = Integer.parseInt(jTFX.getText());
                    int y = Integer.parseInt(jTFY.getText());
                    Cuartel cuartel = new Cuartel();

                    HashMap<Integer, Cuartel> listarCuarteles = new HashMap<>();
                    listarCuarteles = cuartelData.listarCuartelesCercanos(x, y);

                    for (Map.Entry<Integer, Cuartel> entry : listarCuarteles.entrySet()) {
                        cuartel = entry.getValue();
                        Coordenada cordenadas = new Coordenada(cuartel.getCoordX(), cuartel.getCoordY());
                        Coordenada cordenadasSiniestro = new Coordenada(Integer.parseInt(jTFX.getText()), Integer.parseInt(jTFY.getText()));
                        String distancia = formato.format(cuartelData.calcularDistancia(cordenadas, cordenadasSiniestro));

                        jLCuartel.setText(cuartel.getNombreCuartel() + " - " + distancia + " Km");
                        break;
                    }

                    //----------BRIGADA-------------//
                    if (!jLCuartel.equals("Cuartel no definido.")) {
                        int idCuartel = cuartel.getCodCuartel();

                        jCBBrigada.removeAllItems();

                        ArrayList<Brigada> listarBrigadas = new ArrayList<>();
                        listarBrigadas = brigadaData.listarBrigadasPorCuartel(idCuartel);

                        for (Brigada listarBrigada : listarBrigadas) {
                            if (listarBrigada.isEstado() == true) {
                                jCBBrigada.addItem(listarBrigada);
                            }
                        }
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        // ------------------------------ X -------------------------
        jTFX.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {

                if (!jTFY.getText().isEmpty()) {
                    //----------CUARTEL-------------//
                    int x = Integer.parseInt(jTFX.getText());
                    int y = Integer.parseInt(jTFY.getText());
                    Cuartel cuartel = new Cuartel();

                    HashMap<Integer, Cuartel> listarCuarteles = new HashMap<>();
                    listarCuarteles = cuartelData.listarCuartelesCercanos(x, y);

                    for (Map.Entry<Integer, Cuartel> entry : listarCuarteles.entrySet()) {
                        cuartel = entry.getValue();
                        Coordenada cordenadas = new Coordenada(cuartel.getCoordX(), cuartel.getCoordY());
                        Coordenada cordenadasSiniestro = new Coordenada(Integer.parseInt(jTFX.getText()), Integer.parseInt(jTFY.getText()));
                        String distancia = formato.format(cuartelData.calcularDistancia(cordenadas, cordenadasSiniestro));

                        jLCuartel.setText(cuartel.getNombreCuartel() + " - " + distancia + " Km");
                        break;
                    }

                    //----------BRIGADA-------------//
                    if (!jLCuartel.equals("Cuartel no definido.")) {
                        int idCuartel = cuartel.getCodCuartel();

                        jCBBrigada.removeAllItems();

                        ArrayList<Brigada> listarBrigadas = new ArrayList<>();
                        listarBrigadas = brigadaData.listarBrigadasPorCuartel(idCuartel);

                        for (Brigada listarBrigada : listarBrigadas) {
                            if (listarBrigada.isEstado() == true) {
                                jCBBrigada.addItem(listarBrigada);
                            }
                        }
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (jTFY.getText().isEmpty() || jTFX.getText().isEmpty()) {
                    jLCuartel.setText("Cuartel no definido.");
                } else {
                    int x = Integer.parseInt(jTFX.getText());
                    int y = Integer.parseInt(jTFY.getText());
                    Cuartel cuartel = new Cuartel();

                    HashMap<Integer, Cuartel> listarCuarteles = new HashMap<>();
                    listarCuarteles = cuartelData.listarCuartelesCercanos(x, y);

                    for (Map.Entry<Integer, Cuartel> entry : listarCuarteles.entrySet()) {
                        cuartel = entry.getValue();
                        Coordenada cordenadas = new Coordenada(cuartel.getCoordX(), cuartel.getCoordY());
                        Coordenada cordenadasSiniestro = new Coordenada(Integer.parseInt(jTFX.getText()), Integer.parseInt(jTFY.getText()));
                        String distancia = formato.format(cuartelData.calcularDistancia(cordenadas, cordenadasSiniestro));

                        jLCuartel.setText(cuartel.getNombreCuartel() + " - " + distancia + " Km");
                        break;
                    }

                    //----------BRIGADA-------------//
                    if (!jLCuartel.equals("Cuartel no definido.")) {
                        int idCuartel = cuartel.getCodCuartel();

                        jCBBrigada.removeAllItems();

                        ArrayList<Brigada> listarBrigadas = new ArrayList<>();
                        listarBrigadas = brigadaData.listarBrigadasPorCuartel(idCuartel);

                        for (Brigada listarBrigada : listarBrigadas) {
                            if (listarBrigada.isEstado() == true) {
                                jCBBrigada.addItem(listarBrigada);
                            }
                        }
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<Brigada> jCBBrigada;
    private javax.swing.JComboBox<Emergencia> jCBEmergencia;
    private javax.swing.JLabel jLCuartel;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTADetalle;
    private javax.swing.JTextField jTFX;
    private javax.swing.JTextField jTFY;
    // End of variables declaration//GEN-END:variables
}
