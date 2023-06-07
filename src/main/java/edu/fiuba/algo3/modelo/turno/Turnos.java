package edu.fiuba.algo3.modelo.turno;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.TurnoInvalidoError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Camino;

import java.util.ArrayList;

public class Turnos {
    private final ArrayList<ArrayList<Enemigo>> oleadas;

    public Turnos() {
        this.oleadas = new ArrayList<>();
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

    public void generarEnemigos(Camino camino, Jugador jugador){
        if (oleadas.size() == 0){
            return;
        }
        ArrayList<Enemigo> enemigosDelTurno = this.oleadas.get(0);
        for (int i =0; i < enemigosDelTurno.size(); i++){
            camino.generarEnemigo(enemigosDelTurno.get(i),  jugador);
        }
        this.oleadas.remove(0);
        return;
    }
}

