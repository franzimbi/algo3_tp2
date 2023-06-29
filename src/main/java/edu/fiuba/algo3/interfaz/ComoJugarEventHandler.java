package edu.fiuba.algo3.interfaz;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ComoJugarEventHandler implements EventHandler<MouseEvent> {
    private final Stage popUpMenu1;
    private final javafx.scene.image.Image icon;

    public ComoJugarEventHandler(Stage popUpMenu2, javafx.scene.image.Image icon) {
        this.icon = icon;
        this.popUpMenu1 = popUpMenu2;
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent) {
        popUpMenu1.setTitle("Como Jugar");
        popUpMenu1.getIcons().add(icon);
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";

        var label = new Label("Tower Defense consiste en defender la base de los ataques de los\nenemigos para ganar se debe sobrevivir a todas las oleadas de\nenemigos");
        var label1 = new Label("1) El juegador comienza con 100 creditos, 20 de vida y\n0 oleadas pasadas en la cual se podra comprar defensas");
        var label2 = new Label("2) Para jugar se debe clickear en una parcela y ubicar una defensa,\nen tierra (para las torres) o el camino para la trampa de arena.");
        var label3 = new Label("3) El numero de enemigos aparece en el menu a la\n derecha del mapa ya que en una parcela puede haber varios enemigos");
        var label4 = new Label("4) Al matar enemigos se obtienen creditos necesarios\npara comprar los distintos tipos de defensas habilitados.");
        var label5 = new Label("5) Al perder/ganar el juego se podra reiniciar o salir del juego.");

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setPadding(new Insets(5));
        gridPane1.setHgap(5);
        gridPane1.setVgap(10);

        gridPane1.add(label, 0, 0);
        gridPane1.add(label1, 0, 1);
        gridPane1.add(label2, 0, 2);
        gridPane1.add(label3, 0, 3);
        gridPane1.add(label4, 0, 4);
        gridPane1.add(label5, 0, 5);

        label.setStyle(loginStyle);
        label1.setStyle(loginStyle);
        label2.setStyle(loginStyle);
        label3.setStyle(loginStyle);
        label4.setStyle(loginStyle);
        label5.setStyle(loginStyle);

        StackPane layout = new StackPane(gridPane1);
        layout.setStyle("-fx-background-color: #070d26;");
        Scene scene = new Scene(layout, 457, 290);
        popUpMenu1.setScene(scene);
        popUpMenu1.show();
    }
}