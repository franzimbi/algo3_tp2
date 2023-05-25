package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01Entrega1 {
    @Test
    public void unJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20,100);

        assertEquals(jugador.obtenerVida(),20);

        assertEquals(jugador.obtenerCreditos(),100);

    }
}
