/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.Storage;
import java.time.LocalDate;

/**
 *
 * @author OreJr
 */
public class PassengerControler {

    public static Response addPassenger(long id, String firstname, String lastname, int year, int month, int day, int phoneCode, long phone, String country) {
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

            Storage storage = Storage.getInstance();
            if (!storage.addPassenger(new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country))) {
                return new Response("A passenger with that id already exists", Status.BAD_REQUEST);
            }

            return new Response("Person created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
