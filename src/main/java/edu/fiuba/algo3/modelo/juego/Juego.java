package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;

public class Juego {

    private final Jugador jugador;
    private final Mapa mapa; //mapa tiene un camino.
    private final Turnos turnos;

    public Juego(Jugador jugador, Mapa mapa, Turnos turnos) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.turnos = turnos;
    }

    public void turnoEnemigos() {
        this.mapa.mover(this.jugador);

        if (this.mapa.perdio(this.jugador)) {
            System.out.println("Perdiste!");
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
            System.out.println("Ganaste!");
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

}
