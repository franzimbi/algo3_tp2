package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PasarTurnoEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final Stage stage;
    private final Main main;

    public PasarTurnoEventHandler(Stage stage, Juego juego, Main main) {
        this.stage = stage;
        this.juego = juego;
        this.main = main;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.juego.pasarTurno();
        stage.getScene().setRoot(main.actualizar(juego, stage));
        stage.setMaximized(true);
    }
}
