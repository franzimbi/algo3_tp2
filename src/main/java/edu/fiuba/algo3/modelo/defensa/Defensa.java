package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;


public abstract class Defensa {
    protected SistemaDeAtaque armas;
    protected int rango;
    protected int turnosRestantes;
    protected Creditos coste;

    public boolean estaOperativa() {
        return this.turnosRestantes == 0;
    }

    public void atacar() {
        if (this.estaOperativa()) {
            return;
        }
        this.turnosRestantes--;
    }

    public Creditos costo(){
        return this.coste;
    }
    public int rangoMaximo() {
        return rango;
    }

    public Creditos coste() {
        return this.coste;
    }
}
