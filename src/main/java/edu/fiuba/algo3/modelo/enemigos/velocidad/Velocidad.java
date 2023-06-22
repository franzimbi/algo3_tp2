package edu.fiuba.algo3.modelo.enemigos.velocidad;

public class Velocidad {
    protected int velocidad;
    protected float multiplicador;

    public Velocidad(int velocidad) {
        this.velocidad = velocidad;
        this.multiplicador = 1;
    }

    public int obtenerVelocidad() {
        return (int) (this.velocidad * multiplicador);
    }

    public void reducir(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    public void restaurar() {
        this.multiplicador = 1;
    }

    public void aumentarVelocidad(int velocidad) {
        this.velocidad += velocidad;
    }
    
}

