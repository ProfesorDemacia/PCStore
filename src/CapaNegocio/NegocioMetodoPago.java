/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.MetodoPago;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class NegocioMetodoPago {
    private ConexionMySQL conec1;

    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/psctore");
         this.getConec1().setNombreTabla("metodo_pago");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }//DEJE LISTO DE AQUI PARA ARRIBA
    
    public void insertarMetodoPago(MetodoPago metodopago)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO metodo_pago "
                                     +" (id_metodo_pago,nombre_metodo) VALUES ("+
                                      metodopago.getId_metodo_pago()+ ",'"+
                                      metodopago.getNombre_metodo()+ "');");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public void actualizarMetodoPago(MetodoPago metodopago)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("UPDATE metodo_pago "
                                     +" SET "
                                     + " nombre_metodo = '" + metodopago.getNombre_metodo()
                               
                                     + "' WHERE id_metodo_pago = " + metodopago.getId_metodo_pago()+ ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }

    public void eliminarMetodoPago(int id_metodo_pago)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("DELETE FROM metodo_pago "
                                     + " WHERE id_metodo_pago = " + id_metodo_pago + ";");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
    }

    public ArrayList<MetodoPago> consultaMetodoPago()
    {
       ArrayList<MetodoPago> auxLisMetodoPago = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM metodo_pago;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              MetodoPago auxMetodoPago = new MetodoPago();
              auxMetodoPago.setId_metodo_pago(this.getConec1().getDbresultSet().getInt("id_metodo_pago"));
              auxMetodoPago.setNombre_metodo(this.getConec1().getDbresultSet().getString("nombre_metodo"));
              auxLisMetodoPago.add(auxMetodoPago);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       return auxLisMetodoPago; 
    
    }

    public MetodoPago buscaMetodoPago(int id_metodo_pago)
    {
       MetodoPago auxMetodoPago = new MetodoPago();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM metodo_pago"
                                    + " WHERE id_metodo_pago = "+id_metodo_pago+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxMetodoPago.setId_metodo_pago(this.getConec1().getDbresultSet().getInt("id_metodo_pago"));
              auxMetodoPago.setNombre_metodo(this.getConec1().getDbresultSet().getString("nombre_metodo"));
           }
           else
           {
              auxMetodoPago.setId_metodo_pago(Integer.parseInt(""));
              auxMetodoPago.setNombre_metodo("");
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       return auxMetodoPago; 
    
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
