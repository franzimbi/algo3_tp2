package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.Tierra;
import edu.fiuba.algo3.modelo.turno.Turnos;

import java.util.ArrayList;

public class Mapa {
    private final ArrayList<Parcela> parcelas;
    private final Camino camino;
    private final ArrayList<Parcela> defensas;

    public Mapa() {
        this.parcelas = new ArrayList<>();
        this.camino = new Camino();
        this.defensas = new ArrayList<>();
    }

    public void agregarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
        if (parcela instanceof Pasarela) {
            this.camino.agregarPasarela((Pasarela) parcela);
        }
    }

    public boolean agregarDefensa(Defensa defensa, Coordenadas posicion, Jugador jugador) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.getUbicacion().equals(posicion)) {
                boolean pudo = parcela.ubicar(defensa, jugador);
                if (pudo) this.defensas.add(parcela);{
                    Logger.getInstancia().info("se ubico un " + defensa.getNombre()
                            + " en (" + posicion.getX() + "," + posicion.getY() + ")");
                    return pudo;
                }
            }
        }
        return false;
    }

    public void defensasAtacar(Jugador jugador) {
        for (Parcela defensa : this.defensas) {
            this.camino.atacar((Tierra) defensa, jugador);
        }
    }

    public void mover(Jugador jugador, int cantidadDeTurnos) {
        this.camino.mover(jugador, cantidadDeTurnos);
    }

    public boolean perdio(Jugador jugador) {
        return this.camino.perdio(jugador);
    }

    public void generarEnemigos(Turnos oleada, Jugador jugador) {
//        for (Parcela parcela : this.parcelas) {
//            if (parcela instanceof Pasarela){
//                oleada.generarEnemigos((Pasarela) parcela, jugador);
//            }
//        }
        //TODO: HACER DESAPARECER CAMINO Y QUE TODO SEA MAPA. LO PIDE JOAQUIN. ESTA
        // LO COMENTADO ES UN EJEMPLO DE COMO HACER
        oleada.generarEnemigos(this.camino, jugador);
    }

    public boolean gano(Jugador jugador) {
        return this.camino.gano(jugador);
    }

    public int cantidadEnemigos(int posCamino) {
        return this.camino.cantidadEnemigos(posCamino);
    }

    public int tamanoMapa() {
        return this.parcelas.size();
    }
}
