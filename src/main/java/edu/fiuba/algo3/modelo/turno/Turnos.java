package edu.fiuba.algo3.modelo.turno;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.TurnoInvalidoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Camino;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;

public class Turnos {
    private final ArrayList<ArrayList<Enemigo>> turnos;
    private int cantidadTurnos;
    private int siguienteTurno;

    public Turnos() {
        this.cantidadTurnos = 0;
        this.turnos = new ArrayList<>();
        this.siguienteTurno = 0;
    }

    public void agregarEnemigoATurno(int turno, Enemigo enemigo) {
        if (turno > this.cantidadTurnos || turno < 0) throw new TurnoInvalidoError();
        if (turno == this.cantidadTurnos) {
            ArrayList<Enemigo> aux = new ArrayList<>();
            this.cantidadTurnos++;
            this.turnos.add(aux);
        }
        ArrayList<Enemigo> enemigosDelTurno = this.turnos.get(turno);
        enemigosDelTurno.add(enemigo);
    }

    public boolean spawnearEnemigos(Camino camino, Jugador jugador){
        if (siguienteTurno >= cantidadTurnos){
            return false;
        }
        ArrayList<Enemigo> enemigosDelTurno = this.turnos.get(siguienteTurno);
        for (int i =0; i< enemigosDelTurno.size()-1;i++){
            camino.spawnEnemigo(enemigosDelTurno.get(i),  jugador);
        }
        return true;
    }
}

