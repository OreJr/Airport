package core.models.storage;

import core.models.IFlight; // Usar la interfaz
// import core.models.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StorageFlight implements IFlightStorage {
    private static IFlightStorage instance;
    private List<IFlight> flightsList; // Almacena la interfaz

    private StorageFlight() {
        flightsList = new ArrayList<>();
    }

    public static synchronized IFlightStorage getInstance() {
        if (instance == null) {
            instance = new StorageFlight();
        }
        return instance;
    }

    @Override
    public boolean exists(String id) {
        for (IFlight f : flightsList) {
            if (f.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(IFlight flight) { // Acepta la interfaz
        if (flight == null || exists(flight.getId())) {
            return false;
        }
        flightsList.add(flight); // Añade la instancia de la interfaz
        return true;
    }

    @Override
    public IFlight getOriginal(String id) { // Devuelve la interfaz
        for (IFlight f : flightsList) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public IFlight get(String id) { // Devuelve la interfaz (copia)
        IFlight originalFlight = getOriginal(id);
        if (originalFlight != null) {
            return originalFlight.copy(); // Usa el método copy() del modelo
        }
        return null;
    }

    @Override
    public List<IFlight> getAll() { // Devuelve lista de interfaces (copias)
        List<IFlight> copiedList = new ArrayList<>();
        for (IFlight f : flightsList) {
            copiedList.add(f.copy()); // Usa el método copy()
        }
        // Ordenar por fecha de salida, manejando fechas nulas
        Collections.sort(copiedList, Comparator.comparing(IFlight::getDepartureDate, Comparator.nullsLast(Comparator.naturalOrder())));
        return copiedList;
    }

    @Override
    public List<String> getAllEntityIds() {
        return flightsList.stream()
                .map(IFlight::getId) // Llama al método de la interfaz
                .sorted()
                .collect(Collectors.toList());
    }
}