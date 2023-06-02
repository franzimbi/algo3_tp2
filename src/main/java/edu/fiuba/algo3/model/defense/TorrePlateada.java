package edu.fiuba.algo3.model.defense;

import edu.fiuba.algo3.model.Creditos;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.coste = new Creditos(20);
        this.danio = 2;
        this.turnosRestantes = 2;
        this.rango = 3;
    }

    public void atacar() {
    }
}
