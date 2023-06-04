package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;

import java.util.ArrayList;

public class Pasarela extends Parcela {
    protected ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();

    public Pasarela(Coordenadas ubicacion){this.ubicacion = ubicacion;}

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        enemigos.add(enemigo);
        return true;
    }

    public void atacado(Defensa defensa, Jugador jugador) {
        Enemigo primerEnemigo = enemigos.get(0);
        defensa.atacarEnemigo(primerEnemigo,jugador);
        if (primerEnemigo.estaMuerto()){
            enemigos.remove(primerEnemigo);
        }
    }

    public void mover(Camino camino,Jugador jugador){
        int tam = enemigos.size();

        for (int i = 0; i < tam; i++) {
            Enemigo actual = enemigos.remove(0);
            camino.moverEnemigo(actual, this,jugador);
        }
    }

    public boolean estaVacia(){
        return this.enemigos.isEmpty();
    }

}