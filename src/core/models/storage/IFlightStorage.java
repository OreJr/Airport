package core.models.storage;

import core.models.IFlight; // Importa la interfaz del modelo

public interface IFlightStorage extends IStorage<IFlight, String> {
    // IFlight es el tipo de entidad que maneja
    // String es el tipo de su ID
}