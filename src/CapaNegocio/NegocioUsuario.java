/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioUsuario {
    
     private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("usuario");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }//DEJE LISTO DE AQUI PARA ARRIBA
    
    public void insertarUsuario(Usuario usuario)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO usuario "
                                     +" (rut_usu,nombre_usu,apellido_usu,sueldo_usu,correo_usu,contrasena_usu,id_tipo_usu) VALUES ('"+
                                      usuario.getRut_usu()+ "','"+
                                      usuario.getNombre_usu()+ "','"+
                                      usuario.getApellido_usu()+ "',"+
                                      usuario.getSueldo_usu()+ ",'"+
                                      usuario.getCorreo_usu()+ "','"+
                                      usuario.getContrasena_usu()+ "',"+
                                      usuario.getId_tipo_usu()+ ");");
                                      
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void actualizarUsuario(Usuario usuario)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE usuario " 
                                     + " SET "
                                     + " nombre_usu = '" + usuario.getNombre_usu()
                                     + "', apellido_usu = '" + usuario.getApellido_usu()
                                     + "', sueldo_usu = " + usuario.getSueldo_usu()
                                     + ", correo_usu = '" + usuario.getCorreo_usu()
                                     + "', contrasena_usu = '" + usuario.getContrasena_usu()
                                     + "', id_tipo_usu = " + usuario.getId_tipo_usu()
                                     + " WHERE rut_usu = '" + usuario.getRut_usu()+ "';");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public void eliminarUsuario(String rut_usu)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM usuario "
                                     + " WHERE rut_usu = '" + rut_usu + "';");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public ArrayList<Usuario> consultaUsuario()
    {
       ArrayList<Usuario> auxLisUsuario = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM usuario;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              Usuario auxUsuario = new Usuario();
              auxUsuario.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxUsuario.setNombre_usu(this.getConec1().getDbresultSet().getString("nombre_usu"));
              auxUsuario.setApellido_usu(this.getConec1().getDbresultSet().getString("apellido_usu"));
              auxUsuario.setSueldo_usu(this.getConec1().getDbresultSet().getInt("sueldo_usu"));
              auxUsuario.setCorreo_usu(this.getConec1().getDbresultSet().getString("correo_usu"));
              auxUsuario.setContrasena_usu(this.getConec1().getDbresultSet().getString("contrasena_usu"));
              auxUsuario.setId_tipo_usu(this.getConec1().getDbresultSet().getInt("id_tipo_usu"));
              auxLisUsuario.add(auxUsuario);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       
       return auxLisUsuario; 
    
    }

    public Usuario buscaUsuario(String rut_usu)
    {
       Usuario auxUsuario = new Usuario();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM usuario"
                                    + " WHERE rut_usu = '"+rut_usu+"';");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
      
       
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
               
              auxUsuario.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxUsuario.setNombre_usu(this.getConec1().getDbresultSet().getString("nombre_usu"));
              auxUsuario.setApellido_usu(this.getConec1().getDbresultSet().getString("apellido_usu"));
              auxUsuario.setSueldo_usu(this.getConec1().getDbresultSet().getInt("sueldo_usu"));
              auxUsuario.setCorreo_usu(this.getConec1().getDbresultSet().getString("correo_usu"));
              auxUsuario.setContrasena_usu(this.getConec1().getDbresultSet().getString("contrasena_usu"));
              auxUsuario.setId_tipo_usu(this.getConec1().getDbresultSet().getInt("id_tipo_usu"));
              this.getConec1().cerrar();
           }
           else
           {
              auxUsuario.setRut_usu("");
              auxUsuario.setNombre_usu("");
              auxUsuario.setApellido_usu("");
              auxUsuario.setSueldo_usu(Integer.parseInt(""));
              auxUsuario.setCorreo_usu("");
              auxUsuario.setContrasena_usu("");
              auxUsuario.setId_tipo_usu(Integer.parseInt(""));
              this.getConec1().cerrar();
           
           }
       }
       catch(Exception ex)
       {
          this.getConec1().cerrar();
       }
       this.getConec1().cerrar();
       return auxUsuario; 
    
    }
    
    
    public int consultarCargo (String rut_usu)
    {
        int id_cargo = 0;
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT id_tipo_usu FROM usuario WHERE rut_usu = '" + rut_usu + "';");
        this.getConec1().setEsSelect(true);
        this.getConec1().conectar();
        

        try {
            while (this.getConec1().getDbresultSet().next()){
                id_cargo = this.getConec1().getDbresultSet().getInt("id_tipo_usu");
                return id_cargo;
            }
        } catch (Exception ex) {
            System.out.println("El rut ingresado no existe");
        }
        
        return id_cargo;
    }
        
    public boolean existeUsuario(String rut_usu) 
    {
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT * FROM usuario WHERE rut_usu = '"+rut_usu+"';");
        this.getConec1().setEsSelect(true);
        this.getConec1().conectar();
        boolean existe = false;
         try
        {
            
           existe = this.getConec1().getDbresultSet().next() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
        }
        this.getConec1().cerrar();
        return(existe);
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
