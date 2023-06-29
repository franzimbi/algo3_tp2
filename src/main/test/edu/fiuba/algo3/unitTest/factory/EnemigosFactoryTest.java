package edu.fiuba.algo3.unitTest.factory;

import edu.fiuba.algo3.modelo.enemigos.*;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.enemigos.Topo;
import edu.fiuba.algo3.modelo.excepciones.EnemigoInvalidoError;
import edu.fiuba.algo3.modelo.excepciones.ParcelaInvalidaError;
import edu.fiuba.algo3.modelo.factory.EnemigosFactory;
import edu.fiuba.algo3.modelo.factory.ParcelasFactory;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.mapa.parcelas.Rocoso;
import edu.fiuba.algo3.modelo.mapa.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnemigosFactoryTest {
    @Test
    public void Test01PruebaTiposDevueltosValidos() {
        assert EnemigosFactory.crearEnemigo("hormiga") instanceof Hormiga;
        assert EnemigosFactory.crearEnemigo("topo") instanceof Topo;
        assert EnemigosFactory.crearEnemigo("arana") instanceof Arania;
        assert EnemigosFactory.crearEnemigo("lechuza") instanceof Lechuza;
    }

    @Test
    public void Test02PruebaTiposInvalidos() {
        EnemigosFactory ene = new EnemigosFactory();
        assertThrows(EnemigoInvalidoError.class, () -> ene.crearEnemigo("messi"));
    }
}
