/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;
/**
 *
 * @author JorgeDuarte
 */
public class ValidAirportIdFormatLocationController {

    public static boolean isValidAirportIdFormat(String airportId) {
        if (airportId == null || airportId.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char c = airportId.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
}
