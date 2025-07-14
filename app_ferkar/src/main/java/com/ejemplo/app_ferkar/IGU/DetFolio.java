/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ejemplo.app_ferkar.IGU;

import com.ejemplo.app_ferkar.persistencia.IngresoInventario;
import com.ejemplo.app_ferkar.persistencia.IngresoInventarioDAO;
import com.ejemplo.app_ferkar.persistencia.Soldador;
import com.ejemplo.app_ferkar.persistencia.SoldadorDAO;
import com.ejemplo.app_ferkar.persistencia.TipoAro;
import com.ejemplo.app_ferkar.persistencia.TipoAroDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author kpaor
 */
public class DetFolio extends javax.swing.JFrame {

    IngresoInventario ii = new IngresoInventario();
    IngresoInventarioDAO iid = new IngresoInventarioDAO();
    TipoAro tipoA = new TipoAro();
    TipoAroDAO tipoAd = new TipoAroDAO();
    Soldador id = new Soldador();
    SoldadorDAO idd = new SoldadorDAO();
    
    public DetFolio(String folio) {
        initComponents();
        TextField_Folio.setText(folio);

        LlenarDetalles(folio);
    }
    
    public void LlenarDetalles(String folio){
        ii = iid.InfoFolio(folio);
        String ubi = ii.getUbicacion();
        id = idd.BuscarPro(String.valueOf(ii.getId_soldador()));
        tipoA = tipoAd.BuscarPro(ii.getCodigo_aro());
        
        switch(ii.getUbicacion()){
            case "-" -> jComboBox1.setSelectedIndex(0);
            case "Cuarto1" -> jComboBox1.setSelectedIndex(1);
            case "Cuarto 2" -> jComboBox1.setSelectedIndex(2);
            case "Azotea" -> jComboBox1.setSelectedIndex(3);
            case "Accesoria 1" -> jComboBox1.setSelectedIndex(4);
            case "Accesoria 2" -> jComboBox1.setSelectedIndex(5);
            case "A. Producción" -> jComboBox1.setSelectedIndex(6);
        }
        
        TextField_Fecha.setText(ii.getFecha());
        TextField_Caseta.setText(String.valueOf(ii.getCaseta()));
        TextField_codigo.setText(ii.getCodigo_aro());
        TextField_TratoAdi.setText(ii.getTratamiento_adicional());
        TextField_CantidadAros.setText(String.valueOf(ii.getCantidad()));
        TextField_CantidadAtados.setText(String.valueOf(ii.getCantidad_atados()));
        TextField_CantidadAtados1.setText(String.valueOf(ii.getCantidad_exs()));
        TextField_soldador.setText(id.getNombre_completo());
        TextField_tipoAro.setText(tipoA.getDescripcion_esp());
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_title = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TextField_Folio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TextField_Fecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TextField_codigo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TextField_tipoAro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TextField_TratoAdi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TextField_soldador = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TextField_Caseta = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        button_Atras = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TextField_CantidadAros = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TextField_CantidadAtados = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TextField_CantidadAtados1 = new javax.swing.JTextField();
        button_Modificar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(690, 450));
        setMinimumSize(new java.awt.Dimension(690, 450));
        setPreferredSize(new java.awt.Dimension(690, 450));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\kpaor\\Downloads\\ferkar_logo_150x90.jpg")); // NOI18N

        label_title.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        label_title.setText("Detalle Folio Producido");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Folio:");

        TextField_Folio.setEditable(false);
        TextField_Folio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_Folio.setBorder(null);
        TextField_Folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_FolioActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Fecha:");

        TextField_Fecha.setEditable(false);
        TextField_Fecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_Fecha.setBorder(null);
        TextField_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_FechaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Código:");

        TextField_codigo.setEditable(false);
        TextField_codigo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_codigo.setBorder(null);
        TextField_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_codigoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Tipo Aro:");

        TextField_tipoAro.setEditable(false);
        TextField_tipoAro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_tipoAro.setBorder(null);
        TextField_tipoAro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_tipoAroActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Adicional:");

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Trato");

        TextField_TratoAdi.setEditable(false);
        TextField_TratoAdi.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_TratoAdi.setBorder(null);
        TextField_TratoAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_TratoAdiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_TratoAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_TratoAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Soldador:");

