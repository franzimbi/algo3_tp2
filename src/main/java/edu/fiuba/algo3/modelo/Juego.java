package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;

import java.util.ArrayList;

public class Juego {

    private Jugador jugador;
    private Mapa mapa;
    private Camino camino;
    private Turnos turnos;

    public Juego(){

    }
    // esta clase es la estructura simplificada implementada a traves del patron de diseño Facade.
    // https://refactoring.guru/es/design-patterns/facade
    public void jugar(Jugador jugador, Mapa mapa, Camino camino, Turnos turnos){
        this.jugador = jugador;
        this.mapa = mapa;
        this.turnos = turnos;
        this.camino = camino;
    }
    public void terminarTurno(){
        if(!this.turnos.spawnearEnemigos(this.camino, this.jugador)){
            // no hay mas turnos. sigue el juego hasta q el camino quede vacio o muera jugador
            if(!this.camino.tieneEnemigos() && !this.jugador.estaMuerto()){
                // ganó
            }
        }
        // muevo enemigos
        this.camino.mover(this.jugador);
        // que ataquen todas las torres una vez
    }
    public void agregarDefensa(Defensa defensa, Coordenadas coordenadas){
        this.mapa.agregarDefensa(defensa, coordenadas, this.jugador);

        }
    }

}
