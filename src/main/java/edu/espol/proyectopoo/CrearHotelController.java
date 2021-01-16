/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Hotel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Alexandra Imaicela
 */
public class CrearHotelController implements Initializable {

    @FXML
    private Button crearbtn;
    @FXML
    private Button restartbtn;
    @FXML
    private Button salirbtn;
    @FXML
    private TextField nombreHotel;
    @FXML
    private TextField ciudadHotel;
    @FXML
    private TextField telefonoHotel;
    @FXML
    private TextArea direccionHotel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void crearhotel(ActionEvent event) {
        Hotel newHotel = new Hotel(nombreHotel.getText(), ciudadHotel.getText(), direccionHotel.getText(), telefonoHotel.getText());
        Hotel.hoteles.add(newHotel);
        Hotel.guardarHoteles();
        nombreHotel.setText("");
        ciudadHotel.setText("");
        telefonoHotel.setText("");
        direccionHotel.setText("");
    }

    @FXML
    private void reiniciarbtn(ActionEvent event) {
        nombreHotel.setText("");
        ciudadHotel.setText("");
        telefonoHotel.setText("");
        direccionHotel.setText("");
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage window = (Stage) salirbtn.getScene().getWindow();
        PrimaryController.primaryController.loadHabitaciones(PrimaryController.primaryController.hotelSeleccionado);
        window.close();
    }

}
