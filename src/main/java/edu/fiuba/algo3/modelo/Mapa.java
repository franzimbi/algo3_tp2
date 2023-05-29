package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapa {
    final private static Mapa instancia = new Mapa();
    final private ArrayList<Camino> caminos;
    final private ArrayList<Enemigo> enemigos;

    private Mapa() {
        this.caminos = new ArrayList<>();
        this.enemigos = new ArrayList<>();
    }

    public static Mapa getInstancia() {
        return instancia;
    }

    public void ubicarCamino(Camino camino) {
        this.caminos.add(camino);
    }

    public void ubicarEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }


    public Enemigo getObjetivo(Parcela parcela) {
        Iterator<Enemigo> it = enemigos.iterator();
        //int distanciaMinima = enemigos.get(0).distancia(parcela);
        //Enemigo enemigoCercano = enemigos.get(0);
        Enemigo enemigoCercano = it.next();
        int distanciaMinima = enemigoCercano.distancia(parcela);
        int distanciaElemento;
        Enemigo enemigo;
        //for (int i = 1; i < enemigos.size(); i++) {
        while(it.hasNext()){
            //enemigo = enemigos.get(i);
            enemigo = it.next();
            distanciaElemento = enemigo.distancia(parcela);

            if (distanciaMinima > distanciaElemento) {
                distanciaMinima = distanciaElemento;
                enemigoCercano = enemigo;
            }
        }
        return enemigoCercano;
    }

    public void reiniciar() {
        enemigos.clear();
        caminos.clear();
    }

    public void moverEnemigos() {
        Enemigo enemigo;

        for (int i = enemigos.size(); i >= 0; i--) {
            enemigo = enemigos.get(i);
            enemigo.mover();
        }
    }

    public void actualizarMapa() {
        Iterator<Enemigo> it = enemigos.iterator();
        Enemigo enemigo;
        while(it.hasNext()){
            enemigo = it.next();
            if (enemigo.estaMuerto()) {
                it.remove();
            }
        }
    }

    public boolean gano(Jugador jugador) {
        return (enemigos.size() == 0 && jugador.getVida() > 0);
    }

}