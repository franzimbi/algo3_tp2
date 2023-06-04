package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.enemigos.Arania;
import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.enemigos.Hormiga;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lector {
    public final ArrayList<ArrayList<Enemigo>> enemigosPorTurno = new ArrayList<ArrayList<Enemigo>>();
    //public final mapa = new ;
    public Lector() {
    }

    public void leerMapa(String rutaArchivoMapa) {
        try {
            JSONParser parser = new JSONParser();
            // Leer y procesar el archivo de mapa
            JSONObject mapaJSON = (JSONObject) parser.parse(new FileReader(rutaArchivoMapa));
            JSONObject mapaObject = (JSONObject) mapaJSON.get("Mapa");
            int filas = mapaObject.size();
            int columnas = ((JSONArray) mapaObject.get("1")).size(); // Suponiendo que todas las filas tienen la misma longitud

            for (int i = 1; i <= filas; i++) {
                JSONArray filaArray = (JSONArray) mapaObject.get(String.valueOf(i));
                for (int j = 0; j < columnas; j++) {
                    Object elemento = filaArray.get(j);
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public void leerEnemigos(String rutaArchivoTurnos) {
        // Leer y procesar el archivo de turnos
        try {
            JSONParser parser = new JSONParser();
            JSONArray turnosJSON = (JSONArray) parser.parse(new FileReader(rutaArchivoTurnos));
            for (Object turnoObj : turnosJSON) {
                JSONObject turnoJSON = (JSONObject) turnoObj;
                long turno = (Long) turnoJSON.get("turno");
                JSONObject enemigosJSON = (JSONObject) turnoJSON.get("enemigos");
                ArrayList<Enemigo> enemigosEnEsteTurno = new ArrayList<>();
                long cantidadHormigas = (Long) enemigosJSON.get("hormiga");

                for (int i = 0; i < cantidadHormigas; i++) {
                    enemigosEnEsteTurno.add(new Hormiga());
                }
                long cantidadAranias = (Long) enemigosJSON.get("arana");

                for (int i = 0; i < cantidadAranias; i++) {
                    enemigosEnEsteTurno.add(new Arania());
                }
                enemigosPorTurno.add(enemigosEnEsteTurno);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

/*

Mapa:
1:  [R P T T T T T T T T R R R R R]
2:  [T P T T T T T T T T R R R R R]
3:  [T P T T T T T T T T R R R R R]
4:  [T P T T T T T T T T R R R R R]
5:  [T P R R T T T T T T T T T T T]
6:  [T P R R T T T R T T T T T T T]
7:  [T P P P P P P P P T T T T T T]
8:  [T T T T T T T T P T T T T T T]
9:  [T T T T T T T T P T T T T T T]
10: [T T T T T T T T P R T T T T T]
11: [T T T T T T T T P P P P P P P]
12: [R R R R R T T T T T T T T T T]
13: [R R R R R T T T T T T T T T T]
14: [R R R R R T T T T T T T T T T]
15: [R R R R R T T T T T T T T T T]

 */



