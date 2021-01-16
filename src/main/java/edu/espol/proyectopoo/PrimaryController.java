package edu.espol.proyectopoo;

import edu.espol.clases.Habitacion;
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
    
    public static PrimaryController primaryController;
    
    private ArrayList<Hotel> hoteles;
    public Hotel hotelSeleccionado;
    
    private ArrayList<Habitacion> habitaciones;
    public Habitacion habSeleccionada;

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
        loadHotels();
        primaryController = this;
    
        public void loadHabitaciones(Hotel hotel) {
        lbcantidad.setText("Habitaciones cargadas");
        lbcantidad1.setText("Habitacion seleccionada");
        addbtn.setText("Crear Habitacion");

        content.getChildren().clear();
        if (hotelSeleccionado.getHabitaciones() == null || hotelSeleccionado.getHabitaciones().size() == 0) {
            cantidad.setText("0");
            content.getChildren().add(new Label("No hay habitaciones en este hotel"));
            
        } else {
            cantidad.setText(String.valueOf(hotel.getHabitaciones().size()));
            habitaciones = hotel.getHabitaciones();
            for (Habitacion hab : hotelSeleccionado.getHabitaciones()) {
                try {
                    FXMLLoader habLoader = new FXMLLoader(getClass().getResource("habitacionBox.fxml"));
                    Parent habPanel = habLoader.load();
                    HabitacionBoxController habController = (HabitacionBoxController) habLoader.getController();
                    habController.setData(hab.getNumero(), String.valueOf(hab.getPrecio()), hab.getServicios(), hab.getCategoria(), hab.getEstado());
                    habController.setHabitacion(hab);
                    content.getChildren().add(habPanel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
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
        if (hotelSeleccionado == null) {
            FXMLLoader dialog = new FXMLLoader(getClass().getResource("crearHotel.fxml"));
            Parent hotelpanel = dialog.load();
            hotelDialog.getDialogPane().setContent(hotelpanel);
            hotelDialog.initStyle(StageStyle.TRANSPARENT);
            hotelDialog.show();
        } else if (hotelSeleccionado != null && habSeleccionada == null) {
            FXMLLoader dialog = new FXMLLoader(getClass().getResource("crearHabitacion.fxml"));
            Parent hotelpanel = dialog.load();
            hotelDialog.getDialogPane().setContent(hotelpanel);
            hotelDialog.initStyle(StageStyle.TRANSPARENT);
            hotelDialog.show();
        }
    }
}

