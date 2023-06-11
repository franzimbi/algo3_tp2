package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.velocidad.Velocidad;
import org.junit.jupiter.api.Test;

public class VelocidadTest {
    @Test
    public void test01VelocidadSeCreaConUnValor() {
        Velocidad velocidad = new Velocidad(10);
        assert(velocidad.obtenerVelocidad() == 10);
    }

    @Test
    public void test02VelocidadSeReduceConUnMultiplicador() {
        Velocidad velocidad = new Velocidad(1);
        velocidad.reducir(0.5F);
        assert(velocidad.obtenerVelocidad() == 0);
    }

}
