package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefensaTest {
    @Test
    public void Test01DefensaDevuelveLatorreCorrecta() {
        Jugador jugador = Jugador.getInstancia();
        Defensa torreBlancaDevuelta = Defensa.construirDefensa("torre blanca");
        Defensa torrePlanteadaDevuelta = Defensa.construirDefensa("torre plateada");

        TorreBlanca torreBlanca = new TorreBlanca();
        TorrePlateada torrePlateada = new TorrePlateada();

        assertSame(torreBlancaDevuelta.getClass(), torreBlanca.getClass());
        assertSame(torrePlanteadaDevuelta.getClass(), torrePlateada.getClass());

        Jugador.reiniciar();
    }

    @Test
    public void Test02ConstruirTorreInexistenteLanzaExcepcion() {
        Jugador jugador = Jugador.getInstancia();
        assertThrows(DefensaNoExisteError.class, () -> Defensa.construirDefensa("torre de obsidiana"));
        Jugador.reiniciar();
    }
}
