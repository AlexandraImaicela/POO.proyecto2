/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.saves;

import edu.espol.clases.Reservacion;
import edu.espol.proyectopoo.PrimaryController;
import edu.espol.proyectopoo.reservasBoxController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.layout.VBox;

/**
 * 
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
    }

    private void loadReservas() throws IOException {
        for (Reservacion reserva : PrimaryController.primaryController.habSeleccionada.getReservas()) {
            FXMLLoader reservasLoader = new FXMLLoader(getClass().getResource("hotelbox.fxml"));
            Parent reservasPanel = reservasLoader.load();
            reservasBoxController controller = (reservasBoxController) reservasLoader.getController();

        }
    }

}
