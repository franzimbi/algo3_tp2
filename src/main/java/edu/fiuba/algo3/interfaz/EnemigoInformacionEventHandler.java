package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.enemigos.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EnemigoInformacionEventHandler implements EventHandler<javafx.scene.input.MouseEvent> {

    private final ArrayList<Enemigo> enemigosArray;
    private Stage popUpMenu1;

    private javafx.scene.image.Image icon;

    public EnemigoInformacionEventHandler(Stage popUpMenu1, javafx.scene.image.Image icon) {
        this.popUpMenu1 = popUpMenu1;
        this.icon = icon;
        this.enemigosArray = new ArrayList<>();
        enemigosArray.add(new Arania());
        enemigosArray.add(new Hormiga());
        enemigosArray.add(new Topo());
        enemigosArray.add(new Lechuza());
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent){
        popUpMenu1.getIcons().add(icon);
        popUpMenu1.setTitle("Enemigos Informacion");
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";

        GridPane enemigosMenu = new GridPane();
        enemigosMenu.setAlignment(Pos.CENTER);
        enemigosMenu.setGridLinesVisible(true);
        int columna = 0;

        for (Enemigo enemigo: enemigosArray) {
            VBox cajaVertical = new VBox();
            Button enemigoBoton = new Button();
            ImageView vistaEnemigo = Input.getInstance().imagenEnemigo(enemigo.getNombre());
            vistaEnemigo.setFitHeight(50);
            vistaEnemigo.setPreserveRatio(true);
            enemigoBoton.setGraphic(vistaEnemigo);

            Label nombre = new Label(enemigo.getNombre());
            nombre.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            nombre.setStyle(loginStyle);
            Label velocidad = new Label("Velocidad: " + Input.getInstance().informacion(enemigo.getNombre(), "Velocidad"));
            velocidad.setStyle(loginStyle);
            Label vida = new Label("Energia: " + Input.getInstance().informacion(enemigo.getNombre(), "Energia"));
            vida.setStyle(loginStyle);
            Label recompensa = new Label("Recompensa: " + Input.getInstance().informacion(enemigo.getNombre(), "Recompensa"));
            recompensa.setStyle(loginStyle);
            Label info = new Label(Input.getInstance().informacion(enemigo.getNombre(), "Info"));
            info.setStyle(loginStyle);

            cajaVertical.getChildren().addAll(enemigoBoton, nombre, velocidad, vida, info);

            VBox.setMargin(enemigoBoton, new Insets(5, 5, 5, 5));
            VBox.setMargin(nombre, new Insets(5, 5, 5, 5));
            VBox.setMargin(velocidad, new Insets(5, 5, 5, 5));
            VBox.setMargin(vida, new Insets(5, 5, 5, 5));
            VBox.setMargin(info, new Insets(5, 5, 5, 5));
            VBox.setMargin(recompensa, new Insets(5, 5, 5, 5));

            enemigosMenu.add(cajaVertical, columna, 0);
            columna++;
        }

        StackPane stackPane = new StackPane(enemigosMenu);
        stackPane.setStyle("-fx-background-color: #070d26;");
        Scene scene = new Scene(stackPane, 500,415);
        popUpMenu1.setScene(scene);
        popUpMenu1.show();
    }

}
