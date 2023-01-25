/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Venta;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioVenta {
    
    private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("venta");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    public void insertarVenta(Venta venta)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO venta "
                                     +" (monto_venta,id_metodo_pago,fecha_venta,rut_usu, rut_cli, id_detalle_venta) VALUES ("
               +""+venta.getMonto_venta()+","
               + ""+venta.getId_metodo_pago()+ ","
               + "CURRENT_DATE(),'"
               + ""+venta.getRut_usu()+ "','"
               + ""+venta.getRut_cli()+ "',"
               + venta.getId_detalle_venta()+");");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void eliminarVenta(int id_venta){
        this.configurarConexion();
        this.getConec1().setCadenaSQL("DELETE FROM venta "
                                     + " WHERE id_venta = " + id_venta + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
     public ArrayList<Venta> consultaVenta()
    {
       ArrayList<Venta> auxLisVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM venta ORDER BY fecha_venta ASC, id_metodo_pago ASC;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              Venta auxVenta = new Venta();
              auxVenta.setId_venta(this.getConec1().getDbresultSet().getInt("id_venta"));
              auxVenta.setMonto_venta(this.getConec1().getDbresultSet().getInt("monto_venta"));
              auxVenta.setId_metodo_pago(this.getConec1().getDbresultSet().getInt("id_metodo_pago"));
              auxVenta.setFecha_venta(this.getConec1().getDbresultSet().getDate("fecha_venta"));
              auxVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxLisVenta.add(auxVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisVenta; 
    
    }
     
    public ArrayList<Venta> consultaVentaEspecifa(int id_venta)
    {
       ArrayList<Venta> auxLisVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM venta WHERE id_venta = "+id_venta+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              Venta auxVenta = new Venta();
              auxVenta.setId_venta(this.getConec1().getDbresultSet().getInt("id_venta"));
              auxVenta.setMonto_venta(this.getConec1().getDbresultSet().getInt("monto_venta"));
              auxVenta.setId_metodo_pago(this.getConec1().getDbresultSet().getInt("id_metodo_pago"));
              auxVenta.setFecha_venta(this.getConec1().getDbresultSet().getDate("fecha_venta"));
              auxVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxLisVenta.add(auxVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisVenta; 
    
    }
    
    
    public ArrayList<Venta> consultaVentaPorFecha(String fecha)
    {
       ArrayList<Venta> auxLisVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM venta WHERE fecha_venta = '"+fecha+"' ORDER BY fecha_venta ASC, id_metodo_pago ASC ;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              Venta auxVenta = new Venta();
              auxVenta.setId_venta(this.getConec1().getDbresultSet().getInt("id_venta"));
              auxVenta.setMonto_venta(this.getConec1().getDbresultSet().getInt("monto_venta"));
              auxVenta.setId_metodo_pago(this.getConec1().getDbresultSet().getInt("id_metodo_pago"));
              auxVenta.setFecha_venta(this.getConec1().getDbresultSet().getDate("fecha_venta"));
              auxVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));
              auxLisVenta.add(auxVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisVenta; 
    
    }
    
    public boolean existeVenta(int id_venta){
        
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT * FROM venta WHERE id_venta = "+id_venta+";");
        this.getConec1().setEsSelect(true);
        this.getConec1().conectar();
        boolean existe = false;
        
        try {
            
            existe = this.getConec1().getDbresultSet().next();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
        }
        this.getConec1().cerrar();
        return existe;
    }
    
    
    public Venta buscaVenta(int id_venta)
    {
       Venta auxVenta = new Venta();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM venta"
                                    + " WHERE id_venta = "+id_venta+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              
              auxVenta.setId_venta(this.getConec1().getDbresultSet().getInt("id_venta"));
              auxVenta.setMonto_venta(this.getConec1().getDbresultSet().getInt("monto_venta"));
              auxVenta.setId_metodo_pago(this.getConec1().getDbresultSet().getInt("id_metodo_pago"));
              auxVenta.setFecha_venta(this.getConec1().getDbresultSet().getDate("fecha_venta"));
              auxVenta.setRut_usu(this.getConec1().getDbresultSet().getString("rut_usu"));
              auxVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt("id_detalle_venta"));

           
           }
           else
           {
              auxVenta.setId_venta(this.getConec1().getDbresultSet().getInt(""));
              auxVenta.setMonto_venta(this.getConec1().getDbresultSet().getInt(""));
              auxVenta.setId_metodo_pago(this.getConec1().getDbresultSet().getInt(""));
              auxVenta.setFecha_venta(this.getConec1().getDbresultSet().getDate(""));
              auxVenta.setRut_usu(this.getConec1().getDbresultSet().getString(""));
              auxVenta.setRut_cli(this.getConec1().getDbresultSet().getString(""));
              auxVenta.setId_detalle_venta(this.getConec1().getDbresultSet().getInt(""));
              
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxVenta; 
    
    }

    public ConexionMySQL getConec1() {
        return conec1;
    }

    public void setConec1(ConexionMySQL conec1) {
        this.conec1 = conec1;
    }
    
    
    
    
}


    
