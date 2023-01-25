/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.CategoriaProducto;
import CapaDTO.DetalleVenta;
import CapaDTO.Producto;
import CapaDTO.SolicitudVenta;
import CapaNegocio.NegocioCategoriaProducto;
import CapaNegocio.NegocioDetalleVenta;
import CapaNegocio.NegocioProducto;
import CapaNegocio.NegocioSolicitudVenta;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
//import com.itextpdf.text.pdf.PdfTable;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Iterator;

/**
 *
 * @author Cesar
 */
public class VistaVendedor extends javax.swing.JFrame {

    /**
     * Creates new form VistaVendedor
     */
    public VistaVendedor() {
        initComponents();
        VistaLogin auxVista = new VistaLogin();
        lbl_rut.setText(auxVista.rut_usu);
        java.awt.Font fuente = new java.awt.Font("Tahoma",java.awt.Font.BOLD,18);
        table_detalleProd.getTableHeader().setFont(fuente);
        
    }
    
    String patron ="###,###,###";
    DecimalFormat numero = new DecimalFormat(patron);
    String patron2 = "#######";
    DecimalFormat numero2 = new DecimalFormat(patron2);
    
    
     
    public static int folio = 0; 
    public static String rut_cliente = "";
    public static int monto_final = 0;
    public static String rut_vendedor = "";
    
    public void buscarProducto(){
        
        if (txt_codProd.getText().length()!=0)
        {
            NegocioProducto auxNegocioProducto = new NegocioProducto();
            if(auxNegocioProducto.existeProducto(Integer.parseInt(txt_codProd.getText())))
            {
                Producto auxProducto = new Producto();
                auxProducto = auxNegocioProducto.buscaProducto(Integer.parseInt(txt_codProd.getText()));
                
                CategoriaProducto auxCategoria = new CategoriaProducto();
                NegocioCategoriaProducto auxNegocioCategoria = new NegocioCategoriaProducto();
                auxCategoria = auxNegocioCategoria.buscaCategoriaProducto(auxProducto.getId_categoria_prod());
                
                txt_categoriaProd.setText(auxCategoria.getNombre_categoria());
                txt_marcaProd.setText(auxProducto.getMarca_prod());
                txt_modeloProd.setText(auxProducto.getModelo_prod());
                txt_precioProd.setText(String.format("$%,d",auxProducto.getPrecio_unitario()));
                txt_cantidadProd.setEditable(true);
                txt_codProd.setEditable(false);
                
                
            }else{
                JOptionPane.showMessageDialog(null,"El codigo del producto no existe");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Primero escriba el codigo del producto");
        }
        
    }
    
    public void limpiarDatos(){
        txt_codProd.setText("");
        txt_categoriaProd.setText("");
        txt_marcaProd.setText("");
        txt_modeloProd.setText("");
        txt_cantidadProd.setText("");
        txt_precioProd.setText("");
        
    }
    
    public void limpiarTabla(){
        DefaultTableModel tb = (DefaultTableModel) table_detalleProd.getModel();
        int a = table_detalleProd.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
        tb.removeRow(tb.getRowCount()-1);
        txt_codProd.setEditable(true);
        txt_cantidadProd.setEditable(false);
        }
    }
    
//    private void ValorTotal()
//    {
//        int a = 0;
//        int b = 0;
//        
//        if (table_detalleProd.getRowCount()>0)
//        {
//            for (int i=0;i<table_detalleProd.getRowCount();i++)
//            {
//                b = Integer.parseInt(table_detalleProd.getValueAt(i,6).toString());
//                a+=b;
//            }
//            lbl_montoTotal.setText(String.valueOf(a));
//            
//        }
//    }
    
