package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.architecture.Mocks.RecompensaRandomMock;
import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

public class RecompensaRandomTest {
    @Test
    public void Test01RecompensaRandomDaLosCreditosCorrectos() {
        Jugador jugador = new Jugador(1, 0, "Vegeta");
        RecompensaRandomMock recompensaRandom = new RecompensaRandomMock();
        Creditos creditos = new Creditos(2);
        recompensaRandom.otorgarRecompensa(jugador);
        assert creditos.equals(jugador.getCreditos());
    }
}
