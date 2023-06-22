package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.recompensa.RecompensaSimple;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.DanioSimple;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.score.Score;

public class Hormiga extends Enemigo {

    public Hormiga() {
        super();
        int recompensaBase = 1;
        this.recompensa = new RecompensaSimple(recompensaBase);
        this.energia = 1;
        this.danio = new DanioSimple(1);
        this.velocidad = new Velocidad(1);
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

    public void cambiarRecompensa() {
        this.recompensa.duplicarRecompensa();
    }

    public String getNombre() {
        return "Hormiga";
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
