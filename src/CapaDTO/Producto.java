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
public class Producto {
    
    private int id_prod;
    private String marca_prod;
    private String modelo_prod;
    private int precio_unitario;
    private String descripcion_prod;
    private int stock_prod;
    private String comentario;
    private int id_categoria_prod;

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getMarca_prod() {
        return marca_prod;
    }

    public void setMarca_prod(String marca_prod) {
        this.marca_prod = marca_prod;
    }

    public String getModelo_prod() {
        return modelo_prod;
    }

    public void setModelo_prod(String modelo_prod) {
        this.modelo_prod = modelo_prod;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public int getStock_prod() {
        return stock_prod;
    }

    public void setStock_prod(int stock_prod) {
        this.stock_prod = stock_prod;
    }

    public int getId_categoria_prod() {
        return id_categoria_prod;
    }

    public void setId_categoria_prod(int id_categoria_prod) {
        this.id_categoria_prod = id_categoria_prod;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
    
}
