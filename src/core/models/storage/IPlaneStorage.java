package core.models.storage;

import core.models.IPlane; // Importa la interfaz del modelo

public interface IPlaneStorage extends IStorage<IPlane, String> {
    // IPlane es el tipo de entidad
    // String es el tipo de su ID
}