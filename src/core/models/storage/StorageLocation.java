package core.models.storage;

import core.models.ILocation; // Usar la interfaz


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StorageLocation implements ILocationStorage {
    private static ILocationStorage instance;
    private List<ILocation> locationsList; // Almacena la interfaz

    private StorageLocation() {
        locationsList = new ArrayList<>();
    }

    public static synchronized ILocationStorage getInstance() {
        if (instance == null) {
            instance = new StorageLocation();
        }
        return instance;
    }

    @Override
    public boolean exists(String airportId) {
        for (ILocation loc : locationsList) {
            if (loc.getAirportId().equals(airportId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(ILocation location) { // Acepta la interfaz
        if (location == null || exists(location.getAirportId())) {
            return false;
        }
        locationsList.add(location); // Añade la instancia de la interfaz
        return true;
    }

    @Override
    public ILocation getOriginal(String airportId) { // Devuelve la interfaz
        for (ILocation loc : locationsList) {
            if (loc.getAirportId().equals(airportId)) {
                return loc;
            }
        }
        return null;
    }

    @Override
    public ILocation get(String airportId) { // Devuelve la interfaz (copia)
        ILocation originalLocation = getOriginal(airportId);
        if (originalLocation != null) {
            return originalLocation.copy(); // Usa el método copy() del modelo
        }
        return null;
    }

    @Override
    public List<ILocation> getAll() { // Devuelve lista de interfaces (copias)
        List<ILocation> copiedList = new ArrayList<>();
        for (ILocation loc : locationsList) {
            copiedList.add(loc.copy()); // Usa el método copy()
        }
        Collections.sort(copiedList, Comparator.comparing(ILocation::getAirportId));
        return copiedList;
    }

    @Override
    public List<String> getAllEntityIds() {
        return locationsList.stream()
                .map(ILocation::getAirportId) // Llama al método de la interfaz
                .sorted()
                .collect(Collectors.toList());
    }
}