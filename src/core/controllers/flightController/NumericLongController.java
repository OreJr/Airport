/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class NumericLongController {

    public static long isValidNumeric(String passengerIdParam) {
        long longPassengerId;
        try {
            longPassengerId = Long.parseLong(passengerIdParam);
            return longPassengerId;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
