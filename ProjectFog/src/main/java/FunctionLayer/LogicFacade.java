package FunctionLayer;

import FunctionLayer.Calculation.CarportCalculator;
import FunctionLayer.Util.UtilCarportDrawing;
import FunctionLayer.Entities.Part;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael
 */
public class LogicFacade {

    private static CarportCalculator cc = new CarportCalculator(0, 0, 0, 0, false, false, 0, 0);

    public static void calculateCustomCarport(int length, int width, int height, int angle, boolean angledRoof, boolean shed, int shedLength, int shedWidth) throws FogException {
        cc = new CarportCalculator(length, width, height, angle, angledRoof, shed, shedLength, shedWidth);
        cc.calcCarport();
    }

    public static double getPriceFromCarport() throws FogException {
        return cc.getTotalPrice();
    }

    public static ArrayList<Part> getProductListFromCarport() throws FogException {
        return cc.getProductList();
    }

    public static HashMap<String, ArrayList<Part>> getProductMapFromCarport() {
        return cc.getProductMap();
    }

    public static String getDrawingFromAbove(int length, int width, boolean angledRoof) {
        return UtilCarportDrawing.drawSchematicViewFromAbove(length, width, angledRoof);
    }

    public static String getDrawingFromAside(int length, int height) {
        return UtilCarportDrawing.drawSchematicViewFromAside(length, height);
    }

    public static String getDrawingFromFront(int width, int height) {
        return UtilCarportDrawing.drawSchematicViewFromFront(width, height);
    }
}
