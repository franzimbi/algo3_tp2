package edu.fiuba.algo3.modelo.logger;

public class Logger {
    private boolean activado;
    private int accion;
    private static Logger instancia = new Logger();

    private Logger() {
        this.activado = false;
        this.accion = 0;
    }

    public static Logger getInstancia() {
        return instancia;
    }
    public void info(String textoAImprimir){
        if (activado){
            System.out.println("\u001B[38;5;45m accion " + this.accion + ": \u001B[0m" + textoAImprimir);
            this.accion ++;
        }
    }
    public void error(String textoAImprimir){
        if (activado){System.err.println("\u001B[31mError: \u001B[0m " + textoAImprimir);}
    }
    public void activar(){
        this.activado = true;
    }
    public void desactivar(){
        this.accion = 0;
        this.activado = false;
    }
}