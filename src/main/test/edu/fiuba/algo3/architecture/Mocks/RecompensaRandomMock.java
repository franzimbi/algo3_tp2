package edu.fiuba.algo3.architecture.Mocks;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.Recompensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RecompensaRandomMock implements Recompensa {

        private static final int rango = 1;

        @Override
        public void otorgarRecompensa(Jugador jugador) {
            jugador.recibirCreditos(new Creditos(rango));
        }

}
