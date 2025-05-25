/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author JorgeDuarte
 */
public class ValidFlightIdFormatController {

    public static boolean isValidFlightIdFormat(String id) {
        if (id == null || id.length() != 6) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char c = id.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        for (int i = 3; i < 6; i++) {
            char c = id.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
