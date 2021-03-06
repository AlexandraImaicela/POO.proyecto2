/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.clases;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Alexandra Imaicela
 */
public class Reservacion implements java.io.Serializable {


    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    private String nombre;
    private String identificacion;
    private String paisOrigen;
    
    private String Estado;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    private String formaPago;
    
    public Reservacion(Hotel hotel, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin){
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Estado = "Check-In";
    }
    
    public boolean fechaReservada(LocalDate fecha){
        if (this.Estado.equals("Reserva finalizada")){
            return true;
        }else if(fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin)){
            return true;
        } else if(fecha.isEqual(fechaInicio) || fecha.isEqual(fechaFin)){
            return true;
        }
        return false;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
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
        final Reservacion other = (Reservacion) obj;
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        return true;
    }
    /**
     * Obtiene cuantos dias hay entre 2 fechas
     * @return dias entre la fecha inicial y final de la reserva
     */
    public int getDiferenciaFechas(){
        return fechaFin.compareTo(fechaInicio);
    }

}

