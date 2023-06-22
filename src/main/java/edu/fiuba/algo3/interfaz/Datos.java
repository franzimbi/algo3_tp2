package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.juego.Juego;
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
    public VBox generarDatos(Juego juego, TextField nombre, Button pasarTurno, MediaPlayer media) {
        Font font = new Font("Minecraftia", 22);
        String infoStyle = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;";


        if (juego.perdio()) {
            Stage casoPerdio = new Stage();

            Rectangle disney = new Rectangle(50, 50);
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream("src/main/java/edu/fiuba/algo3/resources/imagenes/disney.jpg");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Image img = new Image(inputStream, 50, 50, false, true);
            disney.setFill(new ImagePattern(img));
            disney.setStroke(Color.BLACK);

            var label = new Label("Perdiste");

            StackPane ventana = new StackPane(disney);
            HBox caja = new HBox(ventana);
            label.setPadding(new Insets(0, 0, 0, 150));
            Scene scene = new Scene(caja);

            casoPerdio.setScene(scene);
            casoPerdio.showAndWait();
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

        Button botonMusica = new Button("MUTE");
        botonMusica.setStyle("-fx-background-color: green; -fx-text-fill: black;");
        botonMusica.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (media.getStatus() == MediaPlayer.Status.PLAYING) {
                media.stop();
                botonMusica.setText("UNMUTE");
                botonMusica.setStyle("-fx-background-color: #ff8000; -fx-text-fill: #131313;");
            } else {
                media.play();
                botonMusica.setText("MUTE");
                botonMusica.setStyle("-fx-background-color: green; -fx-text-fill: black;");
            }
        });

        VBox informacion = new VBox(botonMusica, labelNombre, vida, creditos, cantEnemigos, cantTurnos, pasarTurno);
        VBox.setMargin(labelNombre, new Insets(30, 0, 0, 50));
        VBox.setMargin(vida, new Insets(50, 0, 0, 50));
        VBox.setMargin(creditos, new Insets(50, 0, 0, 50));
        VBox.setMargin(cantEnemigos, new Insets(50, 0, 0, 50));
        VBox.setMargin(cantTurnos, new Insets(50, 0, 0, 50));
        VBox.setMargin(pasarTurno, new Insets(50, 0, 0, 50));
        VBox.setMargin(botonMusica, new Insets(20, 0, 0, 50));
        return informacion;
    }


}
