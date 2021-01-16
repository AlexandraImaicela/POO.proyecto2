/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Habitacion;
import edu.espol.clases.Hotel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 
 */
public class CrearHabitacionController implements Initializable {

    @FXML
    private Button crearbtn;
    @FXML
    private Button restartbtn;
    @FXML
    private Button salirbtn;
    @FXML
    private TextField numeroHab;
    @FXML
    private TextField precioHab;
    @FXML
    private TextArea serviciosHab;
    @FXML
    private ComboBox<String> categoriaHab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categoriaHab.getItems().add("Matrimonial");
        categoriaHab.getItems().add("Suite");
        categoriaHab.getItems().add("Doble");
        categoriaHab.getItems().add("Triple");
    }

    @FXML
    private void crearhotel(ActionEvent event) {
        Habitacion newHab = new Habitacion(numeroHab.getText(), Float.valueOf(precioHab.getText()), serviciosHab.getText(), categoriaHab.getSelectionModel().getSelectedItem());
        
        PrimaryController.primaryController.hotelSeleccionado.getHabitaciones().add(newHab);
        Hotel.guardarHoteles();
        numeroHab.setText("");
        precioHab.setText("");
        serviciosHab.setText("");
        categoriaHab.getSelectionModel().clearSelection();
    }

    @FXML
    private void reiniciarbtn(ActionEvent event) {
        numeroHab.setText("");
        precioHab.setText("");
        serviciosHab.setText("");
        categoriaHab.getSelectionModel().clearSelection();
    }

    @FXML
    private void salir(ActionEvent event) {

        Stage window = (Stage) salirbtn.getScene().getWindow();
        PrimaryController.primaryController.loadHabitaciones(PrimaryController.primaryController.hotelSeleccionado);
        window.close();
    }

}
