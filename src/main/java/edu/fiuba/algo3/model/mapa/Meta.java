package edu.fiuba.algo3.model.mapa;


import edu.fiuba.algo3.model.jugador.Jugador;
import edu.fiuba.algo3.model.enemigos.Enemigo;

public class Meta extends Pasarela {

    public Meta(Coordenadas ubicacion ){
        super(ubicacion);
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        enemigo.atacar(jugador);
        return true;
    }
}

