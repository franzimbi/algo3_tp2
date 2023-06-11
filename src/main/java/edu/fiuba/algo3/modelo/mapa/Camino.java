package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;

import java.util.ArrayList;

public class Camino {
    private final ArrayList<Pasarela> pasarelas;

    public Camino() {
        this.pasarelas = new ArrayList<>();
    }

    public void atacar(Parcela parcela, Jugador jugador) {
        Pasarela pasarelaCercana = pasarelas.get(0);
        int distanciaMinima = parcela.distancia(pasarelaCercana);

        for (int i = 1; i < pasarelas.size(); i++) {
            Pasarela pasarelaActual = pasarelas.get(i);
            int distanciaActual = parcela.distancia(pasarelaActual);
            if (!pasarelaActual.estaVacia()) {
                if (distanciaMinima > distanciaActual) {
                    pasarelaCercana = pasarelaActual;
                    distanciaMinima = distanciaActual;
                }
            }
        }
        parcela.defensaAtacar(pasarelaCercana, jugador);
    }

    public void agregarPasarela(Pasarela pasarela) {
        this.pasarelas.add(pasarela);
    }

    public void mover(Jugador jugador, int cantidadDeTurnos) {
        for (int i = pasarelas.size() - 1; i >= 0; i--) {
            pasarelas.get(i).mover(this, jugador, cantidadDeTurnos);
        }
    }

    public void generarEnemigo(Enemigo enemigo, Jugador jugador) {
        this.pasarelas.get(0).ubicar(enemigo, jugador);
    }

    public void moverEnemigo(Enemigo enemigo, Pasarela pasarela, Jugador jugador, int cantidadDeTurnos) {
        int aux = pasarelas.indexOf(pasarela) + enemigo.getVelocidad();
        if (aux >= pasarelas.size() - 1) {
            Logger.getInstancia().info("Se movio un " + enemigo.getNombre() +
                    " a (" + pasarelas.get(pasarelas.size() - 1).ubicacion().getX() + "," +
                    pasarelas.get(pasarelas.size() - 1).ubicacion().getY() + ")");
            Logger.getInstancia().info(enemigo.getNombre() +
                    " ataco al jugador. vida restante: " + jugador.getVida().getCantidad());
            enemigo.atacar(jugador, cantidadDeTurnos);
            return;
        }
        Logger.getInstancia().info("Se movio un " + enemigo.getNombre() +
                " a (" + pasarelas.get(aux).ubicacion().getX() + "," +
                pasarelas.get(aux).ubicacion().getY() + ")");
        pasarelas.get(aux).ubicar(enemigo, jugador);
        enemigo.actualizarMovimientos();
        enemigo.restaurarVelocidad();
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

    public int cantidadEnemigos(int posPasarela) {
        return this.pasarelas.get(posPasarela).cantidadEnemigos();
    }
}
