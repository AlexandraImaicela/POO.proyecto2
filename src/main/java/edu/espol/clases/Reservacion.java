/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.clases;

import java.time.LocalDate;

/**
 *
 * @author Alexandra Imaicela
 */
public class Reservacion {
     private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String nombre;
    private String identificacion;
    private String paisOrigen;
    private String formaPago;
    
    public LocalDate getFechaInicio(){
        return fechaInicio;
    }
    
    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio=fechaInicio;
    }
    
    public LocalDate getFechaFin(){
        return fechaFin;
    }
    
    public void setFechaFin(LocalDate fechaFin){
        this.fechaFin=fechaFin;
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

    public Reservacion(Hotel hotel,Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin){
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;        
    }
    
    public boolean fechaReservada(LocalDate fecha){
        if(fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin)){
            return true;
        } else if(fecha.isEqual(fechaInicio) || fecha.isEqual(fechaFin)){
            return true;
        }
        return false;
    }
    
    public int getDiferenciaFechas(){
        return fechaFin.compareTo(fechaInicio);
    }

    
    } 

