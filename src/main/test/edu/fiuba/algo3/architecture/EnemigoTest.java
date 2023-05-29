package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.EnemigoNoExisteError;
import edu.fiuba.algo3.modelo.Hormiga;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnemigoTest {
    @Test
    public void Test01EnemigoDuelveElenemigoCorrecto() {
        Enemigo hormigaDevuelta = Enemigo.crearEnemigo("Hormiga");
        Enemigo araniaDevuelta = Enemigo.crearEnemigo("Arania");

        Hormiga hormiga = new Hormiga();
        Arania arania = new Arania();

        assertSame(hormigaDevuelta.getClass(), hormiga.getClass());
        assertSame(araniaDevuelta.getClass(), arania.getClass());
    }

    @Test
    public void Test02CrearEnemigoInexistenteLanzaExcepcion() {
        assertThrows(EnemigoNoExisteError.class, () -> Enemigo.crearEnemigo("Hormiga Gigante"));
    }

    @Test
    public void Test03UnEnemigoSeCreaEnLaPasarelaDeLargada(){

    }
}
