package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class FinJuego implements EventHandler<ActionEvent> {
    private final Stage primaryStage;
    private final TextField nombre;
    private final Button botonInformacion;
    private final String estado;
    private final String texto;

    public FinJuego(Stage stage, TextField nombre, Button botonInformacion, String estado, String textoFinal) {
        this.nombre = nombre;
        primaryStage = stage;
        this.botonInformacion = botonInformacion;
        this.estado = estado;
        this.texto = textoFinal;
    }

    public void handle(ActionEvent actionEvent) {
        Image icon = new Image(String.valueOf(new File("src/main/java/edu/fiuba/algo3/resources/imagenes/windowIcon.png").toURI().toString()));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Tower Defense");
        String loginStyle = "-fx-background-color: rgba(0,0,128,0.76); -fx-text-fill: #ffffff; -fx-font-size: 20px";
        String musicStyle = "-fx-background-color: #333333; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        DropShadow shadow = new DropShadow();

        // Cargar Video
        MediaPlayer mediaPlayer = Input.getInstance().mediaPlayer(estado);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);

        Button botonMusica = new Button();
        ImageView musicaOff = Input.getInstance().media("musicOff");
        ImageView musicaOn = Input.getInstance().media("musicOn");
        musicaOn.setFitHeight(20);
        musicaOn.setPreserveRatio(true);
        botonMusica.setGraphic(musicaOn);
        MediaPlayer musicaLogin = Input.getInstance().mediaPlayer("loginMusic");
        botonMusica.setOnAction(new BotonMusicaEventHandler(musicaLogin, botonMusica, musicaOn, musicaOff));
        botonMusica.setStyle(musicStyle);

        //titulo perdiste!
        Label titulo = new Label(nombre.getText() + texto);
        titulo.setStyle("-fx-font-size: 30px; -fx-text-fill: #ffffff");
        titulo.setEffect(shadow);

        // Boton Reiniciar
        Button reiniciarBoton = new Button("Reiniciar");
        reiniciarBoton.setStyle(loginStyle);
        reiniciarBoton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> reiniciarBoton.setEffect(shadow));
        reiniciarBoton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> reiniciarBoton.setEffect(null));
        reiniciarBoton.setOnAction(event -> {
            mediaPlayer.stop();
            Main iniciarEvent = new Main(primaryStage, nombre, botonMusica, botonInformacion, musicaLogin);
            iniciarEvent.handle(event);
            musicaLogin.play();
            mediaPlayer.setAutoPlay(false);
        });

        // exit
        Button exit = new Button("EXIT");
        exit.setStyle(loginStyle);
        exit.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> exit.setEffect(shadow));
        exit.addEventHandler(MouseEvent.MOUSE_EXITED, e -> exit.setEffect(null));
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.exit(0));

        double buttonWidth = 370;
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
        primaryStage.setFullScreen(false);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1024);
        centerStageOnScreen(primaryStage);
        primaryStage.show();
    }

    // Centrar la ventana
    private void centerStageOnScreen(Stage stage) {
        // Obtener el tamaño de la pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Calcular las coordenadas para centrar la ventana
        double centerX = screenBounds.getMinX() + (screenBounds.getWidth() - stage.getWidth()) / 2;
        double centerY = screenBounds.getMinY() + (screenBounds.getHeight() - stage.getHeight()) / 2;

        // Establecer las coordenadas para centrar la ventana
        stage.setX(centerX);
        stage.setY(centerY);
    }

}
