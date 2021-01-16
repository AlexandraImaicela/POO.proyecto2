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
 * @author Alexandra Imaicela
 */
public class hotelController implements Initializable {

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

    public void setData(String hotelnombre, String ciudad, String direccion, String telefono) {
        this.hotelnombre.setText(hotelnombre);
        this.ciudad.setText(ciudad);
        this.direccion.setText(direccion);
        this.telefono.setText(telefono);
    }

    @FXML
    private void seleccionarHotel(MouseEvent event) {
        
    }
}
