package edu.fiuba.algo3.modelo;

import java.util.*;
public abstract class Enemigo {
    protected Vida vida;
    public static Enemigo crearEnemigo(String enemigo) {
        Map<String, Enemigo> enemigosPosibles = new HashMap<String, Enemigo>(){{
            put("Hormiga", (new Hormiga()));
            put("Arania", (new Arania()));
            }
        };
        Enemigo enemigoActual = enemigosPosibles.get(enemigo);
        if (enemigoActual != null){
            return enemigoActual;
        }else{
            throw new EnemigoNoExisteError();
        }

    }
    public void recibirDanio(int danio,Jugador jugador){
        vida.quitar(danio);
    }

    public int Vida(){
        return vida.cantidad();
    }

    public boolean estaMuerto(){
        return (vida.cantidad() == 0);
    }

    protected abstract void destruirse(Jugador jugador);

}



