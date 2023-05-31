package edu.fiuba.algo3.modelo;


public class Meta extends Pasarela {

    public Meta(Coordenadas ubicacion ){
        super(ubicacion);
    }
    public void atacar(Jugador jugador){
        for (int i = 0; i< this.enemigos.size()-1; i++){
            this.enemigos.remove(i).atacar(jugador);
        }
    }
}

