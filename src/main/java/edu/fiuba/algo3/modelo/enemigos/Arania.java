package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.RecompensaRandom;
import edu.fiuba.algo3.modelo.danio.DanioSimple;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class Arania extends Enemigo {

    public Arania() {
        super();
        int rango = 10;
        this.recompensa = new RecompensaRandom(rango);
        this.energia = new Energia(2);
        this.danio = new DanioSimple(2);
        this.velocidad = new Velocidad(2);
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    public String getNombre() {
        return "Arania";
    }
}