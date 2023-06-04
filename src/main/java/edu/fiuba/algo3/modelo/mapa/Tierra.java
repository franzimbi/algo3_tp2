package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Tierra extends Parcela {
    private Defensa defensa;

    public Tierra(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        this.defensa = defensa;
        jugador.sacarCreditos(defensa.costo());
        return true;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador) {
        return false;
    }

    public boolean estaOcupada() {
        return this.defensa != null;
    }

    public void defender(Camino camino){
        camino.atacar(this);
    }
}
