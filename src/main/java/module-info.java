module edu.espol.proyectopoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens edu.espol.proyectopoo to javafx.fxml;
    exports edu.espol.proyectopoo;
}
