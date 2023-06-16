package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega3Test {

    @Test
    public void Test14LechuzaSeMueveEnL() {
        //Logger.getInstancia().activar();
        String mapa = "src/main/test/testResources/mapaValido2.json";
        String turnos = "src/main/test/testResources/enemigosValidos2.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);
        juego.juegoEmpezar();
        assertEquals(1, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(1, juego.cantidadEnemigos());
        juego.pasarTurno();
        juego.pasarTurno();
        //Logger.getInstancia().desactivar();
    }
}
