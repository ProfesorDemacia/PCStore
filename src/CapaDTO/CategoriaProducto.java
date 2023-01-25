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
public class CategoriaProducto {
    
    private int id_categoria_prod;
    private String nombre_categoria;

    public int getId_categoria_prod() {
        return id_categoria_prod;
    }

    public void setId_categoria_prod(int id_categoria_prod) {
        this.id_categoria_prod = id_categoria_prod;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    @Override//Esto sirve para cuando llamas a este objeto y sale con una id rara muestre el nombre
    public String toString() {
        return this.nombre_categoria;
    }
    
    
    
}
