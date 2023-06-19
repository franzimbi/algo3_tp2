package edu.fiuba.algo3.interfaz;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.Math.sqrt;

public class Main implements EventHandler<ActionEvent> {

    private final TextField nombre;
    private Stage stage;

    public Main (Stage stage, TextField nombre){
        this.stage = stage;
        this.nombre = nombre;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.nombre.setEditable(false);
        StackPane ventana = new StackPane();
        String mapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        Parent tablero = createBoard(juego.tamanoMapa());
        disposicion.getChildren().add(tablero);
        disposicion.setPadding(new Insets(20,0,0,50));

        HBox todo = new HBox(ventana,informacion);
        todo.setStyle("-fx-background-color: #070d26;");


        Scene escena = new Scene(columnas,500,500);
        stage.setScene(escena);
        stage.show();
    }

    public Parent createBoard(int tamano) {

        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(500, 500);
        int tamanoTablero = (int) sqrt(tamano);
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j=0; j < tamanoTablero;j++) {

                ;

                Rectangle tile = new Rectangle(50, 50);

                Image img = new Image((new Input()).imagenParcela("Tierra"));
                tile.setFill(new ImagePattern(img));
                tile.setStroke(Color.BLACK);
                tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        System.out.println("No se puede...");
                    }
                });


                /*Image image=new Image();
                ImageView  imageView=new ImageView();
                ImageView.setImage(image);*/
                Text text = new Text();
               /*text.setFont(Font.font(40));
                text.setText(Integer.toString(i));*/
                gameBoard.add(new StackPane(tile, text), i, j);
                /*GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, i);
                gameBoard.getChildren().addAll(tile, text);
                tile.setOnMouseClicked(event -> drawMove(text));*/
            }
        }
        return gameBoard;
    }


    public class escribir implements EventHandler<ActionEvent>{

        public void handle(ActionEvent actionEvent) {
            System.out.println("No se puede...");

        }
    }

}



