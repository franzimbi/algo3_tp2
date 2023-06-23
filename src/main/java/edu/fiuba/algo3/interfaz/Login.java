package edu.fiuba.algo3.interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tower Defense");
        String infoStyle = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;";
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        String musicStyle = "-fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        DropShadow shadow = new DropShadow();

        // Crear controles
        Label usernameLabel = new Label(" ingrese su nombre para comenzar ");
        usernameLabel.setStyle("-fx-background-color: white;");
        TextField usernameField = new TextField();
        usernameField.setPromptText("nombre");
        usernameField.setStyle(infoStyle);
        usernameField.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> usernameField.setEffect(shadow));
        usernameField.addEventHandler(MouseEvent.MOUSE_EXITED, e -> usernameField.setEffect(null));

//        Label passwordLabel = new Label();
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPromptText("Password");
//        passwordField.setStyle(infoStyle);
//        passwordField.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> passwordField.setEffect(shadow));
//        passwordField.addEventHandler(MouseEvent.MOUSE_EXITED, e -> passwordField.setEffect(null));

        Button empezarButton = new Button("Empezar el juego");
        empezarButton.setStyle(loginStyle);
        empezarButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> empezarButton.setEffect(shadow));
        empezarButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> empezarButton.setEffect(null));


        // Information button
        Button informacion = new Button("INFORMACION");
        Stage popUpMenu = new Stage();
        informacion.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> {
            GridPane gridMenu = new GridPane();

            Stage popUpMenu1 = new Stage();
            Button enemigos = new Button("ENEMIGOS");

            enemigos.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, en -> {
                GridPane enemigosMenu = new GridPane();
                TextField arania = new TextField("Arania");
                arania.setFocusTraversable(false);
                arania.setEditable(false);

                enemigosMenu.add(arania, 0, 0);

                StackPane stackPane = new StackPane(enemigosMenu);
                Scene scene = new Scene(stackPane, 200, 200);
                popUpMenu1.setScene(scene);
                popUpMenu1.show();
            });
            enemigos.addEventHandler(MouseEvent.MOUSE_EXITED, en -> popUpMenu1.close());

            gridMenu.add(enemigos, 0 , 0);
            StackPane stackPane1 = new StackPane(gridMenu);
            Scene scene1 = new Scene(stackPane1, 200, 200);
            popUpMenu.setScene(scene1);
            popUpMenu.show();
        });

        // Crear el diseño del formulario
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); // Centrar el GridPane en medio de la pantalla
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Agregar los controles al diseño
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
//        gridPane.add(passwordLabel, 0, 1);
//        gridPane.add(passwordField, 1, 1);
        gridPane.add(empezarButton, 1, 2);


        // Cargar Video
        String videoPath = "src/main/java/edu/fiuba/algo3/resources/musica/towerDefense.mp4"; // Ruta del archivo de video
        Media media = new Media(new File(videoPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Reproducir en bucle

        // Cargar Musica
        String musicPath = "src/main/java/edu/fiuba/algo3/resources/musica/theHorde.mp3"; // Ruta del archivo de video
        Media sound = new Media(new File(musicPath).toURI().toString());
        MediaPlayer music = new MediaPlayer(sound);
        music.setCycleCount(MediaPlayer.INDEFINITE);
        music.play();


        // Boton Musica
        Button botonMusica = new Button();
        botonMusica.setStyle(musicStyle);
        ImageView musicaOn = Input.getInstance().media("musicOn");
        musicaOn.setFitHeight(15);
        musicaOn.setPreserveRatio(true);
        botonMusica.setGraphic(musicaOn);
        ImageView musicaOff = Input.getInstance().media("musicOff");
        musicaOff.setFitHeight(15);
        musicaOff.setPreserveRatio(true);

        botonMusica.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (music.getStatus() == MediaPlayer.Status.PLAYING) {
                music.stop();
                botonMusica.setGraphic(musicaOff);
            } else {
                music.play();
                botonMusica.setGraphic(musicaOn);
            }
        });

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.TOP_RIGHT);
        gridPane1.add(botonMusica, 0, 0);
        gridPane1.add(informacion, 1, 0);
        gridPane.setPadding(new Insets(10));

        MediaView mediaView = new MediaView(mediaPlayer);
        StackPane stackPane = new StackPane(mediaView, new MediaView(music), gridPane, gridPane1); // Apilar el video y el formulario


        // Crear la escena y mostrarla en el escenario
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1024);
        primaryStage.show();
    }

    private boolean authenticate(String username) {
        // Devuelve true si 6 < username < 10
        return username.length() > 6 && username.length() < 10;
    }

//    private boolean authenticatePassword(String password) {
//        // Devuelve true si 6 < username < 10
//        return Objects.equals(password, "Disney");
//    }
}