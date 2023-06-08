package edu.fiuba.algo3.modelo.parcelas;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;

public class Pasarela extends Parcela {
    protected ArrayList<Enemigo> enemigos = new ArrayList<>();

    public Pasarela(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador) {
        enemigos.add(enemigo);
        return true;
    }

    /* nunca se usa
    public Coordenadas ubicacion() {
        return this.ubicacion;
    }*/

    public void recibirAtaqueDe(Defensa defensa, Jugador jugador) {
        if (enemigos.isEmpty()) {
            return;
        }
        Enemigo primerEnemigo = enemigos.get(0);
        defensa.atacarEnemigo(primerEnemigo, jugador);
        if (primerEnemigo.estaMuerto()) {
            jugador.recibirMuerto(primerEnemigo);
            enemigos.remove(primerEnemigo);
        }
    }

    public void mover(Camino camino, Jugador jugador) {
        int tam = enemigos.size();

        for (int i = 0; i < tam; i++) {
            Enemigo actual = enemigos.remove(0);
            camino.moverEnemigo(actual, this, jugador);
        }
    }

    public boolean estaVacia() {
        return this.enemigos.isEmpty();
    }

    public int cantidadEnemigos() {
        return this.enemigos.size();
    }
}