package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Creditos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditosTest {
    @Test
    public void unosCreditosComienzaEnUnEstadoValido() {
        Creditos creditos = new Creditos(100);

        assertEquals(creditos.cantidad(),100);
    }
}