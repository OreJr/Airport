package core.models;

import core.utils.CopyContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight implements IFlight {
    
    private final String id;
    private List<IPassenger> passengers; 
    private IPlane plane;
    private ILocation departureLocation;
    private ILocation scaleLocation;
    private ILocation arrivalLocation;
    private LocalDateTime departureDate;
    private int hoursDurationArrival;
    private int minutesDurationArrival;
    private int hoursDurationScale;
    private int minutesDurationScale;
    
    public Flight(String id, IPlane plane, ILocation departureLocation, ILocation arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = 0; 
        this.minutesDurationScale = 0;
        
        if (this.plane != null) {
            this.plane.addFlight(this); 
        }
    }

    public Flight(String id, IPlane plane, ILocation departureLocation, ILocation scaleLocation, ILocation arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.scaleLocation = scaleLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = hoursDurationScale;
        this.minutesDurationScale = minutesDurationScale;
        
        if (this.plane != null) {
           this.plane.addFlight(this); 
        }
    }
    
    private Flight(String id, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {
        this.id = id;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = hoursDurationScale;
        this.minutesDurationScale = minutesDurationScale;
        this.passengers = new ArrayList<>();
    }

    @Override
    public String getId() { return id; }
    
    @Override
    public List<IPassenger> getPassengers() { 
        return new ArrayList<>(this.passengers);
    }
    
    @Override
    public IPlane getPlane() { return plane; }
    @Override
    public ILocation getDepartureLocation() { return departureLocation; }
    @Override
    public ILocation getScaleLocation() { return scaleLocation; }
    @Override
    public ILocation getArrivalLocation() { return arrivalLocation; }
    @Override
    public LocalDateTime getDepartureDate() { return departureDate; }
    @Override
    public void setDepartureDate(LocalDateTime departureDate) { this.departureDate = departureDate; }
    @Override
    public int getHoursDurationArrival() { return hoursDurationArrival; }
    @Override
    public int getMinutesDurationArrival() { return minutesDurationArrival; }
    @Override
    public int getHoursDurationScale() { return hoursDurationScale; }
    @Override
    public int getMinutesDurationScale() { return minutesDurationScale; }
    
    @Override
    public void addPassenger(IPassenger passenger) {
        if (passenger == null) return;
        boolean exists = false;
        for (IPassenger existingPassenger : this.passengers) {
            if (existingPassenger.getId() == passenger.getId()) {
                exists = true;
                break;
            }
        }
        if (!exists) {
             this.passengers.add(passenger);
        }
    }
    
    @Override
    public LocalDateTime calculateArrivalDate() { if (this.departureDate == null) return null; return departureDate.plusHours(hoursDurationScale).plusHours(hoursDurationArrival).plusMinutes(minutesDurationScale).plusMinutes(minutesDurationArrival); }
    @Override
    public void delay(int hours, int minutes) { if (this.departureDate == null) return; this.departureDate = this.departureDate.plusHours(hours).plusMinutes(minutes); }
    @Override
    public int getNumPassengers() { return this.passengers.size(); }

    @Override
    public IFlight copy(CopyContext context) {
        IFlight existingCopy = context.getCopied(this);
        if (existingCopy != null) {
            return existingCopy;
        }

        Flight newFlight = new Flight(this.id, this.departureDate, this.hoursDurationArrival, this.minutesDurationArrival, this.hoursDurationScale, this.minutesDurationScale);
        context.registerCopy(this, newFlight); // Registrar la copia ANTES de copiar campos referenciados

        if (this.departureLocation != null) {
            newFlight.departureLocation = this.departureLocation.copy(context);
        }
        if (this.arrivalLocation != null) {
            newFlight.arrivalLocation = this.arrivalLocation.copy(context);
        }
        if (this.scaleLocation != null) {
            newFlight.scaleLocation = this.scaleLocation.copy(context);
        }

        if (this.plane != null) {
            newFlight.plane = this.plane.copy(context);
        }

        if (this.passengers != null) {
            for (IPassenger originalPassenger : this.passengers) {
                if (originalPassenger != null) {
                    newFlight.addPassenger(originalPassenger.copy(context));
                }
            }
        }
        return newFlight;
    }
}