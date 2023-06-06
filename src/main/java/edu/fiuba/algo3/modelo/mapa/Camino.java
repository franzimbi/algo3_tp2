package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;

import java.util.ArrayList;

public class Camino {
    private final ArrayList<Pasarela> pasarelas;

    public Camino(Pasarela meta) {
        this.pasarelas = new ArrayList<>();
        this.pasarelas.add(meta);
    }

    public void atacar(Tierra tierra, Jugador jugador) {
        Pasarela pasarelaCercana = pasarelas.get(0);
        int distanciaMinima = tierra.distancia(pasarelaCercana);

        for (int i = 1; i < pasarelas.size(); i++) {
            Pasarela pasarelaActual = pasarelas.get(i);
            int distanciaActual = tierra.distancia(pasarelaActual);
            if (!pasarelaActual.estaVacia()) {
                if (distanciaMinima > distanciaActual) {
                    pasarelaCercana = pasarelaActual;
                    distanciaMinima = distanciaActual;
                }
            }
        }
        tierra.atacar(pasarelaCercana, jugador);
    }

    public void agregarPasarela(Pasarela pasarela) {
        this.pasarelas.add(this.pasarelas.size()-1,pasarela);
    }

    // a cada pasarela de atras para adelante le envia el mensaje de mover
    public void mover(Jugador jugador) {
        for (int i = pasarelas.size() - 1; i >= 0; i--) {
            pasarelas.get(i).mover(this, jugador);
        }
    }

    // agrega un nuevo enemigo a la posicion de inicio
    public void spawnEnemigo(Enemigo enemigo, Jugador jugador) {
        this.pasarelas.get(0).ubicar(enemigo,jugador);
    }

    //devuelve la pasarela a la q tiene q moverse dependiendo de su ubicacion y velocidad


    public void moverEnemigo(Enemigo enemigo, Pasarela pasarela, Jugador jugador) {
        int aux = pasarelas.indexOf(pasarela) + enemigo.getVelocidad();
        if (aux >= pasarelas.size()) {
            this.pasarelas.get(this.pasarelas.size()-1).ubicar(enemigo, jugador);
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
