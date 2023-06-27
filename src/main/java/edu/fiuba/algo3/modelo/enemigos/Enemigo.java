package edu.fiuba.algo3.modelo.enemigos;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigos.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.enemigos.movimiento.MovimientoCamino;
import edu.fiuba.algo3.modelo.enemigos.recompensa.Recompensa;
import edu.fiuba.algo3.modelo.enemigos.tipoDeAtaque.Danio;
import edu.fiuba.algo3.modelo.enemigos.velocidad.Velocidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.score.Score;
import edu.fiuba.algo3.modelo.logger.Logger;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;

public abstract class Enemigo {
    protected int energia;
    protected Danio danio;
    protected Velocidad velocidad;
    protected Recompensa recompensa;
    protected Movimiento movimiento;
    protected Coordenadas ubicacion;

    public Enemigo() {
        this.ubicacion = new Coordenadas(0, 0);
        this.movimiento = new MovimientoCamino();
    }

    public void recibirDanio(int danioRecibido) {
        this.energia -= danioRecibido;
        if (estaMuerto()) {
            Logger.getInstancia().info("un " + this.getNombre() + " murio");
        }
    }


    public void ubicarEn(Coordenadas ubicacion) {
        try {
            this.ubicacion = ubicacion.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void reducirVelocidad(float multiplicador) {
        this.velocidad.reducir(multiplicador);
    }

    public void setRecompensa(Recompensa nuevaRecompensa) {
        this.recompensa = nuevaRecompensa;
    }

    public boolean estaMuerto() {
        return this.energia <= 0;
    }

    public int getVelocidad() {
        return velocidad.obtenerVelocidad();
    }


    public Coordenadas getUbicacion() {
        return this.ubicacion;
    }

    public void atacar(Jugador jugador, int cantidadDeTurnos) {
        this.danio.atacar(jugador, cantidadDeTurnos);
    }

    public abstract void agregarMuerto(Score scorer);

    public abstract String getNombre();

    public void mover(Parcela actual, Jugador jugador, Mapa mapa) {
        if (this.estaMuerto()){
            return;
        }
        for (int i=0; i < this.velocidad.obtenerVelocidad(); i++) {
            this.movimiento.mover( this,  jugador, mapa);
        }
    }

    public void setDireccion(Movimiento nuevaDireccion) {
        this.movimiento = nuevaDireccion;
    }

    public void recompensar(Jugador jugador) {
        this.recompensa.otorgarRecompensa(jugador);
    }

    public int distancia(Defensa other) {
        return this.ubicacion.distancia(other.getUbicacion());
    }

    public boolean ubicacion(Parcela pasarela) {
        return pasarela.ubicacion(this.ubicacion);
    }

    public abstract void atacarEnemigo(TorreBlanca torreBlanca);

    public abstract void atacarEnemigo(TorrePlateada torrePlateada);

    public abstract void atacarEnemigo(TrampaArenosa trampaArenosa);
}
