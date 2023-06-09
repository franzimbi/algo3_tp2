package edu.fiuba.algo3.modelo.energia;

public class EnergiaAzul extends Energia{
    int cantidad;

    public EnergiaAzul(int cantidad) {
        this.cantidad = cantidad;
    }

    public void reducir(Energia energiaRestada){
        //hay que aplicar un double dispatch
    }
}
