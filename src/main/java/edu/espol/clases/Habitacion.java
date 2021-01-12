/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.clases;

/**
 *
 * @author Alexandra
 */
public class Habitacion implements java.io.Serializable{
    
    private String numero;
    private float precio;
    private String[] servicios;
    private String categoria;
    
    public Habitacion(String numero, float precio, String[] servicios, String categoria){
        this.numero = numero;
        this.precio = precio;
        this.servicios = servicios;
        this.categoria = categoria;
    }
    
    public Habitacion(){
        this("", 0,new String[1],"");
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String[] getServicios() {
        return servicios;
    }

    public void setServicios(String[] servicios) {
        this.servicios = servicios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", precio=" + precio + ", servicios=" + servicios + ", categoria=" + categoria + '}';
    }
}
