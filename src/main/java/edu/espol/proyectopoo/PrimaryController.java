package edu.espol.proyectopoo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import edu.espol.clases.Hotel;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {

    private ArrayList<Hotel> hoteles;
    @FXML
    private BorderPane borderpane;
    @FXML
    private ScrollPane panelprincipal;
    @FXML
    private VBox content;
    @FXML
    private Label a;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*Hotel prueba = new Hotel("Hotel Samanes", "Guayaquil", "Samanes 7", "0993346356");
        Hotel prueba2 = new Hotel("Hotel Rios", "Guayaquil", "Centro", "0993558356");
        Hotel.hoteles.add(prueba2);
        Hotel.hoteles.add(prueba);
        Hotel.guardarHoteles();*/
        Hotel.cargarHoteles();
        hoteles = Hotel.hoteles;
        a.setText(String.valueOf(hoteles.size()));

        for (Hotel hotel : hoteles) {
            try {
                FXMLLoader hotelloader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                Parent hotelpanel = hotelloader.load();
                hotelController controller = (hotelController) hotelloader.getController();
                controller.setData(hotel.getNombre(), hotel.getCiudad(), hotel.getDireccion(), hotel.getTelefono());
                System.out.println(controller);
                content.getChildren().add(hotelpanel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
