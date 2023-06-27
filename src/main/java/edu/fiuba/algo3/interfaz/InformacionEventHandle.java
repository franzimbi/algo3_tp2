package edu.fiuba.algo3.interfaz;

import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InformacionEventHandle implements EventHandler<MouseEvent> {
    private final Image icon;
    private final String loginStyle;
    private final Stage popUpMenu;
    private final HostServices service;

    public InformacionEventHandle(Image icon, String loginStyle, Stage popUpMenu, HostServices service) {
        this.icon = icon;
        this.loginStyle = loginStyle;
        this.popUpMenu = popUpMenu;
        this.service = service;
    }

    @Override
    public void handle(MouseEvent aE) {
        popUpMenu.getIcons().add(icon);
        popUpMenu.setTitle("Info");
        InnerShadow innerShadow = new InnerShadow();
        Stage popUpMenu1 = new Stage();

        popUpMenu1.initModality(Modality.WINDOW_MODAL);
        popUpMenu1.initOwner(popUpMenu);
        GridPane gridMenu = new GridPane();
        gridMenu.setAlignment(Pos.CENTER);
        gridMenu.setPadding(new Insets(10));
        gridMenu.setHgap(10);
        gridMenu.setVgap(10);

        Button comoJugar = new Button("COMO JUGAR");
        Button defensas = new Button("DEFENSAS");
        Button enemigos = new Button("ENEMIGOS");
        Button acercaDe = new Button("ACERCA DE");
        //Hyperlink acercaDe = new Hyperlink("ACERCA DE");
        Button creditos = new Button("CREDITOS");

        // hyperlink acerca de
        acercaDe.setOnAction(event -> this.service.showDocument("https://github.com/franzimbi/algo3_tp2"));
        acercaDe.setStyle(loginStyle);
        acercaDe.setBorder(null);
        acercaDe.setUnderline(false);

        comoJugar.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> comoJugar.setEffect(innerShadow));
        comoJugar.addEventHandler(MouseEvent.MOUSE_EXITED, e -> comoJugar.setEffect(null));
        defensas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> defensas.setEffect(innerShadow));
        defensas.addEventHandler(MouseEvent.MOUSE_EXITED, e -> defensas.setEffect(null));
        enemigos.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> enemigos.setEffect(innerShadow));
        enemigos.addEventHandler(MouseEvent.MOUSE_EXITED, e -> enemigos.setEffect(null));
        acercaDe.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> acercaDe.setEffect(innerShadow));
        acercaDe.addEventHandler(MouseEvent.MOUSE_EXITED, e -> acercaDe.setEffect(null));
        creditos.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, e -> creditos.setEffect(innerShadow));
        creditos.addEventHandler(MouseEvent.MOUSE_EXITED, e -> creditos.setEffect(null));

        comoJugar.setStyle(loginStyle);
        defensas.setStyle(loginStyle);
        enemigos.setStyle(loginStyle);
        acercaDe.setStyle(loginStyle);
        creditos.setStyle(loginStyle);

        double buttonWidth = 120;
        double buttonHeight = 50;
        comoJugar.setPrefSize(buttonWidth, buttonHeight);
        defensas.setPrefSize(buttonWidth, buttonHeight);
        enemigos.setPrefSize(buttonWidth, buttonHeight);
        acercaDe.setPrefSize(buttonWidth, buttonHeight);
        creditos.setPrefSize(buttonWidth, buttonHeight);

        comoJugar.addEventHandler(MouseEvent.MOUSE_CLICKED, new ComoJugarEventHandler(popUpMenu1, icon));
        enemigos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EnemigoInformacionEventHandler(popUpMenu1, icon));
        defensas.addEventHandler(MouseEvent.MOUSE_CLICKED, new DefensaInformacionEventHandler(popUpMenu1, icon));
        creditos.addEventHandler(MouseEvent.MOUSE_CLICKED, new CreditosEvenHandler(popUpMenu1, service, icon));

        //botones primer popUp
        gridMenu.add(comoJugar, 0, 0);
        gridMenu.add(defensas, 0, 1);
        gridMenu.add(enemigos, 0, 2);
        gridMenu.add(acercaDe, 0, 3);
        gridMenu.add(creditos, 0, 4);
        GridPane.setHgrow(comoJugar, Priority.ALWAYS);
        GridPane.setHalignment(comoJugar, HPos.CENTER);
        GridPane.setHalignment(defensas, HPos.CENTER);
        GridPane.setHalignment(enemigos, HPos.CENTER);
        GridPane.setHalignment(acercaDe, HPos.CENTER);
        GridPane.setHalignment(creditos, HPos.CENTER);

        StackPane stackPane1 = new StackPane(gridMenu);
        stackPane1.setStyle("-fx-background-color: #070d26;");

        Scene scene1 = new Scene(stackPane1, 195, 250);
        popUpMenu.setScene(scene1);
        popUpMenu.show();
    }

}
