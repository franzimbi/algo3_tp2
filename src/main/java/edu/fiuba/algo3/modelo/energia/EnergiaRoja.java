package edu.fiuba.algo3.modelo.energia;

public class EnergiaRoja extends Energia {

    int cantidad;

    public EnergiaRoja(int cantidad) {
        this.cantidad = cantidad;
    }

    public void reducir(Energia energiaRestada){
        //hay que aplicar un double dispatch
    }

}