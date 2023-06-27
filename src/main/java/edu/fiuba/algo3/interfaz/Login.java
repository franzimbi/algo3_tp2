package edu.fiuba.algo3.interfaz;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image icon = new Image(String.valueOf(new File("src/main/java/edu/fiuba/algo3/resources/imagenes/windowIcon.png").toURI().toString()));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Tower Defense");
        String infoStyle = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;";
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        String musicStyle = "-fx-background-color: #333333; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        DropShadow shadow = new DropShadow();

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
        botonMusica.setEffect(shadow);
        ImageView musicaOff = Input.getInstance().media("musicOff");
        ImageView musicaOn = Input.getInstance().media("musicOn");
        musicaOn.setFitHeight(20);
        musicaOn.setPreserveRatio(true);
        botonMusica.setGraphic(musicaOn);
        botonMusica.setOnAction(new BotonMusicaEventHandler(music, botonMusica, musicaOn, musicaOff));
        botonMusica.setStyle(musicStyle);

        // Information button
        Button informacion = new Button("INFORMACION");
        informacion.setStyle(loginStyle);
        informacion.setEffect(shadow);
        Stage popUpMenu = new Stage();
        popUpMenu.initModality(Modality.WINDOW_MODAL);
        popUpMenu.initOwner(primaryStage);
        popUpMenu.getIcons().add(icon);
        HostServices service = getHostServices();
        informacion.addEventHandler(MouseEvent.MOUSE_ENTERED, new InformacionEventHandle(icon, loginStyle, popUpMenu, service));

        // FullScreen button
        Button fullScreen = new Button("FULLSCREEN");
        fullScreen.setStyle(loginStyle);
        fullScreen.setEffect(shadow);
        fullScreen.setOnAction(event -> primaryStage.setFullScreen(!primaryStage.isFullScreen()));

        // Crear controles
        //Titulo
        Label titulo = new Label("Ingrese un nombre de usuario");
        titulo.setStyle(loginStyle);

        // Username
        Label usernameLabel = new Label();
        usernameLabel.setStyle("-fx-background-color: white;");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Minimo 6 digitos.");
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
                Main iniciarEvent = new Main(primaryStage, new TextField(username), botonMusica, informacion, music);
                iniciarEvent.handle(event);
            } else {
                // Credenciales inválidas, mostrar mensaje de error o realizar alguna acción
                System.out.println("Login failed");
                Stage casoError = new Stage();
                casoError.initModality(Modality.WINDOW_MODAL);
                casoError.initOwner(primaryStage);
                casoError.getIcons().add(icon);
                var label = new Label("El nombre de usuario ingresado es invalido.");
                var label2 = new Label("Ingrese minimo 6 digitos, maximo 10 digitos.");
                GridPane gridPane1 = new GridPane();
                gridPane1.setAlignment(Pos.CENTER);
                gridPane1.setPadding(new Insets(5));
                gridPane1.setHgap(5);
                gridPane1.setVgap(5);
                gridPane1.add(label, 0, 0);
                gridPane1.add(label2, 0, 1);
                label2.setStyle(loginStyle);
                label.setStyle(loginStyle);
                StackPane layout = new StackPane(gridPane1);
                layout.setStyle("-fx-background-color: #070d26;");
                Scene scene = new Scene(layout, 320, 60);
                casoError.setScene(scene);
                casoError.setTitle("Error");
                casoError.showAndWait();
            }
        });

        // Crear el diseño del formulario
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); // Centrar el GridPane en medio de la pantalla
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Agregar los controles al diseño
        gridPane.add(titulo, 0, 1);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 0, 2);
        gridPane.add(empezarButton, 0, 3);

        MediaView mediaView = new MediaView(mediaPlayer);

        MotionBlur motionBlur = new MotionBlur(4, 4);
        gridPane.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> mediaView.setEffect(motionBlur));
        gridPane.addEventHandler(MouseEvent.MOUSE_EXITED, e -> mediaView.setEffect(null));

        StackPane stackPane = new StackPane(mediaView, gridPane); // Apilar el video y el formulario
        StackPane.setAlignment(botonMusica, Pos.TOP_RIGHT);
        StackPane.setAlignment(informacion, Pos.TOP_LEFT);
        StackPane.setAlignment(fullScreen, Pos.BOTTOM_RIGHT);
        stackPane.getChildren().add(botonMusica);
        stackPane.getChildren().add(informacion);
        stackPane.getChildren().add(fullScreen);
        StackPane.setMargin(fullScreen, new Insets(5));
        StackPane.setMargin(informacion, new Insets(5));
        StackPane.setMargin(botonMusica, new Insets(5));

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
        return (username.length() > 6 && username.length() < 10);
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

