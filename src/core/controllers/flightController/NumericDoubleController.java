/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class NumericDoubleController {
    public static double isValidNumeric(String value) {
        double DoubleValue;
        try {
            DoubleValue = Double.parseDouble(value);
            return DoubleValue;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
