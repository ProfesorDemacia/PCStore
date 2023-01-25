/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

import java.util.Date;

/**
 *
 * @author Cesar
 */
public class Venta {
    
    private int id_venta;
    private int monto_venta;
    private int id_metodo_pago;
    private Date fecha_venta;
    private String rut_usu;
    private String rut_cli;
    private int id_detalle_venta;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getMonto_venta() {
        return monto_venta;
    }

    public void setMonto_venta(int monto_venta) {
        this.monto_venta = monto_venta;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getRut_usu() {
        return rut_usu;
    }

    public void setRut_usu(String rut_usu) {
        this.rut_usu = rut_usu;
    }

    public String getRut_cli() {
        return rut_cli;
    }

    public void setRut_cli(String rut_cli) {
        this.rut_cli = rut_cli;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }
    
    
    
}
