package core.models.storage;

import core.models.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Gestiona el almacenamiento en memoria para objetos de tipo Ubicación (Location) utilizando un ArrayList.
 *
 * @author JorgeDuarte and OreJr
 */
public class StorageLocation {
    private static StorageLocation instance;
    private List<Location> locationsList;

    private StorageLocation() {
        locationsList = new ArrayList<>();
    }

    /**
     * Obtiene la instancia única (Singleton) de StorageLocation.
     * @return La instancia única de StorageLocation.
     */
    public static synchronized StorageLocation getInstance() {
        if (instance == null) {
            instance = new StorageLocation();
        }
        return instance;
    }

    /**
     * Verifica si ya existe una ubicación con el ID de aeropuerto proporcionado.
     * @param airportId El ID del aeropuerto a verificar.
     * @return true si una ubicación con ese ID existe, false en caso contrario.
     */
    public boolean locationExists(String airportId) {
        for (Location loc : locationsList) {
            if (loc.getAirportId().equals(airportId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade una nueva ubicación al almacenamiento si el ID de aeropuerto es único.
     * @param location La ubicación a añadir.
     * @return true si la ubicación fue añadida exitosamente, false si ya existe una ubicación con el mismo ID.
     */
    public boolean addLocation(Location location) {
        if (locationExists(location.getAirportId())) {
            return false; 
        }
        locationsList.add(location);
        return true;
    }

    /**
     * Recupera una copia de la ubicación con el ID de aeropuerto especificado.
     * @param airportId El ID del aeropuerto de la ubicación a recuperar.
     * @return Una copia del objeto Location si se encuentra, o null en caso contrario.
     */
    public Location getLocation(String airportId) {
        for (Location loc : locationsList) {
            if (loc.getAirportId().equals(airportId)) {
                return new Location(loc); 
            }
        }
        return null;
    }
    
    /**
     * Recupera el objeto Ubicación original con el ID de aeropuerto especificado.
     * Este método es usado internamente por los controladores.
     * @param airportId El ID del aeropuerto de la ubicación a recuperar.
     * @return El objeto Location original si se encuentra, o null en caso contrario.
     */
    public Location getOriginalLocation(String airportId) {
        for (Location loc : locationsList) {
            if (loc.getAirportId().equals(airportId)) {
                return loc; 
            }
        }
        return null;
    }

    /**
     * Recupera una lista de copias de todas las ubicaciones, ordenada por ID de aeropuerto.
     * @return Una nueva lista conteniendo copias de todas las ubicaciones almacenadas.
     */
    public List<Location> getAllLocations() {
        List<Location> copiedList = new ArrayList<>();
        for (Location loc : locationsList) {
            copiedList.add(new Location(loc)); 
        }
        Collections.sort(copiedList, Comparator.comparing(Location::getAirportId));
        return copiedList;
    }
}