package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.ParcelaNoPuedeUbicarError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private final ArrayList<Parcela> parcelas;
    private final ArrayList<Enemigo> enemigos;
    private Parcela meta;

    public Mapa() {
        this.parcelas = new ArrayList<>();
        this.enemigos = new ArrayList<>();
        this.meta = null;
    }

    public ArrayList<Parcela> getParcelas() {
        return this.parcelas;
    }

    public ArrayList<Enemigo> getEnemigos() {
        return this.enemigos;
    }

    public void agregarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }

    public void ubicar(Defensa defensa, Coordenadas posicion, Jugador jugador) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.tieneUbicacion(posicion)) {
                try {
                    parcela.ubicar(defensa);
                    defensa.asignarAJugador(jugador);
                    Logger.getInstancia().info("se ubica un " +
                            defensa.getNombre() + " en (" + posicion.getX() + "," +
                            posicion.getY() + ")");
                } catch (ParcelaNoPuedeUbicarError e) {
                    Logger.getInstancia().info("no se pudo ubicar un " +
                            defensa.getNombre() + " en (" + posicion.getX() + "," +
                            posicion.getY() + ")");
                    throw e;
                }
            }
        }
    }

    private void agregarEnemigo(Enemigo enemigoAgregado) {
        for (Enemigo enemigo : this.enemigos) {
            if (enemigo.equals(enemigoAgregado)) {
                return;
            }
        }
        this.enemigos.add(enemigoAgregado);
    }

    public void mover(Jugador jugador) {
        List<Enemigo> enemigosCopia = new ArrayList<>(this.enemigos);
        for (Enemigo enemigo : enemigosCopia) {
            enemigo.mover(this.encontrarParcela(enemigo), jugador, this);
        }
    }

    public void ubicar(Enemigo enemigo, Coordenadas posicion, Jugador jugador) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.ubicacion(posicion)) {
                try {
                    parcela.ubicar(enemigo);
                    break;
                } catch (ParcelaNoPuedeUbicarError e) {
                    Logger.getInstancia().info("no se pudo ubicar un " + enemigo.getNombre()
                            + " en (" + posicion.getX() + "," + posicion.getY() + ")");
                    agregarEnemigo(enemigo);
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

    public boolean sinEnemigos() {
        return this.enemigos.isEmpty();
    }

    private Parcela encontrarParcela(Enemigo enemigo) {
        for (Parcela parcela : this.parcelas) {
            if (enemigo.ubicacion(parcela)) {
                return parcela;
            }
        }
        return null;
    }

    public Parcela encontrarParcela(Coordenadas ubicacion) {
        for (Parcela parcela : this.parcelas) {
            if (parcela.ubicacion(ubicacion)) {
                return parcela;
            }
        }
        return null;
    }

    public void enemigosAtacados(Defensa defensa) {
        Enemigo enemigoActual = null;
        int distanciaMinima = 0;
        for (Enemigo enemigo : enemigos) {
            if (enemigo.estaMuerto()) {
                continue;
            }
            enemigoActual = enemigo;
            distanciaMinima = enemigo.distancia(defensa);
            break;
        }
        for (Enemigo enemigo : enemigos) {
            if (enemigo.estaMuerto()) {
                continue;
            }
            int distanciaActual = enemigo.distancia(defensa);
            if (distanciaMinima > distanciaActual) {
                enemigoActual = enemigo;
                distanciaMinima = distanciaActual;
            }
        }
        if (enemigoActual != null) {
            defensa.atacarEnemigo(enemigoActual);
        }
        defensa.reducirVidaUtil();
    }

    public void dejarEnRango(Coordenadas posicion) {
        posicion.chequearXY(this.meta.getUbicacion());
    }

    public int cantidadEnemigos() {
        return this.enemigos.size();
    }

    public void spawnear(Enemigo enemigo) {
        for (Parcela parcela : this.parcelas) {
            try {
                parcela.ubicar(enemigo);
                this.enemigos.add(enemigo);
                break;
            } catch (ParcelaNoPuedeUbicarError ignored) {
            }
        }
    }

    public int size() {
        return this.parcelas.size();
    }

    public boolean estaEnEjeYConMeta(int y) {
        return this.meta.getUbicacion().getY() == y;
    }

    public boolean estaEnMeta(Coordenadas posicion) {
        return posicion.equals(this.meta.getUbicacion());
    }

    public Coordenadas getMeta() {

        return this.meta.getUbicacion();
    }

    public void setMeta(Parcela parcela) {
        this.parcelas.add(parcela);
        this.meta = parcela;
    }
}
