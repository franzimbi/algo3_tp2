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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class InformacionEventHandle implements EventHandler<MouseEvent> {

    private final Image icon;
    private final String loginStyle;
    private final Stage popUpMenu;

    public InformacionEventHandle(Image icon, String loginStyle, Stage popUpMenu) {
        this.icon = icon;
        this.loginStyle = loginStyle;
        this.popUpMenu = popUpMenu;
    }

    @Override
    public void handle(MouseEvent aE){
        Stage popUpMenu1 = new Stage();
        popUpMenu.getIcons().add(icon);
        popUpMenu1.setTitle("Juego Informacion");

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

        comoJugar.addEventHandler(MouseEvent.MOUSE_CLICKED, new ComoJugarEventHandler(popUpMenu1, icon));
        enemigos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EnemigoInformacionEventHandler(popUpMenu1, icon));
        defensas.addEventHandler(MouseEvent.MOUSE_CLICKED, new DefensaInformacionEventHandler(popUpMenu1, icon));

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
