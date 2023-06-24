package edu.fiuba.algo3.interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
        Label usernameLabel = new Label();
        //usernameLabel.setStyle("-fx-background-color: white;");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Nombre");
        usernameField.setStyle(infoStyle);
        usernameField.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> usernameField.setEffect(shadow));
        usernameField.addEventHandler(MouseEvent.MOUSE_EXITED, e -> usernameField.setEffect(null));

        // Boton Empezar
        Button empezarButton = new Button("Empezar el juego");
        empezarButton.setStyle(loginStyle);
        empezarButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> empezarButton.setEffect(shadow));
        empezarButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> empezarButton.setEffect(null));
        empezarButton.setOnAction(event -> {
            // Lógica de verificación de credenciales aquí
            String username = usernameField.getText();
            // Realizar la autenticación y verificar las credenciales ingresadas
            if (authenticate(username)) {
                // Credenciales válidas, mostrar otra pantalla o realizar alguna acción
                System.out.println("Login successful");
            } else {
                // Credenciales inválidas, mostrar mensaje de error o realizar alguna acción
                System.out.println("Login failed");
            }
        });


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

            gridMenu.add(enemigos, 0, 0);
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
        gridPane.setPadding(new Insets(10));

        // Agregar los controles al diseño
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(empezarButton, 1, 1);

        // Cargar Video
        MediaPlayer mediaPlayer = Input.getInstance().mediaPlayer("loginVideo");
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Reproducir en bucle

        // Cargar Musica
        MediaPlayer music = Input.getInstance().mediaPlayer("loginMusic");
        music.setCycleCount(MediaPlayer.INDEFINITE);
        music.setVolume(0.1);
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
                music.pause();
                botonMusica.setGraphic(musicaOff);
            } else {
                music.play();
                botonMusica.setGraphic(musicaOn);
            }
        });

        //GridPane gridPane1 = new GridPane();
        gridPane.setAlignment(Pos.TOP_RIGHT);
        gridPane.add(botonMusica, 2, 2);
        gridPane.add(informacion, 3, 3);


        MediaView mediaView = new MediaView(mediaPlayer);
        StackPane stackPane = new StackPane(mediaView, new MediaView(music), gridPane); // Apilar el video y el formulario


        // Crear la escena y mostrarla en el escenario
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1024);
        centerStageOnScreen(primaryStage);
        primaryStage.show();
    }

    private boolean authenticate(String username) {
        // Devuelve true si 6 < username < 10
        return username.length() > 6 && username.length() < 10;
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