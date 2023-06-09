package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.excepciones.RangoInvalidoMapeadoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import edu.fiuba.algo3.modelo.turno.Turnos;

import java.util.ArrayList;

public class Mapa {
    private final int tamanoHorizontal;
    private final int tamanoVertical;
    private final ArrayList<ArrayList<Parcela>> matriz;
    private final Camino camino;

    private final ArrayList<Parcela> defensas;

    public Mapa(int tamanoHorizontal, int tamanoVertical) {
        this.tamanoVertical = tamanoVertical - 1;
        this.tamanoHorizontal = tamanoHorizontal - 1;
        this.matriz = new ArrayList<>(tamanoHorizontal);
        for (int i = 0; i < tamanoHorizontal; i++) {
            ArrayList<Parcela> aux = new ArrayList<>(tamanoVertical);
            this.matriz.add(aux);
        }
        this.camino = new Camino();
        this.defensas = new ArrayList<>();
    }

    public void agregarParcela(int x, int y, Parcela parcela) throws RangoInvalidoMapeadoError {
        if (x > this.tamanoHorizontal || y > this.tamanoVertical) {
            throw new RangoInvalidoMapeadoError();
        }
        var filaX = matriz.get(x);
        filaX.add(y, parcela);
        if (parcela instanceof Pasarela) {
            this.camino.agregarPasarela((Pasarela) parcela);
        }
    }

    public boolean agregarDefensa(Defensa defensa, Coordenadas posicion, Jugador jugador) {
        if (posicion.getX() > this.tamanoHorizontal || posicion.getY() > this.tamanoVertical) {
            return false;
        }
        var filaX = matriz.get(posicion.getX());
        var parcelaParaUbicar = filaX.get(posicion.getY());
        boolean pudoUbicar = parcelaParaUbicar.ubicar(defensa, jugador);
        if(pudoUbicar){
            defensas.add(parcelaParaUbicar);
        }
        return pudoUbicar;
    }

    /*public void defensasAtacar(Jugador jugador) {
        for (int f = 0; f < this.tamanoHorizontal; f++) {
            var filaX = this.matriz.get(f);
            for (int c = 0; c < this.tamanoVertical; c++) {
                if (filaX.get(c) instanceof Tierra) {
                    this.camino.atacar((Tierra) filaX.get(c), jugador);
                }
            }
        }
    }*/

    public void defensasAtacar(Jugador jugador){
        for (int i=0;i<this.defensas.size();i++){
            this.camino.atacar((Tierra) this.defensas.get(i), jugador);
        }
    }

    public void mover(Jugador jugador) {
        this.camino.mover(jugador);
    }

    public boolean perdio(Jugador jugador) {
        return this.camino.perdio(jugador);
    }

    public void generarEnemigos(Turnos oleada, Jugador jugador) {
        oleada.generarEnemigos(this.camino, jugador);
    }

    public boolean gano(Jugador jugador) {
        return this.camino.gano(jugador);
    }

    public int cantidadEnemigos(int posCamino){
        return this.camino.cantidadEnemigos(posCamino);
    }
    public int tamanoMapa(){
        return (this.tamanoVertical +1) * (this.tamanoHorizontal +1);
    }
}
