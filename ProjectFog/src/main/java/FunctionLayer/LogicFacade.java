package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class LogicFacade {

    public static double CalculateCustomCarportPrice(int length, int width, int height) {
        return new CarportCalculator(height, length, width).calcCarport();
    }

    public static ArrayList<String> GetProductListFromCalculatedCustomCarport(int length, int width, int height) {
        CarportCalculator CC = new CarportCalculator(height, length, width);
        CC.calcCarport();
        return CC.getProductList();
    }
}
