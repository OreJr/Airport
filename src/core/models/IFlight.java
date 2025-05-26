package core.models;

import core.utils.CopyContext;
import java.time.LocalDateTime;
import java.util.List;

public interface IFlight {
    String getId();
    List<IPassenger> getPassengers();
    IPlane getPlane();
    ILocation getDepartureLocation();
    ILocation getScaleLocation();
    ILocation getArrivalLocation();
    LocalDateTime getDepartureDate();
    void setDepartureDate(LocalDateTime departureDate);
    int getHoursDurationArrival();
    int getMinutesDurationArrival();
    int getHoursDurationScale();
    int getMinutesDurationScale();
    void addPassenger(IPassenger passenger);
    LocalDateTime calculateArrivalDate();
    void delay(int hours, int minutes);
    int getNumPassengers();

    IFlight copy(CopyContext context);
    default IFlight copy() {
        return copy(new CopyContext());
    }
}