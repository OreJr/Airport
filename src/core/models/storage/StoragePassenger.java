package core.models.storage;

import core.models.Passenger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages in-memory storage for Passenger objects using an ArrayList.
 */
public class StoragePassenger {
    private static StoragePassenger instance;
    private List<Passenger> passengersList;

    private StoragePassenger() {
        passengersList = new ArrayList<>();
    }

    public static synchronized StoragePassenger getInstance() {
        if (instance == null) {
            instance = new StoragePassenger();
        }
        return instance;
    }

    /**
     * Checks if a passenger with the given ID already exists.
     * @param id The ID to check.
     * @return True if a passenger with the ID exists, false otherwise.
     */
    public boolean passengerExists(long id) {
        for (Passenger p : passengersList) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new passenger to the storage if the ID is unique.
     * @param passenger The passenger to add.
     * @return True if the passenger was added successfully, false if a passenger with the same ID already exists.
     */
    public boolean addPassenger(Passenger passenger) {
        if (passengerExists(passenger.getId())) {
            return false; 
        }
        passengersList.add(passenger);
        return true;
    }

    /**
     * Retrieves a copy of the passenger with the specified ID.
     * @param id The ID of the passenger to retrieve.
     * @return A copy of the Passenger object if found, or null otherwise.
     */
    public Passenger getPassenger(long id) {
        for (Passenger p : passengersList) {
            if (p.getId() == id) {
                return new Passenger(p); 
            }
        }
        return null;
    }
    
    /**
     * Retrieves the original passenger object with the specified ID.
     * Used internally by controllers for updates or direct associations.
     * @param id The ID of the passenger to retrieve.
     * @return The original Passenger object if found, or null otherwise.
     */
    public Passenger getOriginalPassenger(long id) {
        for (Passenger p : passengersList) {
            if (p.getId() == id) {
                return p; 
            }
        }
        return null;
    }

    /**
     * Retrieves a list of copies of all passengers, sorted by ID.
     * @return A new list containing copies of all stored passengers.
     */
    public List<Passenger> getAllPassengers() {
        List<Passenger> copiedList = new ArrayList<>();
        for (Passenger p : passengersList) {
            copiedList.add(new Passenger(p)); 
        }
        Collections.sort(copiedList, Comparator.comparingLong(Passenger::getId));
        return copiedList;
    }
    
    public List<String> getAllIdPassengers(){
      List<Passenger> passengers = getAllPassengers();
      List<String> ids = new ArrayList<>();
      for (Passenger passenger: passengers){
          ids.add(String.valueOf(passenger.getId()));
      }
      return ids;
    }
}