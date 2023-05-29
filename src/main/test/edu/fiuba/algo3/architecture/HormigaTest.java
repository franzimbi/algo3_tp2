package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Hormiga;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HormigaTest {

    @Test
    public void Test01HormigaSeIniciaEnUnEstadoValido() {
        Hormiga hormiga = new Hormiga();
        assertFalse(hormiga.estaMuerto());
        assertEquals(1, hormiga.Vida());
    }

    @Test
    public void Test2HormigaAlRecibirDanioSeDestruye() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(20, 100);
        hormiga.recibirDanio(1, jugador);

        assertTrue(hormiga.estaMuerto());
        Hormiga.reiniciar();
    }

    @Test
    public void Test03HormigaAlRecirDanioPierdeVida() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(20, 100);
        hormiga.recibirDanio(1, jugador);

        assertEquals(0, hormiga.Vida());
        Hormiga.reiniciar();
    }

}
