/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

/**
 *
 * @author Cesar
 */
public class SolicitudVenta {
    private int id_solicitud;
    private String rut_cli;
    private int folio_detalle_venta;

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }


    public String getRut_cli() {
        return rut_cli;
    }

    public void setRut_cli(String rut_cli) {
        this.rut_cli = rut_cli;
    }

    public int getFolio_detalle_venta() {
        return folio_detalle_venta;
    }

    public void setFolio_detalle_venta(int folio_detalle_venta) {
        this.folio_detalle_venta = folio_detalle_venta;
    }
    
    
    
    
    
    
    
}
