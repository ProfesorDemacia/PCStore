/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.CategoriaProducto;
import CapaDTO.Producto;
import CapaNegocio.NegocioCategoriaProducto;
import CapaNegocio.NegocioProducto;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class VistaBodeguero extends javax.swing.JFrame {

    /**
     * Creates new form VistaBodeguero
     */
    public VistaBodeguero() {
        initComponents();
        VistaLogin auxVista = new VistaLogin();
        lbl_rut.setText(auxVista.rut_usu);
          cargarListadoDeProductos();
          Font fuente = new Font("Tahoma",Font.BOLD,18);
          table_prod.getTableHeader().setFont(fuente);
          
    }
    
    
    public static int id_prod = 0;

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
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_codProd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bto_agregarProd = new javax.swing.JButton();
        bto_modificarProd = new javax.swing.JButton();
        box_categoria = new javax.swing.JComboBox<>();
        bto_eliminarProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_prod = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        bto_buscar = new javax.swing.JButton();
        bto_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
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
        lbl_rut.setText("19635672-9");
        lbl_rut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bto_cerrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        bto_cerrar.setText("Cerrar Sesion");
        bto_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_cerrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bodega");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_usuario)
                .addGap(18, 18, 18)
                .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(478, 478, 478)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bto_cerrar)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bto_cerrar)
                    .addComponent(lbl_usuario)
                    .addComponent(lbl_rut)
                    .addComponent(jLabel6))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 980));

        txt_codProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Categoria:");

        bto_agregarProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_agregarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        bto_agregarProd.setText("Agregar Productos");
        bto_agregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_agregarProdActionPerformed(evt);
            }
        });

        bto_modificarProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_modificarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        bto_modificarProd.setText("Modificar Productos");
        bto_modificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_modificarProdActionPerformed(evt);
            }
        });

        box_categoria.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        box_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria" }));
        box_categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_categoriaItemStateChanged(evt);
            }
        });

        bto_eliminarProd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_eliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        bto_eliminarProd.setText("Eliminar Productos");
        bto_eliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_eliminarProdActionPerformed(evt);
            }
        });

        table_prod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Categoria ", "Marca", "Modelo", "Descripcion", "Precio", "Stock", "Comentario"
            }
        ));
        jScrollPane1.setViewportView(table_prod);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Codigo del Producto");

        bto_buscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        bto_buscar.setText("Buscar");
        bto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarActionPerformed(evt);
            }
        });

        bto_actualizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        bto_actualizar.setText("Actualizar Tabla");
        bto_actualizar.setToolTipText("");
        bto_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_codProd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(bto_buscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bto_agregarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bto_modificarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bto_eliminarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bto_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(box_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_buscar))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(bto_agregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(bto_modificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(bto_eliminarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(bto_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
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
        VistaLogin btnSalir = new VistaLogin();
        btnSalir.redireccionarCerrar(lbl_rut.getText());
        this.dispose();
    }//GEN-LAST:event_bto_cerrarActionPerformed

    private void bto_agregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_agregarProdActionPerformed
        VistaAgregarProductos producto = new VistaAgregarProductos();
        producto.setVisible(true);
    }//GEN-LAST:event_bto_agregarProdActionPerformed

    private void bto_modificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_modificarProdActionPerformed
        codProd();
        
    }//GEN-LAST:event_bto_modificarProdActionPerformed

    private void bto_eliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_eliminarProdActionPerformed
        // TODO add your handling code here:
        eliminarProducto();
        
    }//GEN-LAST:event_bto_eliminarProdActionPerformed

    private void bto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarActionPerformed
         // TODO add your handling code here:
          buscarProductoID(txt_codProd.getText());
    }//GEN-LAST:event_bto_buscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        cargarComboBoxCategorias();
        validarStock();
        
        
    }//GEN-LAST:event_formWindowOpened

    private void bto_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_actualizarActionPerformed
        // TODO add your handling code here:
        cargarListadoDeProductos();
    }//GEN-LAST:event_bto_actualizarActionPerformed

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
            buscarCategoria(auxCategoria.getId_categoria_prod());
        }
    }//GEN-LAST:event_box_categoriaItemStateChanged

    
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
                this.table_prod.setValueAt(auxProducto.getComentario(), fila, 7);
                fila++;
            }
        } catch (Exception e) {
        }
    }
    
    private void eliminarProducto(){
        try
        {
            int cantidad_usuarios = this.table_prod.getModel().getRowCount();
            if(cantidad_usuarios > 0)
            {
                int fila_seleccionada = this.table_prod.getSelectedRow();
                if(fila_seleccionada > -1)
                    JOptionPane.showInputDialog("");
                {
                    int respuesta = JOptionPane.showConfirmDialog(null,"Estas seguro de continuar con el proceso de eliminacion?.\nEste proceso no se puede deshacer.", "Mensaje", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE);
                    if(respuesta == JOptionPane.YES_OPTION)
                    {
                        
                        String id = this.table_prod.getModel().getValueAt(fila_seleccionada, 0).toString();
                        NegocioProducto auxNegocio = new NegocioProducto();
                        auxNegocio.eliminarProducto(Integer.parseInt(id));
                        
                        JOptionPane.showMessageDialog(null, "Producto eliminado satisfactoriamente.", "Mensajes", JOptionPane.INFORMATION_MESSAGE);
                        cargarListadoDeProductos();
                    }
                }
                
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Problemas desconocidos con la base de datos: " + ex.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void buscarProductoID(String cod_prod)
    {
        try
        {
            if(txt_codProd.getText().length()!=0)
            {
                NegocioProducto auxNegocioProd = new NegocioProducto();
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
                this.table_prod.setValueAt(auxProducto.getComentario(), fila, 7);
             
                }else{
                    JOptionPane.showMessageDialog(null, "El codigo del producto no existe");
                }
            }else{
                cargarListadoDeProductos();
                JOptionPane.showMessageDialog(null, "Ingrese primero codigo del producto");
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido listar a las ventas ");
        }
    }
    
    
     public void cargarListadoDeProductos(){
        try
        {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) this.table_prod.getModel();
        
            modelo.setNumRows(0);
        
            int fila = 0;
        
            NegocioProducto auxNegocio = new NegocioProducto();
            NegocioCategoriaProducto auxNegocioCategoria = new NegocioCategoriaProducto();
            
        
            Iterator iter = auxNegocio.consultaProducto().iterator();
        
            while(iter.hasNext())
            {
                Producto auxProducto = new Producto();
                auxProducto = (Producto) iter.next();
                Object[] num = {};
                modelo.addRow(num);
                CategoriaProducto auxCategoria = auxNegocioCategoria.buscaCategoriaProducto(auxProducto.getId_categoria_prod());
                this.table_prod.setValueAt(auxProducto.getId_prod(), fila, 0);
                this.table_prod.setValueAt(auxCategoria.getNombre_categoria(), fila, 1);
                this.table_prod.setValueAt(auxProducto.getMarca_prod(), fila, 2);
                this.table_prod.setValueAt(auxProducto.getModelo_prod(), fila, 3);
                this.table_prod.setValueAt(auxProducto.getDescripcion_prod(), fila, 4);
                this.table_prod.setValueAt(String.format("$%,d",auxProducto.getPrecio_unitario()), fila, 5);
                this.table_prod.setValueAt(auxProducto.getStock_prod(), fila, 6);
                this.table_prod.setValueAt(auxProducto.getComentario(), fila, 7);
                fila++;
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No se han podido listar los Productos " + ex.getMessage());
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
     
     public void codProd(){
         int fila = table_prod.getSelectedRow();
         if(fila == -1)
         {
             JOptionPane.showMessageDialog(null, "Seleccione un producto primero");
         }else{
            id_prod = Integer.parseInt(this.table_prod.getValueAt(fila, 0).toString());
            VistaModificarProductos pMenu = new VistaModificarProductos();
            pMenu.setVisible(true);
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
     
    
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_categoria;
    private javax.swing.JButton bto_actualizar;
    private javax.swing.JButton bto_agregarProd;
    private javax.swing.JButton bto_buscar;
    private javax.swing.JButton bto_cerrar;
    private javax.swing.JButton bto_eliminarProd;
    private javax.swing.JButton bto_modificarProd;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable table_prod;
    private javax.swing.JTextField txt_codProd;
    // End of variables declaration//GEN-END:variables
}