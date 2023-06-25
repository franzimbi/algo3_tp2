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
    public VBox generarDatos(Juego juego, TextField nombre, Button pasarTurno, Stage stage) {
        Font font = new Font("Minecraftia", 22);
        String infoStyle = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;";


        if (juego.perdio()) {
            stage.close();
            Perdio perdio = new Perdio(nombre.getText());
            perdio.handle(new ActionEvent());
        }

        //informacion del menu
        Label labelNombre = new Label("Jugador: " + nombre.getText());
        labelNombre.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 40px;");
        labelNombre.setFont(font);
        TextField vida = new TextField("Vida: " + juego.vidaJugador());
        vida.setStyle(infoStyle);
        vida.setFont(font);
        vida.setFocusTraversable(false);
        vida.setEditable(false);
        TextField creditos = new TextField("Creditos: " + juego.creditosJugador());
        creditos.setStyle(infoStyle);
        creditos.setFont(font);
        creditos.setFocusTraversable(false);
        creditos.setEditable(false);
        TextField cantEnemigos = new TextField("Enemigos: " + juego.cantidadEnemigos());
        cantEnemigos.setStyle(infoStyle);
        cantEnemigos.setFont(font);
        cantEnemigos.setFocusTraversable(false);
        cantEnemigos.setEditable(false);
        TextField cantTurnos = new TextField("Turnos: " + juego.cantidadDeTurnos());
        cantTurnos.setStyle(infoStyle);
        cantTurnos.setFont(font);
        cantTurnos.setFocusTraversable(false);
        cantTurnos.setEditable(false);

        VBox informacion = new VBox( labelNombre, vida, creditos, cantEnemigos, cantTurnos, pasarTurno);
        VBox.setMargin(labelNombre, new Insets(30, 0, 0, 50));
        VBox.setMargin(vida, new Insets(50, 0, 0, 50));
        VBox.setMargin(creditos, new Insets(50, 0, 0, 50));
        VBox.setMargin(cantEnemigos, new Insets(50, 0, 0, 50));
        VBox.setMargin(cantTurnos, new Insets(50, 0, 0, 50));
        VBox.setMargin(pasarTurno, new Insets(50, 0, 0, 50));

        return informacion;
    }

}
