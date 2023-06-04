package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vida.Energia;

public abstract class Enemigo {
    protected Energia energia;
    protected Energia danio;
    protected int velocidad;
    protected Recompensa recompensa;

    public void recibirDanio(Energia danioRecibido, Jugador jugador) {
        this.energia.reducir(danioRecibido);
        if (estaMuerto()) {
            this.recompensa.otorgarRecompensa(jugador);
        }
    }

    public void setRecompensa(Recompensa nuevaRecompensa) {
        this.recompensa = nuevaRecompensa;
    }

    public boolean estaMuerto() {
        return this.energia.estaMuerto();
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void atacar(Jugador jugador) {
        jugador.recibirAtaque(this.danio);
    }

}
