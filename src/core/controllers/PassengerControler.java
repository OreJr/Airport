/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.StoragePassenger;
import java.time.LocalDate;

/**
 *
 * @author OreJr
 */
public class PassengerControler {

    public static Response createPassenger(long id, String firstname, String lastname, int year, int month, int day, int phoneCode, long phone, String country) {
        try {
            //antes de  establecer el LocalDate, validar  año,  mes y  dia
            LocalDate birthDate = LocalDate.of(year, month, day);
            if (firstname.equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }

            if (lastname.equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }

            if (country.equals("")) {
                return new Response("country must be not empty", Status.BAD_REQUEST);
            }

            StoragePassenger storage = StoragePassenger.getInstance();
            if (!storage.addPassenger(new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country))) {
                return new Response("A passenger with that id already exists", Status.BAD_REQUEST);
            }

            return new Response("Person created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response updatePerson(long id, String firstname, String lastname, int year, int month, int day, int phoneCode, long phone, String country) {
        try {

            try {
                if (id < 0) {
                    return new Response("Id must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }

            StoragePassenger storage = StoragePassenger.getInstance();

            Passenger passenger = storage.getPassenger(id);
            if (passenger == null) {
                return new Response("passenger not found", Status.NOT_FOUND);
            }

            if (firstname.equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }

            if (lastname.equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }

            if (country.equals("")) {
                return new Response("country must be not empty", Status.BAD_REQUEST);
            }
            
            //antes de  establecer el LocalDate, validar  año,  mes y  dia
            LocalDate birthDate = LocalDate.of(year, month, day);
            
            
            passenger.setFirstname(firstname);
            passenger.setLastname(lastname);
            passenger.setBirthDate(birthDate);
            passenger.setCountryPhoneCode(phoneCode);
            passenger.setPhone(phone);
            passenger.setCountry(country);

            return new Response("Person data updated successfully", Status.OK);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
