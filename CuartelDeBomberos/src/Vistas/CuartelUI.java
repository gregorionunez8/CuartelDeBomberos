package Vistas;

import AccesoADatos.BrigadaData;
import AccesoADatos.CuartelData;
import Entidades.Brigada;
import Entidades.Cuartel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class CuartelUI extends javax.swing.JInternalFrame {

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

            Boolean dato = (Boolean) table.getModel().getValueAt(row, 7);
            if (!dato) {
                c.setForeground(Color.LIGHT_GRAY); // Cambia el color del texto para la primera fila
                return c;
            } else {
                c.setForeground(Color.BLACK);
                return c;
            }
        }
    };

    //CONSTRUCTOR DE LA VISTA
    public CuartelUI() {
        initComponents();
        cargarCabecera();
        iniciarComandos();
        cargoTabla();
    }

    //CARGO LA INFO EN LA TABLA
    public void cargoTabla() {

        CuartelData cuartelData = new CuartelData();
        ArrayList<Cuartel> listaCuartel = new ArrayList();
        listaCuartel = cuartelData.listarCuarteles();
        for (Cuartel cuartel : listaCuartel) {
            tabla.addRow(new Object[]{cuartel.getCodCuartel(), cuartel.getNombreCuartel(), cuartel.getDireccion(), cuartel.getCoordX(),
                cuartel.getCoordY(), cuartel.getTelefono(), cuartel.getCorreo(), cuartel.isEstado()});
            // Aplica el renderizador personalizado a todas las columnas
            for (int i = 0; i < TablaDeCuarteles.getColumnCount(); i++) {
                TablaDeCuarteles.getColumnModel().getColumn(i).setCellRenderer(rowRenderer);
            }

        }
    }

    //INICIO LOS COMANDOS 
    private void iniciarComandos() {
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
    }

    // METODO PARA CENTRAR LOS ENCABEZADOS DE LAS COLUMNAS
    private void centrarEncabezado(JTable table) {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    }

    //METODO PARA CARGAR CABECERA DE LA TABLA
    private void cargarCabecera() {
        tabla.addColumn("ID"); //Creo columna
        tabla.addColumn("Nombre"); //Creo columna
        tabla.addColumn("Direccion"); //Creo columna
        tabla.addColumn("Coodenada X"); //Creo columna
        tabla.addColumn("Coodenada Y"); //Creo columna
        tabla.addColumn("Telefono"); //Creo columna
        tabla.addColumn("Correo"); //Creo columna 
        tabla.addColumn("Estado");
        TablaDeCuarteles.setModel(tabla); //CARGO LAS COLUMNAS A LA TABLA
        centrarEncabezado(TablaDeCuarteles); //Centro los encabezados
        TableColumnModel columnModel = TablaDeCuarteles.getColumnModel();//Determino el ancho de cada columna
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setMaxWidth(0);  //PONGO EN 0 TODOS LOS VALORES DEL LA COLUMNA Y NO LA MUESTRA
        columnModel.getColumn(7).setMinWidth(0);
        columnModel.getColumn(7).setPreferredWidth(0);
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
        TablaDeCuarteles = new javax.swing.JTable();
        jbtnAgregar = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cuarteles");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Listado De Cuarteles");

        TablaDeCuarteles.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaDeCuarteles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaDeCuarteles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDeCuartelesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDeCuarteles);

        jbtnAgregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-más-50.png"))); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.setPreferredSize(new java.awt.Dimension(147, 35));
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnModificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-editar-50.png"))); // NOI18N
        jbtnModificar.setText("Modificar");
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-basura-501.png"))); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.setPreferredSize(new java.awt.Dimension(147, 35));
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salir-50.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.setPreferredSize(new java.awt.Dimension(147, 35));
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //LLAMO LA VENTANA AGREGAR
    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed

        Frame f = JOptionPane.getFrameForComponent(this);
        CuartelUIAgregar ventanaAgregar = new CuartelUIAgregar(f, true);
        ventanaAgregar.setVisible(true);
        borrarFilas();
        cargoTabla();
        iniciarComandos();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    //HAGO CLICK SOBRE UNA FILA
    private void TablaDeCuartelesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDeCuartelesMouseClicked
        int filaSeleccionada = -1;
        filaSeleccionada = TablaDeCuarteles.getSelectedRow();
        if (filaSeleccionada != -1) {
            Boolean activo = (Boolean) TablaDeCuarteles.getValueAt(filaSeleccionada, 7);
            if (activo) {
                jbtnEliminar.setEnabled(true);
                jbtnModificar.setEnabled(true);
            } else {
                jbtnEliminar.setEnabled(false);
                jbtnModificar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_TablaDeCuartelesMouseClicked

    //LIMPIO LAS FILAS
    private void borrarFilas() {

        int filas = TablaDeCuarteles.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            tabla.removeRow(f);

        }
    }

    //PRESIONO EL BOTON ELIMINAR
    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed

        int filaSeleccionada = -1;
        filaSeleccionada = TablaDeCuarteles.getSelectedRow();
        if (filaSeleccionada != -1) {
            Integer nroCuartel = (Integer) TablaDeCuarteles.getValueAt(filaSeleccionada, 0);
            String nombre = (String) TablaDeCuarteles.getValueAt(filaSeleccionada, 1);
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea eliminar el cuartel: " + nombre, "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                //BORRO EL CUARTEL
                CuartelData cuartelData = new CuartelData();

                //VERIFICO SI TIENE BRIGADAS
                BrigadaData brigadaData = new BrigadaData();
                ArrayList<Brigada> listaBrigadas = new ArrayList();
                listaBrigadas=brigadaData.listarBrigadasPorCuartel(nroCuartel);
                if (listaBrigadas.isEmpty()) {
                    cuartelData.eliminarCuartel(nroCuartel);
                } else {
                    JOptionPane.showMessageDialog(this, "Imposible borrar cuartel tiene " + listaBrigadas.size() + " brigadas asignadas");
                }
                borrarFilas();
                cargoTabla();
                iniciarComandos();
            }
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    //PRESIONO EL BOTON MODIFICAR SI EL CUARTEL ESTA SELECCIONADO
    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed

        int nroCuartel;
        int filaSeleccionada = -1;
        filaSeleccionada = TablaDeCuarteles.getSelectedRow();
        if (filaSeleccionada != -1) {
            nroCuartel = (Integer) TablaDeCuarteles.getValueAt(filaSeleccionada, 0);
        } else {
            nroCuartel = -1;
        }
        Frame f = JOptionPane.getFrameForComponent(this);
        CuartelUIModificar ventanaModificar = new CuartelUIModificar(f, true, nroCuartel);
        ventanaModificar.setVisible(true);
        borrarFilas();
        cargoTabla();
        iniciarComandos();
    }//GEN-LAST:event_jbtnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDeCuarteles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JButton jbtnSalir;
    // End of variables declaration//GEN-END:variables
}
