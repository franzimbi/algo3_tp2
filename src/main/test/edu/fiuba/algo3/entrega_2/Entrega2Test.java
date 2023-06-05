package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.lector.Lector;


import org.junit.jupiter.api.Test;

public class Entrega2Test {
    //Verificar el formato valido del JSON de enemigos
    @Test
    public void Test13ElFormatoDelJSONDeEnemigosNoEsValido(){
        Lector lector = new Lector();
        assertThrows(NoSePuedeLeerEnemigosError.class, ()->lector.leerEnemigos("src/main/test/edu/fiuba/algo3/entrega_2/setDeDatos/test13.txt"));
    }

    //Verificar el formato valido del JSON del mapa
    @Test
    public void Test14ElFormatoDelJASONDelMapaEsValido(){
        Lector lector = new Lector();
        assert (lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/setDeDatos/test14.json").tamanoTotal() == 9 );
        assertThrows(NoSePuedeLeerElMapaError.class, ()->lector.leerMapa("src/main/test/edu/fiuba/algo3/entrega_2/setDeDatos/test14.txt"));
    }

    //Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON de enemigos
    @Test
    public void Test15(){}

    // Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON del mapa.
    @Test
    public void Test16(){}

    //Verificar que el juego se crea acorde a ambos JSON
    @Test
    public void Test17(){}

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
