/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;
import CapaConexion.ConexionMySQL;
import CapaDTO.DetalleVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioDetalleVenta {
     private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("detalle_venta");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    public void insertarDetalleVenta(DetalleVenta detalleventa)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO detalle_venta "
                                     +" (folio_detalle_venta,id_prod,nombre_categoria, marca_prod, modelo_prod, precio_unitario_prod, precio_total_detalle, rut_cli, rut_usu, cantidad_prod) VALUES ("
               +""+detalleventa.getFolio_detalle_venta()+","
               + ""+detalleventa.getId_prod()+ ",'"
               + ""+detalleventa.getNombre_categoria()+ "','"
               + ""+detalleventa.getMarca_prod()+ "','"
               + ""+detalleventa.getModelo_prod()+ "',"
               + ""+detalleventa.getPrecio_unitario_prod()+ ","
               + ""+detalleventa.getPrecio_total_detalle()+ ",'"
               + ""+detalleventa.getRut_cli()+ "','"
               + ""+detalleventa.getRut_usu()+ "',"
               + detalleventa.getCantidad_prod()+");");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void actualizarDetalleVenta(DetalleVenta detalleventa)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE detalle_venta "
                                     + " SET "
                                     +"folio_detalle_venta = "+ detalleventa.getFolio_detalle_venta()
                                     + " id_prod = " + detalleventa.getId_prod()
                                     + ",nombre_categoria = "+detalleventa.getNombre_categoria()
                                     + ", marca_prod = " + detalleventa.getMarca_prod()
                                     + ", modelo_prod = " + detalleventa.getModelo_prod()
                                     + ", precio_unitario_prod = " + detalleventa.getPrecio_unitario_prod()
                                     + ", Precio_total_detalle = " + detalleventa.getPrecio_total_detalle()
                                     + ", rut_cli = " + detalleventa.getRut_cli()
                                     + ", rut_usu = " + detalleventa.getRut_usu()
                                     + ", cantidad_prod = " + detalleventa.getCantidad_prod()
                                     + " WHERE id_detalle_venta = " + detalleventa.getId_detalle_venta()+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public void eliminarDetalleVenta(int folio_detalle_venta)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM detalle_venta "
                                     + " WHERE folio_detalle_venta = " + folio_detalle_venta + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public ArrayList<DetalleVenta> consultaDetalleVenta()
    {
       ArrayList<DetalleVenta> auxLisDetalleVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM detalle_venta WHERE precio_total_detalle != 0;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       this.getConec1().cerrar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              DetalleVenta auxDetalleVenta = new DetalleVenta();
              auxDetalleVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxDetalleVenta.setFolio_detalle_venta(this.getConec1().getDbresultSet().getInt("folio_detalle_venta"));
              auxDetalleVenta.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxDetalleVenta.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
              auxDetalleVenta.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxDetalleVenta.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxDetalleVenta.setPrecio_unitario_prod(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxDetalleVenta.setPrecio_total_detalle(this.getConec1().getDbresultSet().getInt("precio_total_detalle"));
              auxDetalleVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxDetalleVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxDetalleVenta.setCantidad_prod(this.getConec1().getDbresultSet().getInt("cantidad_prod"));
              
              auxLisDetalleVenta.add(auxDetalleVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisDetalleVenta; 
    
    }
    
    public ArrayList<DetalleVenta> consultaDetalleVentaCarro(int folio)
    {
       ArrayList<DetalleVenta> auxLisDetalleVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM detalle_venta WHERE folio_detalle_venta ="+ folio +";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              DetalleVenta auxDetalleVenta = new DetalleVenta();
              auxDetalleVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxDetalleVenta.setFolio_detalle_venta(this.getConec1().getDbresultSet().getInt("folio_detalle_venta"));
              auxDetalleVenta.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxDetalleVenta.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
              auxDetalleVenta.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_god"));
              auxDetalleVenta.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxDetalleVenta.setPrecio_unitario_prod(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxDetalleVenta.setPrecio_total_detalle(this.getConec1().getDbresultSet().getInt("precio_total_detalle"));
              auxDetalleVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxDetalleVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxDetalleVenta.setCantidad_prod(this.getConec1().getDbresultSet().getInt("cantidad_prod"));
           
              auxLisDetalleVenta.add(auxDetalleVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisDetalleVenta; 
    
    }

   public DetalleVenta buscaDetalleVenta(int id_detalle_venta)
    {
       DetalleVenta auxDetalleVenta = new DetalleVenta();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM detalle_venta"
                                    + " WHERE id_detalle_venta = "+id_detalle_venta+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxDetalleVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxDetalleVenta.setFolio_detalle_venta(this.getConec1().getDbresultSet().getInt("folio_detalle_venta"));
              auxDetalleVenta.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxDetalleVenta.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
              auxDetalleVenta.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_god"));
              auxDetalleVenta.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxDetalleVenta.setPrecio_unitario_prod(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxDetalleVenta.setPrecio_total_detalle(this.getConec1().getDbresultSet().getInt("precio_total_detalle"));
              auxDetalleVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxDetalleVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxDetalleVenta.setCantidad_prod(this.getConec1().getDbresultSet().getInt("cantidad_prod"));

           
           }
           else
           {
              auxDetalleVenta.setId_detalle_venta(Integer.parseInt(""));
              auxDetalleVenta.setId_prod(Integer.parseInt(""));
              auxDetalleVenta.setNombre_categoria("");
              auxDetalleVenta.setMarca_prod("");
              auxDetalleVenta.setModelo_prod("");
              auxDetalleVenta.setPrecio_unitario_prod(Integer.parseInt(""));
              auxDetalleVenta.setPrecio_total_detalle(Integer.parseInt(""));
              auxDetalleVenta.setRut_cli("");
              auxDetalleVenta.setRut_usu("");
              auxDetalleVenta.setCantidad_prod(Integer.parseInt(""));

              
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxDetalleVenta; 
    
    }
   
   
   
        public int sumarFolio()
    {

       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT MAX(folio_detalle_venta) FROM detalle_venta;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       int id_folio = 1;
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              
              id_folio = (this.getConec1().getDbresultSet().getInt(1))+1;

           
              
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return id_folio; 
    
    }
     
     
     public int encontrarFolio()
    {

       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT MAX(folio_detalle_venta) FROM detalle_venta;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       int id_folio = 1;
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              
              id_folio = (this.getConec1().getDbresultSet().getInt(1));
    
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return id_folio; 
    
    }


     public int encontrarFolioEspecifico(int id_detalle_venta)
    {
        
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT folio_detalle_venta FROM detalle_venta WHERE id_detalle_venta = "+id_detalle_venta+";");
        this.getConec1().setEsSelect(true);
        this.getConec1().conectar();
        int folio_detalle_venta = 0;
        try {
            
            while(this.getConec1().getDbresultSet().next()) 
           {
              
              folio_detalle_venta = (this.getConec1().getDbresultSet().getInt(1));
   
           }
            
        } catch (Exception e) {
        }
        this.getConec1().cerrar();
        return folio_detalle_venta;
    }
    
     public ArrayList<DetalleVenta> buscarDetalleVentaPorFolio(int id_folio)
    {
       ArrayList<DetalleVenta> auxLisVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM detalle_venta WHERE folio_detalle_venta = "+id_folio+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              DetalleVenta auxDetalleVenta = new DetalleVenta();
              
              
              auxDetalleVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxDetalleVenta.setFolio_detalle_venta(this.getConec1().getDbresultSet().getInt("folio_detalle_venta"));
              auxDetalleVenta.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxDetalleVenta.setNombre_categoria(this.getConec1().getDbresultSet().getString("nombre_categoria"));
              auxDetalleVenta.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxDetalleVenta.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxDetalleVenta.setPrecio_unitario_prod(this.getConec1().getDbresultSet().getInt("precio_unitario_prod"));
              auxDetalleVenta.setPrecio_total_detalle(this.getConec1().getDbresultSet().getInt("precio_total_detalle"));
              auxDetalleVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxDetalleVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxDetalleVenta.setCantidad_prod(this.getConec1().getDbresultSet().getInt("cantidad_prod"));
           
              auxLisVenta.add(auxDetalleVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisVenta; 
    
    }
     
     
     public int buscarIdDetalleVenta(int id_folio)
    {
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT MAX(id_detalle_venta) FROM detalle_venta WHERE folio_detalle_venta = "+id_folio+";" );
        this.getConec1().setEsSelect(true);
        this.getConec1().conectar();
        try
        {
           while(this.getConec1().getDbresultSet().next()) 
           {
              
              id_folio = (this.getConec1().getDbresultSet().getInt(1));

           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return id_folio;
        
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
