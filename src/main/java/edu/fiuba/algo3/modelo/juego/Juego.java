package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.turno.Turnos;

import java.util.ArrayList;

public class Juego {

    private final Jugador jugador;
    private final Mapa mapa;
    private final Turnos turnos;
    private Boolean empezo = false;

    public Juego(Jugador jugador, Lector lector, String rutaMapa, String rutaTurnos) {
        this.jugador = jugador;
        this.mapa = lector.leerMapa(rutaMapa);
        this.turnos = lector.leerEnemigos(rutaTurnos);
        Logger.getInstancia().info("se creo un juego para el jugador: \"" +
                jugador.nombre() + "\" con un mapa de tamanio " + mapa.size() + " y "
                + turnos.cantidadOleadas() + " oleadas");
    }

    public void turnoEnemigos() {
        this.turnos.moverEnemigos(this.jugador, mapa);
        if (this.perdio()) {
            Logger.getInstancia().info("Jugador perdio!");
            return;
        }
        this.turnos.generarEnemigos(this.mapa);
        turnos.sumarTurnos();
    }

    public void agregarDefensa(Defensa defensa, Coordenadas coordenadas) {
        this.mapa.ubicar(defensa, coordenadas, this.jugador);
    }

    public void pasarTurno() {
        this.empezo = true;
        Logger.getInstancia().info("\nNUEVO TURNO:\n\n");
        this.jugador.atacarEnemigos(this.mapa);
        this.jugador.recolectarDefensas();
        this.mapa.recolectarEnemigos(this.jugador);
        this.turnoEnemigos();
        if (this.gano()) {
            Logger.getInstancia().info("Jugador gano!");
        }
    }

    public void juegoEmpezar() {
        this.turnoEnemigos();
    }

    public boolean empezo() {
        return this.empezo;
    }

    public boolean gano() {
        return this.mapa.sinEnemigos() && !this.jugador.estaMuerto();
    }

    public boolean perdio() {
        return this.jugador.estaMuerto();
    }

    public int tamanoMapa() {
        return this.mapa.size();
    }

    public int cantidadDeOleadas() {
        return this.turnos.cantidadOleadas();
    }

    public int cantidadEnemigos() {
        return this.mapa.cantidadEnemigos();
    }

    public ArrayList<Parcela> getParcelasMapa() {
        return this.mapa.getParcelas();
    }

    public ArrayList<Enemigo> getEnemigosMapa() {
        return this.mapa.getEnemigos();
    }

    public ArrayList<Defensa> getDefensasJugador() {
        return this.jugador.getDefensas();
    }

    public int vidaJugador() {
        return this.jugador.getVida();
    }

    public int creditosJugador() {
        return this.jugador.getCreditos();
    }

    public int cantidadDeTurnos() {
        return this.turnos.getCantidadDeTurnos();
    }
}
