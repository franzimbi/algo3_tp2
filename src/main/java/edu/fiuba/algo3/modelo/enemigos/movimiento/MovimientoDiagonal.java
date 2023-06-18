package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.turno.Turnos;

import java.util.ArrayList;

public class MovimientoDiagonal implements Movimiento {


    private ArrayList<Coordenadas> movimientos = new ArrayList<Coordenadas>();


    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa){
        if (movimientos.size() == 0) {
            bresenghamAlgorithm(mapa, enemigo);
        }

//        for (Coordenadas coord : movimientos) {
//            System.out.printf("x = %d, y = %d \n", coord.getX(), coord.getY());
//        }

        Coordenadas posicion = movimientos.get(0);
        movimientos.remove(0);

        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
    }

    private void bresenghamAlgorithm(Mapa mapa, Enemigo enemigo) {
        Coordenadas meta = mapa.getMeta();
        Coordenadas origen = enemigo.getUbicacion();

        Coordenadas coordenadasInicio = new Coordenadas(origen.getX(), origen.getY());
        Coordenadas coordenadasFin = new Coordenadas(meta.getX(), meta.getY());

        int x = coordenadasInicio.getX();
        int y = coordenadasInicio.getY();
        int xFin = coordenadasFin.getX();

        int dx = coordenadasFin.getX() - coordenadasInicio.getX();
        int dy = coordenadasFin.getY() - coordenadasInicio.getY();

        int variableDecision = 2*dy - dx;

        int coordenadaEste = 2*dy;
        int coordenadaNorEste = 2*(dy - dx);

        while (x != xFin) {
            if (variableDecision <= 0) {
                variableDecision += coordenadaEste;
            } else {
                y++;
                variableDecision += coordenadaNorEste;
            }
            x++;
            movimientos.add(new Coordenadas(x, y));
        }
    }
}

