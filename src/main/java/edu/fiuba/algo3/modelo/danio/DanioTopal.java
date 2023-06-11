package edu.fiuba.algo3.modelo.danio;

import edu.fiuba.algo3.modelo.energia.Energia;
import edu.fiuba.algo3.modelo.energia.EnergiaAzul;
import edu.fiuba.algo3.modelo.energia.EnergiaRoja;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class DanioTopal extends Danio {
    public final Energia impar;

    public DanioTopal(int par, int impar) {
        this.energia = new EnergiaRoja(par);
        this.impar = new EnergiaRoja(impar);
    }

    @Override
    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        if (cantidadDeTurnos / 2 == 1) {
            jugador.recibirAtaque(this.impar);
        } else {
            jugador.recibirAtaque(this.energia);
        }
    }
}
