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

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EnemigoInformacionEventHandler implements EventHandler<javafx.scene.input.MouseEvent> {

    private final ArrayList<Enemigo> enemigosArray;
    private Stage popUpMenu1;

    public EnemigoInformacionEventHandler(Stage popUpMenu1) {
        this.popUpMenu1 = popUpMenu1;
        this.enemigosArray = new ArrayList<>();
        enemigosArray.add(new Arania());
        enemigosArray.add(new Hormiga());
        enemigosArray.add(new Topo());
        enemigosArray.add(new Lechuza());
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent){
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

            Text nombre = new Text(enemigo.getNombre());
            nombre.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            Text velocidad = new Text("Velocidad: " + Input.getInstance().informacion(enemigo.getNombre(), "Velocidad"));
            Text vida = new Text("Energia: " + Input.getInstance().informacion(enemigo.getNombre(), "Energia"));
            Text recompensa = new Text("Recompensa: " + Input.getInstance().informacion(enemigo.getNombre(), "Recompensa"));
            Text info = new Text(Input.getInstance().informacion(enemigo.getNombre(), "Info"));

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
        Scene scene = new Scene(stackPane, 435,315);
        popUpMenu1.setScene(scene);
        popUpMenu1.show();
    }

}
