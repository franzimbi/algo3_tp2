package edu.fiuba.algo3.modelo.turno;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.TurnoInvalidoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;

public class Turnos {
    private final ArrayList<ArrayList<Enemigo>> oleadas;
    private int cantidadDeTurnos;

    public Turnos() {
        this.oleadas = new ArrayList<>();
        this.cantidadDeTurnos = 0;
    }

    public void agregarEnemigoATurno(int turno, Enemigo enemigo) {
        if (turno > oleadas.size() || turno < 0) throw new TurnoInvalidoError();
        if (turno == oleadas.size()) {
            ArrayList<Enemigo> aux = new ArrayList<>();
            this.oleadas.add(aux);
        }
        ArrayList<Enemigo> enemigosDelTurno = this.oleadas.get(turno);
        enemigosDelTurno.add(enemigo);
    }

    public void generarEnemigos(Mapa mapa) {
        if (oleadas.size() == 0) {
            Logger.getInstancia().info("no se spawnearon mas enemigos porque no hay mas oleadas");
            return;
        }
        ArrayList<Enemigo> enemigosDelTurno = this.oleadas.get(0);
        for (Enemigo enemigo : enemigosDelTurno) {
            mapa.spawnear(enemigo);
            Logger.getInstancia().info("se agrego un " + enemigo.getNombre() + " al camino");
        }
        this.oleadas.remove(0);
    }
    public int cantidadOleadas() {
        return this.oleadas.size();
    }

    public void sumarTurnos() {
        this.cantidadDeTurnos++;
    }

    public void moverEnemigos(Jugador jugador, Mapa mapa) {
        mapa.mover(jugador);
    }
    public int getCantidadDeTurnos() {
        return this.cantidadDeTurnos;
    }
}

