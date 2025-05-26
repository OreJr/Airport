package core.models.storage;

import core.models.IPassenger; // Usar la interfaz
// import core.models.Passenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StoragePassenger implements IPassengerStorage {
    private static IPassengerStorage instance;
    private List<IPassenger> passengersList; // Almacena la interfaz

    private StoragePassenger() {
        passengersList = new ArrayList<>();
    }

    public static synchronized IPassengerStorage getInstance() {
        if (instance == null) {
            instance = new StoragePassenger();
        }
        return instance;
    }

    @Override
    public boolean exists(Long id) { // El ID es Long para Passenger
        for (IPassenger p : passengersList) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(IPassenger passenger) { // Acepta la interfaz
        if (passenger == null || exists(passenger.getId())) {
            return false;
        }
        passengersList.add(passenger); // Añade la instancia de la interfaz
        return true;
    }

    @Override
    public IPassenger getOriginal(Long id) { // Devuelve la interfaz
        for (IPassenger p : passengersList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public IPassenger get(Long id) { // Devuelve la interfaz (copia)
        IPassenger originalPassenger = getOriginal(id);
        if (originalPassenger != null) {
            return originalPassenger.copy(); // Usa el método copy() del modelo
        }
        return null;
    }

    @Override
    public List<IPassenger> getAll() { // Devuelve lista de interfaces (copias)
        List<IPassenger> copiedList = new ArrayList<>();
        for (IPassenger p : passengersList) {
            copiedList.add(p.copy()); // Usa el método copy()
        }
        Collections.sort(copiedList, Comparator.comparingLong(IPassenger::getId));
        return copiedList;
    }

    @Override
    public List<Long> getAllEntityIds() { // Devuelve List<Long>
        return passengersList.stream()
                .map(IPassenger::getId) // Llama al método de la interfaz
                .sorted()
                .collect(Collectors.toList());
    }
}