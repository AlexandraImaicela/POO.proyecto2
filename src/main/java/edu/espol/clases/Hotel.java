/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Alexandra
 */
public class Hotel implements java.io.Serializable {

    private String nombre;
    private String ciudad;
    private String direccion;
    private String telefono;

    private ArrayList<Habitacion> habitaciones;

    public static ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

    public Hotel(String nombre, String ciudad, String direccion, String telefono) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Hotel() {
        this("", "", "", "");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static void cargarHoteles() {

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/edu/espol/saves/hoteles");
            ObjectInputStream ois = new ObjectInputStream(fis);

            hoteles = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

        for (Hotel hotel : hoteles) {
            System.out.println(hotel);
        }
    }

    public static void guardarHoteles() {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/edu/espol/saves/hoteles");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hoteles);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Hotel{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
