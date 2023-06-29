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
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Main implements EventHandler<ActionEvent> {
    private final TextField nombre;
    private final Stage stage;
    private final MediaPlayer music;
    private final Button botonMusica;
    private final Button botonInformacion;
    private final Image icono;
    private Parent tablero;
    private ArrayList<StackPane> coordenadas;
    private ArrayList<StackPane> coordenadas2;

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
        VBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 95));
        VBox.setMargin(fullScreen, new Insets(400, 5, 5, 95));

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
        InnerShadow shadow = new InnerShadow();
        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(500, 500);
        for (Parcela p : parcelas) {
            Rectangle tile = new Rectangle(45, 45);
            Image img;
            if (Objects.equals(p.getNombre(), "meta")) {
                img = (Input.getInstance()).imagenParcela("meta").getImage();
            } else {
                img = (Input.getInstance()).imagenParcela(p.getNombre()).getImage();
            }
            tile.setFill(new ImagePattern(img));

            tile.setStrokeWidth(0);
            tile.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> tile.setEffect(shadow));
            tile.addEventHandler(MouseEvent.MOUSE_EXITED, e -> tile.setEffect(null));
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new ParcelaEventHandler(stage, p.getUbicacion(), juego, this, icono));
            Text text = new Text();
            StackPane stack = new StackPane(tile, text);
            stack.setStyle("-fx-background-color: #446bff;");
            gameBoard.add(stack, p.getUbicacion().getX(), p.getUbicacion().getY());
        }
        return gameBoard;
    }

    public Parent actualizar(Juego juego, Stage stage) {
        if (juego.perdio()) {
            music.pause();
            FinJuego finJuego = new FinJuego(stage, nombre, botonInformacion, "perdioVideo", "! PERDISTE!");
            finJuego.handle(new ActionEvent());
        }
        if (juego.gano() && juego.empezo()) {
            music.pause();
            FinJuego finJuego = new FinJuego(stage, nombre, botonInformacion, "ganoVideo", "! GANASTE!");
            finJuego.handle(new ActionEvent());
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
        VBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 95));
        VBox.setMargin(fullScreen, new Insets(400, 5, 5, 95));

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
            Rectangle tile = new Rectangle(44, 44);
            Image img;
            if (e.estaOperativa()) {
                img = (Input.getInstance().imagenDefensa(e.getNombre())).getImage();
            } else {
                img = (Input.getInstance().imagenDefensa("noOperativa")).getImage();
            }
            tile.setFill(new ImagePattern(img));
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> System.out.println("No se puede..."));
            Text text = new Text();
            Coordenadas coordenadasDefensa = e.getUbicacion();
            StackPane stack = new StackPane(tile, text);
            this.coordenadas2.add(stack);
            tablero.add(stack, coordenadasDefensa.getX(), coordenadasDefensa.getY());
        }

        for (Enemigo e : juego.getEnemigosMapa()) {
            Rectangle tile = new Rectangle(44, 44);
            Image img = Input.getInstance().imagenEnemigo(e.getNombre()).getImage();
            tile.setFill(new ImagePattern(img));
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
            System.out.println("No se puede agregar defensa en parcelas con enemigos");
        }
    }
}



