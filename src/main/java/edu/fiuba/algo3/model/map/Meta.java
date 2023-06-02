package edu.fiuba.algo3.model.map;


import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.enemy.Enemigo;

public class Meta extends Pasarela {

    public Meta(Coordenadas ubicacion ){
        super(ubicacion);
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        enemigo.atacar(jugador);
        return true;
    }
}

