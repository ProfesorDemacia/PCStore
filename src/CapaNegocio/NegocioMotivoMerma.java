/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.MotivoMerma;
import CapaDTO.MotivoMerma;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesar
 */
public class NegocioMotivoMerma {
    
    private ConexionMySQL conec1;
    
    public void configurarConexion()
    {
         this.setConec1(new ConexionMySQL());
         this.getConec1().setNombreBaseDatos("jdbc:mysql://localhost/pcstore");
         this.getConec1().setNombreTabla("motivo_merma");
         this.getConec1().setCadenaConexion("com.mysql.jdbc.Driver");
         this.getConec1().setUsuario("root");
         this.getConec1().setPass("");
    }
    
    public void insertarMotivoMerma(MotivoMerma motivomerma)
    {
       this.configurarConexion();
       this.getConec1().setCadenaSQL("INSERT INTO motivo_merma "
                                     +" (id_prod ,marca_prod,modelo_prod,motivo_merma) VALUES ("+
                                      motivomerma.getId_prod()+ ",'"+
                                      motivomerma.getMarca_prod()+"','"+
                                      motivomerma.getModelo_prod()+"','"+
                                      motivomerma.getMotivo_merma()+ "');");
       this.getConec1().setEsSelect(false);
       this.getConec1().conectar();
       this.getConec1().cerrar();
    }
    
    public ArrayList<MotivoMerma> consultaMerma()
    {
       ArrayList<MotivoMerma> auxLisMotivoMerma = new ArrayList<>();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM motivo_merma;");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           while(this.getConec1().getDbresultSet().next()) 
           {
              MotivoMerma auxMotivoMerma = new MotivoMerma();
              auxMotivoMerma.setId_eliminar_prod(this.getConec1().getDbresultSet().getInt("id_eliminar_prod"));
              auxMotivoMerma.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxMotivoMerma.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxMotivoMerma.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxMotivoMerma.setMotivo_merma(this.getConec1().getDbresultSet().getString("motivo_merma"));
              auxLisMotivoMerma.add(auxMotivoMerma); 
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxLisMotivoMerma; 
    
    }
    
    public MotivoMerma buscaMotivoMerma(int id_prod)
    {
       MotivoMerma auxMotivoMerma = new MotivoMerma();
       this.configurarConexion();
       this.getConec1().setCadenaSQL("SELECT *  FROM motivo_merma"
                                    + " WHERE id_prod = "+id_prod+";");
       this.getConec1().setEsSelect(true);
       this.getConec1().conectar();
       
       try
       {
           if(this.getConec1().getDbresultSet().next()) 
           {
              auxMotivoMerma.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxMotivoMerma.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxMotivoMerma.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxMotivoMerma.setMotivo_merma(this.getConec1().getDbresultSet().getString("motivo_merma"));
           }
           else
           {
              auxMotivoMerma.setId_prod(this.getConec1().getDbresultSet().getInt("id_prod"));
              auxMotivoMerma.setMarca_prod(this.getConec1().getDbresultSet().getString("marca_prod"));
              auxMotivoMerma.setModelo_prod(this.getConec1().getDbresultSet().getString("modelo_prod"));
              auxMotivoMerma.setMotivo_merma(this.getConec1().getDbresultSet().getString("motivo_merma"));
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       this.getConec1().cerrar();
       return auxMotivoMerma; 
    
    }
    
    public boolean existeProducto(int id_prod) 
    {
        this.configurarConexion();
        this.getConec1().setCadenaSQL("SELECT * FROM motivo_merma WHERE id_prod = "+id_prod+";");
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
