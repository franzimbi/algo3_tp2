package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Input {
    private FileInputStream inputstream ;
    private Map<String, String> mapa;
    private Map<String, String> enemigos;
    private ArrayList<Parcela> parcelas;

    public Input(){
        mapa = new HashMap<>();
        mapa.put("tierra","src/main/java/edu/fiuba/algo3/resources/imagenes/tierra.jpg");
        mapa.put("rocoso","src/main/java/edu/fiuba/algo3/resources/imagenes/rocoso.jpg");
        mapa.put("pasarela","src/main/java/edu/fiuba/algo3/resources/imagenes/camino.jpg");
        this.enemigos = new HashMap<>();
        this.enemigos.put("arania","src/main/java/edu/fiuba/algo3/resources/imagenes/arana.png");
        this.enemigos.put("hormiga","src/main/java/edu/fiuba/algo3/resources/imagenes/hormiga.png");
        this.enemigos.put("topo","src/main/java/edu/fiuba/algo3/resources/imagenes/topo.png");
        this.enemigos.put("lechuza","src/main/java/edu/fiuba/algo3/resources/imagenes/lechuza.png");
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
}
