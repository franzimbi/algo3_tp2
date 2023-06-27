package edu.fiuba.algo3.interfaz;

import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreditosEvenHandler implements EventHandler<MouseEvent> {
    private final Stage popUpMenu1;
    private final javafx.scene.image.Image icon;
    private final HostServices service;

    public CreditosEvenHandler(Stage popUpMenu2, HostServices service, javafx.scene.image.Image icon) {
        this.icon = icon;
        this.popUpMenu1 = popUpMenu2;
        this.service = service;
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent) {
        popUpMenu1.setTitle("Creditos");
        popUpMenu1.getIcons().add(icon);
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        InnerShadow innerShadow = new InnerShadow();

        Hyperlink juli = new Hyperlink("Garcia Sanchez Julian");
        juli.setOnAction(event -> {
            this.service.showDocument("https://github.com/JulianGarciaSan");
        });
        juli.setStyle(loginStyle);
        juli.setBorder(null);
        juli.setUnderline(false);
        juli.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> juli.setEffect(innerShadow));
        juli.addEventHandler(MouseEvent.MOUSE_EXITED, e -> juli.setEffect(null));

        Hyperlink martu = new Hyperlink("Lozano Martina Victoria");
        martu.setOnAction(event -> {
            this.service.showDocument("https://github.com/MLozano01");
        });
        martu.setStyle(loginStyle);
        martu.setBorder(null);
        martu.setUnderline(false);
        martu.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> martu.setEffect(innerShadow));
        martu.addEventHandler(MouseEvent.MOUSE_EXITED, e -> martu.setEffect(null));

        Hyperlink fede = new Hyperlink("Peralta Manuel Federico");
        fede.setOnAction(event -> {
            this.service.showDocument("https://github.com/FedericoMPeralta");
        });
        fede.setStyle(loginStyle);
        fede.setBorder(null);
        fede.setUnderline(false);
        fede.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> fede.setEffect(innerShadow));
        fede.addEventHandler(MouseEvent.MOUSE_EXITED, e -> fede.setEffect(null));

        Hyperlink fran = new Hyperlink("Zimbimbakis Francisco Manuel");
        fran.setOnAction(event -> {
            this.service.showDocument("https://github.com/franzimbi");
        });
        fran.setStyle(loginStyle);
        fran.setBorder(null);
        fran.setUnderline(false);
        fran.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> fran.setEffect(innerShadow));
        fran.addEventHandler(MouseEvent.MOUSE_EXITED, e -> fran.setEffect(null));

        Hyperlink nico = new Hyperlink("Natale Nicolas Marcelo");
        nico.setOnAction(event -> {
            this.service.showDocument("https://github.com/Igris-1");
        });
        nico.setStyle(loginStyle);
        nico.setBorder(null);
        nico.setUnderline(false);
        nico.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> nico.setEffect(innerShadow));
        nico.addEventHandler(MouseEvent.MOUSE_EXITED, e -> nico.setEffect(null));


        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setPadding(new Insets(5));
        gridPane1.setHgap(5);
        gridPane1.setVgap(10);


        Label label = new Label("Desarrolladores:");
        label.setStyle(loginStyle);
        gridPane1.add(label, 0, 0);
        gridPane1.add(juli, 0, 1);
        gridPane1.add(martu, 0, 2);
        gridPane1.add(fede, 0, 3);
        gridPane1.add(fran, 0, 4);
        gridPane1.add(nico, 0, 5);

        StackPane layout = new StackPane(gridPane1);
        layout.setStyle("-fx-background-color: #070d26;");
        Scene scene = new Scene(layout, 220, 220);
        popUpMenu1.setScene(scene);
        popUpMenu1.show();
    }
}