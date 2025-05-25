/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.StoragePassenger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period; // Importado para calcular la edad

/**
 *
 * @author JorgeDuarte and OreJr 
 */
public class CreatePassengerController { 

    public static Response createPassenger(String id, String firstname, String lastname, String year, String month, String day, String phoneCode, String phone, String country) {
        try {
            long longId;
            try {
                longId = Long.parseLong(id);
                if (longId < 0) {
                    return new Response("El ID del pasajero debe ser no negativo.", Status.BAD_REQUEST);
                }
                if (String.valueOf(longId).length() > 15) {
                    return new Response("El ID del pasajero debe tener como máximo 15 dígitos.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("El ID del pasajero debe ser numérico.", Status.BAD_REQUEST);
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
                    return new Response("Fecha de nacimiento inválida.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Los componentes de la fecha de nacimiento deben ser numéricos.", Status.BAD_REQUEST);
            }

            LocalDate today = LocalDate.now(); 
            if (birthDate.isEqual(today)) {
                return new Response("La fecha de nacimiento no puede ser la fecha actual.", Status.BAD_REQUEST);
            }
            if (birthDate.isAfter(today)) { 
                return new Response("La fecha de nacimiento no puede ser una fecha futura.", Status.BAD_REQUEST);
            }

            Period age = Period.between(birthDate, today);
            if (age.getYears() >= 130) { // CAMBIO: Límite de edad a 130
                return new Response("El pasajero no puede tener 130 años o más.", Status.BAD_REQUEST);
            }

            if (firstname == null || firstname.trim().isEmpty()) {
                return new Response("El nombre no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (lastname == null || lastname.trim().isEmpty()) {
                return new Response("El apellido no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (country == null || country.trim().isEmpty()) {
                return new Response("El país no debe estar vacío.", Status.BAD_REQUEST);
            }

            int intPhoneCode;
            long longPhone;
            try {
                intPhoneCode = Integer.parseInt(phoneCode);
                if (intPhoneCode < 0 || String.valueOf(intPhoneCode).length() > 3) {
                    return new Response("Código telefónico inválido (debe ser no negativo, máx 3 dígitos).", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("El código telefónico debe ser numérico.", Status.BAD_REQUEST);
            }

            try {
                longPhone = Long.parseLong(phone);
                if (longPhone < 0 || String.valueOf(longPhone).length() > 11) {
                    return new Response("Número de teléfono inválido (debe ser no negativo, máx 11 dígitos).", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("El teléfono debe ser numérico.", Status.BAD_REQUEST);
            }

            StoragePassenger storage = StoragePassenger.getInstance();
            Passenger newPassenger = new Passenger(longId, firstname.trim(), lastname.trim(), birthDate, intPhoneCode, longPhone, country.trim());

            if (!storage.addPassenger(newPassenger)) {
                return new Response("Un pasajero con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Pasajero creado exitosamente.", Status.CREATED, new Passenger(newPassenger));
        } catch (Exception ex) {
            return new Response("Error inesperado durante la creación del pasajero: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}