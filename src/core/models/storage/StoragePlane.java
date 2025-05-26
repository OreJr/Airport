package core.models.storage;

import core.models.IPlane; // Usar la interfaz


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StoragePlane implements IPlaneStorage {
    private static IPlaneStorage instance;
    private List<IPlane> planesList; // Almacena la interfaz

    private StoragePlane() {
        planesList = new ArrayList<>();
    }

    public static synchronized IPlaneStorage getInstance() {
        if (instance == null) {
            instance = new StoragePlane();
        }
        return instance;
    }

    @Override
    public boolean exists(String id) {
        for (IPlane p : planesList) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(IPlane plane) { // Acepta la interfaz
        if (plane == null || exists(plane.getId())) {
            return false;
        }
        planesList.add(plane); // Añade la instancia de la interfaz
        return true;
    }

    @Override
    public IPlane getOriginal(String id) { // Devuelve la interfaz
        for (IPlane p : planesList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public IPlane get(String id) { // Devuelve la interfaz (copia)
        IPlane originalPlane = getOriginal(id);
        if (originalPlane != null) {
            return originalPlane.copy(); // Usa el método copy() del modelo
        }
        return null;
    }

    @Override
    public List<IPlane> getAll() { // Devuelve lista de interfaces (copias)
        List<IPlane> copiedList = new ArrayList<>();
        for (IPlane p : planesList) {
            copiedList.add(p.copy()); // Usa el método copy()
        }
        Collections.sort(copiedList, Comparator.comparing(IPlane::getId));
        return copiedList;
    }

    @Override
    public List<String> getAllEntityIds() {
        return planesList.stream()
                .map(IPlane::getId) // Llama al método de la interfaz
                .sorted()
                .collect(Collectors.toList());
    }
}