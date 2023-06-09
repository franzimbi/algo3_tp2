package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SistemaDeArena extends SistemaDeAtaque {
    public SistemaDeArena(Energia danio, int rango) {
        this.rango = rango;
        this.danio = danio;
    }

    public void atacar(Enemigo enemigo, Jugador jugador) {
        //hay que que tocar la clase velocidad dentro del enemigo
    }
}
