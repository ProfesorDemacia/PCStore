/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.DetalleVenta;
import CapaDTO.Venta;
import CapaNegocio.NegocioDetalleVenta;
import CapaNegocio.NegocioProducto;
import CapaNegocio.NegocioVenta;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class VistaAnularVenta extends javax.swing.JFrame {

    /**
     * Creates new form VistaAnularVenta
     */
    public VistaAnularVenta() {
        initComponents();
        VistaLogin auxVista = new VistaLogin();
        lbl_rut.setText(auxVista.rut_usu);
        //bto_buscarFecha.setVisible(false);
        buscarVenta();
    }
    
    public static String id_detalle_venta = "";
    public static String monto_total = "";
    
    public void buscarVenta(){
        
        try {
            
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) this.table_venta.getModel();
            modelo.setNumRows(0);
            
            NegocioVenta auxNegocioVenta = new NegocioVenta();
            NegocioDetalleVenta auxNegocioDetalleVenta = new NegocioDetalleVenta();
            Iterator iter = auxNegocioVenta.consultaVenta().iterator();
            int fila = 0;
            int folio = 0;
            while(iter.hasNext())
            {
                Venta auxVenta = new Venta();
                auxVenta = (Venta) iter.next();
                Object[] num = {};
                modelo.addRow(num);
                folio = auxNegocioDetalleVenta.encontrarFolioEspecifico(auxVenta.getId_detalle_venta());
                
                
                this.table_venta.setValueAt(auxVenta.getId_venta(), fila, 0);
                this.table_venta.setValueAt(String.format("$%,d",auxVenta.getMonto_venta()), fila, 1);
                this.table_venta.setValueAt(auxVenta.getRut_cli(), fila, 2);
                this.table_venta.setValueAt(auxVenta.getRut_usu(), fila, 3);
                this.table_venta.setValueAt(auxVenta.getFecha_venta(), fila, 4);
                this.table_venta.setValueAt(auxVenta.getId_metodo_pago(), fila, 5);
                this.table_venta.setValueAt(folio, fila, 6);
                fila++;
                       
            }
            
            
                
            
        } catch (Exception e) {
        }
        
    }
    
    public void buscarVentaEspecifica(String id_venta){
        NegocioVenta auxNegocioVenta = new NegocioVenta();
        if(txt_idVenta.getText().length()!=0)
        {
            if (auxNegocioVenta.existeVenta(Integer.parseInt(id_venta)))
            {
                DefaultTableModel modelo = new DefaultTableModel();
                modelo = (DefaultTableModel) this.table_venta.getModel();
                modelo.setNumRows(0);

                NegocioDetalleVenta auxNegocioDetalleVenta = new NegocioDetalleVenta();
                Iterator iter = auxNegocioVenta.consultaVentaEspecifa(Integer.parseInt(id_venta)).iterator();
                int fila = 0;
                int folio = 0;
                while(iter.hasNext())
                {
                    Venta auxVenta = new Venta();
                    auxVenta = (Venta) iter.next();
                    Object[] num = {};
                    modelo.addRow(num);
                    
                    folio = auxNegocioDetalleVenta.encontrarFolioEspecifico(auxVenta.getId_detalle_venta());
                    this.table_venta.setValueAt(auxVenta.getId_venta(), fila, 0);
                    this.table_venta.setValueAt(String.format("$%,d",auxVenta.getMonto_venta()), fila, 1);
                    this.table_venta.setValueAt(auxVenta.getRut_cli(), fila, 2);
                    this.table_venta.setValueAt(auxVenta.getRut_usu(), fila, 3);
                    this.table_venta.setValueAt(auxVenta.getFecha_venta(), fila, 4);
                    this.table_venta.setValueAt(auxVenta.getId_metodo_pago(), fila, 5);
                    this.table_venta.setValueAt(folio, fila, 6);
                    fila++;

                }
            }else{
                JOptionPane.showMessageDialog(null, "La id de venta no existe");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Primero Ingrese un id de venta");
        }

        
        
    }
    
    
    public void eliminarVenta (){
        
        int fila = table_venta.getSelectedRow();
        if( fila == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecciona una venta primero");
        }else{
            
            int id_venta = Integer.parseInt(table_venta.getValueAt(fila, 0).toString());
            
            if(JOptionPane.showConfirmDialog(null, "Se modificara un usuario, ¿Desea Continuar?", "Modificar Usuario"
                    ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                //Se elimina la venta
                NegocioVenta auxNegocioVenta = new NegocioVenta();
                auxNegocioVenta.eliminarVenta(id_venta);
                NegocioDetalleVenta auxNegocioDetalleVenta = new NegocioDetalleVenta();
                int folio = Integer.parseInt(table_venta.getValueAt(fila, 6).toString());
                //Devolver Stock al producto devuelto
                NegocioProducto auxNegocioProducto = new NegocioProducto();
                Iterator iter = auxNegocioDetalleVenta.buscarDetalleVentaPorFolio(folio).iterator();
                
                while(iter.hasNext())
                {
                    DetalleVenta auxDetalleVenta = new DetalleVenta();
                    auxDetalleVenta = (DetalleVenta) iter.next();
                    int id_cod = auxDetalleVenta.getId_prod();
                    int cantidad = auxDetalleVenta.getCantidad_prod();
                    auxNegocioProducto.SumarStockDeProducto(id_cod, cantidad);
                }
                
                //Borrar el detallede la venta
                auxNegocioDetalleVenta.eliminarDetalleVenta(folio);
                //borra el producto del jtable
                DefaultTableModel modelo = new DefaultTableModel();
                modelo = (DefaultTableModel) table_venta.getModel();
                modelo.removeRow(fila);
                
                
                
                
                
                
            }
        }
        
        
    }
    
    public void mostrarVenta(){
        
        int fila = table_venta.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecciona una venta primero");   
        }else{
            id_detalle_venta = (table_venta.getValueAt(fila, 6).toString());
            monto_total = ((table_venta.getValueAt(fila, 1).toString()));
            VistaDetalleVenta pMenu = new VistaDetalleVenta();
            pMenu.setVisible(true);
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

        jPanel2 = new javax.swing.JPanel();
        txt_idVenta = new javax.swing.JTextField();
        bto_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_venta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        bto_buscar = new javax.swing.JButton();
        bto_mostrarDetalle = new javax.swing.JButton();
        bto_ventaDia = new javax.swing.JButton();
        bto_buscar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_rut = new javax.swing.JLabel();
        bto_cerrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 980));

        txt_idVenta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_idVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idVentaKeyTyped(evt);
            }
        });

        bto_eliminar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        bto_eliminar.setText("Anular Venta");
        bto_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_eliminarActionPerformed(evt);
            }
        });

        table_venta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Venta", "Monto ", "Rut Cliente", "Rut Trabajador", "Fecha Venta", "Metodo de Pago", "Folio"
            }
        ));
        jScrollPane1.setViewportView(table_venta);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Codigo Venta");

        bto_buscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        bto_buscar.setText("Buscar");
        bto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarActionPerformed(evt);
            }
        });

        bto_mostrarDetalle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_mostrarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pagar.png"))); // NOI18N
        bto_mostrarDetalle.setText("Mostrar Detalle");
        bto_mostrarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_mostrarDetalleActionPerformed(evt);
            }
        });

        bto_ventaDia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_ventaDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras.png"))); // NOI18N
        bto_ventaDia.setText("Ventas del Dia");
        bto_ventaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_ventaDiaActionPerformed(evt);
            }
        });

        bto_buscar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        bto_buscar1.setText("Actualizar Tabla");
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
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bto_mostrarDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bto_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bto_ventaDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txt_idVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(bto_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bto_buscar1)
                        .addGap(357, 357, 357))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_idVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bto_buscar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bto_buscar1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(bto_mostrarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(bto_ventaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(bto_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(334, 334, 334))
        );

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reporte de Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbl_usuario)
                .addGap(18, 18, 18)
                .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(508, 508, 508)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bto_cerrar)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bto_cerrar))
                .addContainerGap(26, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bto_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_cerrarActionPerformed
        // TODO add your handling code here:
        VistaLogin login = new VistaLogin();
        login.redireccionarVentana(lbl_rut.getText());
        this.dispose();
    }//GEN-LAST:event_bto_cerrarActionPerformed

    private void bto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarActionPerformed
        // TODO add your handling code here:
        buscarVentaEspecifica((txt_idVenta.getText()));
    }//GEN-LAST:event_bto_buscarActionPerformed

    private void bto_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_eliminarActionPerformed
        // TODO add your handling code here:
        eliminarVenta();
    }//GEN-LAST:event_bto_eliminarActionPerformed

    private void bto_mostrarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_mostrarDetalleActionPerformed
        // TODO add your handling code here:
        mostrarVenta();
        
        
        
    }//GEN-LAST:event_bto_mostrarDetalleActionPerformed

    private void txt_idVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idVentaKeyTyped
        // TODO add your handling code here:
        if(this.txt_idVenta.getText().length() >= 10)
            {
                evt.consume();
            }
        char c=evt.getKeyChar();
 
 
	if(Character.isLetter(c)) {
		getToolkit().beep();
 
		evt.consume();
        }
    }//GEN-LAST:event_txt_idVentaKeyTyped

    private void bto_ventaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_ventaDiaActionPerformed
        // TODO add your handling code here:
        VistaVentaDia pMenu = new VistaVentaDia();
        pMenu.setVisible(true);

    }//GEN-LAST:event_bto_ventaDiaActionPerformed

    private void bto_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscar1ActionPerformed
        // TODO add your handling code here:
        buscarVenta();
        txt_idVenta.setText("");
    }//GEN-LAST:event_bto_buscar1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bto_buscar;
    private javax.swing.JButton bto_buscar1;
    private javax.swing.JButton bto_cerrar;
    private javax.swing.JButton bto_eliminar;
    private javax.swing.JButton bto_mostrarDetalle;
    private javax.swing.JButton bto_ventaDia;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable table_venta;
    private javax.swing.JTextField txt_idVenta;
    // End of variables declaration//GEN-END:variables
}
