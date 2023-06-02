package edu.fiuba.algo3.model.defensa;

import edu.fiuba.algo3.model.mapa.Coordenadas;
import edu.fiuba.algo3.model.jugador.Jugador;
import edu.fiuba.algo3.model.enemigos.Enemigo;
import edu.fiuba.algo3.model.mapa.Parcela;

public class Tierra extends Parcela {
    private Defensa defensa;

    public Tierra(Coordenadas ubicacion){
        this.ubicacion = ubicacion;
    }
    public Tierra(){
        this.ubicacion = new Coordenadas(0,0);
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        this.defensa = defensa;
        jugador.sacarCreditos(defensa.coste);
        return true;
    }
    public boolean ubicar(Enemigo enemigo, Jugador jugador) {
        return false;
    }
    public boolean estaOcupada(){
        return this.defensa != null;
    }
    @Override
    public boolean defender(Parcela lugar) {
        if (!this.estaOcupada()) {
            return false;
        }
        return lugar.atacado(this.defensa,this);
    }

}
