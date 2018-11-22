package FunctionLayer;

import FunctionLayer.Entities.Part;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class LogicFacade {

    public static double calculateCustomCarportPrice(int length, int width, int height, int angle, boolean angledRoof) throws FogException {
        return new CarportCalculator(height, length, width, angle, angledRoof).calcCarport();
    }

    public static ArrayList<Part> getProductListFromCalculatedCustomCarport(int length, int width, int height, int angle, boolean angledRoof) throws FogException {
        CarportCalculator CC = new CarportCalculator(height, length, width, angle, angledRoof);
        CC.calcCarport();
        return CC.getProductList();
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
