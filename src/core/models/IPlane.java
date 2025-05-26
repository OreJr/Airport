package core.models;

import core.utils.CopyContext;
import java.util.List;

public interface IPlane {
    String getId();
    String getBrand();
    String getModel();
    int getMaxCapacity();
    String getAirline();
    List<IFlight> getFlights();
    int getNumFlights();
    void addFlight(IFlight flight);

    IPlane copy(CopyContext context);
    default IPlane copy() {
        return copy(new CopyContext());
    }
}