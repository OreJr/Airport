/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import java.time.LocalDateTime;

/**
 *
 * @author OreJr
 */
public class CreateFlightController {

    public static Flight createFlight(String id, Plane originalPlane, Location originalDepartureLocation, Location originalArrivalLocation, Location originalScaleLocation,
            LocalDateTime departureDateTime, int intHoursDurationArrival, int intMinutesDurationArrival, int intHoursDurationScale, int intMinutesDurationScale) {
        Flight newFlight = null;
        
        newFlight = new Flight(id, originalPlane, originalDepartureLocation, originalScaleLocation, originalArrivalLocation,
                departureDateTime, intHoursDurationArrival, intMinutesDurationArrival,
                intHoursDurationScale, intMinutesDurationScale);

        return newFlight;
    }

    public static Flight createFlight(String id, Plane originalPlane, Location originalDepartureLocation, Location originalArrivalLocation,
            LocalDateTime departureDateTime, int intHoursDurationArrival, int intMinutesDurationArrival) {
        Flight newFlight = null;
        newFlight = new Flight(id, originalPlane, originalDepartureLocation, originalArrivalLocation,
                departureDateTime, intHoursDurationArrival, intMinutesDurationArrival);

        return newFlight;
    }
}
