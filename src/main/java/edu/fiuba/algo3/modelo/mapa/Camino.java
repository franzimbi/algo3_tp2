package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;

import java.util.ArrayList;

public class Camino {
    private final ArrayList<Pasarela> pasarelas;

    public Camino() {
        this.pasarelas = new ArrayList<>();
    }

    public void atacar(Tierra tierra, Jugador jugador) {
        for (int i = pasarelas.size() - 1; i >= 0; i--) {
            Pasarela pasarelaActual = pasarelas.get(i);
            tierra.atacar(pasarelaActual, jugador);
        }
    }

    public void agregarPasarela(Pasarela pasarela) {
        this.pasarelas.add(pasarela);
    }

    public void mover(Jugador jugador) {
        for (int i = pasarelas.size() - 1; i >= 0; i--) {
            pasarelas.get(i).mover(this, jugador);
        }
    }

    public void generarEnemigo(Enemigo enemigo, Jugador jugador) {
        this.pasarelas.get(0).ubicar(enemigo, jugador);
    }

    public void moverEnemigo(Enemigo enemigo, Pasarela pasarela, Jugador jugador) {
        int aux = pasarelas.indexOf(pasarela) + enemigo.getVelocidad();
        if (aux >= pasarelas.size() - 1) {
            enemigo.atacar(jugador);
            return;
        }
        pasarelas.get(aux).ubicar(enemigo, jugador);
    }

    public boolean tieneEnemigos() {
        for (Pasarela pasarela : this.pasarelas) {
            if (!pasarela.estaVacia()) {
                return true;
            }
        }
        return false;
    }

    public boolean gano(Jugador jugador) {
        return (!tieneEnemigos() && !jugador.estaMuerto());
    }

    public boolean perdio(Jugador jugador) {
        return jugador.estaMuerto();
    }
}
