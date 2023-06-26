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

public class CreditosEvenHandler implements EventHandler<MouseEvent> {
    private final Stage popUpMenu1;
    private final javafx.scene.image.Image icon;

    public CreditosEvenHandler(Stage popUpMenu2, javafx.scene.image.Image icon) {
        this.icon = icon;
        this.popUpMenu1 = popUpMenu2;
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent) {
        popUpMenu1.setTitle("Como Jugar");
        popUpMenu1.getIcons().add(icon);
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";

        var label = new Label("Garcia Sanchez Julian");
        var label1 = new Label("Lozano Martina Victoria");
        var label2 = new Label("Peralta Manuel Federico");
        var label3 = new Label("Zimbimbakis Francisco Manuel");
        var label4 = new Label("Natale Nicolas Marcelo");

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setPadding(new Insets(5));
        gridPane1.setHgap(5);
        gridPane1.setVgap(10);

        gridPane1.add(label, 0, 0);
        gridPane1.add(label1, 0, 1);
        gridPane1.add(label4, 0, 2);
        gridPane1.add(label2, 0, 3);
        gridPane1.add(label3, 0, 4);


        label.setStyle(loginStyle);
        label1.setStyle(loginStyle);
        label2.setStyle(loginStyle);
        label3.setStyle(loginStyle);
        label4.setStyle(loginStyle);

        StackPane layout = new StackPane(gridPane1);
        layout.setStyle("-fx-background-color: #070d26;");
        Scene scene = new Scene(layout, 400, 300);
        popUpMenu1.setScene(scene);
        popUpMenu1.show();
    }
}