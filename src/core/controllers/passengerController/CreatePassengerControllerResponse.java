/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.flightController.NumericIntController;
import core.controllers.flightController.NumericLongController;
import core.controllers.flightController.ValidCreateLocalDateTimeController;
import core.controllers.flightController.ValidStringNotEmpty;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import java.time.LocalDate;

/**
 *
 * @author JorgeDuarte and OreJr
 */
public class CreatePassengerControllerResponse {

    public static Response createPassenger(String id, String firstname, String lastname, String year, String month, String day, String phoneCode, String phone, String country) {
        try {
            long longId;

            longId = NumericLongController.isValidNumeric(id);
            if (longId == -1) {
                return new Response("El ID del pasajero debe ser numérico.", Status.BAD_REQUEST);
            } else {

                if (!ValidPassengerIdFormatController.isValidPassengerIdFormat(longId)) {
                    return new Response("El ID del pasajero debe ser positivo y tener como máximo 15 dígitos.", Status.BAD_REQUEST);
                }
            }

            LocalDate birthDate;
            int intYear = NumericIntController.isValidNumeric(year),
                    intMonth = NumericIntController.isValidNumeric(month),
                    intDay = NumericIntController.isValidNumeric(day);
            if (intYear == -1 || intMonth == -1 || intDay == -1) {
                return new Response("Los componentes de la fecha de nacimiento deben ser numéricos.", Status.BAD_REQUEST);
            } else {
                birthDate = ValidCreateLocalDateTimeController.isValidLocalDateTime(intYear, intMonth, intDay);
                if (birthDate == null) {
                    return new Response("Fecha de nacimiento inválida.", Status.BAD_REQUEST);
                }
            }

            LocalDate today = LocalDate.now();
            if (EqualTodayController.isEqualToToday(birthDate, today)) {
                return new Response("La fecha de nacimiento no puede ser la fecha actual.", Status.BAD_REQUEST);
            }
            if (AfterTodayController.isAfterToToday(birthDate, today)) {
                return new Response("La fecha de nacimiento no puede ser una fecha futura.", Status.BAD_REQUEST);
            }

            if (PeriodBirthdayController.period(birthDate, today)) { // CAMBIO: Límite de edad a 130
                return new Response("El pasajero no puede tener 130 años o más.", Status.BAD_REQUEST);
            }

            if (ValidStringNotEmpty.isValid(firstname.trim())) {
                return new Response("El nombre no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(lastname.trim())) {
                return new Response("El apellido no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(country.trim())) {
                return new Response("El país no debe estar vacío.", Status.BAD_REQUEST);
            }

            int intPhoneCode;
            long longPhone;

            intPhoneCode = NumericIntController.isValidNumeric(phoneCode);
            if (intPhoneCode == -1) {
                return new Response("El código telefónico debe ser numérico.", Status.BAD_REQUEST);
            } else {
                if (!ValidNumberAndCapacityController.isValidNumber(intPhoneCode, 3)) {
                    return new Response("Código telefónico inválido (debe ser no negativo, máx 3 dígitos).", Status.BAD_REQUEST);
                }
            }

            longPhone = NumericLongController.isValidNumeric(phone);
            if (longPhone == -1) {
                return new Response("El teléfono debe ser numérico.", Status.BAD_REQUEST);
            } else {
                if (!ValidNumberAndCapacityController.isValidNumber(longPhone)) {
                    return new Response("Número de teléfono inválido (debe ser no negativo, máx 11 dígitos).", Status.BAD_REQUEST);
                }
            }

            Passenger newPassenger = CreatePassengerController.createPassenger(longId, firstname.trim(), lastname.trim(), birthDate, intPhoneCode, longPhone, country.trim());

            if (newPassenger == null) {
                return new Response("Error inesperado durante la creación del pasajero", Status.INTERNAL_SERVER_ERROR);
            }

            if (!AddPassengerController.add(newPassenger)) {
                return new Response("Un pasajero con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Pasajero creado exitosamente.", Status.CREATED, new Passenger(newPassenger));
        } catch (Exception ex) {
            return new Response("Error inesperado durante la creación del pasajero: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
