package core.models;

import core.utils.CopyContext;
import java.util.ArrayList;
import java.util.List; 

public class Plane implements IPlane {
    
    private final String id;
    private String brand;
    private String model;
    private final int maxCapacity;
    private String airline;
    private List<IFlight> flights; 

    public Plane(String id, String brand, String model, int maxCapacity, String airline) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
        this.flights = new ArrayList<>();
    }

    @Override
    public String getId() { return id; }
    @Override
    public String getBrand() { return brand; }
    @Override
    public String getModel() { return model; }
    @Override
    public int getMaxCapacity() { return maxCapacity; }
    @Override
    public String getAirline() { return airline; }
    
    @Override
    public List<IFlight> getFlights() { 
        return new ArrayList<>(this.flights);
    }
    
    @Override
    public int getNumFlights() { return this.flights.size(); }

    @Override
    public void addFlight(IFlight flight) {
        if (flight == null) return;
        boolean exists = false;
        for (IFlight existingFlight : this.flights) {
            if (existingFlight.getId().equals(flight.getId())) { 
                exists = true;
                break;
            }
        }
        if (!exists) {
            this.flights.add(flight);
        }
    }

    @Override
    public IPlane copy(CopyContext context) {
        IPlane existingCopy = context.getCopied(this);
        if (existingCopy != null) {
            return existingCopy;
        }

        Plane newPlane = new Plane(this.id, this.brand, this.model, this.maxCapacity, this.airline);
        context.registerCopy(this, newPlane); // Registrar la copia ANTES de copiar campos referenciados

        if (this.flights != null) {
            for (IFlight originalFlight : this.flights) {
                if (originalFlight != null) {
                    newPlane.addFlight(originalFlight.copy(context));
                }
            }
        }
        return newPlane;
    }
}