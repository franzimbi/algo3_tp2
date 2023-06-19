package edu.fiuba.algo3.interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        Label label = new Label("Ingrese su nombre: ");

        TextField texto = new TextField();

        Button botonInit = new Button("JUGAR!");

        Main iniciarEvent = new Main(stage,texto);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(25, 25);

        TextoEventHandler textoEvent = new TextoEventHandler(botonInit);
        texto.setOnKeyPressed(textoEvent);



        HBox datosIniciales = new HBox(label, texto);
        datosIniciales.setSpacing(5);

        VBox botones = new VBox(datosIniciales, botonInit);
        botones.setMargin(botonInit,new Insets(30,0,0,100));
        botones.setPadding(new Insets(30,10,10,10));

        var menu = new Scene(botones, 300, 150);

        stage.setScene(menu);
        stage.show();
    }

}