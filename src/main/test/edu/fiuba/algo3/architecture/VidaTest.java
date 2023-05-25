package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Vida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VidaTest {
    @Test
    public void unaVidaComienzaEnUnEstadoValido() {
        Vida vida = new Vida(20);

        assertEquals(vida.cantidad(),20);
    }
}
