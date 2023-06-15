package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turno.Turnos;

public interface Lector {
    public Mapa leerMapa(String mapa);
    public Turnos leerEnemigos(String oleadas);
}
