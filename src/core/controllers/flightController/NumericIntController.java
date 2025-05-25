/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class NumericIntController {

    public static int isValidNumeric(String value) {
        int intValue;
        try {
            intValue = Integer.parseInt(value);
            return intValue;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
