/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectopoo;

import edu.espol.clases.Reservacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author 
 */
public class reservasPanel implements Initializable {

    @FXML
    private VBox content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void loadReservas() throws IOException {
        content.getChildren().clear();
        for (Reservacion reserva : PrimaryController.primaryController.habSeleccionada.getReservas()) {
            FXMLLoader reservasLoader = new FXMLLoader(getClass().getResource("reservasBox.fxml"));
            Parent reservasPanel = reservasLoader.load();
            reservasBoxController controller = (reservasBoxController) reservasLoader.getController();
            controller.setData(reserva.getNombre(), reserva.getFechaInicio().toString(), reserva.getFechaFin().toString());
            content.getChildren().add(reservasPanel);
        }
    }
}

