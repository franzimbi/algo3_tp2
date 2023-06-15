package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.turno.Turnos;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class Entrega3Test {

    @Test
    public void Test14LechuzaSeMueveEnL() {
        Logger.getInstancia().activar();
        String mapa = "src/main/test/edu/fiuba/algo3/entrega_3/jsonsTest/mapaValido.json";
        String turnos = "src/main/test/edu/fiuba/algo3/entrega_3/jsonsTest/enemigosValidos.json";
        Jugador jugador = new Jugador(20, 300, "Cristiano Ronaldo");
        Juego juego = new Juego(jugador, new LectorJSON(), mapa, turnos);
        juego.juegoEmpezar();
        assertEquals(1, juego.cantidadEnemigos());
        juego.pasarTurno();
        assertEquals(1, juego.cantidadEnemigos());
        juego.pasarTurno();
        juego.pasarTurno();
        Logger.getInstancia().desactivar();
    }
}
