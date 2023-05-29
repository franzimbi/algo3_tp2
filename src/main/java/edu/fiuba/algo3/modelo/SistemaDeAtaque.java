package edu.fiuba.algo3.modelo;

public class SistemaDeAtaque {
    private int danio;
    private int rango;

    public SistemaDeAtaque(int danio, int rango){
        this.danio = danio;
        this.rango = rango;
    }

    public boolean atacar(Enemigo objetivo, Defensa defensa){
        Jugador jugador = Jugador.getInstancia();
        boolean puedeAtacar= this.puedeAtacar(objetivo,defensa);
        if(puedeAtacar){
            objetivo.recibirDanio(this.danio);
        }
        return puedeAtacar;
    }

    private boolean puedeAtacar(Enemigo objetivo, Defensa defensa){
        return (objetivo.distancia(defensa)<=rango);
    }

}