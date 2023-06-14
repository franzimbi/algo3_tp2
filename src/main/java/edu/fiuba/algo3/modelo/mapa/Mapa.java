package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.parcelas.Parcela;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapa {
    private final ArrayList<Parcela> parcelas;
    private ArrayList<Enemigo> enemigos;

    // REPRESENTACION DEL MAPA EN MATRIZ
    // 0,0 0,1 0,2 0,3
    // 1,0 1,1 1,2 1,3
    // 2,0 2,1 2,2 2,3
    // 3,0 3,1 3,2 3,3

    // ARREGLO DE PARCELAS
    // (0,0) (0,1) (0,2) (0,3) (1,0) (1,1) (1,2) (1,3) (2,0) (2,1) (2,2) (2,3) (3,0) (3,1) (3,2) (3,3)

    public Mapa() {
        this.parcelas = new ArrayList<>();
        this.enemigos = new ArrayList<Enemigo>();
    }

    public void agregarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }

    public boolean ubicar(Defensa defensa, Coordenadas posicion, Jugador jugador) {
        for(Parcela parcela : this.parcelas){
            if (parcela.tieneUbicacion(posicion)){
                if (parcela.ubicar(defensa)){
                    defensa.asignarAJugador(jugador);
                }
            }
        }
        return true;
    }
    public boolean ubicar(Enemigo enemigo, Coordenadas posicion) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.getUbicacion().equals(posicion)) {
                boolean pudo = parcela.ubicar(enemigo);
                if (pudo){
                    Logger.getInstancia().info("se ubico un " + enemigo.getNombre()
                            + " en (" + posicion.getX() + "," + posicion.getY() + ")");
                    this.enemigos.add(enemigo);
                }
                return pudo;
            }
        }
        return false;
    }
    public void recolectarEnemigos(Jugador jugador){
        for(Enemigo e: this.enemigos){
            if (e.estaMuerto()){
                jugador.recibirMuerto(e);
                this.enemigos.remove(e);
            }
        }
    }
    public boolean gano(Jugador jugador) {
        return !jugador.estaMuerto() && this.enemigos.isEmpty();
    }

}
