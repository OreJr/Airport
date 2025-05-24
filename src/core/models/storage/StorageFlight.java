package core.models.storage;

import core.models.Flight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Gestiona el almacenamiento en memoria para objetos de tipo Vuelo (Flight) utilizando un ArrayList.
 *
 * @author JorgeDuarte
 */
public class StorageFlight {
    private static StorageFlight instance;
    private List<Flight> flightsList;

    private StorageFlight() {
        flightsList = new ArrayList<>();
    }

    /**
     * Obtiene la instancia única (Singleton) de StorageFlight.
     * @return La instancia única de StorageFlight.
     */
    public static synchronized StorageFlight getInstance() {
        if (instance == null) {
            instance = new StorageFlight();
        }
        return instance;
    }

    /**
     * Verifica si ya existe un vuelo con el ID proporcionado.
     * @param id El ID del vuelo a verificar.
     * @return true si un vuelo con ese ID existe, false en caso contrario.
     */
    public boolean flightExists(String id) {
        for (Flight f : flightsList) {
            if (f.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade un nuevo vuelo al almacenamiento si el ID es único.
     * @param flight El vuelo a añadir.
     * @return true si el vuelo fue añadido exitosamente, false si ya existe un vuelo con el mismo ID.
     */
    public boolean addFlight(Flight flight) {
        if (flightExists(flight.getId())) {
            return false; 
        }
        flightsList.add(flight);
        return true;
    }

    /**
     * Recupera el objeto Vuelo original con el ID especificado.
     * Este método es usado internamente por los controladores.
     * @param id El ID del vuelo a recuperar.
     * @return El objeto Flight original si se encuentra, o null en caso contrario.
     */
    public Flight getOriginalFlight(String id) {
        for (Flight f : flightsList) {
            if (f.getId().equals(id)) {
                return f; 
            }
        }
        return null;
    }
    
    /**
     * Recupera una copia del vuelo con el ID especificado.
     * @param id El ID del vuelo a recuperar.
     * @return Una copia del objeto Flight si se encuentra, o null en caso contrario.
     */
    public Flight getFlightCopy(String id) {
        for (Flight f : flightsList) {
            if (f.getId().equals(id)) {
                return new Flight(f); 
            }
        }
        return null;
    }

    /**
     * Recupera una lista de copias de todos los vuelos, ordenada por fecha de salida.
     * @return Una nueva lista conteniendo copias de todos los vuelos almacenados.
     */
    public List<Flight> getAllFlights() {
        List<Flight> copiedList = new ArrayList<>();
        for (Flight f : flightsList) {
            copiedList.add(new Flight(f)); 
        }
        Collections.sort(copiedList, Comparator.comparing(Flight::getDepartureDate));
        return copiedList;
    }

    public List<String> getAllIdFlights() {
        List<Flight> flights = getAllFlights();
      List<String> ids = new ArrayList<>();
      for (Flight flight: flights){
          ids.add(flight.getId());
      }
      return ids;
    }
}