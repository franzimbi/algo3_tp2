package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;

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
        // muevo enemigos
        this.mapa.mover(this.jugador);

        if (this.mapa.perdio(this.jugador)) {
            //perdio. fin del juego
            System.out.println("Perdiste!");
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
            // gano. fin del juego
            System.out.println("Ganaste!");
            return;
        }
    }

    public void juegoEmpezar(){
        this.turnoEnemigos();
    }

    public boolean gano(){
        return this.mapa.gano(jugador);
    }

    public boolean perdio(){
        return this.mapa.perdio(jugador);
    }

}
