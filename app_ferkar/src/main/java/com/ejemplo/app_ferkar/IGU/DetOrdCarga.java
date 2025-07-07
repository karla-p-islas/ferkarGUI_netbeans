
package com.ejemplo.app_ferkar.IGU;

import com.ejemplo.app_ferkar.persistencia.Carga;
import com.ejemplo.app_ferkar.persistencia.CargaDAO;
import com.ejemplo.app_ferkar.persistencia.DetallePedido;
import com.ejemplo.app_ferkar.persistencia.DetallePedidoDAO;
import com.ejemplo.app_ferkar.persistencia.Pedido;
import com.ejemplo.app_ferkar.persistencia.Soldador;
import com.ejemplo.app_ferkar.persistencia.SoldadorDAO;
import com.ejemplo.app_ferkar.persistencia.TipoAro;
import com.ejemplo.app_ferkar.persistencia.TipoAroDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kpaor
 */
public class DetOrdCarga extends javax.swing.JFrame {

    /**
     * Creates new form DetallePedido
     */
    TipoAro tipoA = new TipoAro();
    TipoAroDAO tipoAd = new TipoAroDAO();
    DetallePedido detP = new DetallePedido();
    DetallePedidoDAO detPd = new DetallePedidoDAO();
    Carga car = new Carga();
    CargaDAO carD = new CargaDAO();
    Soldador id = new Soldador();
    SoldadorDAO idd = new SoldadorDAO();
    DefaultTableModel modelo;
    
    public DetOrdCarga(Pedido pd) {
        initComponents();
        TextField_Cliente.setText(pd.getCliente());
        TextField_FolioPedido.setText(pd.getNum_pedido());
        TextField_FechaEnt.setText(pd.getFecha());
        ListarDetalles(TextField_FolioPedido.getText());
    }
    
