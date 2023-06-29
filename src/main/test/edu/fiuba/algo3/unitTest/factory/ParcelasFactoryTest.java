package edu.fiuba.algo3.unitTest.factory;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.ParcelaInvalidaError;
import edu.fiuba.algo3.modelo.factory.ParcelasFactory;
import edu.fiuba.algo3.modelo.lector.LectorJSON;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.mapa.parcelas.Rocoso;
import edu.fiuba.algo3.modelo.mapa.parcelas.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParcelasFactoryTest {

    @Test
    public void Test01PruebaTiposDevueltosValidos() {
        assert ParcelasFactory.crearParcela("Tierra", 0,0 ) instanceof Tierra;
        assert ParcelasFactory.crearParcela("Pasarela", 0,0 ) instanceof Pasarela;
        assert ParcelasFactory.crearParcela("Rocoso", 0,0 ) instanceof Rocoso;
    }
    @Test
    public void Test02PruebaTiposInvalidos() {
        assertThrows(ParcelaInvalidaError.class, () -> ParcelasFactory.crearParcela("Aire", 0,0 ));
    }
}
