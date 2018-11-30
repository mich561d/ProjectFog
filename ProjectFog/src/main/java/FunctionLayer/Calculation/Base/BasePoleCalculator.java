package FunctionLayer.Calculation.Base;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Christian & Michael
 */
public class BasePoleCalculator {

    private ArrayList<Part> parts;

    public ArrayList<Part> calcPoles(ArrayList<Part> parts, int length, int width, int height) throws FogException {
        this.parts = parts;
        int poles = 0;
        poles += calcPolesSides(length);
        poles += calcPolesBack(width);
        addPolesToList(height, poles);
        calcBoltAndSquarePlates(poles);
        return this.parts;
    }

    private void addPolesToList(int height, int poles) throws FogException {
        int calcHeight = height + POLELENGTHUNDERGROUND;
        String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + CalculatorHelper.getLengthOfPole(calcHeight) + "cm";
        addPartToList(poles, type, material, size);

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

    private void calcBoltAndSquarePlates(int count) throws FogException {
        int times = count + PLUSBOLTS;
        addPartToList(times, "Bræddebolt", "Stål", "10x20mm");
        addPartToList(times, "Firkant Skive", "Stål", "40x40x10mm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        for (int i = 0; i < count; i++) {
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
        }
    }
}
