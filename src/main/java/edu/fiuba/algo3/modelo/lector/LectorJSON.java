package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.enemigos.Enemigo;
import edu.fiuba.algo3.modelo.factory.EnemigosFactory;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerElMapaError;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeLeerEnemigosError;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.direcciones.Abajo;
import edu.fiuba.algo3.modelo.mapa.parcelas.Meta;
import edu.fiuba.algo3.modelo.mapa.parcelas.Parcela;
import edu.fiuba.algo3.modelo.factory.ParcelasFactory;
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
            JSONObject mapaJSON = (JSONObject) parser.parse(archivoDeLectura);
            JSONObject mapaObject = (JSONObject) mapaJSON.get("Mapa");

            int filas = mapaObject.size();
            int columnas = ((JSONArray) mapaObject.get("1")).size();

            ArrayList<Coordenadas> coordenadasPasarelas = new ArrayList<>();
            Mapa mapaLeido = new Mapa();

            for (int i = 1; i <= filas; i++) {
                JSONArray filaArray = (JSONArray) mapaObject.get(String.valueOf(i));
                for (int j = 0; j < columnas; j++) {
                    Object elemento = filaArray.get(j);
                    if (elemento.toString().equals("Pasarela")) {
                        coordenadasPasarelas.add(new Coordenadas(i - 1, j));
                    } else {
                        Parcela aux = ParcelasFactory.crearParcela(elemento.toString(), i - 1, j);
                        mapaLeido.agregarParcela(aux);
                    }
                }
            }
            for (int i = 0; i <= coordenadasPasarelas.size() - 2; i++) {
                Pasarela aux = new Pasarela(coordenadasPasarelas.get(i));
                if (coordenadasPasarelas.get(i).getX() == coordenadasPasarelas.get(i + 1).getX()) {
                    aux.setSiguiente(new Abajo());
                }
                mapaLeido.agregarParcela(aux);
            }
            mapaLeido.setMeta(new Meta(coordenadasPasarelas.get(coordenadasPasarelas.size() - 1)));
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
                        Enemigo enemigo = EnemigosFactory.crearEnemigo(nombreEnemigo);
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



