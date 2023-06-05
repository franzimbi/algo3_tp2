package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vida.Energia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HormigaTest {
    @Test
    public void Test01HormigaSeIniciaEnUnEstadoValido() {
        Hormiga hormiga = new Hormiga();
        assertFalse(hormiga.estaMuerto());
        assertEquals(1, hormiga.getVelocidad());

    }
    @Test
    public void Test2HormigaAlRecibirDanioSeDestruye() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10, 100, "Juli");
        Energia danio = new Energia(1);
        hormiga.recibirDanio(danio, jugador);
        assertTrue(hormiga.estaMuerto());
    }

    @Test
    public void Test03HormigaDaCreditosCorrectos() {
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10,10,"juli2");
        Energia danio = new Energia(1);
        hormiga.recibirDanio(danio, jugador);
        Creditos creditos = new Creditos(11);
        assertTrue(creditos.equals(jugador.getCreditos()));

    }

    @Test
    public void Test04HormigaAtacaCorrectamente(){
        Hormiga hormiga = new Hormiga();
        Jugador jugador = new Jugador(10,10,"juli3");
        hormiga.atacar(jugador);
        assertTrue((new Energia(9)).equals(jugador.getVida()));
    }


}


