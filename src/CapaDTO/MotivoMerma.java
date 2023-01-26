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
public class MotivoMerma {
    
    private int id_eliminar_prod;
    private int id_prod;
    private String marca_prod;
    private String modelo_prod;
    private String motivo_merma;

    public int getId_eliminar_prod() {
        return id_eliminar_prod;
    }

    public void setId_eliminar_prod(int id_eliminar_prod) {
        this.id_eliminar_prod = id_eliminar_prod;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getMotivo_merma() {
        return motivo_merma;
    }

    public void setMotivo_merma(String motivo_merma) {
        this.motivo_merma = motivo_merma;
    }

    public String getModelo_prod() {
        return modelo_prod;
    }

    public void setModelo_prod(String modelo_prod) {
        this.modelo_prod = modelo_prod;
    }

    public String getMarca_prod() {
        return marca_prod;
    }

    public void setMarca_prod(String marca_prod) {
        this.marca_prod = marca_prod;
    }
    
    
    
    
}
