package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.excepciones.CreditosInsuficientesError;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ParcelaEventHandler implements EventHandler<MouseEvent> {
    private final Stage stage;
    private final Coordenadas coordenadas;
    private final Juego juego;
    private final Main main;
    private final javafx.scene.image.Image icono;


    public ParcelaEventHandler(Stage stage, Coordenadas coordenadas, Juego juego, Main main, javafx.scene.image.Image icono) {
        this.stage = stage;
        this.coordenadas = coordenadas;
        this.juego = juego;
        this.main = main;
        this.icono = icono;

    }

    @Override
    public void handle(MouseEvent aE) {
        String color = "-fx-background-color: #F4C2C2;";
        Stage ventanaDefensas = new Stage();
        ventanaDefensas.getIcons().add(icono);
        ventanaDefensas.setTitle("Defensas");
        ventanaDefensas.initModality(Modality.WINDOW_MODAL);
        ventanaDefensas.initOwner(stage);


        ArrayList<Defensa> defensas = new ArrayList<>();
        defensas.add(new TorreBlanca());
        defensas.add(new TorrePlateada());
        defensas.add(new TrampaArenosa());

        HBox boton = new HBox();

        for (Defensa defensa : defensas) {
            Button defensaBoton = new Button();
            ImageView vistaBoton = Input.getInstance().imagenDefensa(defensa.getNombre());
            vistaBoton.setFitHeight(50);
            vistaBoton.setPreserveRatio(true);
            defensaBoton.setGraphic(vistaBoton);
            defensaBoton.setStyle(color);
            defensaBoton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 16px";
                Stage casoError = new Stage();
                casoError.getIcons().add(icono);
                casoError.initModality(Modality.WINDOW_MODAL);
                casoError.initOwner(ventanaDefensas);
                Label label;
                StackPane stack;
                Scene scene;
                try {
                    this.juego.agregarDefensa(defensa, coordenadas);
                } catch (ParcelaNoPuedeUbicarError exception) {
                    label = new Label("No se puede agregar " + defensa.getNombre() + " en  esta ubicacion.");
                    label.setStyle(loginStyle);
                    label.setPadding(new Insets(0, 0, 0, 20));
                    stack = new StackPane(label);
                    stack.setStyle("-fx-background-color: #070d26;");
                    scene = new Scene(stack, 450, 100);
                    casoError.setScene(scene);
                    casoError.setTitle("OOPS");
                    casoError.showAndWait();
                } catch (CreditosInsuficientesError exception) {
                    label = new Label("Creditos Insuficientes para " + defensa.getNombre());
                    label.setStyle(loginStyle);
                    label.setPadding(new Insets(0, 0, 0, 20));
                    stack = new StackPane(label);
                    stack.setStyle("-fx-background-color: #070d26;");
                    scene = new Scene(stack, 450, 100);
                    casoError.setScene(scene);
                    casoError.setTitle("OOPS");
                    casoError.showAndWait();
                }
                stage.getScene().setRoot(this.main.actualizar(this.juego, this.stage));
                ventanaDefensas.close();
                stage.getScene().setRoot(this.main.actualizar(this.juego, this.stage));
            });
            boton.getChildren().add(defensaBoton);
            HBox.setMargin(defensaBoton, new Insets(5, 5, 5, 5));
        }

        StackPane ventana = new StackPane();
        ventana.getChildren().add(boton);
        ventana.setStyle("-fx-background-color: rgba(228,0,0,0.49);");
        boton.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(ventana);
        ventanaDefensas.setScene(scene);
        ventanaDefensas.showAndWait();
    }
}
