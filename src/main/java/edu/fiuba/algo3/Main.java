package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.Math.sqrt;
import static javafx.application.Application.launch;

public class Main extends Application{
    Button boton;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenaPrimaria)throws Exception{
        escenaPrimaria.setTitle("Tower Defence");

        boton = new Button();
        boton.setText("Aprobar la materia");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("No se puede...");

            }
        });

        StackPane disposicion = new StackPane();
        String mapa = "src/main/test/testResources/mapaValido.json";
        String turnos = "src/main/test/testResources/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);

        Parent tablero = createBoard(juego.tamanoMapa());
        disposicion.getChildren().add(tablero);
        Scene escena = new Scene(disposicion,500,500);
        escenaPrimaria.setScene(escena);
        escenaPrimaria.show();


    }

    public Parent createBoard(int tamano) {

        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(500, 500);
        int tamanoTablero = (int) sqrt(tamano);
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j=0; j < tamanoTablero;j++) {
                Rectangle tile = new Rectangle(50, 50);
                tile.setFill(Color.BURLYWOOD);
                tile.setStroke(Color.BLACK);
//
//                Image image=new Image();
//                ImageView  imageView=new ImageView();
//                ImageView.setImage(image);
                Text text = new Text();
//                text.setFont(Font.font(40));
//                text.setText(Integer.toString(i));
                gameBoard.add(new StackPane(tile, text), i, j);

//GridPane.setRowIndex(tile, i);
//                GridPane.setColumnIndex(tile, i);
//               gameBoard.getChildren().addAll(tile, text);
                //tile.setOnMouseClicked(event -> drawMove(text));
            }
        }
        return gameBoard;
    }
}



