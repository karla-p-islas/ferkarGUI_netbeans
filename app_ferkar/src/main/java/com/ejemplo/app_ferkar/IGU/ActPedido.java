package com.ejemplo.app_ferkar.IGU;

import com.ejemplo.app_ferkar.persistencia.Carga;
import com.ejemplo.app_ferkar.persistencia.CargaDAO;
import com.ejemplo.app_ferkar.persistencia.DetalleCarga;
import com.ejemplo.app_ferkar.persistencia.Inventario;
import com.ejemplo.app_ferkar.persistencia.InventarioDAO;
import com.ejemplo.app_ferkar.persistencia.Pedido;
import com.ejemplo.app_ferkar.persistencia.PedidoDAO;
import com.ejemplo.app_ferkar.persistencia.Soldador;
import com.ejemplo.app_ferkar.persistencia.SoldadorDAO;
import com.ejemplo.app_ferkar.persistencia.Stock;
import com.ejemplo.app_ferkar.persistencia.TipoAro;
import com.ejemplo.app_ferkar.persistencia.TipoAroDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kpaor
 */
public class ActPedido extends javax.swing.JFrame {

    Soldador id = new Soldador();
    SoldadorDAO idd = new SoldadorDAO();
    Pedido pe = new Pedido();
    PedidoDAO ped = new PedidoDAO();
    Carga cg = new Carga();
    CargaDAO cgd = new CargaDAO();
    TipoAro tipoA = new TipoAro();
    TipoAroDAO tipoAd = new TipoAroDAO();
    Inventario inv = new Inventario();
    InventarioDAO invd = new InventarioDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    int xMouse, yMouse;
    int item;
    int TotalAtados;
    ArrayList<Stock> listaStock = new ArrayList<>();
    ArrayList<Inventario> listaExistencias = new ArrayList<>();

    
    public static int CantidadAros(int clave, int cantidad){
        int ultimoNum = clave %10;
        int multi;
        
        switch(ultimoNum){
            case 4 -> multi = 25;
            case 8 -> multi = 20;
            case 5 -> multi = 10;
            default -> {
                return -1;
            }
        }
        return cantidad * multi;
    }
    
    public ActPedido(Pedido pd) {
        initComponents();
        textF_client.setText(pd.getCliente());
        textF_folio.setText(pd.getNum_pedido());
        switch (pd.getEstado()){
            case "Pedido" -> comboBox_Estado.setSelectedIndex(0);
            case "En producción" -> comboBox_Estado.setSelectedIndex(1);
            case "Cargado" -> comboBox_Estado.setSelectedIndex(2);
            case "Enviado" -> comboBox_Estado.setSelectedIndex(3);
            case "Envio incompleto" -> comboBox_Estado.setSelectedIndex(4);
            case "Entregado" -> comboBox_Estado.setSelectedIndex(5);
            case "Cancelado" -> comboBox_Estado.setSelectedIndex(6);
        }
    }
    
    private void ActEstado(String folio, String estado){
        pe.setNum_pedido(folio);
        pe.setEstado(estado);
        ped.ModificarPedido(pe);
    }
       
    private void InfoCarga() throws ParseException{
        String folio_orden = textField_OrdenCarga.getText();
        String num_pedido = textF_folio.getText();
        String fecha = textF_dateDelivery.getText();
        String modo_p = (String) jComboBox_ModoPago.getSelectedItem();
        String num_fact = jTextField_Factura.getText();
        int id_cond = Integer.parseInt(textF_IDConductor.getText());
        String transporte = (String) comboBox_transporte.getSelectedItem();
        cg.setFolio_orden(folio_orden);
        cg.setNum_pedido(num_pedido);
        cg.setFecha_en(fecha);
        cg.setModo_pago(modo_p);
        cg.setNum_factura(num_fact);
        cg.setId_conductor(id_cond);
        cg.setTransporte(transporte);
        
        cgd.InfoCarga(cg);
    }
    
