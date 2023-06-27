package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Datos {
    private  Font font = new Font("Minecraftia", 22);
    private String infoStyle = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;";

    public VBox generarDatos(Juego juego, TextField nombre, Button pasarTurno) {


        //informacion del menu
        Label labelNombre = generarLabel("Jugador: " , nombre.getText());

        TextField vida = generarTextField("Vida: " , juego.vidaJugador());

        TextField creditos = generarTextField("Creditos: " , juego.creditosJugador());

        TextField cantEnemigos = generarTextField("Enemigos: " , juego.cantidadEnemigos());

        TextField cantTurnos = generarTextField("Turnos: " , juego.cantidadDeTurnos());



        VBox informacion = new VBox( labelNombre, vida, creditos, cantEnemigos, cantTurnos, pasarTurno);
        VBox.setMargin(labelNombre, new Insets(30, 0, 0, 50));
        VBox.setMargin(vida, new Insets(50, 0, 0, 50));
        VBox.setMargin(creditos, new Insets(50, 0, 0, 50));
        VBox.setMargin(cantEnemigos, new Insets(50, 0, 0, 50));
        VBox.setMargin(cantTurnos, new Insets(50, 0, 0, 50));
        VBox.setMargin(pasarTurno, new Insets(50, 0, 0, 50));

        return informacion;
    }

    public TextField generarTextField(String nombreCampo, int valor) {
        TextField texto = new TextField(nombreCampo + valor);
        texto.setStyle(infoStyle);
        texto.setFont(font);
        texto.setFocusTraversable(false);
        texto.setEditable(false);

        return texto;
    }

    private Label generarLabel(String nombre, String texto) {
        Label label = new Label(nombre + texto);
        label.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 40px;");
        label.setFont(font);
        return label;
    }

}
