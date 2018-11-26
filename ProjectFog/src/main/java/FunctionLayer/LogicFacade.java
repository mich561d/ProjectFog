package FunctionLayer;

import FunctionLayer.Calculation.CarportCalculator;
import FunctionLayer.Util.UtilCarportDrawing;
import FunctionLayer.Entities.Part;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class LogicFacade {

    private static CarportCalculator cc = new CarportCalculator(0, 0, 0, 0, false);

    public static void calculateCustomCarport(int length, int width, int height, int angle, boolean angledRoof) throws FogException {
        cc = new CarportCalculator(length, width, height, angle, angledRoof);
        cc.calcCarport();
    }

    public static double getPriceFromCarport() throws FogException {
        return cc.getTotalPrice();
    }

    public static ArrayList<Part> getProductsFromCarport() throws FogException {
        return cc.getProductList();
    }

    public static String getDrawingFromAbove(int length, int width) {
        return UtilCarportDrawing.drawSchematicViewFromAbove(length, width);
    }

    public static String getDrawingFromAside(int length, int height) {
        return UtilCarportDrawing.drawSchematicViewFromAside(length, height);
    }

    public static String getDrawingFromFront(int width, int height) {
        return UtilCarportDrawing.drawSchematicViewFromFront(width, height);
    }
}
