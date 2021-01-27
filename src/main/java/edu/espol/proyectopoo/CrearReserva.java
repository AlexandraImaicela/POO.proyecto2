/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Hotel;
import edu.espol.clases.Reservacion;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @NicolasCarrascoR 
 */
public class CrearReserva implements Initializable {

    @FXML
    private Button crearbtn;
    @FXML
    private Button restartbtn;
    @FXML
    private Button salirbtn;
    @FXML
    private TextField hotelSelec;
    @FXML
    private TextField numHab;
    @FXML
    private TextField catHab;
    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField identificacionCliente;
    @FXML
    private TextField origenCliente;
    @FXML
    private TextField pagoCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        hotelSelec.setDisable(true);
        numHab.setDisable(true);
        catHab.setDisable(true);
        
        hotelSelec.setText(PrimaryController.primaryController.hotelSeleccionado.getNombre());
        numHab.setText(PrimaryController.primaryController.habSeleccionada.getNumero());
        catHab.setText(PrimaryController.primaryController.habSeleccionada.getCategoria());
    }

    @FXML
    private void reiniciarbtn(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage window = (Stage) salirbtn.getScene().getWindow();
        PrimaryController.primaryController.loadHotels();
        window.close();
    }

    @FXML
    private void reservar(ActionEvent event) {

        Reservacion reserva = new Reservacion(PrimaryController.primaryController.hotelSeleccionado, PrimaryController.primaryController.habSeleccionada,PrimaryController.getInicioFecha().getValue(), PrimaryController.getFinalFecha().getValue());
        
        reserva.setNombre(nombreCliente.getText());
        reserva.setIdentificacion(identificacionCliente.getText());
        reserva.setPaisOrigen(origenCliente.getText());
        reserva.setFormaPago(pagoCliente.getText());
                
        PrimaryController.primaryController.habSeleccionada.getReservas().add(reserva);       
    }

}
