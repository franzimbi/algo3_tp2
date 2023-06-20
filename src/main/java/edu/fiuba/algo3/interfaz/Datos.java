package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.scene.text.Font;

public class Datos {
    public VBox generarDatos(Juego juego, TextField nombre, Button pasarTurno){
        Font font = new Font("Minecraftia", 22);
        //informacion del menu
        Label labelNombre = new Label("Jugador: " + nombre.getText());
        labelNombre.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 45px;");
        labelNombre.setFont(font);
        TextField vida = new TextField("Vida: " + Integer.toString(juego.vidaJugador()));
        vida.setStyle("-fx-background-color: #333333; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;");
        vida.setFont(font);
        vida.setFocusTraversable(false);
        vida.setEditable(false);
        TextField creditos = new TextField("Creditos: " + Integer.toString(juego.creditosJugador()));
        creditos.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;");
        creditos.setFont(font);
        creditos.setFocusTraversable(false);
        creditos.setEditable(false);
        TextField cantEnemigos = new TextField("Enemigos: " + Integer.toString(juego.cantidadEnemigos()));
        cantEnemigos.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;");
        cantEnemigos.setFont(font);
        cantEnemigos.setFocusTraversable(false);
        cantEnemigos.setEditable(false);
        TextField cantTurnos = new TextField("Turnos: " + Integer.toString(juego.cantidadDeTurnos()));
        cantTurnos.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 5px;");
        cantTurnos.setFont(font);
        cantTurnos.setFocusTraversable(false);
        cantTurnos.setEditable(false);
        VBox informacion = new VBox( labelNombre, vida, creditos, cantEnemigos, cantTurnos, pasarTurno);
        informacion.setMargin(labelNombre,new Insets(100,0,0,50));
        informacion.setMargin(vida,new Insets(50,0,0,50));
        informacion.setMargin(creditos,new Insets(50,0,0,50));
        informacion.setMargin(cantEnemigos,new Insets(50,0,0,50));
        informacion.setMargin(cantTurnos,new Insets(50,0,0,50));
        informacion.setMargin(pasarTurno,new Insets(50,0,0,50));
        return informacion;
    }


}
