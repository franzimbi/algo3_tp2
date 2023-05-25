package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void unJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20,100);

        assertEquals(jugador.obtenerVida(),20);

        assertEquals(jugador.obtenerCreditos(),100);

    }

    @Test
    public void messageGreetingDefaultLanguage() {

    }
}
