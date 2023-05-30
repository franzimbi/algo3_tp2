package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AraniaTest {
    @Test
    public void Test01UnaAraniaComienzaEnUnEstadoValido() {
        Arania arania = new Arania();

        assertEquals(arania.Vida(), 2);
    }

    @Test
    public void Test02UnaAraniaRecibeElDanioCorrecto() {
        Jugador jugador = Jugador.getInstancia();

        Arania arania = new Arania();

        arania.recibirDanio(1);
        assertEquals(arania.Vida(), 1);
        Jugador.reiniciar();
    }

    @Test
    public void Test03UnaAraniaDaCreditosEnUnRangoCorrecto(){
        Jugador jugador = Jugador.getInstancia();
        Arania arania = new Arania();

        arania.recibirDanio(2);
        int creditos = jugador.getCreditos();
        assertTrue(creditos >= 100 && creditos <= 110);
    }
}
