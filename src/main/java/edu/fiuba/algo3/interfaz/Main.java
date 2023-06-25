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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main implements EventHandler<ActionEvent> {
    private final TextField nombre;
    private final Stage stage;
    private final Button botonMusica;
    private final Button botonInformacion;

    private Parent tablero;
    private ArrayList<StackPane> coordenadas;
    private ArrayList<StackPane> coordenadas2;

    public Main(Stage stage, TextField nombre, Button botonMusica, Button botonInformacion) {
        this.stage = stage;
        this.nombre = nombre;
        this.botonMusica = botonMusica;
        this.botonInformacion = botonInformacion;
        this.coordenadas = new ArrayList<>();
        this.coordenadas2 = new ArrayList<>();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
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

        VBox informacion = datos.generarDatos(juego, nombre, pasarTurno, stage);
        HBox botones = new HBox(this.botonMusica, this.botonInformacion);
        HBox todo = new HBox(ventana, informacion, botones);
        HBox.setMargin(botones, new Insets(5, 5, 5, 100));
        HBox.setMargin(this.botonMusica, new Insets(5, 5, 5, 5));
        HBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 5));

        // Main juego pre pasar turno
        todo.setStyle("-fx-background-color: #070d26;");
        Scene escena = new Scene(todo);
        stage.setScene(escena);
        stage.setMaximized(true);
        stage.setTitle("Tower Defense");
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

        VBox informacion = new Datos().generarDatos(juego, nombre, pasarTurno, stage);
        HBox botones = new HBox(this.botonMusica, this.botonInformacion);
        HBox todo = new HBox(ventana, informacion, botones);
        HBox.setMargin(botones, new Insets(5, 5, 5, 100));
        HBox.setMargin(this.botonMusica, new Insets(5, 5, 5, 5));
        HBox.setMargin(this.botonInformacion, new Insets(5, 5, 5, 5));
        todo.setStyle("-fx-background-color: #070d26;");

        return todo;
    }

    public void tratarError(String mensaje) {
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        label.setPadding(new Insets(0, 0, 0, 20));
        Scene scene = new Scene(label, 200, 100);
        casoError.setScene(scene);
        casoError.setTitle("Error");
        casoError.showAndWait();
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

    public class escribir implements EventHandler<ActionEvent> {
        public void handle(ActionEvent actionEvent) {
            System.out.println("No se puede...");
        }
    }


}



