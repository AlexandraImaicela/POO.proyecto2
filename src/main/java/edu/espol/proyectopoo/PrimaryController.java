package edu.espol.proyectopoo;

import edu.espol.clases.Habitacion;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import edu.espol.clases.Hotel;
import edu.espol.clases.Reservacion;
import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.control.DateCell;

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
    private Button addbtn;
    @FXML
    private Label lbhotelSelec;
    @FXML
    private Label hotelSelec;

    /**
     *
     * @return
     */
    
    public static DatePicker getInicioFecha() {
        return inicioFecha;
    }
    
    /**
     *
     * @param inicioFecha
     */

    public static void setInicioFecha(DatePicker inicioFecha) {
        PrimaryController.inicioFecha = inicioFecha;
    }

     /**
     *
     * @return
     */
    
    public static DatePicker getFinalFecha() {
        return finalFecha;
    }
    
    /**
     *
     * @param finalFecha
     */

    public static void setFinalFecha(DatePicker finalFecha) {
        PrimaryController.finalFecha = finalFecha;
    }
    private Label habSelec;
    @FXML
    private Button inicio;
    private VBox habSelecBox;
    @FXML
    private VBox filtroBox;
    private static DatePicker inicioFecha = new DatePicker();
    private static DatePicker finalFecha = new DatePicker();
    @FXML
    private Button filtrarbtn;
    @FXML
    private DatePicker fechaInicio;
    @FXML
    private DatePicker fechaFinal;
    @FXML
    private ComboBox<String> categoriasHab;
    @FXML
    private Button mostrar;

    /**
     * Inicializa los elementos dentro de las categorias en el filtro, y carga los hoteles.
     * @param url
     * @param rb
     */
    
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

        categoriasHab.getItems().add("Todos");
        categoriasHab.getItems().add("Matrimonial");
        categoriasHab.getItems().add("Suite");
        categoriasHab.getItems().add("Doble");
        categoriasHab.getItems().add("Triple");

    }
    
    /**
     *Esta clase cargas las habitaciones de un hotel respectivo.
     * @param hotel Hotel que es generalmente el hotel seleccionado.
     */

    public void loadHabitaciones(Hotel hotel) {
        lbcantidad.setText("Habitaciones cargadas");
        addbtn.setText("Crear Habitacion");

        hotelSelec.setText(hotel.getNombre());
        filtroBox.setVisible(true);

        setDate();

        content.getChildren().clear();
        if (hotelSeleccionado.getHabitaciones() == null || hotelSeleccionado.getHabitaciones().size() == 0) {
            cantidad.setText("0");
            content.getChildren().add(new Label("No hay habitaciones disponibles"));

        } else {
            cantidad.setText(String.valueOf(hotel.getHabitaciones().size()));
            habitaciones = hotel.getHabitaciones();
            for (Habitacion hab : hotelSeleccionado.getHabitaciones()) {
                
                Reservacion reserva = hab.disponible(LocalDate.now());
                String currentState = "";
                System.out.println(reserva);
                if (reserva == null){
                    currentState = "Disponible";
                }else if(reserva.getEstado().equals("Check-In")){
                    currentState = "Reservada";
                }else if(reserva.getEstado().equals("Check-Out")){
                    currentState = "Ocupada";
                }
                hab.setEstado(currentState);
                try {
                    FXMLLoader habLoader = new FXMLLoader(getClass().getResource("habitacionBox.fxml"));
                    Parent habPanel = habLoader.load();
                    HabitacionBoxController habController = (HabitacionBoxController) habLoader.getController();
                    habController.setData(hab.getNumero(), String.valueOf(hab.getPrecio()), hab.getServicios(), hab.getCategoria(), currentState);
                    habController.setHabitacion(hab);
                    content.getChildren().add(habPanel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Carga las habitaciones que se encuentren en el ArrayList Habitaciones dentro del Hotel Seleccionado.
     */
    public void loadHabitaciones() {
        content.getChildren().clear();
        if (hotelSeleccionado.getHabitaciones() == null || hotelSeleccionado.getHabitaciones().size() == 0) {
            cantidad.setText("0");
            content.getChildren().add(new Label("No hay habitaciones disponibles"));

        } else {

            cantidad.setText(String.valueOf(habitaciones.size()));
            for (Habitacion hab : this.habitaciones) {
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
    /**
     * Configura los DatePicker y deshabilita las fechas del usurario que se encuentren antes a la fecha del computador del usuario.
     */
    private void setDate() {
        fechaInicio.setValue(LocalDate.now());

        final Callback<DatePicker, DateCell> celdaFecha = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(fechaInicio.getValue().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #EEEEEE;");
                        }
                    }
                };
            }
        };
        fechaInicio.setDayCellFactory(celdaFecha);
        fechaFinal.setDayCellFactory(celdaFecha);
        fechaFinal.setValue(fechaInicio.getValue().plusDays(1));
        System.out.println(fechaInicio.getValue().toString());
        System.out.println(fechaFinal.getValue().toString());
    }

    public void loadHotels() {
        lbcantidad.setText("Hoteles cargados");
        cantidad.setText(String.valueOf(hoteles.size()));
        addbtn.setText("Crear Hotel");
        content.getChildren().clear();

        hotelSelec.setText("Ninguno");
        filtroBox.setVisible(false);

        for (Hotel hotel : hoteles) {
            try {
                FXMLLoader hotelloader = new FXMLLoader(getClass().getResource("hotelbox.fxml"));
                Parent hotelpanel = hotelloader.load();
                hotelController controller = (hotelController) hotelloader.getController();
                controller.setData(hotel.getNombre(), hotel.getCiudad(), hotel.getDireccion(), hotel.getTelefono());
                controller.setThisHotel(hotel);
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

    @FXML
    private void inicio(ActionEvent event) {
        loadHotels();
    }

    @FXML
    private void filtrar(ActionEvent event) {
        ArrayList<Habitacion> filtrado = new ArrayList<>();
        boolean aceptarTodos = false;
        if (categoriasHab.getValue().isEmpty() || categoriasHab.getValue().equals("Todos")) {
            aceptarTodos = true;
        }
        Habitacion filtro = new Habitacion(categoriasHab.getValue());
        content.getChildren().clear();
        for (Habitacion hab : this.hotelSeleccionado.getHabitaciones()) {
            if ((aceptarTodos || hab.equals(filtro)) && hab.disponible(fechaInicio.getValue(), fechaFinal.getValue())) {
                filtrado.add(hab);
            }
        }
        this.habitaciones = filtrado;
        loadHabitaciones();

    }

    public String getFechaEntrada() {
        return fechaInicio.toString();
    }

    public String getFechaSalida() {
        return fechaFinal.toString();
    }

    public DatePicker getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(DatePicker fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public DatePicker getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(DatePicker fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @FXML
    private void mostrarTodos(ActionEvent event) {
        loadHabitaciones(this.hotelSeleccionado);
    }
    
    /**
     *  Muestra las reservas dentro del panel, de la habitacion seleccionada.
     */
    public void mostrarReservas() {
        filtroBox.setVisible(false);
        content.getChildren().clear();

        for (Reservacion reserva : this.habSeleccionada.getReservas()) {
            try {
                FXMLLoader reservaLoader = new FXMLLoader(getClass().getResource("reservasBox.fxml"));
                Parent reservaPanel = reservaLoader.load();
                reservasBoxController controller = (reservasBoxController) reservaLoader.getController();
                controller.setData(reserva.getNombre(), reserva.getFechaInicio().toString(), reserva.getFechaFin().toString());
                controller.setThisReserva(reserva);
                controller.getCheckbtn().setText(reserva.getEstado());
                if (reserva.getEstado().equals("Reserva finalizada")){
                    controller.getCheckbtn().setDisable(true);
                }
                content.getChildren().add(reservaPanel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}