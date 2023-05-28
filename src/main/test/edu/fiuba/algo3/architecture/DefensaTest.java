package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefensaTest {
    @Test
    public void Test01DefensaDevuelveLatorreCorrecta() {
        Jugador jugador = new Jugador(20, 100);
        Defensa torreBlancaDevuelta = Defensa.construirDefensa("torre blanca", jugador);
        Defensa torrePlanteadaDevuelta = Defensa.construirDefensa("torre plateada", jugador);

        TorreBlanca torreBlanca = new TorreBlanca();
        TorrePlateada torrePlateada = new TorrePlateada();

        assertSame(torreBlancaDevuelta.getClass(), torreBlanca.getClass());
        assertSame(torrePlanteadaDevuelta.getClass(), torrePlateada.getClass());
    }

    @Test
    public void Test02ConstruirTorreInexistenteLanzaExcepcion() {
        Jugador jugador = new Jugador(20, 100);
        assertThrows(DefensaNoExisteError.class, () -> Defensa.construirDefensa("torre de obsidiana", jugador));
    }
}
