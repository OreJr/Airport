/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.storage.StoragePassenger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author JorgeDuarte and OreJr
 */
public class PassengerControler {

    public static Response createPassenger(String id, String firstname, String lastname, String year, String month, String day, String phoneCode, String phone, String country) {
        try {
            long longId;
            try {
                longId = Long.parseLong(id);
                if (longId < 0) {
                    return new Response("Passenger ID must be non-negative.", Status.BAD_REQUEST);
                }
                if (String.valueOf(longId).length() > 15) {
                    return new Response("Passenger ID must have at most 15 digits.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Passenger ID must be numeric", Status.BAD_REQUEST);
            }

            LocalDate birthDate;
            int intYear, intMonth, intDay;
            try {
                intYear = Integer.parseInt(year);
                intMonth = Integer.parseInt(month);
                intDay = Integer.parseInt(day);
                try {
                    birthDate = LocalDate.of(intYear, intMonth, intDay);
                } catch (DateTimeException e) {
                    return new Response("Invalid birth date.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("birthdate must be numeric", Status.BAD_REQUEST);
            }

            if (firstname == null || firstname.trim().isEmpty()) {
                return new Response("Firstname must not be empty.", Status.BAD_REQUEST);
            }
            if (lastname == null || lastname.trim().isEmpty()) {
                return new Response("Lastname must not be empty.", Status.BAD_REQUEST);
            }
            if (country == null || country.trim().isEmpty()) {
                return new Response("Country must not be empty.", Status.BAD_REQUEST);
            }

            int intPhoneCode;
            long longPhone;
            try {
                intPhoneCode = Integer.parseInt(phoneCode);
                if (intPhoneCode < 0 || String.valueOf(intPhoneCode).length() > 3) {
                    return new Response("Invalid phone code (must be non-negative, max 3 digits).", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("phone code must be numeric", Status.BAD_REQUEST);
            }

            try {
                longPhone = Long.parseLong(phone);
                if (longPhone < 0 || String.valueOf(longPhone).length() > 11) {
                    return new Response("Invalid phone number (must be non-negative, max 11 digits).", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("birthdate must be numeric", Status.BAD_REQUEST);
            }

            StoragePassenger storage = StoragePassenger.getInstance();
            Passenger newPassenger = new Passenger(longId, firstname.trim(), lastname.trim(), birthDate, intPhoneCode, longPhone, country.trim());

            if (!storage.addPassenger(newPassenger)) {
                return new Response("A passenger with that ID already exists.", Status.BAD_REQUEST);
            }
            return new Response("Passenger created successfully.", Status.CREATED, new Passenger(newPassenger));
        } catch (Exception ex) {
            return new Response("Unexpected error during passenger creation: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response updatePassenger(String id, String firstname, String lastname, String year, String month, String day, String phoneCode, String phone, String country) {
        try {
            long longId;
            try {
                longId = Long.parseLong(id);
                if (longId < 0) {
                    return new Response("Passenger ID must be non-negative.", Status.BAD_REQUEST);
                }
                if (String.valueOf(longId).length() > 15) {
                    return new Response("Passenger ID must have at most 15 digits.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Passenger ID must be numeric", Status.BAD_REQUEST);
            }

            LocalDate birthDate;
            int intYear, intMonth, intDay;
            try {
                intYear = Integer.parseInt(year);
                intMonth = Integer.parseInt(month);
                intDay = Integer.parseInt(day);
                try {
                    birthDate = LocalDate.of(intYear, intMonth, intDay);
                } catch (DateTimeException e) {
                    return new Response("Invalid birth date.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("birthdate must be numeric", Status.BAD_REQUEST);
            }

            if (firstname == null || firstname.trim().isEmpty()) {
                return new Response("Firstname must not be empty.", Status.BAD_REQUEST);
            }
            if (lastname == null || lastname.trim().isEmpty()) {
                return new Response("Lastname must not be empty.", Status.BAD_REQUEST);
            }
            if (country == null || country.trim().isEmpty()) {
                return new Response("Country must not be empty.", Status.BAD_REQUEST);
            }

            int intPhoneCode;
            long longPhone;
            try {
                intPhoneCode = Integer.parseInt(phoneCode);
                if (intPhoneCode < 0 || String.valueOf(intPhoneCode).length() > 3) {
                    return new Response("Invalid phone code (must be non-negative, max 3 digits).", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("phone code must be numeric", Status.BAD_REQUEST);
            }

            try {
                longPhone = Long.parseLong(phone);
                if (longPhone < 0 || String.valueOf(longPhone).length() > 11) {
                    return new Response("Invalid phone number (must be non-negative, max 11 digits).", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("birthdate must be numeric", Status.BAD_REQUEST);
            }

            StoragePassenger storage = StoragePassenger.getInstance();
            Passenger passengerToUpdate = storage.getOriginalPassenger(longId);

            if (passengerToUpdate == null) {
                return new Response("Passenger not found for update.", Status.NOT_FOUND);
            }

            passengerToUpdate.setFirstname(firstname.trim());
            passengerToUpdate.setLastname(lastname.trim());
            passengerToUpdate.setBirthDate(birthDate);
            passengerToUpdate.setCountryPhoneCode(intPhoneCode);
            passengerToUpdate.setPhone(longPhone);
            passengerToUpdate.setCountry(country.trim());

            return new Response("Passenger data updated successfully.", Status.OK, new Passenger(passengerToUpdate));
        } catch (Exception ex) {
            return new Response("Unexpected error during passenger update: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getPassengerById(String id) {
        long longId;
        try {
            longId = Long.parseLong(id);
            if (longId < 0) {
                return new Response("Passenger ID must be non-negative.", Status.BAD_REQUEST);
            }
            if (String.valueOf(longId).length() > 15) {
                return new Response("Passenger ID must have at most 15 digits.", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException ex) {
            return new Response("Passenger ID must be numeric", Status.BAD_REQUEST);
        }

        StoragePassenger storage = StoragePassenger.getInstance();
        Passenger passenger = storage.getPassenger(longId);
        if (passenger == null) {
            return new Response("Passenger not found.", Status.NOT_FOUND);
        }
        return new Response("Passenger retrieved successfully.", Status.OK, passenger);
    }

    public static Response getAllPassengers() {
        try {
            StoragePassenger storage = StoragePassenger.getInstance();
            List<Passenger> passengers = storage.getAllPassengers();
            return new Response("Passengers retrieved successfully.", Status.OK, passengers);
        } catch (Exception ex) {
            return new Response("Unexpected error retrieving passengers: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getPassengerFlights(String passengerId) {
        try {
            long longId;
            try {
                longId = Long.parseLong(passengerId);
                if (longId < 0) {
                    return new Response("Passenger ID must be non-negative.", Status.BAD_REQUEST);
                }
                if (String.valueOf(longId).length() > 15) {
                    return new Response("Passenger ID must have at most 15 digits.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Passenger ID must be numeric", Status.BAD_REQUEST);
            }
            StoragePassenger storagePassenger = StoragePassenger.getInstance();
            Passenger passenger = storagePassenger.getOriginalPassenger(longId);

            if (passenger == null) {
                return new Response("Passenger not found.", Status.NOT_FOUND);
            }

            List<Flight> flights = passenger.getFlights(); // Usa el getter que devuelve copia
            Collections.sort(flights, Comparator.comparing(Flight::getDepartureDate));

            return new Response("Passenger flights retrieved successfully.", Status.OK, flights);
        } catch (Exception ex) {
            return new Response("Unexpected error retrieving passenger flights: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
