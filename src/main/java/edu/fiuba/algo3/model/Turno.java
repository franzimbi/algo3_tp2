package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.enemy.Enemigo;
import edu.fiuba.algo3.model.map.Camino;
import edu.fiuba.algo3.model.map.Parcela;

public class Turno {
    private int numero;
    private Jugador jugador;
    private Camino camino;

    public void siguienteTurno(Parcela parcela, Enemigo nuevoEnemigo) {
        // primero atacan las defensas


        // despues se mueven los enemigos
        //camino.mover();

        // despues spawneo enemigo nuevo
        /*if (nuevoEnemigo != null){camino.spawnEnemigo(nuevoEnemigo);}*/
    }

}
