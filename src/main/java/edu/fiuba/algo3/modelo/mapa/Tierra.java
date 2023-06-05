package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.NoHayDefensaEnTierraError;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Tierra extends Parcela {
    private Defensa defensa;

    public Tierra(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        this.defensa = defensa;
        defensa.sacarCreditos(jugador);
        return true;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador) {
        return false;
    }

    public void atacar(Pasarela pasarela, Jugador jugador) {
        int distancia = this.distancia(pasarela);
        if (this.defensa == null){throw new NoHayDefensaEnTierraError();}
        if (this.defensa.estaEnRango(distancia)) {
            pasarela.recibirAtaqueDe(this.defensa, jugador);
        }
    }
}
