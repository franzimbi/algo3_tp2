package edu.fiuba.algo3.modelo;

public class Tierra extends Parcela {
    private Defensa defensa;

    public Tierra(Coordenadas ubicacion){
        this.ubicacion = ubicacion;
    }
    public Tierra(){
        this.ubicacion = new Coordenadas(0,0);
    }

    @Override
    public boolean ubicar(Defensa defensa) {
        this.defensa = defensa;
        return true;
    }
    public boolean estaOcupada(){
        return this.defensa != null;
    }
    @Override
    public boolean defender(Parcela lugar) {
        if (!this.estaOcupada()) {
            return false;
        }
        return lugar.atacado(this.defensa, this.ubicacion);
    }
}
