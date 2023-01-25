/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;
import CapaConexion.ConexionMySQL;
import CapaDTO.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioProducto {
     private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("producto");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    public void insertarProducto(Producto producto)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO producto "
                                     +" (marca_prod ,modelo_prod ,precio_unitario_prod ,descripcion_prod ,stock_prod,comentario,id_categoria_prod) VALUES ('"+
                                      producto.getMarca_prod()+ "','"+
                                      producto.getModelo_prod()+ "',"+
                                      producto.getPrecio_unitario()+ ",'"+
                                      producto.getDescripcion_prod()+ "',"+
                                      producto.getStock_prod()+ ",'"+
                                      producto.getComentario()+"',"+
                                      producto.getId_categoria_prod()+ ");");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void actualizarProducto(Producto producto)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE producto "
                                     + " SET "
                                     + " marca_prod = '" + producto.getMarca_prod()
                                     + "', modelo_prod = '" + producto.getModelo_prod()
                                     + "', precio_unitario_prod = " + producto.getPrecio_unitario()
                                     + ", descripcion_prod = '" + producto.getDescripcion_prod()
                                     + "', stock_prod= " + producto.getStock_prod()
                                     +", comentario = '"+producto.getComentario()
                                     + "', id_categoria_prod = " + producto.getId_categoria_prod()
                                     + " WHERE id_prod = " + producto.getId_prod()+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void SumarStockDeProducto(int id_prod, int cantidad)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE producto "
                                     + " SET "
                                     + " stock_prod = stock_prod +" + cantidad
                                     + " WHERE id_prod = " + id_prod+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void DisminuirStockDeProducto(int id_prod, int cantidad)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE producto "
                                     + " SET "
                                     + " stock_prod = stock_prod -" + cantidad
                                     + " WHERE id_prod = " + id_prod+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public void eliminarProducto(int id_prod)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM producto "
                                     + " WHERE id_prod = " + id_prod + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    

    public ArrayList<Producto> consultaProducto()
    {
       ArrayList<Producto> auxLisProducto = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM producto;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              Producto auxProducto = new Producto();
              auxProducto.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxProducto.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxProducto.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxProducto.setPrecio_unitario(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxProducto.setDescripcion_prod(this.getConec1().getDbresultSet().getString("descripcion_prod"));
              auxProducto.setStock_prod(this.getConec1().getDbresultSet().getInt("stock_prod"));
              auxProducto.setComentario(this.getConec1().getDbresultSet().getString("comentario"));
              auxProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
              auxLisProducto.add(auxProducto); 
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisProducto; 
    
    }
 //Buscar producto por ID
    public Producto buscaProducto(int id_prod)
    {
       Producto auxProducto = new Producto();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM producto"
                                    + " WHERE id_prod = "+id_prod+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxProducto.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxProducto.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxProducto.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxProducto.setPrecio_unitario(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxProducto.setDescripcion_prod(this.getConec1().getDbresultSet().getString("descripcion_prod"));
              auxProducto.setStock_prod(this.getConec1().getDbresultSet().getInt("stock_prod"));
              auxProducto.setComentario(this.getConec1().getDbresultSet().getString("comentario"));
              auxProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
           }
           else
           {
              auxProducto.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxProducto.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxProducto.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxProducto.setPrecio_unitario(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxProducto.setDescripcion_prod(this.getConec1().getDbresultSet().getString("descripcion_prod"));
              auxProducto.setStock_prod(this.getConec1().getDbresultSet().getInt("stock_prod"));
              auxProducto.setComentario(this.getConec1().getDbresultSet().getString("comentario"));
              auxProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxProducto; 
    
    }
    
     //Buscar producto por Nombre

    public ArrayList<Producto> buscarPorCategoria(int id_categoria)
    {
       ArrayList<Producto> auxLisProducto = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM producto WHERE  id_categoria_prod = "+id_categoria+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              Producto auxProducto = new Producto();
              auxProducto.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxProducto.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxProducto.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxProducto.setPrecio_unitario(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxProducto.setDescripcion_prod(this.getConec1().getDbresultSet().getString("descripcion_prod"));
              auxProducto.setStock_prod(this.getConec1().getDbresultSet().getInt("stock_prod"));
              auxProducto.setComentario(this.getConec1().getDbresultSet().getString("comentario"));
              auxProducto.setId_categoria_prod(this.getConec1().getDbresultSet().getInt("id_categoria_prod"));
              auxLisProducto.add(auxProducto); 
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisProducto; 
    
    }
    
    
    public boolean existeProducto(int id_prod) 
    {
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT * FROM producto WHERE id_prod = "+id_prod+";");
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
