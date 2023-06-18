package edu.fiuba.algo3.modelo.mapa.parcelas;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.excepciones.LlegoAMetaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.direcciones.Direccion;

public class Meta extends Pasarela{

    public Meta(Coordenadas ubicacion) {
        super(ubicacion);
    }
    @Override
    public void setSiguiente(Direccion siguiente) {}
    @Override
    public void moverASiguiente(Enemigo enemigo, Jugador jugador, Mapa mapa){
        enemigo.atacar(jugador, 0);
        mapa.removerEnemigo(enemigo);
        Logger.getInstancia().info(enemigo.getNombre()
                + " llego a la meta. jugador quedo con " + jugador.getVida() + " de vida");
        throw new LlegoAMetaException();
    }
}
