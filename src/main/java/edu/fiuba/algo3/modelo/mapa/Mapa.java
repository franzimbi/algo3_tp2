package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.excepciones.RangoInvalidoMapeadoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import edu.fiuba.algo3.modelo.turno.Turnos;
import edu.fiuba.algo3.modelo.excepciones.RangoInvalidoMapeadoError;

import java.util.ArrayList;

public class Mapa {
    private final ArrayList<Parcela> parcelas;
    private final Camino camino;
    private final ArrayList<Parcela> defensas;

    public Mapa(int tamanoHorizontal, int tamanoVertical) {
        //this.tamanoVertical = tamanoVertical - 1;
        //this.tamanoHorizontal = tamanoHorizontal - 1;
        this.parcelas = new ArrayList<>();
        this.camino = new Camino();
        this.defensas = new ArrayList<>();
    }

    public void agregarParcela(Parcela parcela){
        this.parcelas.add(parcela);
        if (parcela instanceof Pasarela) {
            this.camino.agregarPasarela((Pasarela) parcela);
        }
    }

    public boolean agregarDefensa(Defensa defensa, Coordenadas posicion, Jugador jugador) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.getUbicacion().equals(posicion)) {
                boolean pudo = parcela.ubicar(defensa, jugador);
                if (pudo) this.defensas.add(parcela);
                return pudo;
            }
        }
        return false;
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
        for (Parcela defensa : this.defensas) {
            this.camino.atacar((Tierra) defensa, jugador);
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
        return this.parcelas.size();
    }
}
