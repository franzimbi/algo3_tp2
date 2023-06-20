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
    private ArrayList<Parcela> parcelas;

    public Input(){
        mapa = new HashMap<>();
        mapa.put("tierra","src/main/java/edu/fiuba/algo3/resources/imagenes/tierra.jpg");
        mapa.put("rocoso","src/main/java/edu/fiuba/algo3/resources/imagenes/rocoso.jpg");
        mapa.put("pasarela","src/main/java/edu/fiuba/algo3/resources/imagenes/camino.jpg");
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
}
