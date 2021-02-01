/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import edu.espol.clases.Hotel;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author Alexandra Imaicela
 */
public class hotelController implements Initializable, Configurable {
    
    private Hotel thisHotel;

    public Hotel getThisHotel() {
        return thisHotel;
    }

    public void setThisHotel(Hotel thisHotel) {
        this.thisHotel = thisHotel;
    }
    
    @FXML
    private Label hotelnombre;
    @FXML
    private Label ciudad;
    @FXML
    private Label direccion;
    @FXML
    private Label telefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void seleccionarHotel(MouseEvent event) throws IOException{
        PrimaryController.primaryController.hotelSeleccionado = thisHotel;
        System.out.println(thisHotel);
        PrimaryController.primaryController.loadHabitaciones(thisHotel);
    }
    
    @Override
    public void setData() {
        this.setData("","","",""); 
    }
    
    public void setData(String hotelnombre, String ciudad, String direccion, String telefono) {
        this.hotelnombre.setText(hotelnombre);
        this.ciudad.setText(ciudad);
        this.direccion.setText(direccion);
        this.telefono.setText(telefono);
    } 
}
