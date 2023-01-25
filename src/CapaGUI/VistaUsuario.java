/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.Usuario;
import CapaNegocio.NegocioUsuario;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class VistaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaUsuario
     */
    public VistaUsuario() {
        initComponents();
        VistaLogin auxVista = new VistaLogin();
        lbl_rut.setText(auxVista.rut_usu);
        buscarUsuario();
    }
    
    public static String rut_usu = "";
    
    
    public void buscarUsuario(){
        
        try {
            
            DefaultTableModel model = new DefaultTableModel();
            model = (DefaultTableModel) this.table_usuario.getModel();
            model.setNumRows(0);
            int fila = 0;
            NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
            Iterator iter = auxNegocioUsuario.consultaUsuario().iterator();
            
            while(iter.hasNext())
            {
                Usuario auxUsuario = new Usuario();
                auxUsuario = (Usuario) iter.next();
                Object[] num = {};
                model.addRow(num);
                this.table_usuario.setValueAt(auxUsuario.getRut_usu(),fila , 0);
                this.table_usuario.setValueAt(auxUsuario.getNombre_usu(),fila , 1);
                this.table_usuario.setValueAt(auxUsuario.getApellido_usu(),fila , 2);
                this.table_usuario.setValueAt(String.format("$%,d",auxUsuario.getSueldo_usu()),fila , 3);
                this.table_usuario.setValueAt(auxUsuario.getCorreo_usu(),fila , 4);
                this.table_usuario.setValueAt(auxUsuario.getContrasena_usu(),fila , 5);
                this.table_usuario.setValueAt(auxUsuario.getId_tipo_usu(),fila , 6);
                fila++;
            }
            
            
        } catch (Exception e) {
        }
        
    }
    
    public void buscarUsuarioEspecifico(String rut_usu){
        
        if(txt_rutUsu.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Ingrese un rut primero");
            buscarUsuario();
        }else{
            NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
            if(auxNegocioUsuario.existeUsuario(rut_usu))
            {
                Usuario auxUsuario = new Usuario();
                DefaultTableModel model = new DefaultTableModel();
                model = (DefaultTableModel) this.table_usuario.getModel();
                model.setNumRows(0);
                Object[] num = {};
                model.addRow(num);
                auxUsuario.setRut_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getRut_usu());
                auxUsuario.setNombre_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getNombre_usu());
                auxUsuario.setApellido_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getApellido_usu());
                auxUsuario.setSueldo_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getSueldo_usu());
                auxUsuario.setCorreo_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getCorreo_usu());
                auxUsuario.setContrasena_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getContrasena_usu());
                auxUsuario.setId_tipo_usu(auxNegocioUsuario.buscaUsuario(rut_usu).getId_tipo_usu());
                
                String rut_usuario = auxUsuario.getRut_usu();
                String nombre_usu = auxUsuario.getNombre_usu();
                String apellido_usu = auxUsuario.getApellido_usu();
                int sueldo_usu = auxUsuario.getSueldo_usu();
                String correo = auxUsuario.getCorreo_usu();
                String contrasena_usu = auxUsuario.getContrasena_usu();
                int tipo_usu = auxUsuario.getId_tipo_usu();
                
                this.table_usuario.setValueAt(rut_usuario, 0, 0);
                this.table_usuario.setValueAt(nombre_usu, 0, 1);
                this.table_usuario.setValueAt(apellido_usu, 0, 2);
                this.table_usuario.setValueAt(sueldo_usu, 0, 3);
                this.table_usuario.setValueAt(correo, 0, 4);
                this.table_usuario.setValueAt(contrasena_usu, 0, 5);
                this.table_usuario.setValueAt(tipo_usu, 0, 6);
                
            }else{
                JOptionPane.showMessageDialog(null, "El rut del usuario no existe");
            }
        }
        
    }
    
    public void eliminarUsuario (){
        
        int fila = table_usuario.getSelectedRow();
        if( fila == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecciona una venta primero");
        }else{
            
            String rut_usuario = (table_usuario.getValueAt(fila, 0).toString());
            if(JOptionPane.showConfirmDialog(null, "Se borrara un usuario, ¿Desea Continuar?", "Eliminar Usuario"
                    ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                //Se elimina el usuario
                NegocioUsuario auxNegocioVenta = new NegocioUsuario();
                auxNegocioVenta.eliminarUsuario(rut_usuario);
                //borra el usuario del jtable
                DefaultTableModel modelo = new DefaultTableModel();
                modelo = (DefaultTableModel) table_usuario.getModel();
                modelo.removeRow(fila);
                
                JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado"); 
            }
        }
        
        
    }
    
    
    public void mostrarUsuario(){
        
        int fila = table_usuario.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario primero");   
        }else{
            rut_usu = (table_usuario.getValueAt(fila, 0).toString());
            VistaModificarUsuario pMenu = new VistaModificarUsuario();
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
        txt_rutUsu = new javax.swing.JTextField();
        bto_agregarUsu = new javax.swing.JButton();
        bto_modificarUsu = new javax.swing.JButton();
        bto_eliminarUsu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        bto_buscar = new javax.swing.JButton();
        bto_actualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_rut = new javax.swing.JLabel();
        bto_cerrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 980));

        txt_rutUsu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_rutUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rutUsuKeyTyped(evt);
            }
        });

        bto_agregarUsu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_agregarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        bto_agregarUsu.setText("Agregar Usuario");
        bto_agregarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_agregarUsuActionPerformed(evt);
            }
        });

        bto_modificarUsu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_modificarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        bto_modificarUsu.setText("Modificar Usuario");
        bto_modificarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_modificarUsuActionPerformed(evt);
            }
        });

        bto_eliminarUsu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_eliminarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        bto_eliminarUsu.setText("Eliminar Usuario");
        bto_eliminarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_eliminarUsuActionPerformed(evt);
            }
        });

        table_usuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Apellido", "Sueldo", "Correo", "Contraseña", "Tipo Usuario"
            }
        ));
        jScrollPane1.setViewportView(table_usuario);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Rut Usuario");

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
        bto_actualizar.setText("Actualizar");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_rutUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(bto_buscar)
                        .addGap(486, 486, 486)
                        .addComponent(bto_actualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bto_modificarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bto_agregarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bto_eliminarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_rutUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bto_buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bto_actualizar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(bto_agregarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(bto_modificarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(bto_eliminarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 100));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Rut Usuario/a:");
        lbl_usuario.setToolTipText("");

        lbl_rut.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_rut.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rut.setText("19635672-9");
        lbl_rut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bto_cerrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bto_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        bto_cerrar.setText("Volver");
        bto_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_cerrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_usuario)
                .addGap(18, 18, 18)
                .addComponent(lbl_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(527, 527, 527)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void bto_agregarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_agregarUsuActionPerformed
        // TODO add your handling code here:
        VistaAgregarUsuario pMenu = new VistaAgregarUsuario();
        pMenu.setVisible(true);
        
    }//GEN-LAST:event_bto_agregarUsuActionPerformed

    private void bto_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_cerrarActionPerformed
        // TODO add your handling code here:
        VistaLogin login = new VistaLogin();
        login.redireccionarVentana(lbl_rut.getText());
        this.dispose();
    }//GEN-LAST:event_bto_cerrarActionPerformed

    private void bto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarActionPerformed
        // TODO add your handling code here:
        buscarUsuarioEspecifico(txt_rutUsu.getText());
    }//GEN-LAST:event_bto_buscarActionPerformed

    private void bto_modificarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_modificarUsuActionPerformed
        // TODO add your handling code here:
        mostrarUsuario();
        
    }//GEN-LAST:event_bto_modificarUsuActionPerformed

    private void bto_eliminarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_eliminarUsuActionPerformed
        // TODO add your handling code here:
        eliminarUsuario();
        buscarUsuario();
    }//GEN-LAST:event_bto_eliminarUsuActionPerformed

    private void bto_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_actualizarActionPerformed
        // TODO add your handling code here:
        buscarUsuario();
    }//GEN-LAST:event_bto_actualizarActionPerformed

    private void txt_rutUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rutUsuKeyTyped
        // TODO add your handling code here:
        if(this.txt_rutUsu.getText().length() >9)
    {
        evt.consume();
    }
    }//GEN-LAST:event_txt_rutUsuKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bto_actualizar;
    private javax.swing.JButton bto_agregarUsu;
    private javax.swing.JButton bto_buscar;
    private javax.swing.JButton bto_cerrar;
    private javax.swing.JButton bto_eliminarUsu;
    private javax.swing.JButton bto_modificarUsu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable table_usuario;
    private javax.swing.JTextField txt_rutUsu;
    // End of variables declaration//GEN-END:variables
}
