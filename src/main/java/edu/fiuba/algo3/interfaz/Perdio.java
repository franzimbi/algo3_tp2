package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class Perdio implements EventHandler<ActionEvent> {
    private final Stage primaryStage;
    private final TextField nombre;
    private final Button botonInformacion;

    public Perdio(Stage stage, TextField nombre, Button botonInformacion) {
        this.nombre = nombre;
        primaryStage = stage;
        this.botonInformacion = botonInformacion;
    }

    public void handle(ActionEvent actionEvent) {
        Image icon = new Image(String.valueOf(new File("src/main/java/edu/fiuba/algo3/resources/imagenes/windowIcon.png").toURI().toString()));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Tower Defense");
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 20px";
        String musicStyle = "-fx-background-color: #333333; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        DropShadow shadow = new DropShadow();

        // Cargar Video
        MediaPlayer mediaPlayer = Input.getInstance().mediaPlayer("perdioVideo");
        mediaPlayer.setAutoPlay(true);

        Button botonMusica = new Button();
        ImageView musicaOff = Input.getInstance().media("musicOff");
        ImageView musicaOn = Input.getInstance().media("musicOn");
        musicaOn.setFitHeight(20);
        musicaOn.setPreserveRatio(true);
        botonMusica.setGraphic(musicaOn);
        MediaPlayer musicaLogin =  Input.getInstance().mediaPlayer("loginMusic");
        botonMusica.setOnAction(new BotonMusicaEventHandler(musicaLogin, botonMusica, musicaOn, musicaOff));
        botonMusica.setStyle(musicStyle);

        //titulo perdiste!
        Label titulo = new Label(nombre.getText() + " PERDISTE!");
        titulo.setStyle("-fx-font-size: 30px; -fx-text-fill: #ffffff");
        titulo.setEffect(shadow);

        // Boton Reiniciar
        Button reiniciarBoton = new Button("Reiniciar");
        reiniciarBoton.setStyle(loginStyle);
        reiniciarBoton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> reiniciarBoton.setEffect(shadow));
        reiniciarBoton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> reiniciarBoton.setEffect(null));
        reiniciarBoton.setOnAction(event -> {
            mediaPlayer.stop();
            Main iniciarEvent = new Main(primaryStage,nombre, botonMusica, botonInformacion, musicaLogin);
            iniciarEvent.handle(event);
        });

        // exit
        Button exit = new Button("EXIT");
        exit.setStyle(loginStyle);
        exit.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> exit.setEffect(shadow));
        exit.addEventHandler(MouseEvent.MOUSE_EXITED, e -> exit.setEffect(null));
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.exit(0));

        double buttonWidth = 325;
        double buttonHeight = 50;
        reiniciarBoton.setPrefSize(buttonWidth, buttonHeight);
        exit.setPrefSize(buttonWidth, buttonHeight);
        titulo.setPrefSize(buttonWidth, buttonHeight);

        // Crear el diseño del formulario
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); // Centrar el GridPane en medio de la pantalla
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        // Agregar los controles al diseño
        gridPane.add(titulo, 0, 1);
        gridPane.add(reiniciarBoton, 0, 2);
        gridPane.add(exit, 0, 3);

        MediaView mediaView = new MediaView(mediaPlayer);
        StackPane stackPane = new StackPane(mediaView, gridPane); // Apilar el video y el formulario

        // Crear la escena y mostrarla en el escenario
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}

