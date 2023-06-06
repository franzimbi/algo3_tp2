package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.lector.Lector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Entrega2Test {
    //Verificar el formato valido del JSON de enemigos
    @Test
    public void Test13LecturaDeEnemigosLanzaExccepcionSiElArchivoEsInvalido(){
        Lector lector = new Lector();
        assertThrows(NoSePuedeLeerEnemigosError.class, ()->lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosInvalidos.txt"));
        assertThrows(NoSePuedeLeerEnemigosError.class, ()->lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosInvalidos.json"));
        assertDoesNotThrow(()->lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/enemigosValidos.json"));
    }

    //Verificar el formato valido del JSON del mapa
    @Test
    public void Test14LecturaDelMapaLanzaExccepcionSiElArchivoEsInvalidoo(){
        Lector lector = new Lector();
        assertThrows(NoSePuedeLeerElMapaError.class, ()->lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaInvalido.txt"));
        assertThrows(NoSePuedeLeerElMapaError.class, ()->lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaInvalido.json"));
        assertDoesNotThrow(()->lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/jsonsTest/mapaValido.json"));
    }

    //Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON de enemigos
    @Test
    public void Test15VerificarConversionDelJSONDeEnemigos(){

    }

    // Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON del mapa.
    @Test
    public void Test16VerificarConversionDelJSONDeMapa(){}

    //Verificar que el juego se crea acorde a ambos JSON
    @Test
    public void Test17SimularYVerificarQueElJuegoSeCreeCorrectamenteAcordeAlJSON(){}

    //Simular y verificar que el jugador gana una partida.
    @Test
    public void Test18(){}

    //Simular y verificar que el jugador pierde una partida.
    @Test
    public void Test19(){}

    // Verificar el sistema de log a utilizar necesario para la entrega 3. El log puede ser
    // una implementación propia, casera y simple del grupo o utilizar alguna librería.
    @Test
    public void Test20(){}


}
