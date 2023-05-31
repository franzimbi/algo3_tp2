package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pasarela extends Parcela {
    protected ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();

    public Pasarela(Coordenadas ubicacion){this.ubicacion = ubicacion;}

    public Pasarela(){
        this.ubicacion = new Coordenadas(0,0);
    }

    public boolean ubicar(Defensa defensa) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo){
        enemigos.add(enemigo);
        return true;
    }

    @Override
    public boolean atacado(Defensa defensa, Coordenadas ubicacionDefensa) {
        if(ubicacionDefensa.distancia(this.ubicacion) > defensa.rangoMaximo() || enemigos.isEmpty()){
            return false;
        }
        enemigos.get(0).recibirDanio(defensa);
        return true;
    }

    public void mover(Camino camino){
        int tam = enemigos.size();
        for (int i = 0; i < tam; i++) {
            Enemigo actual = enemigos.remove(0);
            camino.siguiente(actual.getVelocidad(), this).ubicar(actual);
        }
    }
    public boolean esta(Enemigo enemigo){return enemigos.contains(enemigo);}

    public boolean estaVacia(){
        return this.enemigos.isEmpty();
    }

}