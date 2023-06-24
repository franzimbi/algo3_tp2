package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.*;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class InformacionEventHandle implements EventHandler<MouseEvent> {

    private final Image icon;
    private final String loginStyle;
    private final Stage popUpMenu;
    private final ArrayList<Defensa> defensas;
    private final ArrayList<Enemigo> enemigosArray;

    public InformacionEventHandle(Image icon, String loginStyle, Stage popUpMenu) {
        this.icon = icon;
        this.loginStyle = loginStyle;
        this.popUpMenu = popUpMenu;

        this.defensas = new ArrayList<>();
        defensas.add(new TorreBlanca());
        defensas.add(new TorrePlateada());
        defensas.add(new TrampaArenosa());

        this.enemigosArray = new ArrayList<>();
        enemigosArray.add(new Arania());
        enemigosArray.add(new Hormiga());
        enemigosArray.add(new Topo());
        enemigosArray.add(new Lechuza());
    }

    @Override
    public void handle(MouseEvent aE){
        Stage popUpMenu1 = new Stage();
        popUpMenu1.getIcons().add(icon);

        GridPane gridMenu = new GridPane();
        gridMenu.setAlignment(Pos.CENTER);
        gridMenu.setPadding(new Insets(10));
        gridMenu.setHgap(10);
        gridMenu.setVgap(10);

        Button comoJugar = new Button("COMO JUGAR");
        Button defensas = new Button("DEFENSAS");
        Button enemigos = new Button("ENEMIGOS");
        Button acercaDe = new Button("ACERCA DE");
        Button creditos = new Button("CREDITOS");

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

        enemigos.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, en -> {
            GridPane enemigosMenu = new GridPane();

            for (Enemigo enemigo: enemigosArray) {

            }

            TextField arania = new TextField("Hola Fran");
            arania.setFocusTraversable(false);
            arania.setEditable(false);

            //informacion 2do popUp
            enemigosMenu.add(arania, 0, 0);

            StackPane stackPane = new StackPane(enemigosMenu);
            Scene scene = new Scene(stackPane, 200, 200);
            popUpMenu1.setScene(scene);
            popUpMenu1.show();
        });
//        enemigos.addEventHandler(MouseEvent.MOUSE_EXITED, en -> popUpMenu1.close());

        //botones primer popUp
        gridMenu.add(comoJugar, 0, 0);
        gridMenu.add(defensas, 0, 1);
        gridMenu.add(enemigos, 0, 2);
        gridMenu.add(acercaDe, 0, 3);
        gridMenu.add(creditos, 0, 4);
        gridMenu.setHgrow(comoJugar, Priority.ALWAYS);
        gridMenu.setHalignment(comoJugar, HPos.CENTER);
        gridMenu.setHalignment(defensas, HPos.CENTER);
        gridMenu.setHalignment(enemigos, HPos.CENTER);
        gridMenu.setHalignment(acercaDe, HPos.CENTER);
        gridMenu.setHalignment(creditos, HPos.CENTER);


        StackPane stackPane1 = new StackPane(gridMenu);
        stackPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null))); // Establecer el fondo

        Scene scene1 = new Scene(stackPane1, 190, 250);
        popUpMenu.setScene(scene1);
        popUpMenu.show();
    }
}
