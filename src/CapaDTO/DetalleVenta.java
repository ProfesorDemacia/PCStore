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
public class DetalleVenta {
    
    private int id_detalle_venta;
    private int id_prod;
    private int folio_detalle_venta;
    private String nombre_categoria;
    private String marca_prod;
    private String modelo_prod;
    private int precio_unitario_prod;
    private int precio_total_detalle;
    private String rut_cli;
    private String rut_usu;
    private int cantidad_prod;

    /**
     * @return the id_detalle_venta
     */
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    /**
     * @param id_detalle_venta the id_detalle_venta to set
     */
    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    /**
     * @return the id_prod
     */
    public int getId_prod() {
        return id_prod;
    }

    /**
     * @param id_prod the id_prod to set
     */
    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    /**
     * @return the marca_prod
     */
    public String getMarca_prod() {
        return marca_prod;
    }

    /**
     * @param marca_prod the marca_prod to set
     */
    public void setMarca_prod(String marca_prod) {
        this.marca_prod = marca_prod;
    }

    /**
     * @return the modelo_prod
     */
    public String getModelo_prod() {
        return modelo_prod;
    }

    /**
     * @param modelo_prod the modelo_prod to set
     */
    public void setModelo_prod(String modelo_prod) {
        this.modelo_prod = modelo_prod;
    }

    /**
     * @return the precio_unitario_prod
     */
    public int getPrecio_unitario_prod() {
        return precio_unitario_prod;
    }

    /**
     * @param precio_unitario_prod the precio_unitario_prod to set
     */
    public void setPrecio_unitario_prod(int precio_unitario_prod) {
        this.precio_unitario_prod = precio_unitario_prod;
    }

    /**
     * @return the precio_total_detalle
     */
    public int getPrecio_total_detalle() {
        return precio_total_detalle;
    }

    /**
     * @param precio_total_detalle the precio_total_detalle to set
     */
    public void setPrecio_total_detalle(int precio_total_detalle) {
        this.precio_total_detalle = precio_total_detalle;
    }

    /**
     * @return the rut_cli
     */
    public String getRut_cli() {
        return rut_cli;
    }

    /**
     * @param rut_cli the rut_cli to set
     */
    public void setRut_cli(String rut_cli) {
        this.rut_cli = rut_cli;
    }

    /**
     * @return the rut_usu
     */
    public String getRut_usu() {
        return rut_usu;
    }

    /**
     * @param rut_usu the rut_usu to set
     */
    public void setRut_usu(String rut_usu) {
        this.rut_usu = rut_usu;
    }

    public int getCantidad_prod() {
        return cantidad_prod;
    }

    public void setCantidad_prod(int cantidad_prod) {
        this.cantidad_prod = cantidad_prod;
    }

    public int getFolio_detalle_venta() {
        return folio_detalle_venta;
    }

    public void setFolio_detalle_venta(int folio_detalle_venta) {
        this.folio_detalle_venta = folio_detalle_venta;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }


    
    
    
    
    
    
}
