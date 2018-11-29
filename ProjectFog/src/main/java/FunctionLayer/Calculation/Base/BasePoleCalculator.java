package FunctionLayer.Calculation.Base;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Christian & Michael
 */
public class BasePoleCalculator {

    public ArrayList<Part> calcPoles(ArrayList<Part> parts, int length, int width, int height) throws FogException {
        int poles = 0;
        poles += calcPolesSides(length);
        poles += calcPolesBack(width);
        AddPartToList(height, poles, parts);
        return parts;
    }

    private void AddPartToList(int height, int poles, ArrayList<Part> parts) throws FogException {
        int calcHeight = height + POLELENGTHUNDERGROUND;
        for (int i = 0; i < poles; i++) {
            String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + calcHeight + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            while (part == null) {
                size = "97x97mm " + ++calcHeight + "cm";
                part = DatabaseFacade.getPart(type, material, size);
            }
            parts.add(part);
        }
    }

    private int calcPolesSides(int length) {
        int poles = 0;
        double estPolesSides = ((double) length - 30) / (double) MAXDISTANCEBEWTEENPOLES;
        poles += Math.ceil(estPolesSides) + 1;
        poles *= 2; // For both sides
        return poles;
    }

    private int calcPolesBack(int width) {
        int poles = 0;
        if (width >= MAXDISTANCEBEWTEENPOLES) {
            double estPolesSides = ((double) width - 30) / (double) MAXDISTANCEBEWTEENPOLES;
            poles += Math.ceil(estPolesSides) - 1;
        }
        return poles;
    }
}
