package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Defensa;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    @Test
    public void Test01UnJugadorComienzaEnUnEstadoValido() {
        Jugador jugador = new Jugador(20,100);

        assertEquals(jugador.obtenerVida(),20);

        assertEquals(jugador.obtenerCreditos(),100);
    }

    @Test
    public void Test02UnaDefensaSeConstruyeEnElTiempoCorrecto(){
        Defensa defensa = Defensa.construirDefensa("torre blanca");

        assertFalse(defensa.estaOperativa());

        defensa.construir();

        assertTrue(defensa.estaOperativa());
    }
}
