package core.models.storage;

import core.models.Plane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Gestiona el almacenamiento en memoria para objetos de tipo Avión (Plane) utilizando un ArrayList.
 *
 * @author JorgeDuarte
 */
public class StoragePlane {
    private static StoragePlane instance;
    private List<Plane> planesList;

    private StoragePlane() {
        planesList = new ArrayList<>();
    }

    /**
     * Obtiene la instancia única (Singleton) de StoragePlane.
     * @return La instancia única de StoragePlane.
     */
    public static synchronized StoragePlane getInstance() {
        if (instance == null) {
            instance = new StoragePlane();
        }
        return instance;
    }

    /**
     * Verifica si ya existe un avión con el ID proporcionado.
     * @param id El ID del avión a verificar.
     * @return true si un avión con ese ID existe, false en caso contrario.
     */
    public boolean planeExists(String id) {
        for (Plane p : planesList) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade un nuevo avión al almacenamiento si el ID es único.
     * @param plane El avión a añadir.
     * @return true si el avión fue añadido exitosamente, false si ya existe un avión con el mismo ID.
     */
    public boolean addPlane(Plane plane) {
        if (planeExists(plane.getId())) {
            return false; 
        }
        planesList.add(plane);
        return true;
    }

    /**
     * Recupera una copia del avión con el ID especificado.
     * @param id El ID del avión a recuperar.
     * @return Una copia del objeto Plane si se encuentra, o null en caso contrario.
     */
    public Plane getPlane(String id) {
        for (Plane p : planesList) {
            if (p.getId().equals(id)) {
                return new Plane(p); 
            }
        }
        return null;
    }

    /**
     * Recupera el objeto Avión original con el ID especificado.
     * Este método es usado internamente por los controladores.
     * @param id El ID del avión a recuperar.
     * @return El objeto Plane original si se encuentra, o null en caso contrario.
     */
    public Plane getOriginalPlane(String id) {
        for (Plane p : planesList) {
            if (p.getId().equals(id)) {
                return p; 
            }
        }
        return null;
    }

    /**
     * Recupera una lista de copias de todos los aviones, ordenada por ID.
     * @return Una nueva lista conteniendo copias de todos los aviones almacenados.
     */
    public List<Plane> getAllPlanes() {
        List<Plane> copiedList = new ArrayList<>();
        for (Plane p : planesList) {
            copiedList.add(new Plane(p));
        }
        Collections.sort(copiedList, Comparator.comparing(Plane::getId));
        return copiedList;
    }
}