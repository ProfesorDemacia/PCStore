/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.DetalleVenta;
import CapaDTO.SolicitudVenta;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioSolicitudVenta {
    
    private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("solicitud_venta");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    
    public void insertarSolicitudVenta(SolicitudVenta solicitudventa)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO solicitud_venta "
                                     +" (rut_cli,folio_detalle_venta) VALUES ("
               +"'"+solicitudventa.getRut_cli()+"',"
               + solicitudventa.getFolio_detalle_venta()+");");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void eliminarSolicitudVenta(int folio_detalle_venta)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM solicitud_venta "
                                     + " WHERE folio_detalle_venta = " + folio_detalle_venta + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    
    public SolicitudVenta buscarSolicitudVenta(String rut_cli)
    {
       SolicitudVenta auxSolicitudVenta = new SolicitudVenta();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM solicitud_venta"
                                    + " WHERE rut_cli = '"+rut_cli+"';");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxSolicitudVenta.setId_solicitud(this.getConec1().getDbresultSet().getInt("id_solicitud"));
              auxSolicitudVenta.setRut_cli(this.getConec1().getDbresultSet().getString("rut_cli"));
              auxSolicitudVenta.setFolio_detalle_venta(this.getConec1().getDbresultSet().getInt("folio_detalle_venta"));

           }
           else
           {
              auxSolicitudVenta.setId_solicitud(this.getConec1().getDbresultSet().getInt(""));
              auxSolicitudVenta.setRut_cli(this.getConec1().getDbresultSet().getString(""));
              auxSolicitudVenta.setFolio_detalle_venta(this.getConec1().getDbresultSet().getInt(""));
      
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxSolicitudVenta; 
    
    }
    
    public boolean existeUsuario(String rut_cli) 
    {
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT * FROM solicitud_venta WHERE rut_cli = '"+rut_cli+"';");
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
    
    
    
    

    public ConexionMySQL getConec1() {
        return conec1;
    }

    public void setConec1(ConexionMySQL conec1) {
        this.conec1 = conec1;
    }
    
    
    
    
}
