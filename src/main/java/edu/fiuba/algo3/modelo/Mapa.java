package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class Mapa {
    final private static Mapa instancia = new Mapa();
    final private LinkedList<Camino> caminos;
    final private LinkedList<Enemigo> enemigos;

    private Mapa() {
        this.caminos = new LinkedList<>();
        this.enemigos = new LinkedList<>();
    }

    public static Mapa getInstancia() {
        return instancia;
    }

    public void ubicarCamino(Camino camino) {
        this.caminos.addLast(camino);
    }

    public void ubicarEnemigo(Enemigo enemigo) {
        this.enemigos.addLast(enemigo);
    }


    public Enemigo getObjetivo(Parcela parcela) {
        int distanciaMinima = enemigos.get(0).distancia(parcela);
        Enemigo enemigoCercano = enemigos.get(0);
        int distanciaElemento;
        Enemigo enemigo;

        for (int i = 1; i < enemigos.size(); i++) {
            enemigo = enemigos.get(i);
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
}
