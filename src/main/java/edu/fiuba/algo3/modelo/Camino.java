package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Camino {
    private ArrayList<Pasarela> pasarelas;
    private Pasarela meta;

    public Camino(Pasarela meta){
        this.pasarelas = new ArrayList<Pasarela>();
        this.meta= meta;
    }


    public void agregarPasarela(Pasarela pasarela){
        this.pasarelas.add(pasarela);
    }

    // a cada pasarela de atras para adelante le envia el mensaje de mover
    public void mover() {
        for (int i = pasarelas.size()-1; i >= 0; i--) {
            pasarelas.get(i).mover(this);
        }
    }

    // agrega un nuevo enemigo a la posicion de inicio
    public void spawnEnemigo(Enemigo enemigo) {
        this.pasarelas.get(0).ubicar(enemigo);
    }

    //devuelve la pasarela a la q tiene q moverse dependiendo de su ubicacion y velocidad
    public Parcela siguiente(int velocidad, Pasarela pasarela) {
       int aux = pasarelas.indexOf(pasarela) + velocidad;
       if (aux >= pasarelas.size()){
           return meta;
        }
       return  pasarelas.get(aux);
    }
    public boolean tieneEnemigos(){
        for (Pasarela pasarela : this.pasarelas) {
            if (!pasarela.estaVacia()) {
                return true;
            }
        }
        return false;
    }
}
