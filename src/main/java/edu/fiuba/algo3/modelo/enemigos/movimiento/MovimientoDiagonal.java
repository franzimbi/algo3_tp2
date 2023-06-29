package edu.fiuba.algo3.modelo.enemigos.movimiento;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MovimientoDiagonal implements Movimiento {

    @Override
    public void mover(Enemigo enemigo, Jugador jugador, Mapa mapa) {
        Logger.getInstancia().info("un " + enemigo.getNombre() + " cambio su movimiento a diagonal.");
        Coordenadas posicion = lozanoAlgorithm(mapa, enemigo);

        if (enemigo.getUbicacion().equals(mapa.getMeta())) {
            Logger.getInstancia().info("una " + enemigo.getNombre() + " ataco al jugador. vida restante: " + jugador.getVida());
            enemigo.atacar(jugador, 0);
            enemigo.atacar(jugador, 0);
            mapa.removerEnemigo(enemigo);
            return;
        }

        mapa.dejarEnRango(posicion);
        enemigo.ubicarEn(posicion);
    }

    private Coordenadas lozanoAlgorithm(Mapa mapa, Enemigo enemigo) {
        Coordenadas meta = mapa.getMeta();
        Coordenadas origen = enemigo.getUbicacion();

        Coordenadas coordenadasInicio = new Coordenadas(origen.getX(), origen.getY());
        Coordenadas coordenadasFin = new Coordenadas(meta.getX(), meta.getY());

        int x = coordenadasInicio.getX();
        int y = coordenadasInicio.getY();

        int dx = coordenadasFin.getX() - coordenadasInicio.getX();
        int dy = coordenadasFin.getY() - coordenadasInicio.getY();

        int variableDecision = 2 * dy - dx;

        if (variableDecision > 0) {
            y++;
        }
        x++;
        return new Coordenadas(x, y);
    }
}


