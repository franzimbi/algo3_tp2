package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.excepciones.RangoInvalidoMapeadoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.parcelas.Parcela;

import java.util.ArrayList;

public class Mapa {
    private final int tamanoHorizontal;
    private final int tamanoVertical;
    private ArrayList<ArrayList<Parcela>> matriz;
    private Camino camino;


    public Mapa(int tamanoHorizontal, int tamanoVertical) {
        this.tamanoVertical = tamanoVertical;
        this.tamanoHorizontal = tamanoHorizontal;
        this.matriz = new ArrayList<>(tamanoHorizontal);
        for (int i = 0; i < tamanoHorizontal; i++) {
            ArrayList<Parcela> aux = new ArrayList<>(tamanoVertical);
            this.matriz.add(aux);
        }
    }
    public void agregarParcela(int x, int y, Parcela parcela) throws RangoInvalidoMapeadoError {
        if (x > this.tamanoHorizontal || y > this.tamanoVertical) {
            throw new RangoInvalidoMapeadoError();
        }
        var filaX = matriz.get(x);
        filaX.add(y, parcela);
        //TODO: FALTA IMPLEMENTAR QUE MAPA HAGA EL CAMINO DESDE EL JSON.
    }
    public boolean agregarDefensa(Defensa defensa, Coordenadas posicion, Jugador jugador){
        if ( posicion.getX() > this.tamanoHorizontal || posicion.getY() >this.tamanoVertical){
            return false;
        }
        var filaX = matriz.get(posicion.getX());
        var parcelaParaUbicar = filaX.get(posicion.getY());
        return parcelaParaUbicar.ubicar(defensa, jugador);
    }
    public void defensasAtacar(Jugador jugador){
        // las defensas tienen q atacar a su enemigo mas lejano
    }
    public Camino camino(){
        return this.camino;
    }
}

