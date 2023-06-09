package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.creditos.RecompensaSimple;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

public class RecompensaSimpleTest {
    @Test
    public void Test01RecompensaSimpleDaLaCantidadCorrectaDeCreditos() {
        RecompensaSimple recompensa = new RecompensaSimple();
        Jugador jugador = new Jugador(1, 0, "Goku");
        recompensa.otorgarRecompensa(jugador);
        Creditos creditos = new Creditos(1);
        assert creditos.equals(jugador.getCreditos());
    }
}
