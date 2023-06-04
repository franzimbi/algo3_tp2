package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;

import java.util.ArrayList;

public class Pasarela extends Parcela {
    protected ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();

    public Pasarela(Coordenadas ubicacion){this.ubicacion = ubicacion;}

    public Pasarela(){
        this.ubicacion = new Coordenadas(0,0);
    }

    public boolean ubicar(Defensa defensa, Jugador jugador) {
        return false;
    }

    public boolean ubicar(Enemigo enemigo, Jugador jugador){
        enemigos.add(enemigo);
        return true;
    }

    @Override
    public boolean atacado(Defensa defensa, Parcela ubicacionDefensa) {
        if(ubicacionDefensa.distancia(this) > defensa.rangoMaximo() || enemigos.isEmpty()){
            return false;
        }
        Enemigo primerEnemigo = enemigos.get(0);
        primerEnemigo.recibirDanio(defensa);
        if (primerEnemigo.estaMuerto()){
            enemigos.remove(primerEnemigo);
        }
        return true;
    }

    public void mover(Camino camino,Jugador jugador){
        int tam = enemigos.size();

        for (int i = 0; i < tam; i++) {
            Enemigo actual = enemigos.remove(0);
            camino.siguiente(actual, this,jugador);
        }
    }

    //TODO: funcion que no se usa en Pasarela
    public boolean esta(Enemigo enemigo){return enemigos.contains(enemigo);}

    public boolean estaVacia(){
        return this.enemigos.isEmpty();
    }

}