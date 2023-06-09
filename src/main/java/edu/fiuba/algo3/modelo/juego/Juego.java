package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;

public class Juego {

    private final Jugador jugador;
    private final Mapa mapa;
    private final Turnos turnos;


    public Juego(Jugador jugador, Lector lector, String rutaMapa, String rutaTurnos) {
        this.jugador = jugador;
        this.mapa = lector.leerMapa(rutaMapa);
        this.turnos = lector.leerEnemigos(rutaTurnos);
        Logger.getInstancia().info("se creo un juego para el jugador:" +
                jugador.nombre() + " con un mapa de " + mapa.tamanoMapa() + " y "
                + turnos.cantidadTurnos() + "turnos");
    }

    public void turnoEnemigos() {
        this.mapa.mover(this.jugador);
        if (this.mapa.perdio(this.jugador)) {
            Logger.getInstancia().info("Jugador perdio!");
            return;
        }
        this.mapa.generarEnemigos(this.turnos, jugador);
    }

    public void agregarDefensa(Defensa defensa, Coordenadas coordenadas) {
        this.mapa.agregarDefensa(defensa, coordenadas, this.jugador);
    }

    public void pasarTurno() {
        this.mapa.defensasAtacar(this.jugador);
        this.turnoEnemigos();
        if (this.mapa.gano(this.jugador)) {
            Logger.getInstancia().info("Jugador gano!");
        }
    }

    public void juegoEmpezar() {
        this.turnoEnemigos();
    }

    public boolean gano() {
        return this.mapa.gano(jugador);
    }

    public boolean perdio() {
        return this.mapa.perdio(jugador);
    }

    public int tamanoMapa() {
        return this.mapa.tamanoMapa();
    }

    public int cantidadTurnos() { return this.turnos.cantidadTurnos();
    }

    public int cantidadEnemigos(int i) { return this.mapa.cantidadEnemigos(i);
    }
}
