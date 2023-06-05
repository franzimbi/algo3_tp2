package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcelas.Meta;
import edu.fiuba.algo3.modelo.vida.Energia;
import org.junit.jupiter.api.Test;

public class MetaTest {
    //TODO: Implementar tests de Meta
    @Test
    public void Test01AlLllegarALaMetaElJugadorRecibeDanio() {
        Jugador jugador = new Jugador(20, 100, "Jugador");
        Enemigo hormiga = new Hormiga();
        Meta meta = new Meta(new Coordenadas(0, 0));
        meta.ubicar(hormiga, jugador);

        Energia vida = new Energia(19);
        assert vida.equals(jugador.getVida());
    }

}
