package edu.fiuba.algo3.unitTest.Mocks;

import edu.fiuba.algo3.modelo.enemigos.recompensa.Recompensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaRandomMock implements Recompensa {

        private static final int rango = 1;

        @Override
        public void otorgarRecompensa(Jugador jugador) {
            jugador.recibirCreditos(rango);
        }

    public void duplicarRecompensa(){}


}
