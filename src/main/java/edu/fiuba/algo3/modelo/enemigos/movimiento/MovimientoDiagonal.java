package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

import java.util.ArrayList;

public class MovimientoDiagonal implements Movimiento {


    private final ArrayList<Coordenadas> movimientos = new ArrayList<Coordenadas>();
    private boolean arranco = false;

    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Parcela actual, Jugador jugador, Mapa mapa) {
        if (movimientos.size() == 0 && !arranco) {
            Logger.getInstancia().info("un " + enemigo.getNombre() + " cambio su movimiento a diagonal.");
            lozanoAlgorithm(mapa, enemigo);
            this.arranco = true;
        }
        if (movimientos.size() == 0 && arranco) {
            Logger.getInstancia().info("una " + enemigo.getNombre() +
                    " ataco al jugador. vida restante: " + jugador.getVida());
            enemigo.atacar(jugador, 0);
            mapa.removerEnemigo(enemigo);
            return;
        }
        Coordenadas posicion = movimientos.get(0);
        for(int i=0; i< enemigo.getVelocidad(); i++){
            try {
                posicion =  movimientos.remove(0);
            }catch (IndexOutOfBoundsException ignored) {}
        }

        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
    }

    private void lozanoAlgorithm(Mapa mapa, Enemigo enemigo) {
        Coordenadas meta = mapa.getMeta();
        Coordenadas origen = enemigo.getUbicacion();

        Coordenadas coordenadasInicio = new Coordenadas(origen.getX(), origen.getY());
        Coordenadas coordenadasFin = new Coordenadas(meta.getX(), meta.getY());

        int x = coordenadasInicio.getX();
        int y = coordenadasInicio.getY();
        int xFin = coordenadasFin.getX();

        int dx = coordenadasFin.getX() - coordenadasInicio.getX();
        int dy = coordenadasFin.getY() - coordenadasInicio.getY();

        int variableDecision = 2 * dy - dx;

        int coordenadaEste = 2 * dy;
        int coordenadaNorEste = 2 * (dy - dx);

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

