package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pasarela extends Parcela {
    private ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();

    public Pasarela(Coordenadas ubicacion){
        this.ubicacion = ubicacion;
    }
    public Pasarela(){
        this.ubicacion = new Coordenadas(0,0);
    }
    @Override
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
    /*public void moverConVelocidad(int i, int velocidad, Mapa mapa){

        for(enemigo.mover(mapa.pasarela(i, velocidad));)
    }*/
}