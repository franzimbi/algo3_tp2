package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class Mapa {
    private static Mapa instancia = new Mapa();
    private LinkedList<Camino> caminos;

    private Mapa(){
        this.caminos = new LinkedList<>();
    }

    public static Mapa getInstancia(){
        return instancia;
    }

    public void ubicarCamino(Camino camino){
        this.caminos.addLast(camino);
    }

}
