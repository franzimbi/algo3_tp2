package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.excepciones.RangoInvalidoMapeadoError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcelas.Parcela;
import edu.fiuba.algo3.modelo.turno.Turnos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Lector {

    public Mapa leerMapa(String rutaArchivoMapa) {
        if (!rutaArchivoMapa.endsWith(".json")) {
            throw new NoSePuedeLeerElMapaError();
        }
        try {
            FileReader archivoDeLectura = new FileReader(rutaArchivoMapa);
            JSONParser parser = new JSONParser();
            // Leer y procesar el archivo de mapa
            JSONObject mapaJSON = (JSONObject) parser.parse(archivoDeLectura);
            JSONObject mapaObject = (JSONObject) mapaJSON.get("Mapa");
            int filas = mapaObject.size();
            int columnas = ((JSONArray) mapaObject.get("1")).size(); // Suponiendo que todas las filas tienen la misma longitud
            Mapa mapaLeido = new Mapa(filas, columnas);
            for (int i = 1; i <= filas; i++) {
                JSONArray filaArray = (JSONArray) mapaObject.get(String.valueOf(i));
                for (int j = 0; j < columnas; j++) {
                    Object elemento = filaArray.get(j);
                    Parcela aux = Parcela.construirParcela(elemento.toString(), new Coordenadas(i - 1, j));
                    mapaLeido.agregarParcela(i - 1, j, aux);
                }
            }
            return mapaLeido;
        } catch (IOException | RangoInvalidoMapeadoError | ParseException | ClassCastException e) {
            throw new NoSePuedeLeerElMapaError();
        }
    }

    public Turnos leerEnemigos(String rutaArchivoTurnos) {
        // Leer y procesar el archivo de turnos
        if (!rutaArchivoTurnos.endsWith(".json")) {
            throw new NoSePuedeLeerEnemigosError();
        }
        try {
            JSONParser parser = new JSONParser();
            JSONArray turnosJSON = (JSONArray) parser.parse(new FileReader(rutaArchivoTurnos));
            Turnos enemigosPorTurno = new Turnos();
            for (Object turnoObj : turnosJSON) {
                JSONObject turnoJSON = (JSONObject) turnoObj;
                long turno = (long) turnoJSON.get("turno");
                JSONObject enemigosJSON = (JSONObject) turnoJSON.get("enemigos");
                long cantidadHormigas = (Long) enemigosJSON.get("hormiga");

                for (int i = 0; i < cantidadHormigas; i++) {
                    enemigosPorTurno.agregarEnemigoATurno((int)turno-1, new Hormiga());
                }
                long cantidadAranias = (Long) enemigosJSON.get("arana");

                for (int i = 0; i < cantidadAranias; i++) {
                    enemigosPorTurno.agregarEnemigoATurno((int) turno-1, new Arania());
                }
            }
            return enemigosPorTurno;
        } catch (IOException | ParseException | NoSePuedeLeerEnemigosError | ClassCastException e) {
            throw new NoSePuedeLeerEnemigosError();
        }
    }
}



/*

Mapa:
       1:                         :15
   1: [R P T T T T T T T T R R R R R]
      [T P T T T T T T T T R R R R R]
      [T P T T T T T T T T R R R R R]
      [T P T T T T T T T T R R R R R]
      [T P R R T T T T T T T T T T T]
      [T P R R T T T R T T T T T T T]
      [T P P P P P P P P T T T T T T]
      [T T T T T T T T P T T T T T T]
      [T T T T T T T T P T T T T T T]
      [T T T T T T T T P R T T T T T]
      [T T T T T T T T P P P P P P P]
      [R R R R R T T T T T T T T T T]
      [R R R R R T T T T T T T T T T]
      [R R R R R T T T T T T T T T T]
  15: [R R R R R T T T T T T T T T T]

 */



