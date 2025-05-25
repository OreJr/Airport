/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author OreJr
 */
public class RoundToFourDecimalsLocationController {
    public static double roundToFourDecimals(double value) {
        return BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
}
