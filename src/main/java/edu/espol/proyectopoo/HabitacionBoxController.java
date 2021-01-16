/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Habitacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @NicolasCarrascoR
 */
public class HabitacionBoxController implements Initializable {


    @FXML
    private Label estado;
    @FXML
    private Label numeroHab;
    @FXML
    private Label precio;
    @FXML
    private Label servicios;
    @FXML
    private Label tipo;
    public Habitacion habitacion;

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void seleccionarHotel(MouseEvent event) {
    }
    
    public void setData(String numeroHab, String precio, String servicios, String tipo, String estado) {
        this.numeroHab.setText(numeroHab);
        this.precio.setText(precio);
        this.servicios.setText(servicios);
        this.tipo.setText(tipo);
        this.estado.setText(estado);
    }

}
