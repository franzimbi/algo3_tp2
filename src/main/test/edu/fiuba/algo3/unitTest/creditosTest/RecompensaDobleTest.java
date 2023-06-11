package edu.fiuba.algo3.unitTest.creditosTest;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.RecompensaDoble;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

public class RecompensaDobleTest {
    @Test
    public void Test01RecompensaDobleDaLaCantidadCorrecta() {
        int base = 1;
        RecompensaDoble recompensa = new RecompensaDoble(base);
        Jugador jugador = new Jugador(1, 0, "Gohan");
        recompensa.otorgarRecompensa(jugador);
        Creditos creditos = new Creditos(2);
        assert creditos.equals(jugador.getCreditos());
    }
}
