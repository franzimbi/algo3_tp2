package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;


public abstract class Defensa {
    protected SistemaDeAtaque armas;
    protected int turnosRestantes;
    protected Creditos coste;

    public boolean estaOperativa() {
        return this.turnosRestantes == 0;
    }

    public void atacarEnemigo(Enemigo enemigo, Jugador jugador) {
        if (this.estaOperativa()) {
            this.armas.atacar(enemigo,jugador);
            return;
        }
        this.turnosRestantes--;
    }

    public void sacarCreditos(Jugador jugador){
        jugador.sacarCreditos(this.coste);
    }


    public boolean estaEnRango(int distancia){
        return this.armas.estaEnRango(distancia);
    }

}
