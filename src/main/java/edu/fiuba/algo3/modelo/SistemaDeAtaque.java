package edu.fiuba.algo3.modelo;

public class SistemaDeAtaque {
    private int danio;
    private int rango;

    public SistemaDeAtaque(int danio, int rango){
        this.danio = danio;
        this.rango = rango;
    }

    public boolean atacar(Enemigo objetivo, int distancia){
        Jugador jugador = Jugador.getInstancia();
        boolean puedeAtacar= this.puedeAtacar(distancia);
        if(puedeAtacar){
            objetivo.recibirDanio(this.danio);
        }
        return puedeAtacar;
    }

    private boolean puedeAtacar(int distancia){

        return (distancia<=rango);
    }

}