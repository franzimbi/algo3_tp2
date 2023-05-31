package edu.fiuba.algo3.modelo;

public class Rocoso extends Parcela{

    public Rocoso(Coordenadas ubicacion){
        this.ubicacion = ubicacion;
    }
    public Rocoso(){
        this.ubicacion = new Coordenadas(0,0);
    }

}
