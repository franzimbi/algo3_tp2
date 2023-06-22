package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.recompensa.RecompensaRandom;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioSimple;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.score.Score;

public class Arania extends Enemigo {

    public Arania() {
        super();
        int rango = 10;
        this.recompensa = new RecompensaRandom(rango);
        this.energia = 2;
        this.danio = new DanioSimple(2);
        this.velocidad = new Velocidad(2);
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    public String getNombre() {
        return "Arania";
    }

    public void atacarEnemigo(TorreBlanca torre) {
        torre.atacarEnemigo(this);
    }

    public void atacarEnemigo(TorrePlateada torrePlateada) {
        torrePlateada.atacarEnemigo(this);
    }

    public void atacarEnemigo(TrampaArenosa trampaArenosa) {
        trampaArenosa.atacarEnemigo(this);
    }
}