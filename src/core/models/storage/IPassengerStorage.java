package core.models.storage;

import core.models.IPassenger; // Importa la interfaz del modelo

public interface IPassengerStorage extends IStorage<IPassenger, Long> {
    // Long es el tipo de su ID
}