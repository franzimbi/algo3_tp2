package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.logger.Logger;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        Logger.getInstancia().activar();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/resources/musica/inicioKahoot.mp3").toURI().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        //MediaView mediaView = new MediaView(mediaPlayer);
        // Reproducir la música
        mediaPlayer.play();

        Label label = new Label("Ingrese su nombre: ");
        label.setStyle("-fx-font-size: 10px; -fx-background-color: #ffffff; -fx-text-fill: #000080;");

        TextField texto = new TextField();
        texto.setStyle("-fx-font-size: 14px; -fx-background-color: #ffffff; -fx-text-fill: #000080;");


        Button botonInit = new Button("JUGAR!");
        botonInit.setStyle("-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px;");
        DropShadow shadow = new DropShadow();
        botonInit.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> botonInit.setEffect(shadow));
        botonInit.addEventHandler(MouseEvent.MOUSE_EXITED, e -> botonInit.setEffect(null));

        Main iniciarEvent = new Main(stage,texto,mediaPlayer);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(80, 70);

        TextoEventHandler textoEvent = new TextoEventHandler(botonInit);
        texto.setOnKeyPressed(textoEvent);

        HBox datosIniciales = new HBox(label, texto);
        datosIniciales.setSpacing(5);

        VBox botones = new VBox(datosIniciales, botonInit);
        botones.setMargin(botonInit,new Insets(30,0,0,100));
        botones.setPadding(new Insets(30,10,10,10));

        var menu = new Scene(botones, 300, 150);

        stage.setScene(menu);
        //stage.setMaximized(true);
        stage.show();
    }

}