package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.mapa.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.turno.Turnos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorJSON implements Lector {
    public Mapa leerMapa(String mapa) {
        if (!mapa.endsWith(".json")) {
            throw new NoSePuedeLeerElMapaError();
        }
        try {
            FileReader archivoDeLectura = new FileReader(mapa);
            JSONParser parser = new JSONParser();
            // Leer y procesar el archivo de mapa
            JSONObject mapaJSON = (JSONObject) parser.parse(archivoDeLectura);
            JSONObject mapaObject = (JSONObject) mapaJSON.get("Mapa");

            int filas = mapaObject.size();
            int columnas = ((JSONArray) mapaObject.get("1")).size(); // Suponiendo que todas las filas tienen la misma longitud

            ArrayList<Pasarela> pasarelasLeidas = new ArrayList<Pasarela>();
            Mapa mapaLeido = new Mapa();

            for (int i = 1; i <= filas; i++) {
                JSONArray filaArray = (JSONArray) mapaObject.get(String.valueOf(i));
                for (int j = 0; j < columnas; j++) {
                    Object elemento = filaArray.get(j);
                    Parcela aux = Parcela.construirParcela(elemento.toString(), new Coordenadas(i - 1, j));
                    mapaLeido.agregarParcela(aux);
                    if (aux instanceof Pasarela) {
                        pasarelasLeidas.add((Pasarela) aux);
                    }
                }
            }
            for (int i = 0; i < pasarelasLeidas.size() - 2; i++) {
                pasarelasLeidas.get(i).setSiguiente(pasarelasLeidas.get(i + 1));
            }

            mapaLeido.setMeta(pasarelasLeidas.get(pasarelasLeidas.size() - 1));
            return mapaLeido;
        } catch (IOException | ParseException | ClassCastException e) {
            throw new NoSePuedeLeerElMapaError();
        }
    }

    public Turnos leerEnemigos(String oleadas) {
        if (!oleadas.endsWith(".json")) {
            throw new NoSePuedeLeerEnemigosError();
        }
        try {
            JSONParser parser = new JSONParser();
            JSONArray turnosJSON = (JSONArray) parser.parse(new FileReader(oleadas));
            Turnos enemigosPorTurno = new Turnos();
            for (Object turnoObj : turnosJSON) {
                JSONObject turnoJSON = (JSONObject) turnoObj;
                long turno = (long) turnoJSON.get("turno");
                JSONObject enemigosJSON = (JSONObject) turnoJSON.get("enemigos");

                for (Object enemigoKey : enemigosJSON.keySet()) {
                    String nombreEnemigo = (String) enemigoKey;
                    long cantidadEnemigo = (Long) enemigosJSON.get(enemigoKey);

                    for (int i = 0; i < cantidadEnemigo; i++) {
                        Enemigo enemigo = Enemigo.construirEnemigo(nombreEnemigo);
                        enemigosPorTurno.agregarEnemigoATurno((int) turno - 1, enemigo);
                    }
                }
            }
            return enemigosPorTurno;
        } catch (IOException | ParseException | NoSePuedeLeerEnemigosError | ClassCastException e) {
            throw new NoSePuedeLeerEnemigosError();
        }
    }
}