    public void ListarDetalles(String folio){
        JOptionPane.showMessageDialog(null, "En caso de múltiples ordenes de carga, recuerde seleccionar la deseada y hacer click en el botón 'Actualizar'");

        List<DetallePedido> ListaDet = detPd.ListarDetalles(folio);
        modelo = (DefaultTableModel) jTableDetalles.getModel();
        //limpiar tabla
        for(int i = 0; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);    
        }
        Object[] ob1 = new Object[5];
        for(int i = 0; i < ListaDet.size(); i++){
            String clave = ListaDet.get(i).getCodigo_aro();
            tipoA = tipoAd.BuscarPro(clave);
            ob1[0] = clave;
            ob1[1] = tipoA.getDescripcion_gen();
            ob1[2] = ListaDet.get(i).getTratamiento_adicional();
            ob1[4] = ListaDet.get(i).getCantidad();
            modelo.addRow(ob1);
        }
        jTableDetalles.setModel(modelo);
    }
    
    public void ObtenerInfo(String num_carga){
        Carga InfoCarga = carD.ConsultInfoCarga(num_carga);
        TextField_ModoPago.setText(InfoCarga.getModo_pago());
        TextField_Factura.setText(InfoCarga.getNum_factura());
        TextField_Transporte.setText(InfoCarga.getTransporte());
        
        String id_s = String toString(InfoCarga.getId_conductor());
        id = idd.BuscarPro(InfoCarga.getId_conductor());
    }
    
    public void ListarFolios(String folio){
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_title = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextField_FolioPedido = new javax.swing.JTextField();
        TextField_Cliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TextField_FechaEnt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalles = new javax.swing.JTable();
        button_Salir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextField_ModoPago = new javax.swing.JTextField();
        TextField_Factura = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TextField_Conductor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TextField_Transporte = new javax.swing.JTextField();
        button_Actualizar = new javax.swing.JButton();
        jComboBox_FolioOrdCarga = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(740, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(760, 700));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\kpaor\\Downloads\\ferkar_logo_150x90.jpg")); // NOI18N

        label_title.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        label_title.setText("Detalle Orden de Carga");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Folio Pedido:");

        TextField_FolioPedido.setEditable(false);
        TextField_FolioPedido.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextField_FolioPedido.setBorder(null);
        TextField_FolioPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_FolioPedidoActionPerformed(evt);
            }
        });

        TextField_Cliente.setEditable(false);
        TextField_Cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_Cliente.setBorder(null);
        TextField_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_ClienteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Cliente:");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Fecha Entrega:");

        TextField_FechaEnt.setEditable(false);
        TextField_FechaEnt.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextField_FechaEnt.setBorder(null);

        jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave Aro", "Detalle Aro", "Tratamiento Adicional", "Folio Aro", "Cantidad Aros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDetalles);
        if (jTableDetalles.getColumnModel().getColumnCount() > 0) {
            jTableDetalles.getColumnModel().getColumn(0).setResizable(false);
            jTableDetalles.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableDetalles.getColumnModel().getColumn(1).setResizable(false);
            jTableDetalles.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableDetalles.getColumnModel().getColumn(2).setResizable(false);
            jTableDetalles.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTableDetalles.getColumnModel().getColumn(3).setResizable(false);
            jTableDetalles.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableDetalles.getColumnModel().getColumn(4).setResizable(false);
            jTableDetalles.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        button_Salir.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        button_Salir.setText("Cerrar ");
        button_Salir.setContentAreaFilled(false);
        button_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SalirActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Folio Orden de Carga:");

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Modo Pago:");

        TextField_ModoPago.setEditable(false);
        TextField_ModoPago.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextField_ModoPago.setBorder(null);
        TextField_ModoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_ModoPagoActionPerformed(evt);
            }
        });

        TextField_Factura.setEditable(false);
        TextField_Factura.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextField_Factura.setBorder(null);
        TextField_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_FacturaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Factura:");

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Conductor:");

        TextField_Conductor.setEditable(false);
        TextField_Conductor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextField_Conductor.setBorder(null);
        TextField_Conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_ConductorActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Transporte:");

        TextField_Transporte.setEditable(false);
        TextField_Transporte.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextField_Transporte.setBorder(null);
        TextField_Transporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_TransporteActionPerformed(evt);
            }
        });

        button_Actualizar.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        button_Actualizar.setText("Actualizar");
        button_Actualizar.setContentAreaFilled(false);
        button_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ActualizarActionPerformed(evt);
            }
        });

        jComboBox_FolioOrdCarga.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jComboBox_FolioOrdCarga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item" }));
        jComboBox_FolioOrdCarga.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(label_title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_FolioOrdCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TextField_ModoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TextField_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextField_Conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextField_Transporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextField_Factura, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(TextField_FolioPedido)
                                .addComponent(TextField_FechaEnt)))
                        .addGap(82, 82, 82))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335)
                        .addComponent(button_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_FolioPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox_FolioOrdCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_FechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TextField_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TextField_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(TextField_ModoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Transporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(TextField_Conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_FolioPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_FolioPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_FolioPedidoActionPerformed

    private void TextField_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_ClienteActionPerformed

    private void button_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_SalirActionPerformed

    private void TextField_ModoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_ModoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_ModoPagoActionPerformed

    private void TextField_FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_FacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_FacturaActionPerformed

    private void TextField_ConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_ConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_ConductorActionPerformed

    private void TextField_TransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_TransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_TransporteActionPerformed

    private void button_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_ActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextField_Cliente;
    private javax.swing.JTextField TextField_Conductor;
    private javax.swing.JTextField TextField_Factura;
    private javax.swing.JTextField TextField_FechaEnt;
    private javax.swing.JTextField TextField_FolioPedido;
    private javax.swing.JTextField TextField_ModoPago;
    private javax.swing.JTextField TextField_Transporte;
    private javax.swing.JButton button_Actualizar;
    private javax.swing.JButton button_Salir;
    private javax.swing.JComboBox<String> jComboBox_FolioOrdCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalles;
    private javax.swing.JLabel label_title;
    // End of variables declaration//GEN-END:variables
}
