package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DefensaInformacionEventHandler implements EventHandler<MouseEvent> {

    private final ArrayList<Defensa> defensas;
    private final Stage popUpMenu1;
    private final javafx.scene.image.Image icon;

    public DefensaInformacionEventHandler(Stage popUpMenu2, javafx.scene.image.Image icon) {
        this.popUpMenu1 = popUpMenu2;
        this.icon = icon;
        this.defensas = new ArrayList<>();
        defensas.add(new TorreBlanca());
        defensas.add(new TorrePlateada());
        defensas.add(new TrampaArenosa());
    }

    @Override
    public void handle(javafx.scene.input.MouseEvent mouseEvent) {
        popUpMenu1.getIcons().add(icon);
        popUpMenu1.setTitle("Defensas Informacion");
        GridPane defensaMenu = new GridPane();
        defensaMenu.setGridLinesVisible(true);
        String loginStyle = "-fx-background-color: #000080; -fx-text-fill: #ffffff; -fx-font-size: 14px";
        int columna = 0;

        for (Defensa defensa : defensas) {
            VBox cajaVertical = new VBox();
            Rectangle defensaImagen = new Rectangle(50, 50);
            Image img = Input.getInstance().imagenDefensa(defensa.getNombre()).getImage();
            defensaImagen.setFill(new ImagePattern(img));


            Label nombre = new Label(defensa.getNombre());
            nombre.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            nombre.setStyle(loginStyle);
            Label costo = new Label("Costo: " + Input.getInstance().informacion(defensa.getNombre(), "Costo"));
            costo.setStyle(loginStyle);
            Label danio = new Label("Danio: " + Input.getInstance().informacion(defensa.getNombre(), "Danio"));
            danio.setStyle(loginStyle);
            Label rango = new Label("Rango: " + Input.getInstance().informacion(defensa.getNombre(), "Rango"));
            rango.setStyle(loginStyle);
            Label operativa = new Label("Operativa En: " + Input.getInstance().informacion(defensa.getNombre(), "OperativaEn"));
            operativa.setStyle(loginStyle);

            Rectangle parcelaImagen = new Rectangle(50, 50);
            Image imgParcela = Input.getInstance().imagenParcela(Input.getInstance().informacion(defensa.getNombre(), "UbicarEn")).getImage();
            parcelaImagen.setFill(new ImagePattern(imgParcela));

            Label ubicacion = new Label("Ubicar En: ");
            ubicacion.setStyle(loginStyle);

            HBox cajaUbicacion = new HBox(ubicacion, parcelaImagen);
            HBox.setMargin(ubicacion, new Insets(5, 5, 5, 5));
            HBox.setMargin(parcelaImagen, new Insets(5, 5, 5, 5));

            cajaVertical.getChildren().addAll(defensaImagen, nombre, costo, danio, rango, operativa, cajaUbicacion);

            VBox.setMargin(defensaImagen, new Insets(5, 5, 5, 5));
            VBox.setMargin(nombre, new Insets(5, 5, 5, 5));
            VBox.setMargin(costo, new Insets(5, 5, 5, 5));
            VBox.setMargin(danio, new Insets(5, 5, 5, 5));
            VBox.setMargin(rango, new Insets(5, 5, 5, 5));
            VBox.setMargin(operativa, new Insets(5, 5, 5, 5));
            VBox.setMargin(cajaUbicacion, new Insets(5, 5, 5, 5));

            defensaMenu.add(cajaVertical, columna, 0);
            columna++;
        }

        VBox cajaVertical2 = new VBox();
        Rectangle noOpImg = new Rectangle(50, 50);
        Image imgNoOp = Input.getInstance().imagenDefensa("noOperativa").getImage();
        noOpImg.setFill(new ImagePattern(imgNoOp));

        Label noOperativa = new Label("La defensa no esta\n operativa ");
        noOperativa.setStyle(loginStyle);

        defensaMenu.add(cajaVertical2, columna, 0);

        cajaVertical2.getChildren().addAll(noOpImg, noOperativa);
        VBox.setMargin(noOpImg, new Insets(5, 5, 5, 5));
        VBox.setMargin(noOperativa, new Insets(5, 5, 5, 5));

        StackPane stackPane = new StackPane(defensaMenu);
        stackPane.setStyle("-fx-background-color: #070d26;");
        Scene scene = new Scene(stackPane, 570, 280);
        popUpMenu1.setScene(scene);
        popUpMenu1.show();
    }
}