        TextField_soldador.setEditable(false);
        TextField_soldador.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        TextField_soldador.setBorder(null);
        TextField_soldador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_soldadorActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Caseta:");
        jLabel13.setAlignmentY(0.0F);

        TextField_Caseta.setEditable(false);
        TextField_Caseta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_Caseta.setBorder(null);
        TextField_Caseta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CasetaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Ubicación:");

        button_Atras.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        button_Atras.setText("Atrás");
        button_Atras.setContentAreaFilled(false);
        button_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AtrasActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Cantidad");

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Aros:");

        TextField_CantidadAros.setEditable(false);
        TextField_CantidadAros.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_CantidadAros.setBorder(null);
        TextField_CantidadAros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CantidadArosActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Atados");

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Producidos:");

        TextField_CantidadAtados.setEditable(false);
        TextField_CantidadAtados.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_CantidadAtados.setAlignmentX(0.0F);
        TextField_CantidadAtados.setAlignmentY(0.0F);
        TextField_CantidadAtados.setBorder(null);
        TextField_CantidadAtados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CantidadAtadosActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Atados en");

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Existencia:");

        TextField_CantidadAtados1.setEditable(false);
        TextField_CantidadAtados1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TextField_CantidadAtados1.setAlignmentX(0.0F);
        TextField_CantidadAtados1.setAlignmentY(0.0F);
        TextField_CantidadAtados1.setBorder(null);
        TextField_CantidadAtados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CantidadAtados1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_CantidadAros, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_CantidadAtados, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField_CantidadAtados1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_CantidadAtados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25))
                    .addComponent(TextField_CantidadAros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27))
                        .addComponent(TextField_CantidadAtados1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        button_Modificar.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        button_Modificar.setText("Modificar");
        button_Modificar.setContentAreaFilled(false);
        button_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ModificarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Cuarto1", "Cuarto 2", "Azotea", "Accesoria 1", "Accesoria 2", "A. Producción" }));
        jComboBox1.setAlignmentX(0.0F);
        jComboBox1.setAlignmentY(0.0F);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(label_title)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextField_Folio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_codigo)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_Caseta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_tipoAro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(TextField_soldador, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TextField_Folio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(TextField_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(TextField_Caseta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TextField_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(TextField_tipoAro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TextField_soldador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox1))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Atras)
                    .addComponent(button_Modificar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_FolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_FolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_FolioActionPerformed

    private void TextField_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_FechaActionPerformed

    private void TextField_CasetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CasetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_CasetaActionPerformed

    private void TextField_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_codigoActionPerformed

    private void TextField_tipoAroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_tipoAroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_tipoAroActionPerformed

    private void TextField_TratoAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_TratoAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_TratoAdiActionPerformed

    private void TextField_soldadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_soldadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_soldadorActionPerformed

    private void TextField_CantidadArosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CantidadArosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_CantidadArosActionPerformed

    private void TextField_CantidadAtadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CantidadAtadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_CantidadAtadosActionPerformed

    private void button_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_AtrasActionPerformed

    private void button_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ModificarActionPerformed
        // TODO add your handling code here:
        String folio = TextField_Folio.getText();
        ii = iid.InfoFolio(folio);
        String ubi = String.valueOf(jComboBox1.getSelectedItem());
        if(ii.getUbicacion() != ubi){
            boolean mod_f = iid.ModificarFolio(ubi, folio);
            if(mod_f){
                JOptionPane.showMessageDialog(null, "Folio modificado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Solo se modifica el espacio de almacen");
        }
    }//GEN-LAST:event_button_ModificarActionPerformed

    private void TextField_CantidadAtados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CantidadAtados1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_CantidadAtados1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextField_CantidadAros;
    private javax.swing.JTextField TextField_CantidadAtados;
    private javax.swing.JTextField TextField_CantidadAtados1;
    private javax.swing.JTextField TextField_Caseta;
    private javax.swing.JTextField TextField_Fecha;
    private javax.swing.JTextField TextField_Folio;
    private javax.swing.JTextField TextField_TratoAdi;
    private javax.swing.JTextField TextField_codigo;
    private javax.swing.JTextField TextField_soldador;
    private javax.swing.JTextField TextField_tipoAro;
    private javax.swing.JButton button_Atras;
    private javax.swing.JButton button_Modificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_title;
    // End of variables declaration//GEN-END:variables
}
