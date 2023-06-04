package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.vida.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SistemaDeAtaque {
    protected Energia danio;

    public SistemaDeAtaque(Energia danio){
        this.danio = danio;
    }

    public void atacar (Enemigo enemigo, Jugador jugador){
        enemigo.recibirDanio(this.danio,jugador);
    }

}
