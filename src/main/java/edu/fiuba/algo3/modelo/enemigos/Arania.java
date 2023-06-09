package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.scorer.Scorer;
import edu.fiuba.algo3.modelo.creditos.RecompensaRandom;
import edu.fiuba.algo3.modelo.vida.Energia;

public class Arania extends Enemigo {

    private final int rango = 10;
    public Arania() {
        this.recompensa = new RecompensaRandom(this.rango);
        this.energia = new Energia(2);
        this.danio = new Energia(2);
        this.velocidad = 2;
    }

    public void agregarMuerto(Scorer score){
        score.agregarMuerto(this);
    }
}