    private void ArosCargados(){
        if (Tabla_Cargas.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay aros cargados");
        }else{
            for(int i = 0; i<Tabla_Cargas.getRowCount(); i++){
                String serial = textField_OrdenCarga.getText() + "-" + i;
                String folio_orden = textField_OrdenCarga.getText();
                String clave = Tabla_Cargas.getValueAt(i, 0).toString();
                String folio_aro = Tabla_Cargas.getValueAt(i, 3).toString();
                String trato_ad = Tabla_Cargas.getValueAt(i, 2).toString();
                int cantidad = Integer.parseInt(Tabla_Cargas.getValueAt(i, 4).toString());
                
                DetalleCarga dc = new DetalleCarga();
                dc.setNum_serial(serial);
                dc.setFolio_orden(folio_orden);
                dc.setFolio_aro(folio_aro);
                dc.setClave(clave);
                dc.setTratamiento_adicional(trato_ad);
                dc.setCantidad(cantidad);
                
                cgd.ArosCargados(dc);
            }
        }
    }
    
    private void TotalAtados(){
        TotalAtados = 0;
        int numFila = Tabla_Cargas.getRowCount();
        for(int i = 0; i < numFila ; i++){
            int cal = Integer.parseInt(String.valueOf(Tabla_Cargas.getValueAt(i, 4)));
            TotalAtados = TotalAtados + cal;
        }
        jTextField_totalAtados.setText(""+TotalAtados);
    }
    
    private int ConsultarStock(String folio){   //produccion diaria
        int atados = 0;
        atados = invd.ConsultarStock(folio);
        return atados;
    }
    
    private int ConsultarExistenciaAtado(String clave, String trato){    //existencias aros
        List<Inventario> lista = invd.ExistenciaAroClaveTrato(clave, trato);
        if(lista.isEmpty()){
            return 0;
        }else{
            Inventario inv = lista.get(0);
            return inv.getAtados();
        }
    }
    
    private int ConsultarExistenciaAros(String clave, String trato){    //existencias aros
        List<Inventario> lista = invd.ExistenciaAroClaveTrato(clave, trato);
        if(lista.isEmpty()){
            return 0;
        }else{
            Inventario inv = lista.get(0);
            return inv.getAros();
        }
    }
    
    private void ReducirStock(Stock st) throws SQLException{
        invd.ReducirStock(st);
    }
    
