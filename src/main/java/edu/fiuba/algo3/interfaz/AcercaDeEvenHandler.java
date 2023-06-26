package edu.fiuba.algo3.interfaz;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AcercaDeEvenHandler implements EventHandler<MouseEvent> {
    private final Stage popUpMenu1;

    public AcercaDeEvenHandler(Stage popUpMenu2) {
        this.popUpMenu1 = popUpMenu2;
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent) {

    }
}