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
/**
 * FXML Controller class
 *
 * @NicolasCarrascoR
 */
public class HabitacionBoxController implements Initializable {


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
    private void seleccionarHotel(MouseEvent event) {
    }

}
