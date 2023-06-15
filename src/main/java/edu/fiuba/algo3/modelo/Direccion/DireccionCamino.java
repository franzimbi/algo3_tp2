package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.velocidad.Velocidad;

public class DireccionCamino implements Direccion{
    @Override
    public void mover(Velocidad velocidad, Enemigo enemigo, Pasarela actual, Jugador jugador, Mapa mapa) {
        actual.siguientePasarela(velocidad, enemigo, jugador, mapa);
    }
}
