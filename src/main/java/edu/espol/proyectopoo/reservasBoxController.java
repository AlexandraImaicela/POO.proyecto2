/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Hotel;
import edu.espol.clases.Reservacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 
 */
public class reservasBoxController implements Initializable, Configurable {

    public Reservacion thisReserva;

    public Reservacion getThisReserva() {
        return thisReserva;
    }

    public void setThisReserva(Reservacion thisReserva) {
        this.thisReserva = thisReserva;
    }

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
        checkbtn.setText(this.thisReserva.getEstado());

        if (this.thisReserva.getEstado().equals("Check-In")) {
            this.thisReserva.setEstado("Check-Out");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso de reserva");
            alert.setContentText("Ingreso del huesped registrada con exito!");

            alert.showAndWait();
        } else if (this.thisReserva.getEstado().equals("Check-Out")) {

            this.thisReserva.setEstado("Reserva finalizada");
            checkbtn.setDisable(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso de reserva");
            alert.setContentText("Salida del huesped registrada con exito!");

            alert.showAndWait();
        }

        reloadButton();
        Hotel.guardarHoteles();

    }
    
    public Button getCheckbtn() {
        return checkbtn;
    }

    public void setCheckbtn(Button checkbtn) {
        this.checkbtn = checkbtn;
    }
    
    @FXML
    private void seleccionarHotel(MouseEvent event) {
    }
    @Override
    public void setData() {
        this.setData("", "", ""); //To change body of generated methods, choose Tools | Templates.
    }

    public void setData(String nombre, String fecha0, String fecha1) {
        this.nombre.setText(nombre);
        this.fechaInicio.setText(fecha0);
        this.fechaFinal.setText(fecha1);
    }

    public void reloadButton() {
        checkbtn.setText(this.thisReserva.getEstado());

    }

}