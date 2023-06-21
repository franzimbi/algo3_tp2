package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Input {
    private FileInputStream inputstream ;
    private Map<String, String> mapa;
    private Map<String, String> enemigos;
    private Map<String, String> defensas;
    private ArrayList<Parcela> parcelas;

    public Input(){
        mapa = new HashMap<>();
        mapa.put("tierra","src/main/java/edu/fiuba/algo3/resources/imagenes/tierra.jpg");
        mapa.put("rocoso","src/main/java/edu/fiuba/algo3/resources/imagenes/rocoso.jpg");
        mapa.put("pasarela","src/main/java/edu/fiuba/algo3/resources/imagenes/camino.jpg");
        this.enemigos = new HashMap<>();
        this.enemigos.put("Arania","src/main/java/edu/fiuba/algo3/resources/imagenes/arana.png");
        this.enemigos.put("Hormiga","src/main/java/edu/fiuba/algo3/resources/imagenes/hormiga.png");
        this.enemigos.put("Topo","src/main/java/edu/fiuba/algo3/resources/imagenes/topo.png");
        this.enemigos.put("Lechuza","src/main/java/edu/fiuba/algo3/resources/imagenes/lechuza.png");
        this.defensas = new HashMap<>();
        defensas.put("Torre Blanca","src/main/java/edu/fiuba/algo3/resources/imagenes/TorreBlanca.png");
        defensas.put("Torre Plateada","src/main/java/edu/fiuba/algo3/resources/imagenes/TorrePlateada.png");
        defensas.put("Trampa De Arena","src/main/java/edu/fiuba/algo3/resources/imagenes/TrampaArena.png");
    }


    public FileInputStream imagenParcela(String parcela) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(mapa.get(parcela));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }

    public FileInputStream imagenEnemigo(String enemigo) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(enemigos.get(enemigo));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }

    public FileInputStream imagenDefensa(String defensa) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(defensas.get(defensa));
        } catch (FileNotFoundException d) {
            throw new RuntimeException(d);
        }
        return inputStream;
    }

}


