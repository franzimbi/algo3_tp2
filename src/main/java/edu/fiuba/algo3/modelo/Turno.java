package edu.fiuba.algo3.modelo;

public class Turno {
    private int numero;
    private Jugador jugador;
    private Camino camino;

    public void siguienteTurno(Parcela parcela, Enemigo nuevoEnemigo) {
        // primero atacan las defensas


        // despues se mueven los enemigos
        camino.mover();

        // despues spawneo enemigo nuevo
        if (nuevoEnemigo != null){camino.spawnEnemigo(nuevoEnemigo);}
    }

}
