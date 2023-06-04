package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.mapa.*;
import java.util.ArrayList;

public class Mapa {
    ArrayList<ArrayList<Parcela>> matriz;
    public Mapa(){
        this.matriz = new ArrayList<ArrayList<Parcela>>();
    }
    public void agregarParcela(int x, int y){
        Coordenadas aux = new Coordenadas(x,y);

    }
}
