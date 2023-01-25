/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.Producto;
import CapaNegocio.NegocioProducto;
import CapaDTO.CategoriaProducto;
import CapaNegocio.NegocioCategoriaProducto;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class VistaListarProducto extends javax.swing.JFrame {

    /**
     * Creates new form VistaListarProducto
     */
    public VistaListarProducto() {
        initComponents();
        cargarListadoProductos();
        VistaLogin auxVista = new VistaLogin();
        lbl_rut.setText(auxVista.rut_usu);
        cargarComboBoxCategorias();
        Font fuente = new Font("Tahoma",Font.BOLD,16);
        table_prod.getTableHeader().setFont(fuente);
    }

    
    
    public void buscarProductoID(String cod_prod)
    {
        NegocioProducto auxNegocioProd = new NegocioProducto();
        try
        {
            if(txt_codigoProd.getText().length()!=0)
            {
                if(auxNegocioProd.existeProducto(Integer.parseInt(cod_prod)))
                {
                    
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo = (DefaultTableModel) this.table_prod.getModel();
                    modelo.setNumRows(0);



                    NegocioCategoriaProducto auxNegocioCategoria = new NegocioCategoriaProducto();



                    int fila = 0;
                    int monto_final =0;


                    Producto auxProducto = new Producto();
                    auxProducto = auxNegocioProd.buscaProducto(Integer.parseInt(cod_prod));
                    Object[] num = {};
                    modelo.addRow(num);
                    CategoriaProducto auxcategoria = auxNegocioCategoria.buscaCategoriaProducto(auxProducto.getId_categoria_prod());
                    this.table_prod.setValueAt(auxProducto.getId_prod(), fila, 0);
                    this.table_prod.setValueAt(auxcategoria.getNombre_categoria(), fila, 1);
                    this.table_prod.setValueAt(auxProducto.getMarca_prod(), fila, 2);
                    this.table_prod.setValueAt(auxProducto.getModelo_prod(), fila, 3);
                    this.table_prod.setValueAt(auxProducto.getDescripcion_prod(), fila, 4);
                    this.table_prod.setValueAt(String.format("$%,d",auxProducto.getPrecio_unitario()), fila, 5);
                    this.table_prod.setValueAt(auxProducto.getStock_prod(), fila, 6);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no existe");
                }
             
            }else{
                cargarListadoProductos();
                JOptionPane.showMessageDialog(null, "Ingrese primero el codigo del producto");
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido listar a las ventas ");
        }
    }
    
         private void cargarListadoProductos(){
        try
        {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) this.table_prod.getModel();
            modelo.setNumRows(0);
        
            int fila = 0;
        
           NegocioProducto auxNegocioProducto = new NegocioProducto();
           NegocioCategoriaProducto auxNegocioCategoria   = new NegocioCategoriaProducto();
        
            Iterator iter = auxNegocioProducto.consultaProducto().iterator();
        
            while(iter.hasNext())
            {
                Producto auxProducto = new Producto();
                auxProducto = (Producto) iter.next();
                Object[] num = {};
                modelo.addRow(num);
                CategoriaProducto auxcategoria = auxNegocioCategoria.buscaCategoriaProducto(auxProducto.getId_categoria_prod());
                this.table_prod.setValueAt(auxProducto.getId_prod(), fila, 0);
                this.table_prod.setValueAt(auxcategoria.getNombre_categoria(), fila, 1);
                this.table_prod.setValueAt(auxProducto.getMarca_prod(), fila, 2);
                this.table_prod.setValueAt(auxProducto.getModelo_prod(), fila, 3);
                this.table_prod.setValueAt(auxProducto.getDescripcion_prod(), fila, 4);
                this.table_prod.setValueAt(String.format("$%,d",auxProducto.getPrecio_unitario()), fila, 5);
                this.table_prod.setValueAt(auxProducto.getStock_prod(), fila, 6);
                fila++;
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No se han podido listar las Ventas " + ex.getMessage());
        }
    }
         
         
    public void buscarCategoria(int id_categoria_prod){
        try {
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) this.table_prod.getModel();
            modelo.setNumRows(0);       
            int fila = 0;
           
            NegocioProducto auxNegocioProducto = new NegocioProducto();
            NegocioCategoriaProducto auxNegocioCategoria = new NegocioCategoriaProducto();
            Iterator iter = auxNegocioProducto.buscarPorCategoria(id_categoria_prod).iterator();
            
            while(iter.hasNext())
            {              
                Producto auxProducto = new Producto();
                auxProducto = (Producto) iter.next();
                Object[] num = {};
                modelo.addRow(num);
                CategoriaProducto auxcategoria = auxNegocioCategoria.buscaCategoriaProducto(auxProducto.getId_categoria_prod());
                this.table_prod.setValueAt(auxProducto.getId_prod(), fila, 0);
                this.table_prod.setValueAt(auxcategoria.getNombre_categoria(), fila, 1);
                this.table_prod.setValueAt(auxProducto.getMarca_prod(), fila, 2);
                this.table_prod.setValueAt(auxProducto.getModelo_prod(), fila, 3);
                this.table_prod.setValueAt(auxProducto.getDescripcion_prod(), fila, 4);
                this.table_prod.setValueAt(String.format("$%,d",auxProducto.getPrecio_unitario()), fila, 5);
                this.table_prod.setValueAt(auxProducto.getStock_prod(), fila, 6);
                fila++;
            }
        } catch (Exception e) {
        }
    }
         
         
         private void cargarComboBoxCategorias(){
            try
            {
                
                NegocioCategoriaProducto auxCategoria = new NegocioCategoriaProducto();
                ArrayList<CategoriaProducto> categorias = auxCategoria.consultaCategoriaProducto();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione una categoria");
                for(CategoriaProducto c: categorias)
                {
                    modelo.addElement(c);

                }
                this.box_categoria.setModel(modelo);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Problemas desconocidos con la base de datos: " + ex.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
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
        jPanel2 = new javax.swing.JPanel();
        txt_codigoProd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        box_categoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_prod = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bto_buscar = new javax.swing.JButton();
        bto_buscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Rut Usuario/a:");

        lbl_rut.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_rut.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rut.setText("19635672-9");
        lbl_rut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bto_cerrar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bto_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        bto_cerrar.setText("Cerrar");
        bto_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_usuario)
                .addGap(18, 18, 18)
                .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bto_cerrar)
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bto_cerrar)
                    .addComponent(lbl_usuario)
                    .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txt_codigoProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_codigoProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoProdKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Categoria:");

        box_categoria.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        box_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria" }));
        box_categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_categoriaItemStateChanged(evt);
            }
        });

        table_prod.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        table_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Categoria ", "Marca", "Modelo", "Descripcion", "Precio", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_prod.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(table_prod);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Codigo del Producto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel5.setText("Listado de Productos");

        bto_buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bto_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        bto_buscar.setText("Buscar");
        bto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarActionPerformed(evt);
            }
        });

        bto_buscar1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bto_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        bto_buscar1.setText("Reinicar");
        bto_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(box_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(bto_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bto_buscar1)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(box_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_buscar)
                    .addComponent(bto_buscar1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        this.dispose();
    }//GEN-LAST:event_bto_cerrarActionPerformed

    private void bto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarActionPerformed
        // TODO add your handling code here:
         buscarProductoID(txt_codigoProd.getText());
    }//GEN-LAST:event_bto_buscarActionPerformed

    private void txt_codigoProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
 
 
	if(Character.isLetter(c)) {
		getToolkit().beep();
 
		evt.consume();
        }
        
        if(txt_codigoProd.getText().length()>9)
        {
            evt.consume();
            
        }
    }//GEN-LAST:event_txt_codigoProdKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        cargarComboBoxCategorias();
    }//GEN-LAST:event_formWindowOpened

    private void box_categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_categoriaItemStateChanged
        // TODO add your handling code here:
        String obtener = box_categoria.getSelectedItem().toString();
        if(obtener.equals("Seleccione una categoria"))
        {
            JOptionPane.showMessageDialog(null, "Selecciona una categoria primero");
        }else{
            
            NegocioCategoriaProducto auxNegocioCategoria = new NegocioCategoriaProducto();
            CategoriaProducto auxCategoria = new CategoriaProducto();
            auxCategoria = auxNegocioCategoria.buscaNombreCategoria(obtener);
            int id_categoria = auxCategoria.getId_categoria_prod();
            buscarCategoria(id_categoria);
            
        }

    }//GEN-LAST:event_box_categoriaItemStateChanged

    private void bto_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscar1ActionPerformed
        // TODO add your handling code here:
        cargarListadoProductos();
    }//GEN-LAST:event_bto_buscar1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_categoria;
    private javax.swing.JButton bto_buscar;
    private javax.swing.JButton bto_buscar1;
    private javax.swing.JButton bto_cerrar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable table_prod;
    private javax.swing.JTextField txt_codigoProd;
    // End of variables declaration//GEN-END:variables
}