    public boolean existeIdProducto(JTable jtable, int id_prod, int colum)
    {
        boolean Existe = false;
        for (int i=0;i<jtable.getRowCount();i++)
        {
            if (Integer.parseInt(jtable.getValueAt(i, colum).toString())==(id_prod))
            {
                Existe = true;
            }
        }
        return Existe;
    }
 
    
    public void agregarTabla(JTable jtable, String id_prod){
        try {
            
        
        if(this.txt_codProd.getText().length()!=0 ||this.txt_categoriaProd.getText().length()!=0||this.txt_marcaProd.getText().length()!=0
                ||this.txt_modeloProd.getText().length()!=0)
        {
            if(this.txt_cantidadProd.getText().length()!=0)
            {
                NegocioProducto auxNegocioProducto = new NegocioProducto();
                if(auxNegocioProducto.existeProducto(Integer.parseInt(txt_codProd.getText())))
                {
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo = (DefaultTableModel) table_detalleProd.getModel();

                    int total_pago;
                    if (!existeIdProducto(jtable, Integer.parseInt(id_prod), 0))
                    {
                         Object[] num = new Object[7];

                        Producto auxProducto = new Producto();
                        auxProducto = auxNegocioProducto.buscaProducto(Integer.parseInt(txt_codProd.getText()));
                
                        CategoriaProducto auxCategoria = new CategoriaProducto();
                        NegocioCategoriaProducto auxNegocioCategoria = new NegocioCategoriaProducto();
                        auxCategoria = auxNegocioCategoria.buscaCategoriaProducto(auxProducto.getId_categoria_prod()); 
                        num [0] =auxProducto.getId_prod();
                        num [1] =(txt_categoriaProd.getText());
                        num [2] =(txt_modeloProd.getText());
                        num [3] =(txt_marcaProd.getText());
                        num [4] =((String.format("$%,d",auxProducto.getPrecio_unitario())));
                        num [5] =(Integer.parseInt(txt_cantidadProd.getText()));
                        num [6] =String.format("$%,d",(Integer.parseInt(txt_cantidadProd.getText())*auxProducto.getPrecio_unitario()));
                        modelo.addRow(num);
                        
                        total_pago = (Integer.parseInt(txt_cantidadProd.getText())*auxProducto.getPrecio_unitario());
                        monto_final = (Integer.parseInt(txt_cantidadProd.getText())*auxProducto.getPrecio_unitario()) + monto_final;
                        lbl_montoTotal.setText(String.format("$%,d",monto_final));
                        this.table_detalleProd.setModel(modelo);
                        txt_codProd.setEditable(true);
                        txt_cantidadProd.setEditable(false);

                        limpiarDatos();
                        
                    }else
                    {
                      JOptionPane.showMessageDialog(null,"El producto ya fue registrado");  
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El producto no existe");
                }
                        
            }else{
                JOptionPane.showMessageDialog(null, "Primero ingrese la cantidad");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Primero busque un Producto");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Primero busque un Producto"+e.getMessage());
        }
        
    }
    

    
    
    public void guardarDetalleVenta(){
        if(txt_rutCli.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese el rut del cliente");
        }else{
            if(table_detalleProd.getRowCount()>0)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Termino de agregar Productos?, ¿Desea Continuar?", "Generar Venta"
                        ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    try 
                    {
                        NegocioDetalleVenta auxNegocioDetalle = new NegocioDetalleVenta();
                        folio = auxNegocioDetalle.sumarFolio();
                        for(int i = 0;i<table_detalleProd.getRowCount();i++)
                        {
                            try 
                            {
                                NegocioProducto auxNegocioProducto = new NegocioProducto();
                                Producto auxProducto = new Producto();
                                
                                auxProducto = auxNegocioProducto.buscaProducto(Integer.parseInt(table_detalleProd.getValueAt(i, 0).toString()));
                                //Asignar los valores de la tabla a una variable
                                Object cod_prod = table_detalleProd.getValueAt(i, 0);
                                Object categoria_prod = table_detalleProd.getValueAt(i, 1);
                                Object modelo_prod = table_detalleProd.getValueAt(i, 2);
                                Object marca_prod = table_detalleProd.getValueAt(i, 3);
                                Object precio_prod = auxProducto.getPrecio_unitario();
                                Object cantidad_prod = table_detalleProd.getValueAt(i, 5);
                                Object precioTotal_prod = Integer.parseInt(table_detalleProd.getValueAt(i, 5).toString())*auxProducto.getPrecio_unitario();

                                String rut_usu = lbl_rut.getText();
                                String rut_cli = txt_rutCli.getText();
                                
                                //Pasar los valores a un objeto tipo detalleVenta
                                DetalleVenta auxDetalleVenta = new DetalleVenta();
                                auxDetalleVenta.setFolio_detalle_venta(folio);
                                auxDetalleVenta.setId_prod(Integer.parseInt(cod_prod.toString()));
                                auxDetalleVenta.setNombre_categoria(categoria_prod.toString());
                                auxDetalleVenta.setMarca_prod((marca_prod.toString()));
                                auxDetalleVenta.setModelo_prod(modelo_prod.toString());
                                auxDetalleVenta.setPrecio_unitario_prod(Integer.parseInt(precio_prod.toString()));
                                auxDetalleVenta.setPrecio_total_detalle(Integer.parseInt(precioTotal_prod.toString()));
                                auxDetalleVenta.setRut_cli(rut_cli);
                                auxDetalleVenta.setRut_usu(rut_usu);
                                auxDetalleVenta.setCantidad_prod(Integer.parseInt(cantidad_prod.toString()));
                                
                                //Insertar En detalle venta
                                auxNegocioDetalle.insertarDetalleVenta(auxDetalleVenta);
                                
                                
                                
                                
                                

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "No se pudo registrar"+e.getMessage());
                            }
                        }
                        //Pasar los valores a un objeto solicitudVenta
                                SolicitudVenta auxSolicitud = new SolicitudVenta();
                                auxSolicitud.setRut_cli(txt_rutCli.getText());
                                auxSolicitud.setFolio_detalle_venta(folio);
                                
                                NegocioSolicitudVenta auxNegocioSolicitud = new NegocioSolicitudVenta();
                                auxNegocioSolicitud.insertarSolicitudVenta(auxSolicitud);
                                JOptionPane.showMessageDialog(null,"La solicitud de venta fue generada");
                                limpiarDatos();
                                limpiarTabla();
                                txt_rutCli.setText("");
                                lbl_montoTotal.setText("");
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
    
    public void eliminarProducto(){
        
        int fila = table_detalleProd.getSelectedRow();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) table_detalleProd.getModel();
        if(fila == -1)
        {
            JOptionPane.showMessageDialog(null,"Seleccione el producto que desee eliminar");
        }
        else{
            modelo.removeRow(fila);
        }
        
    }
    
    public void validarStock(){
        
        try {
            
            NegocioProducto auxNegocioProducto = new NegocioProducto();
            Iterator iter = auxNegocioProducto.consultaProducto().iterator();
            while(iter.hasNext())
            {
                Producto auxProducto = new Producto();
                auxProducto = (Producto) iter.next();
                int cod_prod = auxProducto.getId_prod();
                int stock_prod = auxProducto.getStock_prod();
                String marca =  auxProducto.getMarca_prod();
                String modelo = auxProducto.getModelo_prod();
                
                if(stock_prod < 10)
                {JOptionPane.showMessageDialog(null, "El producto con ID:"+cod_prod+" Marca:"+marca
                                                +" Modelo:"+modelo+" tiene un stock escaso de:"+stock_prod);
                }else{
                    
                }
            }
            
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_rut = new javax.swing.JLabel();
        bto_cerrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_precioProd = new javax.swing.JTextField();
        txt_modeloProd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_detalleProd = new javax.swing.JTable();
        bto_buscar = new javax.swing.JButton();
        bto_agregar = new javax.swing.JButton();
        bto_limpiar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_rutCli = new javax.swing.JTextField();
        txt_codProd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbl_montoTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bto_continuar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_marcaProd = new javax.swing.JTextField();
        txt_cantidadProd = new javax.swing.JTextField();
        bto_cancelar = new javax.swing.JButton();
        bto_listarProd = new javax.swing.JButton();
        txt_categoriaProd = new javax.swing.JTextField();
        bto_eliminarProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 100));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Rut Usuario/a:");

        lbl_rut.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_rut.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bto_cerrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        bto_cerrar.setText("Cerrar Sesion");
        bto_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_cerrarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_usuario)
                .addGap(18, 18, 18)
                .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(412, 412, 412)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bto_cerrar)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_usuario)
                            .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(bto_cerrar))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 980));

        txt_precioProd.setEditable(false);
        txt_precioProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_modeloProd.setEditable(false);
        txt_modeloProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        table_detalleProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table_detalleProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Categoria", "Marca", "Modelo", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_detalleProd);

        bto_buscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        bto_buscar.setText("Buscar ");
        bto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarActionPerformed(evt);
            }
        });

        bto_agregar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_agregar.setText("Agregar ");
        bto_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_agregarActionPerformed(evt);
            }
        });

        bto_limpiar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_limpiar.setText("Limpiar");
        bto_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_limpiarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Rut del Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Codigo Producto ");

        txt_rutCli.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_rutCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rutCliKeyTyped(evt);
            }
        });

        txt_codProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_codProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codProdActionPerformed(evt);
            }
        });
        txt_codProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codProdKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Total Venta");

        lbl_montoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_montoTotal.setText("0");
        lbl_montoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Marca");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Modelo");

        bto_continuar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_continuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pagar.png"))); // NOI18N
        bto_continuar.setText("Continuar");
        bto_continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_continuarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Categoria");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Precio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Cantidad");

        txt_marcaProd.setEditable(false);
        txt_marcaProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_cantidadProd.setEditable(false);
        txt_cantidadProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_cantidadProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadProdKeyTyped(evt);
            }
        });

        bto_cancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        bto_cancelar.setText("Cancelar");
        bto_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_cancelarActionPerformed(evt);
            }
        });

        bto_listarProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_listarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        bto_listarProd.setText("Lista de Productos");
        bto_listarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_listarProdActionPerformed(evt);
            }
        });

        txt_categoriaProd.setEditable(false);
        txt_categoriaProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        bto_eliminarProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_eliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        bto_eliminarProd.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bto_eliminarProd.setLabel("Eliminar  ");
        bto_eliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_eliminarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_codProd, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(bto_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bto_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_categoriaProd, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_modeloProd, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_cantidadProd, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_precioProd, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_marcaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bto_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bto_listarProd))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(bto_eliminarProd)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bto_continuar)
                                .addGap(169, 169, 169)
                                .addComponent(bto_cancelar)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_rutCli, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_montoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(302, 302, 302))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bto_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bto_listarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(323, 323, 323)
                                .addComponent(bto_eliminarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_codProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_categoriaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_marcaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_modeloProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_cantidadProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_precioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bto_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bto_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_montoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_rutCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(187, 187, 187))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarActionPerformed
        // TODO add your handling code here:
        buscarProducto();
        validarStock();
    }//GEN-LAST:event_bto_buscarActionPerformed

    private void bto_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_agregarActionPerformed
        // TODO add your handling code here:
        agregarTabla(table_detalleProd, txt_codProd.getText());
        
    }//GEN-LAST:event_bto_agregarActionPerformed

    private void bto_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_limpiarActionPerformed
        // TODO add your handling code here:
        limpiarDatos();
        txt_codProd.setEditable(true);
        txt_cantidadProd.setEditable(false);
        
    }//GEN-LAST:event_bto_limpiarActionPerformed

    private void bto_continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_continuarActionPerformed
        // TODO add your handling code here:
        rut_cliente = txt_rutCli.getText();
        rut_vendedor = lbl_rut.getText();
        if(txt_rutCli.getText().length()<=8)
        {
            JOptionPane.showMessageDialog(null, "Tiene que ser un rut valido");
        }else{
            guardarDetalleVenta();
        }
        

    }//GEN-LAST:event_bto_continuarActionPerformed

    private void bto_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_cancelarActionPerformed
        // TODO add your handling code here:
        limpiarDatos();
        limpiarTabla();
        txt_rutCli.setText("");
        lbl_montoTotal.setText("");
    }//GEN-LAST:event_bto_cancelarActionPerformed

    private void bto_listarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_listarProdActionPerformed
        // TODO add your handling code here:
        VistaListarProducto pMenu = new VistaListarProducto();
        pMenu.setVisible(true);
    }//GEN-LAST:event_bto_listarProdActionPerformed

    private void txt_codProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codProdActionPerformed

    private void txt_codProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codProdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
 
 
	if(Character.isLetter(c)) {
		getToolkit().beep();
 
		evt.consume();
        }
        
        if(txt_cantidadProd.getText().length()>9)
        {
            evt.consume();
            
        }
    }//GEN-LAST:event_txt_codProdKeyTyped

    private void txt_cantidadProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadProdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
 
 
	if(Character.isLetter(c)) {
		getToolkit().beep();
 
		evt.consume();
        }
        
        if(txt_cantidadProd.getText().length()>9)
        {
            evt.consume();
            
        }
    }//GEN-LAST:event_txt_cantidadProdKeyTyped

    private void txt_rutCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rutCliKeyTyped
        // TODO add your handling code here:
        if(txt_rutCli.getText().length()>9 )
        {
            evt.consume();
            
        }
    }//GEN-LAST:event_txt_rutCliKeyTyped

    private void bto_eliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_eliminarProdActionPerformed
        // TODO add your handling code here:
        eliminarProducto();
    }//GEN-LAST:event_bto_eliminarProdActionPerformed

    private void bto_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_cerrarActionPerformed
        // TODO add your handling code here:
        VistaLogin pMenu = new VistaLogin();
        pMenu.redireccionarCerrar(lbl_rut.getText());
        this.dispose();
        
    }//GEN-LAST:event_bto_cerrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bto_agregar;
    private javax.swing.JButton bto_buscar;
    private javax.swing.JButton bto_cancelar;
    private javax.swing.JButton bto_cerrar;
    private javax.swing.JButton bto_continuar;
    private javax.swing.JButton bto_eliminarProd;
    private javax.swing.JButton bto_limpiar;
    private javax.swing.JButton bto_listarProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_montoTotal;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable table_detalleProd;
    private javax.swing.JTextField txt_cantidadProd;
    private javax.swing.JTextField txt_categoriaProd;
    private javax.swing.JTextField txt_codProd;
    private javax.swing.JTextField txt_marcaProd;
    private javax.swing.JTextField txt_modeloProd;
    private javax.swing.JTextField txt_precioProd;
    private javax.swing.JTextField txt_rutCli;
    // End of variables declaration//GEN-END:variables
}
