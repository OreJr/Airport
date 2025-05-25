/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

/**
 *
 * @author OreJr
 */
public class CountDecimalPlacesLocationController {
    public static int countDecimalPlaces(double value) {
        String stringValue = Double.toString(Math.abs(value));
        int integerPlaces = stringValue.indexOf('.');
        if (integerPlaces < 0) {
            return 0;
        } else {
            return stringValue.length() - integerPlaces - 1;
        }
    }
}
