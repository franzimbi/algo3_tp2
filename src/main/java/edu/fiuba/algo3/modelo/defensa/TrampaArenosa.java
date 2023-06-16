package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.defensa.sistemaDeDefensa.SistemaDeArena;

public class TrampaArenosa extends Defensa {

    public TrampaArenosa() {
        super();
        this.coste = 25;
        this.armas = new SistemaDeArena(0, 0, 0.5f);
        this.turnosRestantes = 0;
        this.vidaUtil = 3;
    }

    public String getNombre() {
        return "Trampa de arena";
    }
}
