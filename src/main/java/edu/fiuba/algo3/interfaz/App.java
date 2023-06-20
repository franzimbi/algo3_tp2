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
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/musica/inicioKahoot.mp3").toURI().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        //MediaView mediaView = new MediaView(mediaPlayer);
        // Reproducir la música
        mediaPlayer.play();

        Label label = new Label("Ingrese su nombre: ");

        TextField texto = new TextField();

        Button botonInit = new Button("JUGAR!");
        botonInit.setStyle("-fx-background-color: #000080; -fx-text-fill: #FFFFFF; -fx-font-size: 14px;");
        botonInit.setOnAction(event -> {
            // Crear la animación de escala
            ScaleTransition transition = new ScaleTransition(Duration.seconds(0.2), botonInit);
            transition.setToX(0.8); // Reducir la escala horizontalmente
            transition.setToY(0.8); // Reducir la escala verticalmente
            transition.setAutoReverse(true);
            transition.setCycleCount(2);
            transition.play();
        });
        botonInit.setOnMouseClicked(event -> {
            // Aplicar el efecto al hacer clic
            botonInit.setStyle("-fx-background-color: #FF0000; -fx-text-fill: #FFFFFF;");
        });
        DropShadow shadow = new DropShadow();
        ScaleTransition scaleTransition = new ScaleTransition();
        botonInit.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED,
                e -> botonInit.setEffect(shadow));
        botonInit.addEventHandler(MouseEvent.MOUSE_EXITED, e -> botonInit.setEffect(null));

        Main iniciarEvent = new Main(stage,texto,mediaPlayer);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(25, 25);

        TextoEventHandler textoEvent = new TextoEventHandler(botonInit);
        texto.setOnKeyPressed(textoEvent);



        HBox datosIniciales = new HBox(label, texto);
        datosIniciales.setSpacing(5);

        VBox botones = new VBox(datosIniciales, botonInit);
        botones.setMargin(botonInit,new Insets(30,0,0,100));
        botones.setPadding(new Insets(30,10,10,10));

        var menu = new Scene(botones, 300, 150);

        stage.setScene(menu);
        stage.show();
    }

}