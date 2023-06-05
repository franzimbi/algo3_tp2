package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.vida.Energia;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.coste = new Creditos(20);
        this.armas = new SistemaDeAtaque(new Energia(2),5);
        this.turnosRestantes = 2;
    }

    public void atacar() {
    }
}