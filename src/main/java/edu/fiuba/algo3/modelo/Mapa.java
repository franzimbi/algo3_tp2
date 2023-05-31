package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mapa {

    private ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();

    public void mover() {
        for (int i =pasarelas.size()-1; i >= 0; i--) {
            pasarelas.get(i).mover(pasarelas.get(i), this);
        }
    }

    public Pasarela siguiente(int velocidad, Pasarela pasarela) {
       return pasarelas.get(pasarelas.indexOf(pasarela) + velocidad);
    }
}
