/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.BrigadaData;
import Entidades.Bombero;
import Entidades.Brigada;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class EstadisticasUIBomberosPorBrigadas extends javax.swing.JInternalFrame {

    //CREO UN OBJETO DEFAULTABLEMODEL PARA DARLE UN MODELO A LA TABLA
    private final DefaultTableModel tablaModelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) { //SOBREESCRIBO EL METODO PARA QUE NO SE PUEDA EDITAR
            return false;
        }
    };

    // METODO PARA CENTRAR LOS ENCABEZADOS DE LAS COLUMNAS
    private void centrarEncabezado(JTable table) {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    }

    //METODO PARA CARGAR CABECERA DE LA TABLA
    private void cargarCabecera() {
        tablaModelo.addColumn("ID"); //Creo columna
        tablaModelo.addColumn("DNI"); //Creo columna
        tablaModelo.addColumn("Nombre"); //Creo columna
        tablaModelo.addColumn("Apellido"); //Creo columna
        tablaModelo.addColumn("Fecha de Nac."); //Creo columna
        tablaModelo.addColumn("Celular"); //Creo columna
        tablaModelo.addColumn("Grupo Sanguíneo"); //Creo columna
        tablaModelo.addColumn("Estado"); //Creo columna
        jTablaBomberos.setModel(tablaModelo); //CARGO LAS COLUMNAS A LA TABLA
        centrarEncabezado(jTablaBomberos); //Centro los encabezados
        TableColumnModel columnModel = jTablaBomberos.getColumnModel();//Determino el ancho de cada columna
        columnModel.getColumn(0).setPreferredWidth(110);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(300);
        columnModel.getColumn(3).setPreferredWidth(300);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(7).setPreferredWidth(100);
    }

    //CARGO LOS CUARTELES EN EL COMBOBOX
    private void cargarBrigadas() {
        ArrayList<Brigada> listaBrigada = new ArrayList();
        BrigadaData brigadaData = new BrigadaData();
        listaBrigada = brigadaData.listarBrigadas();
        for (Brigada brigada : listaBrigada) {
            jCboxBrigada.addItem(brigada.getCodigoBrigada() + "-" + brigada.getNombreBrigada());
        }
    }

    //LIMPIO LAS FILAS
    private void borrarFilas() {

        int filas = jTablaBomberos.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            tablaModelo.removeRow(f);

        }
    }

    /**
     * Creates new form EstadisticasUIBomberosPorBrigadas
     */
    public EstadisticasUIBomberosPorBrigadas() {
        initComponents();
        cargarCabecera();
        cargarBrigadas();

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
        jCboxBrigada = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaBomberos = new javax.swing.JTable();
        jBtnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Bomberos por Brigadas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Bomberos Por Brigadas:");

        jCboxBrigada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCboxBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboxBrigadaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Brigadas:");

        jTablaBomberos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaBomberos);

        jBtnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salir-50.png"))); // NOI18N
        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(609, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jCboxBrigada, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jLabel1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboxBrigada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //SALGO DE LA VENTANA
    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    //SELECCIONO LA BRIGADA Y CARGO LOS BOMBEROS
    private void jCboxBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboxBrigadaActionPerformed

        borrarFilas(); //CADA VEZ QUE CARGO BORRO LA TABLA
        BrigadaData brigadaData = new BrigadaData();
        ArrayList<Bombero> listaDeBomberoPorBrigada = new ArrayList();
        String dato = jCboxBrigada.getSelectedItem().toString();
        String codigo = "";
        String estado = "";
        if (!dato.isEmpty()) {
            for (int i = 0; i < dato.length(); i++) {
                if (dato.charAt(i) != '-') {
                    codigo = codigo + dato.charAt(i);
                } else {
                    break;
                }
            }
            listaDeBomberoPorBrigada = brigadaData.listarBomerosPorBrigadas(Integer.parseInt(codigo));
            for (Bombero bombero : listaDeBomberoPorBrigada) {

                if (bombero.isEstado()) {
                    estado = "Activa";
                } else {
                    estado = "Inactivo";
                }
                tablaModelo.addRow(new Object[]{bombero.getId(),bombero.getDni(),bombero.getNombre(),bombero.getApellido(),bombero.getFechaNacimiento(),
                            bombero.getCelular(),bombero.getGrupoSanguineo(), estado});
            }
        
        }

    }//GEN-LAST:event_jCboxBrigadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox<String> jCboxBrigada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaBomberos;
    // End of variables declaration//GEN-END:variables
}
