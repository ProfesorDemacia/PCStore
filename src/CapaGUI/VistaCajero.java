/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.DetalleVenta;
import CapaDTO.SolicitudVenta;
import CapaDTO.Venta;
import CapaNegocio.NegocioDetalleVenta;
import CapaNegocio.NegocioProducto;
import CapaNegocio.NegocioSolicitudVenta;
import CapaNegocio.NegocioVenta;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Cesar
 */
public class VistaCajero extends javax.swing.JFrame {

    /**
     * Creates new form VistaCajero
     */
    public VistaCajero() {
        initComponents();
        VistaLogin auxVista = new VistaLogin();
        lbl_rut.setText(auxVista.rut_usu);
        java.awt.Font fuente = new java.awt.Font("Tahoma",java.awt.Font.BOLD,18);
        table_venta.getTableHeader().setFont(fuente);
        
        
    }
    
    public static String nombre_empre = "PCStore";
    public static String rut_empre = "78.888.222-1";
    public static String direccion_empre = "Av providencia 466";
    public static int monto_pagar = 0;
    
    
    public void limpiarDatos(){
        txt_rutCli.setText("");
        box_metodoPago.setSelectedIndex(0);
        lbl_montoPagar.setText("");
        lbl_rutUsu.setText("");
    }
    