    private void ReducirExistencias(Inventario inv){
        invd.ReducirExistencias(inv);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_title = new javax.swing.JLabel();
        label_Cliente = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        label_cantidad = new javax.swing.JLabel();
        textF_client = new javax.swing.JTextField();
        label_folio = new javax.swing.JLabel();
        textF_folio = new javax.swing.JTextField();
        textF_Cantidad = new javax.swing.JTextField();
        button_Clean = new javax.swing.JButton();
        button_Finish = new javax.swing.JButton();
        button_Atras = new javax.swing.JButton();
        label_pedido = new javax.swing.JLabel();
        comboBox_Estado = new javax.swing.JComboBox<>();
        label_foliosEnviados = new javax.swing.JLabel();
        textField_Clave = new javax.swing.JTextField();
        label_IDConductor = new javax.swing.JLabel();
        textF_IDConductor = new javax.swing.JTextField();
        label_Transporte = new javax.swing.JLabel();
        comboBox_transporte = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_ModoPago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Folio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Cargas = new javax.swing.JTable();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textField_OrdenCarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Factura = new javax.swing.JTextField();
        label_IDConductor1 = new javax.swing.JLabel();
        jTextField_nombreConductor = new javax.swing.JTextField();
        textF_dateDelivery = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        OC_Reforzado = new javax.swing.JCheckBox();
        OC_Galvanizado = new javax.swing.JCheckBox();
        OC_Pintado = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField_totalAtados = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1050, 800));
        setMinimumSize(new java.awt.Dimension(1050, 800));
        setPreferredSize(new java.awt.Dimension(1043, 750));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_title.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        label_title.setText("Orden de Carga");
        jPanel1.add(label_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, 37));

        label_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        label_Cliente.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_Cliente.setText("Cliente:");
        jPanel1.add(label_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, 30));

        label_date.setBackground(new java.awt.Color(255, 255, 255));
        label_date.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_date.setText("Fecha Entrega:");
        jPanel1.add(label_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 140, 30));

        label_cantidad.setBackground(new java.awt.Color(255, 255, 255));
        label_cantidad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_cantidad.setText("Cantidad Atados:");
        jPanel1.add(label_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 130, 30));

        textF_client.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textF_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textF_clientActionPerformed(evt);
            }
        });
        jPanel1.add(textF_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 260, 30));

        label_folio.setBackground(new java.awt.Color(255, 255, 255));
        label_folio.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_folio.setText("Folio Pedido:");
        jPanel1.add(label_folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 120, 30));

        textF_folio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textF_folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textF_folioActionPerformed(evt);
            }
        });
        jPanel1.add(textF_folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 110, 30));

        textF_Cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textF_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textF_CantidadActionPerformed(evt);
            }
        });
        jPanel1.add(textF_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 70, 30));

        button_Clean.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        button_Clean.setText("Limpiar");
        button_Clean.setContentAreaFilled(false);
        button_Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CleanActionPerformed(evt);
            }
        });
        jPanel1.add(button_Clean, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 320, 110, 30));

        button_Finish.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        button_Finish.setText("Terminar");
        button_Finish.setContentAreaFilled(false);
        button_Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_FinishActionPerformed(evt);
            }
        });
        jPanel1.add(button_Finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 610, 110, 30));

        button_Atras.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        button_Atras.setText("Atrás");
        button_Atras.setContentAreaFilled(false);
        button_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(button_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 670, 110, -1));

        label_pedido.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_pedido.setText("Estado: ");
        jPanel1.add(label_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, 30));

        comboBox_Estado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comboBox_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedido", "Enviado", "Envio incompleto", "Entregado", "Cancelado" }));
        comboBox_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_EstadoActionPerformed(evt);
            }
        });
        jPanel1.add(comboBox_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 110, 30));

        label_foliosEnviados.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        label_foliosEnviados.setText("Clave:");
        jPanel1.add(label_foliosEnviados, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 60, 30));

        textField_Clave.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(textField_Clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 80, 30));

        label_IDConductor.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_IDConductor.setText("Conductor:");
        jPanel1.add(label_IDConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, 30));

        textF_IDConductor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        textF_IDConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textF_IDConductorActionPerformed(evt);
            }
        });
        textF_IDConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textF_IDConductorKeyPressed(evt);
            }
        });
        jPanel1.add(textF_IDConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 60, 30));

        label_Transporte.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_Transporte.setText("Transporte Usado:");
        jPanel1.add(label_Transporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 140, 30));

        comboBox_transporte.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        comboBox_transporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "F-2015", "F-2020", "FK-001", "Autos", "Externos" }));
        comboBox_transporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_transporteActionPerformed(evt);
            }
        });
        jPanel1.add(comboBox_transporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\kpaor\\Downloads\\ferkar_logo_150x90.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 90));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setText("# Factura:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 80, 30));

        jComboBox_ModoPago.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jComboBox_ModoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Efectivo", "Cheque", "Transferencia" }));
        jComboBox_ModoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ModoPagoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_ModoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 120, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Atados:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 690, 110, 30));

        jTextField_Folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FolioActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 110, 30));

        Tabla_Cargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Detalle", "Tratamiento Adicional", "Folio Enviado", "Cantidad Atados"
            }
        ));
        Tabla_Cargas.setRowHeight(30);
        jScrollPane1.setViewportView(Tabla_Cargas);
        if (Tabla_Cargas.getColumnModel().getColumnCount() > 0) {
            Tabla_Cargas.getColumnModel().getColumn(0).setPreferredWidth(20);
            Tabla_Cargas.getColumnModel().getColumn(1).setPreferredWidth(150);
            Tabla_Cargas.getColumnModel().getColumn(2).setPreferredWidth(20);
            Tabla_Cargas.getColumnModel().getColumn(3).setPreferredWidth(20);
            Tabla_Cargas.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 820, 270));

        jButton_Agregar.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setContentAreaFilled(false);
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 110, 30));

        jButton_Eliminar.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setContentAreaFilled(false);
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, 110, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Aros Cargados");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 270, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setText("# Orden de Carga:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 140, 30));
        jPanel1.add(textField_OrdenCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 110, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel6.setText("Modo de Pago:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 110, 30));

        jTextField_Factura.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jPanel1.add(jTextField_Factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 80, 30));

        label_IDConductor1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        label_IDConductor1.setText("ID Conductor:");
        jPanel1.add(label_IDConductor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 30));

        jTextField_nombreConductor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField_nombreConductor.setBorder(null);
        jTextField_nombreConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreConductorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_nombreConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 280, 30));

        textF_dateDelivery.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jPanel1.add(textF_dateDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 120, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Adicional :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 90, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tratamiento ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 90, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        OC_Reforzado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        OC_Reforzado.setText("Reforzado");
        OC_Reforzado.setContentAreaFilled(false);
        OC_Reforzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OC_ReforzadoActionPerformed(evt);
            }
        });

        OC_Galvanizado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        OC_Galvanizado.setText("Galvanizado");
        OC_Galvanizado.setContentAreaFilled(false);
        OC_Galvanizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OC_GalvanizadoActionPerformed(evt);
            }
        });

        OC_Pintado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        OC_Pintado.setText("Pintado");
        OC_Pintado.setContentAreaFilled(false);
        OC_Pintado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OC_PintadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OC_Reforzado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OC_Galvanizado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OC_Pintado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(OC_Reforzado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OC_Galvanizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OC_Pintado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Folio Enviado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 110, 30));

        jTextField_totalAtados.setEditable(false);
        jTextField_totalAtados.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField_totalAtados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_totalAtados.setText("--");
        jTextField_totalAtados.setBorder(null);
        jPanel1.add(jTextField_totalAtados, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 690, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textF_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textF_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textF_clientActionPerformed

    private void textF_folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textF_folioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textF_folioActionPerformed

    private void textF_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textF_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textF_CantidadActionPerformed

    private void button_CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CleanActionPerformed
        textField_Clave.setText("");
        jTextField_Folio.setText("");
        textF_Cantidad.setText("");
        
    }//GEN-LAST:event_button_CleanActionPerformed

    private void button_FinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_FinishActionPerformed
        // TODO add your handling code here:
        String folio = textF_folio.getText();
        boolean fin = false;
        
        String estado = (String) comboBox_Estado.getSelectedItem();
        switch (estado){
            case "Pedido":
                JOptionPane.showMessageDialog(null, "Favor de Actualizar el estado del pedido");
                break;
            case "En producción":
                ActEstado(folio,estado);
                fin = false;
                break;
            case "Enviado":
                ActEstado(folio,estado);
            {
                try {
                    InfoCarga();
                    ArosCargados();
                } catch (ParseException ex) {
                    System.out.println(ex.toString());
                }
            }
                fin = true;
                break;
            case "Envio incompleto":
                ActEstado(folio,estado);
                {
                try {
                    InfoCarga();
                    ArosCargados();
                } catch (ParseException ex) {
                    Logger.getLogger(ActPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                fin = true;
                break;
            case "Entregado":
                ActEstado(folio,estado);
                fin = true;
                break;
            case "Cancelado":
                ActEstado(folio,estado);
                fin = true;
                break;
        }
        
        if (fin == true){
            JOptionPane.showMessageDialog(null, "Pedido actualizado");
            dispose();
        }
    }//GEN-LAST:event_button_FinishActionPerformed

    private void button_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_AtrasActionPerformed

    private void comboBox_transporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_transporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_transporteActionPerformed

    private void comboBox_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_EstadoActionPerformed

    private void jComboBox_ModoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ModoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ModoPagoActionPerformed

    private void jButton_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarActionPerformed
        // TODO add your handling code here:
        boolean estado = false; //estado para pasar al siguiente punto (posible descarte)
        boolean agregar_ex = true; //estado para agregar o no la línea con la informacion a la tabla de existencia
        boolean agregar_st = true; //estado para agregar o no la línea con la informacion a la tabla de stock
        int stock_atados_disp = 0;
        int existencia_atados_disp = 0;
        int existencia_aros_disp = 0;
        if (!"".equals(textField_Clave.getText()) && !"".equals(jTextField_Folio.getText()) && !"".equals(textF_Cantidad.getText())){
            
            //Obtener descripcion de la clave de aro
            String clave = textField_Clave.getText();
            int atados_requeridos = Integer.parseInt(textF_Cantidad.getText());
            int aros_requeridos = CantidadAros(Integer.parseInt(clave),atados_requeridos);
            String detalle = "";
            tipoA = tipoAd.BuscarPro(clave);
            if (Integer.parseInt(tipoA.getCodigo_aro()) != 0){
                detalle = tipoA.getDescripcion_esp();
            }else{
                textField_Clave.setText("");
                textField_Clave.requestFocus();
                JOptionPane.showMessageDialog(null, "Favor de ingresar un código de aro valido");
            }
            
            //Tratamiento adicional
            String TratamientoA = "";
            if(!OC_Galvanizado.isSelected() && !OC_Pintado.isSelected() && !OC_Reforzado.isSelected()){
                TratamientoA = "NADA";
            }else{
                if(OC_Galvanizado.isSelected()){
                    TratamientoA += "G";
                }
                if(OC_Pintado.isSelected()){
                    TratamientoA += "P";
                }
                if(OC_Reforzado.isSelected()){
                    TratamientoA += "R";
                }
            }
            String trato = TratamientoA;
            
            //obtener folios, en caso de que no sea correcto aparece el formato
            String folio = jTextField_Folio.getText();
            if(folio.length() != 8){
                ImageIcon imagen = new ImageIcon("C:/Users/kpaor/OneDrive/Escritorio/RASTREABILIDAD/Formato folio.png");
                JOptionPane.showMessageDialog(null, imagen);
                jTextField_Folio.setText("");
                jTextField_Folio.requestFocus();
                return;
            }else{
                estado = true;  //si es correcto, se cambia a true
                
                //revisar la tabla de stock disponible 
                stock_atados_disp = ConsultarStock(folio);  //en caso de que no se encuentre (caso default)
                for(Stock e :listaStock){
                    if(e.getFolio().equals(folio)){
                        //si lo encuentra actualiza la cantidad
                        stock_atados_disp = e.getCantidad();
                        int stock_nuevos_disp = stock_atados_disp - atados_requeridos;
                        e.setCantidad(stock_nuevos_disp);
                        agregar_st = false;
                    }
                }
                int stock_nuevos_disp = stock_atados_disp - atados_requeridos; //reduce la cantidad de requeridos
                //agregar a tabla de stock
                if(agregar_st){
                    listaStock.add(new Stock(folio,stock_nuevos_disp));
                }                
                //revisar la tabla de existencias disponibles
                existencia_atados_disp = ConsultarExistenciaAtado(clave,trato);
                existencia_aros_disp = ConsultarExistenciaAros(clave,trato);
                for(Inventario e :listaExistencias){
                    if(e.getCodigo_aros().equals(clave) && e.getTrato_adicional().equals(trato)){
                        //si lo encuentra actualiza la cantidad
                        existencia_atados_disp = e.getAtados();
                        existencia_aros_disp = e.getAros();
                        int ex_nuevos_at_disp = existencia_atados_disp - atados_requeridos;
                        int ex_nuevos_ar_diso = existencia_aros_disp - aros_requeridos;
                        e.setAtados(ex_nuevos_at_disp);
                        e.setAros(ex_nuevos_ar_diso);
                        agregar_ex = false;
                    }
                }
                int ex_nuevos_at_disp = existencia_atados_disp - atados_requeridos;
                int ex_nuevos_ar_diso = existencia_aros_disp - aros_requeridos;
                //agregar a tabla de existencias
                if(agregar_ex){
                    listaExistencias.add(new Inventario(clave,trato,ex_nuevos_ar_diso,ex_nuevos_at_disp));
                }
                
                JOptionPane.showMessageDialog(null, "Folio: " + folio + " Existencias: "+stock_atados_disp + 
                        " "+ " Clave: " + clave + " trato: " + trato + " cantidad: "+ existencia_atados_disp);
                item ++;
                modelo = (DefaultTableModel) Tabla_Cargas.getModel();

                ArrayList lista = new ArrayList();  
                lista.add(item);
                lista.add(clave);
                lista.add(detalle);
                lista.add(trato);
                lista.add(folio);
                lista.add(atados_requeridos);
                Object[] O = new Object[5];
                O[0] = lista.get(1);
                O[1] = lista.get(2);
                O[2] = lista.get(3);
                O[3] = lista.get(4);
                O[4] = lista.get(5);

                modelo.addRow(O);
                Tabla_Cargas.setModel(modelo);
                TotalAtados();

                textField_Clave.setText("");
                jTextField_Folio.setText("");
                textF_Cantidad.setText("");
                OC_Reforzado.setSelected(false);
                OC_Galvanizado.setSelected(false);
                OC_Pintado.setSelected(false);
                textField_Clave.requestFocus();
            }                  
        }else{
            JOptionPane.showMessageDialog(null, "Información Incompleta");
        }
    }//GEN-LAST:event_jButton_AgregarActionPerformed

    private void textF_IDConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textF_IDConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textF_IDConductorActionPerformed

    private void textF_IDConductorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textF_IDConductorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
             if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!"".equals(textF_IDConductor.getText())){
                String id_s = textF_IDConductor.getText();
                id = idd.BuscarPro(id_s);
                if (id.getId_soldador() != 0){
                    jTextField_nombreConductor.setText(""+id.getNombre_completo());
                    
                }else{
                    textF_IDConductor.setText("");
                    jTextField_nombreConductor.setText("");
                    textF_IDConductor.requestFocus();
                    JOptionPane.showMessageDialog(null, "Favor de revisar el id");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingresar un id (1-11)");
                textF_IDConductor.requestFocus();
            }
        }
        }
    }//GEN-LAST:event_textF_IDConductorKeyPressed

    private void jTextField_FolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FolioActionPerformed

    private void OC_ReforzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OC_ReforzadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OC_ReforzadoActionPerformed

    private void OC_GalvanizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OC_GalvanizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OC_GalvanizadoActionPerformed

    private void OC_PintadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OC_PintadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OC_PintadoActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        // TODO add your handling code here:
        modelo = (DefaultTableModel) Tabla_Cargas.getModel();
        
        //regresar los valores al inventario
        int fila = Tabla_Cargas.getSelectedRow();
        //obtener valores
        String clave = (String) Tabla_Cargas.getValueAt(fila, 0);
        String trato = (String) Tabla_Cargas.getValueAt(fila, 2);
        String folio = (String) Tabla_Cargas.getValueAt(fila, 3);
        int atados = Integer.parseInt(Tabla_Cargas.getValueAt(fila, 4).toString());
        
        for(Stock e :listaStock){
            if(e.getFolio().equals(folio)){
                //si lo encuentra actualiza la cantidad
                int stock_nuevos_disp = e.getCantidad() + atados;
                e.setCantidad(stock_nuevos_disp);
            }
        }
        
        for(Inventario e :listaExistencias){
            if(e.getCodigo_aros().equals(clave) && e.getTrato_adicional().equals(trato)){
                //si lo encuentra actualiza la cantidad
                int ex_nuevos_at_disp = e.getAtados() + atados;
                int aros_requeridos = CantidadAros(Integer.parseInt(clave),atados);
                int ex_nuevos_ar_diso = e.getAros() + aros_requeridos;
                e.setAtados(ex_nuevos_at_disp);
                e.setAros(ex_nuevos_ar_diso);
            }
        }
        modelo.removeRow(Tabla_Cargas.getSelectedRow());
        TotalAtados();  
        textField_Clave.requestFocus();
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jTextField_nombreConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombreConductorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox OC_Galvanizado;
    private javax.swing.JCheckBox OC_Pintado;
    private javax.swing.JCheckBox OC_Reforzado;
    private javax.swing.JTable Tabla_Cargas;
    private javax.swing.JButton button_Atras;
    private javax.swing.JButton button_Clean;
    private javax.swing.JButton button_Finish;
    private javax.swing.JComboBox<String> comboBox_Estado;
    private javax.swing.JComboBox<String> comboBox_transporte;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JComboBox<String> jComboBox_ModoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Factura;
    private javax.swing.JTextField jTextField_Folio;
    private javax.swing.JTextField jTextField_nombreConductor;
    private javax.swing.JTextField jTextField_totalAtados;
    private javax.swing.JLabel label_Cliente;
    private javax.swing.JLabel label_IDConductor;
    private javax.swing.JLabel label_IDConductor1;
    private javax.swing.JLabel label_Transporte;
    private javax.swing.JLabel label_cantidad;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_folio;
    private javax.swing.JLabel label_foliosEnviados;
    private javax.swing.JLabel label_pedido;
    private javax.swing.JLabel label_title;
    private javax.swing.JTextField textF_Cantidad;
    private javax.swing.JTextField textF_IDConductor;
    private javax.swing.JTextField textF_client;
    private javax.swing.JFormattedTextField textF_dateDelivery;
    private javax.swing.JTextField textF_folio;
    private javax.swing.JTextField textField_Clave;
    private javax.swing.JTextField textField_OrdenCarga;
    // End of variables declaration//GEN-END:variables
}
