/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Alexandra Imaicela
 */
public class Habitacion implements java.io.Serializable{
    
    private String numero;
    private float precio;
    private String servicios;
    private String categoria;
    private String estado;
    private ArrayList<Reservacion> reservas = new ArrayList<Reservacion>();
    
    public ArrayList<Reservacion> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reservacion> reservas) {
        this.reservas = reservas;
    }
    
    public String getEstado(){
     return estado;}

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Constructor de la clase, se asume que el estado es disponible al crear una habitacion.
     * @param numero
     * @param precio
     * @param servicios
     * @param categoria
     */
    
    public Habitacion(String numero, float precio, String servicios, String categoria){
        this.numero = numero;
        this.precio = precio;
        this.servicios = servicios;
        this.categoria = categoria;
        estado = "Disponible";
    }
    
    public Habitacion(){
        this("", 0,"","");
    }
    
    public Habitacion(String categoria){
        this("",0,"",categoria);
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

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    /**
     * Retorna un String
     * @return String que muestra informacion vital para hacer Debugging
     */
    
    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", precio=" + precio + ", servicios=" + servicios + ", categoria=" + categoria + '}';
    }
    
    /**
     * Revisa si la habitacion se encuentra disponible entre dos fechas.
     * @param fechaInicio Fecha desde la que revisa.
     * @param fechaFinal Fecha hasta donde se revisa.
     * @return retorna true si esta disponible, y retorna false si no esta disponible.
     */
    
    public boolean disponible(LocalDate fechaInicio, LocalDate fechaFinal){
        for(Reservacion reserva : this.reservas){
            if(reserva.fechaReservada(fechaInicio) || reserva.fechaReservada(fechaFinal)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Busca la reserva que esta en una fecha
     * @param fecha Fehca en la que la reserva debe ocupar
     * @return Retorna una reserva si se encuentra en esa fecha, caso contrario retorna null.
     */
    
    public Reservacion disponible(LocalDate fecha){
        for(Reservacion reserva : this.reservas){
            if(reserva.fechaReservada(fecha) && !reserva.getEstado().equals("Reserva finalizada")){
                return reserva;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habitacion other = (Habitacion) obj;
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }
}
