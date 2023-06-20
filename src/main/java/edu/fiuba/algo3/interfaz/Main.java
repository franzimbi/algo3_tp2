package edu.fiuba.algo3.interfaz;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.interfaz.PasarTurnoEventHandler;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import static java.lang.Math.sqrt;

public class Main implements EventHandler<ActionEvent> {
    private TextField nombre;
    private Stage stage;
    private MediaPlayer media;
    private Parent tablero;

    public Main (Stage stage, TextField nombre,  MediaPlayer mediaPlayer){
        this.stage = stage;
        this.nombre = nombre;
        this.media = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.nombre.getLength()<6){
            this.tratarError("El nombre esta mal flaco");
            return;
        }
        StackPane ventana = new StackPane();
        String mapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String turnos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Jugador jugador = new Jugador(20, 100, nombre.getText());
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);
        Parent tablero = createBoard(juego.tamanoMapa(),juego.getParcelasMapa());
        this.tablero = tablero;
        ventana.getChildren().add(tablero);
        ventana.setPadding(new Insets(20,0,0,50));
        Datos datos = new Datos();
        Button pasarTurno = new Button("Empezar Juego");
        pasarTurno.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000080; -fx-font-size: 20px;");
        pasarTurno.setMinSize(25, 25);
        DropShadow shadow = new DropShadow();
        pasarTurno.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED,
                e -> pasarTurno.setEffect(shadow));
        pasarTurno.addEventHandler(MouseEvent.MOUSE_EXITED, e -> pasarTurno.setEffect(null));
        pasarTurno.setOnAction(new PasarTurnoEventHandler(stage,juego,this));
        VBox informacion = datos.generarDatos(juego, nombre, pasarTurno);
        HBox todo = new HBox(ventana,informacion);
        todo.setStyle("-fx-background-color: #070d26;");
        Scene escena = new Scene(todo);
        //escena.setFill(javafx.scene.paint.Color.BLACK);
        stage.setScene(escena);
        stage.setMaximized(true);
        //this.media.stop();
        stage.show();
    }

    public Parent createBoard(int tamano, ArrayList<Parcela> parcelas) {
        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(500, 500);
        int tamanoTablero = (int) sqrt(tamano);
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j=0; j < tamanoTablero;j++) {
                Coordenadas c = new Coordenadas(i,j);
                for (Parcela p: parcelas){
                    if(p.getUbicacion().equals(c)){
                        Rectangle tile = new Rectangle(50, 50);
                        Image img = new Image((new Input()).imagenParcela(p.getNombre()));
                        tile.setFill(new ImagePattern(img));
                        tile.setStroke(Color.BLACK);
                        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                System.out.println("No se puede...");
                            }
                        });
                        Text text = new Text();
                        gameBoard.add(new StackPane(tile, text), i, j);
                        break;
                    }
                }
            }
        }
        return gameBoard;
    }

    public Parent actualizar(Juego juego, Stage stage){
        StackPane ventana = new StackPane();
        ventana.getChildren().add(actualizarTablero(juego,(GridPane) this.tablero));
        ventana.setPadding(new Insets(20,0,0,50));
        Button pasarTurno = new Button("Pasar turno");
        pasarTurno.setStyle("-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 20px;");
        pasarTurno.setMinSize(25, 25);
        DropShadow shadow = new DropShadow();
        pasarTurno.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED,
                e -> pasarTurno.setEffect(shadow));
        pasarTurno.addEventHandler(MouseEvent.MOUSE_EXITED, e -> pasarTurno.setEffect(null));
        pasarTurno.setOnAction(new PasarTurnoEventHandler(stage,juego,this));
        VBox informacion = new Datos().generarDatos(juego, nombre, pasarTurno);
        HBox todo = new HBox(ventana,informacion);
        todo.setStyle("-fx-background-color: #070d26;");
        //Scene escena = new Scene(todo);
        Parent parent = todo;
         return parent;
        //escena.setFill(javafx.scene.paint.Color.BLACK);
        //stage.setScene(escena);
        /*stage.setMaximized(false);
        stage.setMaximized(true);*/
    }

    public class escribir implements EventHandler<ActionEvent>{
        public void handle(ActionEvent actionEvent) {
            System.out.println("No se puede...");
        }
    }

    public void tratarError(String mensaje){
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        label.setPadding(new Insets(0,0,0,150));
        Scene scene = new Scene(label, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }

    public Image enemigos(Enemigo enemigo){
        return new Image((new Input()).imagenEnemigo(enemigo.getNombre()));
    }

    public Parent actualizarTablero(Juego juego, GridPane tablero) {
        for (Enemigo e : juego.getEnemigosMapa()) {
            Rectangle tile = new Rectangle(50, 50);
            Image img = new Image((new Input()).imagenEnemigo(e.getNombre()));
            tile.setFill(new ImagePattern(img));
            tile.setStroke(Color.BLACK);
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    System.out.println("No se puede...");
                }
            });
            Text text = new Text();
            Coordenadas coordenadasEnemigo = e.getUbicacion();
            tablero.add(new StackPane(tile, text), coordenadasEnemigo.getX(), coordenadasEnemigo.getY());
            break;
        }
        return tablero;
    }
}



