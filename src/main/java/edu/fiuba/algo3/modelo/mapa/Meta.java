package edu.fiuba.algo3.modelo.mapa;


import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;

public class Meta extends Pasarela {

    public Meta(Coordenadas ubicacion ){
        super(ubicacion);
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        enemigo.atacar(jugador);
        return true;
    }
}

