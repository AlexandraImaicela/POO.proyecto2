/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Habitacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @NicolasCarrascoR 
 */
public class HabitacionBoxController implements Initializable, Configurable {

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
    @FXML
    private BorderPane habBox;
    @FXML
    private Button verReservas;

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
    }

    @FXML
    private void seleccionarHabitacion(MouseEvent event) throws IOException {

        Dialog reservaDialog = new Dialog();

        PrimaryController.primaryController.habSeleccionada = this.habitacion;

        if (this.habitacion.disponible(PrimaryController.primaryController.getFechaInicio().getValue(), PrimaryController.primaryController.getFechaFinal().getValue())) {
            FXMLLoader dialog = new FXMLLoader(getClass().getResource("crearReserva.fxml"));
            Parent reservaPanel = dialog.load();
            reservaDialog.getDialogPane().setContent(reservaPanel);
            reservaDialog.initStyle(StageStyle.TRANSPARENT);
            reservaDialog.show();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso de reserva");
            alert.setContentText("La habitacion seleccionada ya fue reservada, porfavor filtre para ver las disponibles!");

            alert.showAndWait();
        }

    }

    @FXML
    private void mostrarReservas(ActionEvent event) throws IOException {
        PrimaryController.primaryController.habSeleccionada = this.habitacion;
        PrimaryController.primaryController.mostrarReservas();
    }

    @Override
    public void setData() {
        this.setData("", "", "", "", "");
    }

    public void setData(String numeroHab, String precio, String servicios, String tipo, String estado) {
        this.numeroHab.setText(numeroHab);
        this.precio.setText(precio);
        this.servicios.setText(servicios);
        this.tipo.setText(tipo);
        this.estado.setText(estado);
    }

}
