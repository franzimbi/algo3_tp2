package edu.fiuba.algo3.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonInit implements EventHandler<ActionEvent> {

    private Stage stage;
    private TextField jugadores;

    public BotonInit (Stage stage, TextField texto){
        this.stage = stage;
        this.jugadores = texto;
    }


    @Override
    public void handle(ActionEvent actionEvent){
        if(this.jugadores.getLength()<6){
            this.tratarError("El nombre esta mal flaco");
            return;
        }


        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("src/main/java/edu/fiuba/algo3/imagenes/fiesta.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Image img = new Image(inputstream);
        ImageView view = new ImageView(img);

        view.setFitHeight(50);
        view.setFitWidth(50);
        ImageView view2 = new ImageView(img);
        view2.setFitHeight(50);
        view2.setFitWidth(50);
        ImageView view3 = new ImageView(img);
        view3.setFitHeight(50);
        view3.setFitWidth(50);
        ImageView view4 = new ImageView(img);
        view4.setFitHeight(50);
        view4.setFitWidth(50);
        ImageView view5 = new ImageView(img);
        view5.setFitHeight(50);
        view5.setFitWidth(50);
        ImageView view6 = new ImageView(img);
        view6.setFitHeight(50);
        view6.setFitWidth(50);
        ImageView view7 = new ImageView(img);
        view7.setFitHeight(50);
        view7.setFitWidth(50);
        ImageView view8 = new ImageView(img);
        view8.setFitHeight(50);
        view8.setFitWidth(50);
        ImageView view9 = new ImageView(img);
        view9.setFitHeight(50);
        view9.setFitWidth(50);

        Button parcela1 = new Button();
        parcela1.setPrefSize(50,50);
        Button parcela2 = new Button();
        parcela2.setPrefSize(50,50);
        Button parcela3 = new Button();
        parcela3.setPrefSize(50,50);

        Button parcela4 = new Button();
        parcela4.setPrefSize(50,50);
        Button parcela5 = new Button();
        parcela5.setPrefSize(50,50);
        Button parcela6 = new Button();
        parcela6.setPrefSize(50,50);

        Button parcela7 = new Button();
        parcela7.setPrefSize(50,50);
        Button parcela8 = new Button();
        parcela8.setPrefSize(50,50);
        Button parcela9 = new Button();
        parcela9.setPrefSize(50,50);

        parcela1.setGraphic(view);
        parcela2.setGraphic(view2);
        parcela3.setGraphic(view3);
        parcela4.setGraphic(view4);
        parcela5.setGraphic(view5);
        parcela6.setGraphic(view6);
        parcela7.setGraphic(view7);
        parcela8.setGraphic(view8);
        parcela9.setGraphic(view9);



        HBox filas = new HBox(parcela1,parcela2,parcela3);
        filas.setPadding(new Insets(0,30,0,30));
        filas.setMargin(parcela1,new Insets(0,20,20,0));
        filas.setMargin(parcela2,new Insets(0,20,20,0));
        filas.setMargin(parcela3,new Insets(0,20,20,0));

        HBox filas2 = new HBox(parcela4,parcela5,parcela6);
        filas2.setPadding(new Insets(0,30,0,30));
        filas2.setMargin(parcela4,new Insets(0,20,20,0));
        filas2.setMargin(parcela5,new Insets(0,20,20,0));
        filas2.setMargin(parcela6,new Insets(0,20,20,0));

        HBox filas3 = new HBox(parcela7,parcela8,parcela9);
        filas3.setPadding(new Insets(0,30,0,30));
        filas3.setMargin(parcela7,new Insets(0,20,20,0));
        filas3.setMargin(parcela8,new Insets(0,20,20,0));
        filas3.setMargin(parcela9,new Insets(0,20,20,0));

        VBox columnas = new VBox(filas,filas2,filas3);

        columnas.setPadding(new Insets(30,0,0,0));

        var mapa = new Scene(columnas, 300,300);
        this.stage.setScene(mapa);
        this.stage.show();
    }

    public void tratarError(String mensaje){
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        label.setPadding(new Insets(0,0,0,150));
        Scene scene = new Scene(label, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }

}
