package edu.fiuba.algo3;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class Main extends Application{
    Button boton;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenaPrimaria)throws Exception{
        escenaPrimaria.setTitle("Tower Defence");

        boton = new Button();
        boton.setText("Aprobar la materia");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("No se puede...");

            }
        });

        StackPane disposicion = new StackPane();
        disposicion.getChildren().add(boton);

        Scene escena = new Scene(disposicion,480,480);
        escenaPrimaria.setScene(escena);
        escenaPrimaria.show();

    }


}
