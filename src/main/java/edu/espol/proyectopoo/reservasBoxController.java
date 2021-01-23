/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author 
 */
public class reservasBoxController implements Initializable {


    @FXML
    private Button checkbtn;
    @FXML
    private Label fechaFinal;
    @FXML
    private Label fechaInicio;
    @FXML
    private Label nombre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void check(ActionEvent event) {
    }

    @FXML
    private void seleccionarHotel(MouseEvent event) {
    }
    
    public void setData(String nombre, String fecha0, String fecha1){
        this.nombre.setText(nombre);
        this.fechaInicio.setText(fecha0);
        this.fechaFinal.setText(fecha1);
    }

}
