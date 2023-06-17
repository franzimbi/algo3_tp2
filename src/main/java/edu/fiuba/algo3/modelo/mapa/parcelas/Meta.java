package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class Meta extends Pasarela{

    public Meta(Coordenadas ubicacion) {
        super(ubicacion);
        this.siguiente = null;
    }
    @Override
    public void setSiguiente(Pasarela siguiente) {}
    @Override
    public void siguientePasarela(Velocidad velocidad, Enemigo enemigo, Jugador jugador, Mapa mapa){
        enemigo.atacar(jugador, 0);
        Logger.getInstancia().info(enemigo.getNombre()
                + " llego al jugador, este quedo con " + jugador.getVida() + " de vida");
        mapa.removerEnemigo(enemigo);
    }
}