    public void limpiarTabla(){
        DefaultTableModel tb = (DefaultTableModel) table_venta.getModel();
        int a = table_venta.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
        tb.removeRow(tb.getRowCount()-1);
        }
    }
    
    
    public void imprimirBoleta(){
        
        Document boleta = new Document(PageSize.A3.rotate());
        try {
            
            NegocioDetalleVenta auxNegocioDetalleVenta = new NegocioDetalleVenta();
            NegocioVenta auxNegocioVenta = new NegocioVenta();
            Venta auxVenta = new Venta();
            NegocioSolicitudVenta auxNegocioSolicitudVenta= new NegocioSolicitudVenta();
            SolicitudVenta auxSolicitudVenta = new SolicitudVenta();
            
            int folio = auxNegocioSolicitudVenta.buscarSolicitudVenta(txt_rutCli.getText()).getFolio_detalle_venta();
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(boleta, new FileOutputStream(ruta+"/Documents/Boletas/boleta"+folio+".pdf"));
            
            Image header = Image.getInstance("src/Imagenes/Header3.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            header.getPaddingTop();
            
            Image footer = Image.getInstance("src/Imagenes/Timbre.png");
            footer.scaleToFit(650, 1000);
            footer.setAlignment(Chunk.ALIGN_CENTER);
            
            
            
            Paragraph parrafo = new Paragraph();
            parrafo.getPaddingTop();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma",20,Font.BOLD,BaseColor.BLACK));
            parrafo.add("\n"+nombre_empre+"\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD,BaseColor.BLACK));
            parrafo.add("N° Boleta:"+folio+"\n\n");
            parrafo.add("Rut:"+rut_empre+"\n\n");
            parrafo.add("Vendedor:"+lbl_rutUsu.getText()+"\n\n");
            parrafo.add("Caja:"+lbl_rut.getText()+"\n");
            
            Paragraph parrafo2 = new Paragraph();
            parrafo2.getPaddingTop();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD,BaseColor.BLACK));
            parrafo2.add("Direccion:"+direccion_empre+"\n");
            
            Paragraph espacio= new Paragraph();
            espacio.add("\n");
            espacio.setPaddingTop(100);
            
            Paragraph parrafo3 = new Paragraph();
            parrafo3.getPaddingTop();
            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo3.setFont(FontFactory.getFont("Tahoma",17,Font.BOLD,BaseColor.BLACK));
            
            
            boleta.open();
            //boleta.add(header);
            boleta.add(parrafo);
            boleta.add(espacio);
            
            
            
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.setTotalWidth(650);
            tabla.setPaddingTop(100);
            
            Iterator iter = auxNegocioDetalleVenta.buscarDetalleVentaPorFolio(folio).iterator();
            
            tabla.addCell("Modelo");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Neto");
            tabla.addCell("IVA");
            tabla.addCell("Total");
            ;
            
            while(iter.hasNext())
            {
                DetalleVenta auxDetalleVenta = new DetalleVenta();
                auxDetalleVenta = (DetalleVenta) iter.next();
                int id_prod = auxDetalleVenta.getId_prod();
                String modelo = auxDetalleVenta.getModelo_prod();
                int cantidad = auxDetalleVenta.getCantidad_prod();
                int precio_prod = auxDetalleVenta.getPrecio_unitario_prod();
                int precio_total = auxDetalleVenta.getPrecio_total_detalle();
                tabla.addCell(modelo);
                tabla.addCell(String.valueOf(cantidad));
                tabla.addCell(String.format("$%,d",Math.round(precio_prod*0.81)));
                tabla.addCell(String.format("$%,d",Math.round(precio_prod*0.19)));
                tabla.addCell(String.format("$%,d",precio_total));
                
                
                
                
                
            }
            
            int total_neto = (int) Math.round(monto_pagar*0.81);
            int total_iva = (int) Math.round(monto_pagar*0.19);
            int total = Math.round(monto_pagar);
            parrafo3.add("\n Total Neto ---------------------->  "+String.format("$%,d",total_neto)
                     +"\nTotal IVA  ----------------------->  "+String.format("$%,d",total_iva)
                     +"\n Total      -------------------------->  "+String.format("$%,d",total));
            
            boleta.add(tabla);
            boleta.add(espacio);
            boleta.add(parrafo3);
            boleta.add(footer);
            boleta.add(parrafo2);
            
            
            
            
            
            
            boleta.close();
            try {
                Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"C:\\Users\\Cesar\\Documents\\Boletas\\boleta"+folio+".pdf");
                
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
                      
            
        } catch (Exception e) {
        }
    }
    
    
    public void insertarVenta(){
        
        try {
            int id_detalle_venta = 0;
            if(txt_rutCli.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Primero imgrese el rut del cliente");
            }else{
                if(box_metodoPago.getSelectedIndex()!=0){
                    
                    if(JOptionPane.showConfirmDialog(null, "Se realizara la venta, ¿Desea Continuar?", "Confirmacion de Venta"
                    ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        
                        imprimirBoleta();  
                        
                        int id_folio = Integer.parseInt(table_venta.getValueAt(0,0).toString());
                        NegocioDetalleVenta auxNegocioDetalleVenta = new NegocioDetalleVenta();
                        id_detalle_venta = auxNegocioDetalleVenta.buscarIdDetalleVenta(id_folio);

                        NegocioVenta auxNegocioVenta = new NegocioVenta();
                        Venta auxVenta = new Venta();

                        int monto_venta = monto_pagar;
                        int id_metodo_pago = box_metodoPago.getSelectedIndex();
                        String rut_usu = lbl_rutUsu.getText();
                        String rut_cli = txt_rutCli.getText();
                        
                        
                        

                        auxVenta.setMonto_venta(monto_venta);
                        auxVenta.setId_metodo_pago(id_metodo_pago);
                        auxVenta.setRut_usu(rut_usu);
                        auxVenta.setRut_cli(rut_cli);
                        auxVenta.setId_detalle_venta(id_detalle_venta);
                        //Se insertan los datos que se guardaron en las variables
                        auxNegocioVenta.insertarVenta(auxVenta);

                        //se borra la solicitud de venta
                        NegocioSolicitudVenta auxNegocioSolicitud = new NegocioSolicitudVenta();
                        auxNegocioSolicitud.eliminarSolicitudVenta(id_folio);
                        
                        //Actualiza el stock vendido
                        NegocioProducto auxNegocioProducto = new NegocioProducto();
                        int fila = this.table_venta.getRowCount();
                        for (int i = 0; i < fila ; i++)
                        {
                            int id_prod = Integer.parseInt(this.table_venta.getValueAt(i, 1).toString());
                            int cantidad_prod = Integer.parseInt(this.table_venta.getValueAt(i, 6).toString());
                            auxNegocioProducto.DisminuirStockDeProducto(id_prod,cantidad_prod);
                        }
                        
                        
                                              
                        
                        
                        JOptionPane.showMessageDialog( null, "La venta ha sido realizada... Imprimiendo boleta...");
                        
                        limpiarDatos();
                        limpiarTabla();
                    }
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione un metodo de pago");
                }
                try {
                    
                    
                    
                } catch (Exception e) {
                }
                
            }
            
        } catch (Exception e) {
        }
        
    }
     
    
    public void buscarVenta(String rut_cli)
    {
        try
        {
            if(txt_rutCli.getText().length()!=0)
            {
                NegocioSolicitudVenta auxNegocioSolicitudVenta = new NegocioSolicitudVenta();
                if(auxNegocioSolicitudVenta.existeUsuario(rut_cli))
                {
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo = (DefaultTableModel) this.table_venta.getModel();
                    modelo.setNumRows(0);
                    NegocioDetalleVenta auxNegocioDetalleVenta = new NegocioDetalleVenta();

                    SolicitudVenta auxSolicitudVenta = new SolicitudVenta();
                    auxSolicitudVenta.setRut_cli(auxNegocioSolicitudVenta.buscarSolicitudVenta(rut_cli).getRut_cli());
                    auxSolicitudVenta.setFolio_detalle_venta(auxNegocioSolicitudVenta.buscarSolicitudVenta(rut_cli).getFolio_detalle_venta());


                    Iterator iter = auxNegocioDetalleVenta.buscarDetalleVentaPorFolio(auxSolicitudVenta.getFolio_detalle_venta()).iterator();
                    int fila = 0;
                    
                    while(iter.hasNext())
                    {
                        DetalleVenta auxDetalleVenta = new DetalleVenta();
                        auxDetalleVenta = (DetalleVenta) iter.next();
                        Object[] num = {};
                        modelo.addRow(num);
                        this.table_venta.setValueAt(auxDetalleVenta.getFolio_detalle_venta(), fila, 0);
                        this.table_venta.setValueAt(auxDetalleVenta.getId_prod(), fila, 1);
                        this.table_venta.setValueAt(auxDetalleVenta.getNombre_categoria(), fila, 2);
                        this.table_venta.setValueAt(auxDetalleVenta.getMarca_prod(), fila, 3);
                        this.table_venta.setValueAt(auxDetalleVenta.getModelo_prod(), fila, 4);
                        this.table_venta.setValueAt(String.format("$%,d",auxDetalleVenta.getPrecio_unitario_prod()), fila, 5);
                        this.table_venta.setValueAt(auxDetalleVenta.getCantidad_prod(), fila, 6);
                        this.table_venta.setValueAt(String.format("$%,d",auxDetalleVenta.getPrecio_total_detalle()), fila, 7);
                        monto_pagar = monto_pagar + auxDetalleVenta.getPrecio_total_detalle();
                        fila++;
                        lbl_rutUsu.setText(auxDetalleVenta.getRut_usu());
                        lbl_montoPagar.setText(String.format("$%,d",monto_pagar));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El rut ingresado no existe");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese primero el rut");
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido listar a las ventas ");
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
        jLabel4 = new javax.swing.JLabel();
        lbl_montoPagar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        box_metodoPago = new javax.swing.JComboBox<>();
        bto_pagar = new javax.swing.JButton();
        bto_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_venta = new javax.swing.JTable();
        txt_rutCli = new javax.swing.JTextField();
        bto_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_rutUsu = new javax.swing.JLabel();
        bto_ventaDia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setMaximumSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 100));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Rut Usuario/a:");

        lbl_rut.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_rut.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rut.setText("16258754-3");
        lbl_rut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_rut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
        jLabel7.setText("Caja");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(634, 634, 634)
                .addComponent(bto_cerrar)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bto_cerrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_rut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lbl_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 980));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Monto a Pagar");

        lbl_montoPagar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_montoPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Metodo de Pago");

        box_metodoPago.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        box_metodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Metodo", "Credito", "Debito", "Efectivo", " " }));

        bto_pagar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras.png"))); // NOI18N
        bto_pagar.setText("Pagar");
        bto_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_pagarActionPerformed(evt);
            }
        });

        bto_cancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        bto_cancelar.setText("Cancelar Venta");

        table_venta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio Venta", "Codigo Producto", "Categoria", "Marca", "Modelo", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_venta);

        txt_rutCli.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_rutCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rutCliKeyTyped(evt);
            }
        });

        bto_buscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        bto_buscar.setText("Buscar");
        bto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Rut Cliente");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Rut del vendedor:");

        lbl_rutUsu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_rutUsu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bto_ventaDia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_ventaDia.setText("Ventas del Dia");
        bto_ventaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_ventaDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_rutCli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(bto_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_rutUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 902, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(bto_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(bto_cancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(box_metodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_montoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(bto_ventaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addGap(67, 67, 67))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_rutCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_buscar)
                    .addComponent(jLabel3)
                    .addComponent(lbl_rutUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lbl_montoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(box_metodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bto_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bto_ventaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bto_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_cerrarActionPerformed
        // TODO add your handling code here:
        VistaLogin login = new VistaLogin();
        login.redireccionarCerrar(lbl_rut.getText());
        this.dispose();
    }//GEN-LAST:event_bto_cerrarActionPerformed

    private void bto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarActionPerformed
        // TODO add your handling code here:
        buscarVenta(txt_rutCli.getText());
    }//GEN-LAST:event_bto_buscarActionPerformed

    private void bto_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_pagarActionPerformed
        // TODO add your handling code here:
        insertarVenta();
    }//GEN-LAST:event_bto_pagarActionPerformed

    private void bto_ventaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_ventaDiaActionPerformed
        // TODO add your handling code here:
        VistaVentaDia pMenu = new VistaVentaDia();
        pMenu.setVisible(true);
        
    }//GEN-LAST:event_bto_ventaDiaActionPerformed

    private void txt_rutCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rutCliKeyTyped
        // TODO add your handling code here:
        if(this.txt_rutCli.getText().length() > 9)
    {
        evt.consume();
    }
    }//GEN-LAST:event_txt_rutCliKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_metodoPago;
    private javax.swing.JButton bto_buscar;
    private javax.swing.JButton bto_cancelar;
    private javax.swing.JButton bto_cerrar;
    private javax.swing.JButton bto_pagar;
    private javax.swing.JButton bto_ventaDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_montoPagar;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JLabel lbl_rutUsu;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable table_venta;
    private javax.swing.JTextField txt_rutCli;
    // End of variables declaration//GEN-END:variables
}
