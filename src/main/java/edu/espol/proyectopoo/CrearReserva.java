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
import javafx.scene.control.Alert;

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

    private Reservacion reserva;

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
    @FXML
    private TextField fechaEntrada;
    @FXML
    private TextField fechaSalida;
    @FXML
    private TextField totalPagar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        hotelSelec.setDisable(true);
        numHab.setDisable(true);
        catHab.setDisable(true);

        fechaEntrada.setDisable(true);
        fechaSalida.setDisable(true);
        totalPagar.setDisable(true);

        hotelSelec.setText(PrimaryController.primaryController.hotelSeleccionado.getNombre());
        numHab.setText(PrimaryController.primaryController.habSeleccionada.getNumero());
        catHab.setText(PrimaryController.primaryController.habSeleccionada.getCategoria());

        fechaEntrada.setText(PrimaryController.primaryController.getFechaEntrada());
        fechaSalida.setText(PrimaryController.primaryController.getFechaSalida());

        reserva = new Reservacion(PrimaryController.primaryController.hotelSeleccionado, PrimaryController.primaryController.habSeleccionada, PrimaryController.getInicioFecha().getValue(), PrimaryController.getFinalFecha().getValue());

        reserva.setFechaInicio(PrimaryController.primaryController.getFechaInicio().getValue());
        reserva.setFechaFin(PrimaryController.primaryController.getFechaFinal().getValue());

        fechaEntrada.setText(reserva.getFechaInicio().toString());
        fechaSalida.setText(reserva.getFechaFin().toString());

        System.out.println(reserva.getDiferenciaFechas());

        float total = PrimaryController.primaryController.habSeleccionada.getPrecio() * reserva.getDiferenciaFechas();
        totalPagar.setText(String.valueOf(total));
        System.out.println(total);

    }
    
    /*
    * Elimina los datos para poder reingresarlos.
    */
    @FXML
    private void reiniciarbtn(ActionEvent event) {
        nombreCliente.setText("");
        identificacionCliente.setText("");
        origenCliente.setText("");
        pagoCliente.setText("");
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage window = (Stage) salirbtn.getScene().getWindow();
        PrimaryController.primaryController.loadHotels();
        window.close();
    }
    
    /*
    * Crea reserva.
    */

    @FXML
    private void reservar(ActionEvent event) {

        reserva.setNombre(nombreCliente.getText());
        reserva.setIdentificacion(identificacionCliente.getText());
        reserva.setPaisOrigen(origenCliente.getText());
        reserva.setFormaPago(pagoCliente.getText());

        PrimaryController.primaryController.habSeleccionada.getReservas().add(reserva);

        Hotel.guardarHoteles();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso de reserva");
        alert.setContentText("Habitacion reservada!");

        alert.showAndWait();

        Stage window = (Stage) salirbtn.getScene().getWindow();
        PrimaryController.primaryController.loadHotels();
        window.close();
    }

}

