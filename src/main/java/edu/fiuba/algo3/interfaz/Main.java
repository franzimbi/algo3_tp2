package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Main implements EventHandler<ActionEvent> {
    private final TextField nombre;
    private final Stage stage;
    private final MediaPlayer music;
    private final Button botonMusica;
    private final Button botonInformacion;
    private Parent tablero;
    private ArrayList<StackPane> coordenadas;
    private ArrayList<StackPane> coordenadas2;

    private final Image icono;

    public Main(Stage stage, TextField nombre, Button botonMusica, Button botonInformacion, MediaPlayer music) {
        this.stage = stage;
        this.nombre = nombre;
        this.music = music;
        this.botonMusica = botonMusica;
        this.botonInformacion = botonInformacion;
        this.coordenadas = new ArrayList<>();
        this.coordenadas2 = new ArrayList<>();
        this.icono = new Image(String.valueOf(new File("src/main/java/edu/fiuba/algo3/resources/imagenes/windowIcon.png").toURI().toString()));

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setTitle("Tower Defense");
        stage.getIcons().add(icono);
        StackPane ventana = new StackPane();
        String mapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String turnos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Jugador jugador = new Jugador(20, 100, nombre.getText());
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);
        Parent tablero = createBoard(juego.getParcelasMapa(), juego);
        this.tablero = tablero;
        ventana.getChildren().add(tablero);
        ventana.setPadding(new Insets(20, 0, 0, 50));
        Datos datos = new Datos();
        Button pasarTurno = new Button("Empezar Juego");
        pasarTurno.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000080; -fx-font-size: 20px;");
        pasarTurno.setMinSize(25, 25);
        InnerShadow shadow = new InnerShadow();
        pasarTurno.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> pasarTurno.setEffect(shadow));
        pasarTurno.addEventHandler(MouseEvent.MOUSE_EXITED, e -> pasarTurno.setEffect(null));
        pasarTurno.setOnAction(new PasarTurnoEventHandler(stage, juego, this));


        // Fullscreen Button
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        Button fullScreen = new Button("FULLSCREEN");
        fullScreen.setStyle(loginStyle);
        fullScreen.setOnAction(event -> stage.setFullScreen(!stage.isFullScreen()));

        VBox informacion = datos.generarDatos(juego, nombre, pasarTurno);
        VBox botones = new VBox(botonMusica, fullScreen, this.botonInformacion);
        botones.setAlignment(Pos.CENTER_RIGHT);
        VBox.setMargin(this.botonMusica, new Insets(5, 5, 220, 155));
        VBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 155));
        VBox.setMargin(fullScreen, new Insets(400, 5, 5, 155));

        HBox todo = new HBox(ventana, informacion, botones);
        HBox.setMargin(this.botonMusica, new Insets(5, 5, 5, 5));
        HBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 5));
        HBox.setMargin(fullScreen, new Insets(5, 5, 5, 5));

        double buttonWidth = 115;
        double buttonHeight = 30;
        fullScreen.setPrefSize(buttonWidth, buttonHeight);
        botonInformacion.setPrefSize(buttonWidth, buttonHeight);

        // Main juego pre pasar turno
        todo.setStyle("-fx-background-color: #070d26;");
        Scene escena = new Scene(todo);
        stage.setScene(escena);
        stage.setMaximized(true);

        stage.show();
    }

    public Parent createBoard(ArrayList<Parcela> parcelas, Juego juego) {
        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(500, 500);
        for (Parcela p : parcelas) {
            Rectangle tile = new Rectangle(45, 45);
            Image img = (Input.getInstance()).imagenParcela(p.getNombre()).getImage();
            tile.setFill(new ImagePattern(img));
            tile.setStroke(Color.BLACK);
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new ParcelaEventHandler(stage, p.getUbicacion(), juego, this));
            Text text = new Text();
            gameBoard.add(new StackPane(tile, text), p.getUbicacion().getX(), p.getUbicacion().getY());
        }
        return gameBoard;
    }

    public Parent actualizar(Juego juego, Stage stage) {
        if (juego.perdio()) {
            music.pause();
            Perdio perdiste = new Perdio(stage, nombre, botonInformacion);
            perdiste.handle(new ActionEvent());
        } else if (juego.gano() && juego.empezo()) {
            Stage primaryStage = new Stage();
            primaryStage.initModality(Modality.WINDOW_MODAL);
            primaryStage.initOwner(stage);
            primaryStage.getIcons().add(this.icono);
            primaryStage.setTitle("Tower Defense");
            String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 20px";
            DropShadow shadow = new DropShadow();


            //titulo ganaste!
            Label titulo = new Label(nombre.getText() + ", GANASTE!");
            titulo.setStyle("-fx-font-size: 30px; -fx-text-fill: #ffffff");
            titulo.setEffect(shadow);

            // Boton Reiniciar
            Button reiniciarBoton = new Button("Reiniciar");
            reiniciarBoton.setStyle(loginStyle);
            reiniciarBoton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> reiniciarBoton.setEffect(shadow));
            reiniciarBoton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> reiniciarBoton.setEffect(null));
            reiniciarBoton.setOnAction(event -> {
                Main iniciarEvent = new Main(primaryStage, nombre, botonMusica, botonInformacion, this.music);
                iniciarEvent.handle(event);
            });

            //Boton exit
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

            StackPane stackPane = new StackPane(gridPane); // Apilar el video y el formulario
            stackPane.setStyle("-fx-background-color: #070d26;");
            // Crear la escena y mostrarla en el escenario
            Scene scene = new Scene(stackPane);
            primaryStage.setScene(scene);
            primaryStage.setMaxHeight(300);
            primaryStage.setMaxWidth(400);
            primaryStage.show();
        }

        StackPane ventana = new StackPane();
        ventana.getChildren().add(actualizarTablero(juego, (GridPane) this.tablero));
        ventana.setPadding(new Insets(20, 0, 0, 50));

        InnerShadow shadow = new InnerShadow();
        Button pasarTurno = new Button("Pasar turno");
        pasarTurno.setStyle("-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 20px;");
        pasarTurno.setMinSize(25, 25);
        pasarTurno.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> pasarTurno.setEffect(shadow));
        pasarTurno.addEventHandler(MouseEvent.MOUSE_EXITED, e -> pasarTurno.setEffect(null));
        pasarTurno.setOnAction(new PasarTurnoEventHandler(stage, juego, this));

        // Fullscreen Button
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        Button fullScreen = new Button("FULLSCREEN");
        fullScreen.setStyle(loginStyle);
        fullScreen.setOnAction(event -> stage.setFullScreen(!stage.isFullScreen()));

        VBox informacion = new Datos().generarDatos(juego, nombre, pasarTurno);
        VBox botones = new VBox(botonMusica, fullScreen, this.botonInformacion);
        botones.setAlignment(Pos.CENTER_RIGHT);
        VBox.setMargin(this.botonMusica, new Insets(5, 5, 220, 155));
        VBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 155));
        VBox.setMargin(fullScreen, new Insets(400, 5, 5, 155));

        HBox todo = new HBox(ventana, informacion, botones);
        HBox.setMargin(this.botonMusica, new Insets(5, 5, 5, 5));
        HBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 5));
        HBox.setMargin(fullScreen, new Insets(5, 5, 5, 5));

        double buttonWidth = 115;
        double buttonHeight = 30;
        fullScreen.setPrefSize(buttonWidth, buttonHeight);
        botonInformacion.setPrefSize(buttonWidth, buttonHeight);

        todo.setStyle("-fx-background-color: #070d26;");
        return todo;
    }

    //no se usa
   /* public void tratarError(String mensaje) {
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        label.setPadding(new Insets(0, 0, 0, 20));
        Scene scene = new Scene(label, 200, 100);
        casoError.setScene(scene);
        casoError.setTitle("Error");
        casoError.showAndWait();
    }*/

    public Image enemigos(Enemigo enemigo) {
        return Input.getInstance().imagenEnemigo(enemigo.getNombre()).getImage();
    }

    public Parent actualizarTablero(Juego juego, GridPane tablero) {
        for (StackPane s : coordenadas) {
            tablero.getChildren().remove(s);
        }

        this.coordenadas = new ArrayList<>();

        for (StackPane s : coordenadas2) {
            tablero.getChildren().remove(s);
        }

        this.coordenadas2 = new ArrayList<>();

        for (Defensa e : juego.getDefensasJugador()) {
            Rectangle tile = new Rectangle(45, 45);
            Image img = (Input.getInstance().imagenDefensa(e.getNombre())).getImage();
            tile.setFill(new ImagePattern(img));
            tile.setStroke(Color.BLACK);
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> System.out.println("No se puede..."));
            Text text = new Text();
            Coordenadas coordenadasDefensa = e.getUbicacion();
            StackPane stack = new StackPane(tile, text);
            this.coordenadas2.add(stack);
            tablero.add(stack, coordenadasDefensa.getX(), coordenadasDefensa.getY());
        }

        for (Enemigo e : juego.getEnemigosMapa()) {
            Rectangle tile = new Rectangle(45, 45);
            Image img = Input.getInstance().imagenEnemigo(e.getNombre()).getImage();
            tile.setFill(new ImagePattern(img));
            tile.setStroke(Color.BLACK);
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> System.out.println("No se puede..."));
            Text text = new Text();
            Coordenadas coordenadasEnemigo = e.getUbicacion();
            StackPane stack = new StackPane(tile, text);
            this.coordenadas.add(stack);
            tablero.add(stack, coordenadasEnemigo.getX(), coordenadasEnemigo.getY());
        }
        return tablero;
    }

    public static class escribir implements EventHandler<ActionEvent> {
        public void handle(ActionEvent actionEvent) {
            System.out.println("No se puede...");
        }
    }


}



