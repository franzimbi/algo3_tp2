package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.danio.DanioSimple;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.creditos.RecompensaRandom;
import edu.fiuba.algo3.modelo.energia.Energia;

public class Arania extends Enemigo {

    private final int rango = 10;

    public Arania() {
        this.recompensa = new RecompensaRandom(this.rango);
        this.energia = new EnergiaRoja(2);
        this.danio = new DanioSimple(2);
        this.velocidad = 2;
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    public String getNombre() {
        return "Arania";
    }
}