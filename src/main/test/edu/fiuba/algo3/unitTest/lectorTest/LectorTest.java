package edu.fiuba.algo3.unitTest.lectorTest;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LectorTest {
    @Test
    public void Test14LecturaDelMapaLanzaExcepcionSiElArchivoEsInvalido() {
        LectorJSON lector = new LectorJSON();
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/testResources/mapaInvalido.txt"));
        assertThrows(NoSePuedeLeerElMapaError.class, () -> lector.leerMapa("src/main/test/testResources/mapaInvalido.json"));
    }

    @Test
    public void Test12LecturaDelMapaNoLanzaExcepcionSiElArchivoEsValido() {
        LectorJSON lector = new LectorJSON();
        assertDoesNotThrow(() -> lector.leerMapa("src/main/test/testResources/mapaValido.json"));
    }

    @Test
    public void Test04LecturaDeEnemigosLanzaExcepcionSiElArchivoEsInvalido() {
        LectorJSON lector = new LectorJSON();
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/testResources/enemigosInvalidos.txt"));
        assertThrows(NoSePuedeLeerEnemigosError.class, () -> lector.leerEnemigos("src/main/test/testResources/enemigosInvalidos.json"));
    }

    @Test
    public void Test13LecturaDeEnemigosNoLanzaExcepcionSiElArchivoEsValido() {
        LectorJSON lector = new LectorJSON();
        assertDoesNotThrow(() -> lector.leerEnemigos("src/main/test/testResources/enemigosValidos.json"));
    }
}
