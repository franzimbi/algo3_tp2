package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
    private static int contador = 0;


    public Hormiga() {
        this.vida = new Vida(1);
        this.velocidad = 1;
        this.danio = 1;
    }

    private static void sumarCreditos() {
        Jugador jugador = Jugador.getInstancia();
        if (contador > 10) {
            jugador.sumarCreditos(2);
        } else {
            jugador.sumarCreditos(1);
        }
    }

    public static void reiniciar() {
        contador = 0;
    }

    protected void destruirse() {
        Hormiga.contador += 1;
        Hormiga.sumarCreditos();
    }
}
