package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.danio.DanioLechuzal;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.score.Score;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class Lechuza extends Enemigo {
    //TODO: implementar lechuza

    public Lechuza() {
        super();
        this.recompensa = new RecompensaSimple(0);
        this.energia = new EnergiaRoja(5);
        this.danio = new DanioLechuzal();
        this.velocidad = new Velocidad(5);
    }

    public String getNombre() {
        return "Lechuza";
    }

    @Override
    public void reducirVelocidad(float multiplicador) {
    }

    @Override
    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        jugador.destruirPrimeraDefensa();
    }

    public void agregarMuerto(Score score) {
        score.agregarMuerto(this);
    }

}
