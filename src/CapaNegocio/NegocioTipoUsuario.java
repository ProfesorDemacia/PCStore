/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.TipoUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioTipoUsuario {
     private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("tipo_usuario");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    public void insertarTipoUsuario(TipoUsuario tipousuario)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO tipo_usuario "
                                     +" (id_tipo_usu,nombre_tipo_usu) VALUES ("+
                                      tipousuario.getId_tipo_usu()+",'"+ tipousuario.getNombre_tipo_usu()+ "');");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void actualizarTipoUsuario(TipoUsuario tipousuario)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE tipo_usuario "
                                     +" SET "
                                     + " nombre_tipo_usu = '" + tipousuario.getNombre_tipo_usu()
                           
                                     + "' WHERE id_tipo_usu = " + tipousuario.getId_tipo_usu()+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public void eliminarTipoUsuario(String id_tipo_usu)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM tipo_usuario "
                                     + " WHERE tu_id_tipo_usuario = " + id_tipo_usu + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public ArrayList<TipoUsuario> consultaTipoUsuario()
    {
       ArrayList<TipoUsuario> auxLisTipoUsuario = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT * FROM tipo_usuario");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              TipoUsuario auxTipoUsuario = new TipoUsuario();
              auxTipoUsuario.setId_tipo_usu(this.getConec1().getDbresultSet().getInt("id_tipo_usu"));
              auxTipoUsuario.setNombre_tipo_usu(this.getConec1().getDbresultSet().getString("nombre_tipo_usu"));
              auxLisTipoUsuario.add(auxTipoUsuario);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisTipoUsuario; 
    
    }

    public TipoUsuario buscaTipoUsuario(int id_tipo_usu)
    {
       TipoUsuario auxTipoUsuario = new TipoUsuario();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM tipo_usuario"
                                    + " WHERE id_tipo_usu = '"+ id_tipo_usu+"';");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxTipoUsuario.setId_tipo_usu(this.getConec1().getDbresultSet().getInt("id_tipo_usu"));
              auxTipoUsuario.setNombre_tipo_usu(this.getConec1().getDbresultSet().getString("nombre_tipo_usu"));
           }
           else
           {
              auxTipoUsuario.setId_tipo_usu(Integer.parseInt(""));
              auxTipoUsuario.setNombre_tipo_usu("");
          
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxTipoUsuario; 
    
    }


    
   
    /**
     * @return the conec1
     */
    public ConexionMySQL getConec1() {
        return conec1;
    }

    /**
     * @param conec1 the conec1 to set
     */
    public void setConec1(ConexionMySQL conec1) {
        this.conec1 = conec1;
    }
    
}
