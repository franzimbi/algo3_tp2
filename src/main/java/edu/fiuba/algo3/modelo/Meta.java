package edu.fiuba.algo3.modelo;


public class Meta extends Camino {
    public Meta(Coordenadas coordenadas){
        super(coordenadas);
    }
    @Override
    public boolean ubicar(Enemigo enemigo){
        Jugador jugador = Jugador.getInstancia();
        enemigo.atacar();
        return true;
    }
}
