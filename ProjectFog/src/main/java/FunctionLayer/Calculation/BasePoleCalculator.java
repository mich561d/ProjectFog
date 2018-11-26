package FunctionLayer.Calculation;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class BasePoleCalculator {

    public ArrayList<Part> calcPoles(ArrayList<Part> parts, int length, int width, int height) throws FogException {
        int calcHeight = height + 90;
        int poles = 0;
        poles += calcPolesSides(length);
        poles += calcPolesBack(width);
        for (int i = 0; i < poles; i++) {
            String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + calcHeight + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            while (part == null) {
                size = "97x97mm " + ++calcHeight + "cm";
                part = DatabaseFacade.getPart(type, material, size);
            }
            parts.add(part);
        }
        return parts;
    }

    private int calcPolesSides(int length) {
        int poles = 0;
        int maxDistance = 300;
        double estPolesSides = ((float) length - 30) / (float) maxDistance;
        poles += Math.ceil(estPolesSides) + 1;
        poles *= 2; // For both sides
        return poles;
    }

    private int calcPolesBack(int width) {
        int poles = 0;

        if (width >= 300) {
            int maxDistance = 300;
            double estPolesSides = ((float) width - 30) / (float) maxDistance;
            poles += Math.ceil(estPolesSides) - 1;
        }
        return poles;
    }
}
