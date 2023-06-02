package edu.fiuba.algo3.model.defensa;

import edu.fiuba.algo3.model.creditos.Creditos;
import edu.fiuba.algo3.model.vida.Vida;

public abstract class Defensa {
    protected Vida danio;
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

    public int rangoMaximo() {
        return rango;
    }

    public Vida danioGenerado() {
        return danio;
    }

    public Creditos coste() {
        return this.coste;
    }
}
