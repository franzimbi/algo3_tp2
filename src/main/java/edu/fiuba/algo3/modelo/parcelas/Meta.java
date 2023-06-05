package edu.fiuba.algo3.modelo.parcelas;


import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class Meta extends Pasarela {

    public Meta(Coordenadas ubicacion ){
        super(ubicacion);
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        //enemigos.add(enemigo);
        enemigo.atacar(jugador);
        return true;
    }

}

