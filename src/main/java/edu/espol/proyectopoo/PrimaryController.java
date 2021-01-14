package edu.espol.proyectopoo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import edu.espol.clases.Hotel;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

public class PrimaryController implements Initializable {

    private ArrayList<Hotel> hoteles;
    public Hotel hotelSeleccionado;

    @FXML
    private BorderPane borderpane;
    @FXML
    private ScrollPane panelprincipal;
    @FXML
    private VBox content;
    @FXML
    private Label lbcantidad;
    @FXML
    private Label cantidad;
    @FXML
    private Label lbcantidad1;
    @FXML
    private Label seleccionado;
    @FXML
    private Button addbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*Hotel prueba = new Hotel("Hotel Samanes", "Guayaquil", "Samanes 7", "0993346356");
        Hotel prueba2 = new Hotel("Hotel Rios", "Guayaquil", "Centro", "0993558356");
        Hotel.hoteles.add(prueba2);
        Hotel.hoteles.add(prueba);
        Hotel.guardarHoteles();*/
        Hotel.cargarHoteles();
        hoteles = Hotel.hoteles;

        if (this.hotelSeleccionado == null) {
            loadHotels();
        } else {

        }
    }

    private void loadHotels() {
        cantidad.setText(String.valueOf(hoteles.size()));
        content.getChildren().clear();
        for (Hotel hotel : hoteles) {
            try {
                FXMLLoader hotelloader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                Parent hotelpanel = hotelloader.load();
                hotelController controller = (hotelController) hotelloader.getController();
                controller.setData(hotel.getNombre(), hotel.getCiudad(), hotel.getDireccion(), hotel.getTelefono());
                content.getChildren().add(hotelpanel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void crearHotel(ActionEvent event) throws IOException {
        Dialog hotelDialog = new Dialog();
        FXMLLoader dialog = new FXMLLoader(getClass().getResource("crearHotel.fxml"));
        Parent hotelpanel = dialog.load();
        hotelDialog.getDialogPane().setContent(hotelpanel);
        hotelDialog.initStyle(StageStyle.TRANSPARENT);
        hotelDialog.show();
        loadHotels();
    }
}

