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

    public Mapa() {
        this.parcelas = new ArrayList<>();
    }

    public void agregarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }
    public boolean ubicar(Defensa defensa, Coordenadas posicion) {
        for(Parcela parcela : this.parcelas){
            if (parcela.tieneUbicacion(posicion)){
                parcela.ubicar(defensa);
            }
        }
    }
    public boolean ubicar(Enemigo enemigo, Coordenadas posicion) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.getUbicacion().equals(posicion)) {
                boolean pudo = parcela.ubicar(enemigo);
                if (pudo){
                    Logger.getInstancia().info("se ubico un " + enemigo.getNombre()
                            + " en (" + posicion.getX() + "," + posicion.getY() + ")");

                }
                return pudo;
            }
        }
        return false;
    }


//    public boolean agregarDefensa(Defensa defensa, Coordenadas posicion, Jugador jugador) {
//        for (Parcela parcela : this.parcelas) {
//            if (parcela.getUbicacion().equals(posicion)) {
//                boolean pudo = parcela.ubicar(defensa);
////                if (pudo) this.defensas.add(parcela);{
////                    Logger.getInstancia().info("se ubico un " + defensa.getNombre()
////                            + " en (" + posicion.getX() + "," + posicion.getY() + ")");
////                    return pudo;
////                }
//            }
//        }
//        return false;
//    }
//
//    public void defensasAtacar(Jugador jugador) {
////        for (Parcela defensa : this.defensas) {
////            this.camino.atacar((Tierra) defensa, jugador);
////        }
//    }
//
//    public void mover(Jugador jugador, int cantidadDeTurnos) {
//        //this.camino.mover(jugador, cantidadDeTurnos);
//    }
//
//    public boolean perdio(Jugador jugador) {
//        //return this.camino.perdio(jugador);
//        return false;
//    }
//
//    public void generarEnemigos(Turnos oleada, Jugador jugador) {
//        for (Parcela parcela : this.parcelas) {
//            if (parcela instanceof Pasarela){
//                oleada.generarEnemigos((Pasarela) parcela, jugador);
//            }
//        }
//        //oleada.generarEnemigos(this.camino, jugador);
//    }
//
//    public boolean gano(Jugador jugador) {
//        //return this.camino.gano(jugador);
//        return false;
//    }
//
//    public int cantidadEnemigos(int posCamino) {
//        return 1;
//        //return this.camino.cantidadEnemigos(posCamino);
//    }
//
//    public int tamanoMapa() {
//        return this.parcelas.size();
//    }
}
