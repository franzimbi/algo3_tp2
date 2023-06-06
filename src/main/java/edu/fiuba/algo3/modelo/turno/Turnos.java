package edu.fiuba.algo3.modelo.turno;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.TurnoInvalidoError;
import edu.fiuba.algo3.modelo.mapa.Camino;

import java.util.ArrayList;

public class Turnos {
    private final ArrayList<ArrayList<Enemigo>> turnos;
    private int cantidadTurnos;
    private final int siguienteTurno;

    public Turnos() {
        this.cantidadTurnos = 0;
        this.siguienteTurno = 0;
        this.turnos = new ArrayList<>();
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

    private void pasarTurno(Camino camino){
        if (siguienteTurno >= cantidadTurnos){

        }
    }
}

