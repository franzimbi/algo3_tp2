package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ParcelaEventHandler implements EventHandler<MouseEvent> {
    private Stage stage;
    private Coordenadas coordenadas;
    private Juego juego;
    private Main main;

    public ParcelaEventHandler(Stage stage, Coordenadas coordenadas, Juego juego, Main main){
        this.stage = stage;
        this.coordenadas = coordenadas;
        this.juego = juego;
        this.main = main;
    }

    @Override
    public void handle(MouseEvent aE){
        Stage casoError = new Stage();
        var label = new Label("fiesta");
        Button torreBlanca= new Button("Torre Blanca");
        torreBlanca.setStyle("-fx-background-color: green; -fx-text-fill: black;");
        torreBlanca.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.juego.agregarDefensa(new TorreBlanca(), coordenadas);
            stage.getScene().setRoot(this.main.actualizar(this.juego,this.stage));
            casoError.close();
            stage.getScene().setRoot(this.main.actualizar(this.juego,this.stage));
        });
        Button torrePlateada= new Button("Torre Plateada");
        torrePlateada.setStyle("-fx-background-color: green; -fx-text-fill: black;");
        torrePlateada.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.juego.agregarDefensa(new TorrePlateada(),coordenadas);
            casoError.close();
            stage.getScene().setRoot(this.main.actualizar(this.juego,this.stage));
        });

        Button trampaArena= new Button("Trampa de Arena");
        trampaArena.setStyle("-fx-background-color: green; -fx-text-fill: black;");
        trampaArena.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.juego.agregarDefensa(new TrampaArenosa(),coordenadas);
            casoError.close();
            stage.getScene().setRoot(this.main.actualizar(this.juego,this.stage));
        });
//        botonSeleccionarDefensa.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
//            if (media.getStatus() == MediaPlayer.Status.PLAYING) {
//                media.stop();
//                botonSeleccionarDefensa.setText("UNMUTE");
//                botonSeleccionarDefensa.setStyle("-fx-background-color: #ff8000; -fx-text-fill: #131313;");
//            } else {
//                media.play();
//                botonSeleccionarDefensa.setText("MUTE");
//                botonSeleccionarDefensa.setStyle("-fx-background-color: green; -fx-text-fill: black;");
//            }
//        } );
        VBox boton = new VBox(torreBlanca,torrePlateada,trampaArena);
        StackPane ventana = new StackPane();
        HBox caja = new HBox(ventana,boton);
        label.setPadding(new Insets(0,0,0,150));
        Scene scene = new Scene(caja);

        casoError.setScene(scene);
        casoError.showAndWait();
    }
}
