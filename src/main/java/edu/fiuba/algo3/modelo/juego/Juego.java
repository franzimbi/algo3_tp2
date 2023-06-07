package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;

import java.util.ArrayList;

public class Juego {

    private final Jugador jugador;
    private final Mapa mapa; //mapa tiene q tener un camino.
    private final Turnos turnos;

    // esta clase es la estructura simplificada implementada a traves del patron de diseño Facade.
    // https://refactoring.guru/es/design-patterns/facade
    public Juego(Jugador jugador, Mapa mapa, Turnos turnos) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.turnos = turnos;
    }

    public void turnoEnemigos() {
        if (!this.turnos.spawnearEnemigos(this.mapa.camino(), this.jugador)) {
            // no hay mas turnos. sigue el juego hasta q el camino quede vacio o muera jugador
            if (this.mapa.camino().gano(this.jugador)) {
                // gano. fin del juego
                System.out.println("Ganaste!");
                return;
            }
        }

        // muevo enemigos
        this.mapa.camino().mover(this.jugador);

        if (this.mapa.camino().perdio(this.jugador)) {
            //perdio. fin del juego
            System.out.println("Perdiste!");
        }
    }

    public void agregarDefensa(Defensa defensa, Coordenadas coordenadas) {
        this.mapa.agregarDefensa(defensa, coordenadas, this.jugador);
    }

    public void pasarTurno() {
        this.mapa.defensasAtacar(this.jugador);
    }

}
