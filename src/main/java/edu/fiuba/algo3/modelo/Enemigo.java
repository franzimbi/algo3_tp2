package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    protected Vida vida;
    protected int danio;
    protected int velocidad;

    public Enemigo(){
        this.vida = new Vida(20);
    }
    public void recibirDanio(Defensa defensa){
        this.vida.quitar(defensa.danioGenerado());
    }
    public int danioGenerado(){
        return danio;
    }
    public boolean estaMuerto(){
        return this.vida.estaMuerto();
    }
    public int getVelocidad() {return velocidad;}
}
