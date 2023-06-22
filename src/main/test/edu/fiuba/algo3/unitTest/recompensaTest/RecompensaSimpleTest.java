package edu.fiuba.algo3.unitTest.recompensaTest;

import edu.fiuba.algo3.modelo.enemigos.recompensa.RecompensaSimple;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecompensaSimpleTest {
    @Test
    public void Test01RecompensaSimpleDaLaCantidadCorrectaDeCreditos() {
        int base = 1;
        RecompensaSimple recompensa = new RecompensaSimple(base);
        Jugador jugador = new Jugador(1, 0, "Goku");
        recompensa.otorgarRecompensa(jugador);
        assertEquals(1, jugador.getCreditos());
    }

}
