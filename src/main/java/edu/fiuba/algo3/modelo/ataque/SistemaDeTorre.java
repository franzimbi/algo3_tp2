package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SistemaDeTorre extends SistemaDeAtaque {

    public SistemaDeTorre(Energia danio, int rango) {
        this.rango = rango;
        this.danio = danio;
    }

    public void atacar(Enemigo enemigo, Jugador jugador) {
        enemigo.recibirDanio(this.danio, jugador);
    }
}
