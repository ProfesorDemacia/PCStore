/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.CategoriaProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioCategoriaProducto {
     private ConexionMySQL conec1;
    

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("categoria_producto");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    public void insertarCategoriaProducto(CategoriaProducto categoriaproducto)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO categoria_producto "+" (nombre_categoria) VALUES ('"+
                                      categoriaproducto.getNombre_categoria()+ "');");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void actualizarCategoriaProducto(CategoriaProducto categoriaproducto)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE categoria_producto "
                                     + " SET "
                                     + " nombre_categoria = '" + categoriaproducto.getNombre_categoria()
                                     + "' WHERE id_categoria_prod = " + categoriaproducto.getId_categoria_prod()+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public void eliminarCategoriaProducto(int id_categoria_prod)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM categoria_producto "+" WHERE id_categoria_prod = " + id_categoria_prod + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public ArrayList<CategoriaProducto> consultaCategoriaProducto()
    {
       ArrayList<CategoriaProducto> auxLisCategoriaProducto = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM categoria_producto;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              CategoriaProducto auxCategoriaProducto = new CategoriaProducto();
              auxCategoriaProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
              auxCategoriaProducto.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
              auxLisCategoriaProducto.add(auxCategoriaProducto);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisCategoriaProducto; 
    
    }
    
    
     
    

    public CategoriaProducto buscaCategoriaProducto(int id_categoria_prod)
    {
       CategoriaProducto auxCategoriaProducto = new CategoriaProducto();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM categoria_producto"
                                    + " WHERE id_categoria_prod = "+id_categoria_prod+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxCategoriaProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
              auxCategoriaProducto.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
           }
           else
           {
              auxCategoriaProducto.setId_categoria_prod(Integer.parseInt(""));
              auxCategoriaProducto.setNombre_categoria("");
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       return auxCategoriaProducto; 
    
    }
    public CategoriaProducto buscaNombreCategoria(String nombre_categoria)
    {
       CategoriaProducto auxCategoriaProducto = new CategoriaProducto();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM categoria_producto"
                                    + " WHERE nombre_categoria = '"+nombre_categoria+"';");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxCategoriaProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
              auxCategoriaProducto.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
           }
           else
           {
              auxCategoriaProducto.setId_categoria_prod(Integer.parseInt(""));
              auxCategoriaProducto.setNombre_categoria("");
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       return auxCategoriaProducto; 
    
    }
    
    public boolean existeCategoria(int id_cat) 
    {
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT * FROM categoria_producto WHERE id_categoria_prod = "+id_cat+";");
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
