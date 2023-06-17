package edu.fiuba.algo3.unitTest.recompensaTest;

import edu.fiuba.algo3.unitTest.Mocks.RecompensaRandomMock;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecompensaRandomTest {
    @Test
    public void Test01RecompensaRandomDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(1, 0, "Vegeta");
        RecompensaRandomMock recompensaRandom = new RecompensaRandomMock();

        recompensaRandom.otorgarRecompensa(jugador);

        assertEquals(1, jugador.getCreditos());
    }
}
