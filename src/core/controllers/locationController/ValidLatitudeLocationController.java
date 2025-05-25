/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

/**
 *
 * @author OreJr
 */
public class ValidLatitudeLocationController {
    public static boolean isValidLatitude(double latitude) {
        return latitude >= -90 && latitude <= 90;
    }
}
