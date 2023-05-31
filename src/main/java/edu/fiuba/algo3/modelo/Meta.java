package edu.fiuba.algo3.modelo;


public class Meta extends Pasarela {

    public Meta(Coordenadas ubicacion ){
        super(ubicacion);
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        enemigo.atacar(jugador);
        return true;
    }
}

