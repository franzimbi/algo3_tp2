package edu.fiuba.algo3.modelo;

public abstract class Defensa {
    protected int danio;
    protected int rango;
    protected int turnosRestantes;
    protected Creditos coste;


    public boolean estaOperativa(){
        return this.turnosRestantes == 0;
    }

    public void atacar(){
        if (this.estaOperativa()){
            return;
        }
        this.turnosRestantes --;
    }
    public int rangoMaximo(){
        return rango;
    }
    public int danioGenerado(){
        return danio;
    }

    public Creditos coste(){
        return this.coste;
    }
}
