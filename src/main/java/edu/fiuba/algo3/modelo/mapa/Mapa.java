package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mapa {
    private final ArrayList<Parcela> parcelas;
    private final ArrayList<Enemigo> enemigos;
    private Parcela meta;

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
        this.meta = null;
    }

    public void agregarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }
    public void ubicar(Defensa defensa, Coordenadas posicion, Jugador jugador) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.tieneUbicacion(posicion)) {
                if (parcela.ubicar(defensa)) {
                    defensa.asignarAJugador(jugador);
                    Logger.getInstancia().info("se ubica un " +
                            defensa.getNombre() + " en (" + posicion.getX() + "," +
                            posicion.getY() + ")");
                }
            }
        }
    }
    public void setMeta(Pasarela ultima){
        this.meta = ultima;
    }
    public void mover(Jugador jugador) {
        List<Enemigo> enemigosCopia = new ArrayList<>(this.enemigos);
        for (Enemigo enemigo : enemigosCopia) {
            enemigo.mover( this.encontrarParcela(enemigo.getUbicacion()),
                    jugador, this);
        }
    }
    public void ubicar(Enemigo enemigo, Coordenadas posicion, Jugador jugador) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.getUbicacion().equals(posicion)) { //esto rompe tell dont ask
                boolean pudo = parcela.ubicar(enemigo);
                if (pudo) {
                    Logger.getInstancia().info("se ubico un " + enemigo.getNombre()
                            + " en (" + posicion.getX() + "," + posicion.getY() + ")");
                    this.enemigos.add(enemigo);
                }
            }
        }
    }
    public void recolectarEnemigos(Jugador jugador) {
        List<Enemigo> enemigosAEliminar = new ArrayList<>();
        for (Enemigo e : this.enemigos) {
            if (e.estaMuerto()) {
                jugador.recibirMuerto(e);
                enemigosAEliminar.add(e);
            }
        }
        this.enemigos.removeAll(enemigosAEliminar);
    }
    public void removerEnemigo(Enemigo enemigo) {
        this.enemigos.remove(enemigo);
    }
    public boolean gano(Jugador jugador) {
        return !jugador.estaMuerto() && this.enemigos.isEmpty();
    }
    public boolean perdio(Jugador jugador) {return jugador.estaMuerto();}
    private Parcela encontrarParcela(Coordenadas posicion) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.getUbicacion().equals(posicion)) {
                return parcela;
            }
        }
        return null;
    }
    public void enemigosAtacados(Defensa defensa) {
        if (enemigos.isEmpty()) {
            return;
        }
        Enemigo enemigoActual = enemigos.get(0);
        int distanciaMinima = enemigoActual.distancia(defensa);

        for (Enemigo enemigo : enemigos) {
            if(enemigo.estaMuerto()){
                continue;
            }
            int distanciaActual = enemigo.distancia(defensa);
            if (distanciaMinima > distanciaActual) {
                enemigoActual = enemigo;
                distanciaMinima = distanciaActual;
            }
        }
        defensa.atacarEnemigo(enemigoActual);
    }
    public void dejarEnRango(Coordenadas posicion) {
        posicion.chequearXY(this.meta.getUbicacion());
    }
    public int cantidadEnemigos(){
        return this.enemigos.size();
    }
    public void spawnear(Enemigo enemigo){
        for(Parcela parcela : this.parcelas){
            if(parcela.ubicar(enemigo)){
                this.enemigos.add(enemigo);
                break;
            }
        }
    }
    public int size(){
        return this.parcelas.size();
    }

}
