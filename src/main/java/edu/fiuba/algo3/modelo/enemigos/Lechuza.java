package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.danio.DanioLechuzal;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Lechuza extends Enemigo {
    //TODO: implementar lechuza

    public Lechuza() {
        this.recompensa = new RecompensaSimple(10);
        this.energia = new EnergiaRoja(5);
        this.danio = new DanioLechuzal();
        this.velocidad = 5;
    }

    public String getNombre(){
        return "Lechuza";
    }

    @Override
    public void atacar(Jugador jugador, int cantidadDeTurnos){
        jugador.destruirPrimeraDefensa();
    }
}
