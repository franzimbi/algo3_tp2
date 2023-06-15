package edu.fiuba.algo3.modelo.ataque;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;

public class SistemaDeTorre extends SistemaDeAtaque {

    public SistemaDeTorre(Energia danio, int rango) {
        this.rango = rango;
        this.danio = danio;
    }

    public void atacar(Enemigo enemigo, int distancia){
        if (this.estaEnRango(distancia)) {
            Logger.getInstancia().info("un " + enemigo.getNombre() + " recibe el daño");
            enemigo.recibirDanio(this.danio);
            return;
        }
        Logger.getInstancia().info(  enemigo.getNombre() + " no estaba en rango");
        }

}
