package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.creditos.Creditos;
import edu.fiuba.algo3.modelo.excepciones.CreditosInsuficientesError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreditosTest {
    @Test
    public void Test01UnosCreditosComienzaEnUnEstadoValido() {
        Creditos creditos = new Creditos(100);

        assertTrue(new Creditos(100).equals(creditos));
    }

    @Test
    public void Test02SacarCreditosCorrectamente() {
        Creditos creditos = new Creditos(100);
        creditos.sacarCreditos(new Creditos(10));
        assertTrue((new Creditos(90)).equals(creditos));
    }

    @Test
    public void Test03AgregarCreditosCorrectamente() {
        Creditos creditos = new Creditos(100);
        creditos.agregarCreditos(new Creditos(10));
        assertTrue((new Creditos(110)).equals(creditos));
    }

    @Test
    public void Test04CreditosInsuficienteExeption() {
        Creditos creditos = new Creditos(100);
        assertThrows(CreditosInsuficientesError.class, () -> creditos.sacarCreditos(new Creditos(110)));

    }


}