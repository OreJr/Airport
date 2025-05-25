/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class ExistScaleLocationController {

    public static boolean ExistScaleLocation(String scaleLocationId) {
        if (scaleLocationId != null && !scaleLocationId.trim().isEmpty()
                && !scaleLocationId.equalsIgnoreCase("Location") && !scaleLocationId.equalsIgnoreCase("None")) {
            return true;
        }
        return false;
    }
}
