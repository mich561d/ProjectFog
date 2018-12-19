package FunctionLayer.Calculation.Base;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
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
        int calcHeight = height + POLE_LENGTH_UNDER_GROUND;
        String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + CalculatorHelper.getLengthOfPole(calcHeight) + "cm";
        addPartToList(poles, type, material, size);

    }

    private int calcPolesSides(int length) {
        int poles = 0;
        double estPolesSides = ((double) length - 30) / (double) MAX_DISTANCE_BEWTEEN_POLES;
        poles += Math.ceil(estPolesSides) + 1;
        poles *= 2; // For both sides
        return poles;
    }

    private int calcPolesBack(int width) {
        int poles = 0;
        if (width >= MAX_DISTANCE_BEWTEEN_POLES) {
            double estPolesSides = ((double) width - 30) / (double) MAX_DISTANCE_BEWTEEN_POLES;
            poles += Math.ceil(estPolesSides) - 1;
        }
        return poles;
    }

    private void calcBoltAndSquarePlates(int count) throws FogException {
        int times = count + PLUS_BOLTS;
        int packOfBolt = (int) Math.ceil((double) times / (double) BOLTS_PER_PACK);
        int packOfSquares = (int) Math.ceil((double) times / (double) SQUARE_PER_PACK);
        addPartToList(packOfBolt, "Bræddebolt", "Stål", "10x20mm");
        addPartToList(packOfSquares, "Firkant Skive", "Stål", "40x40x10mm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < count; i++) {
            parts.add(part);
        }
    }
}
