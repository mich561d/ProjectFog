package FunctionLayer.Calculation.Shed;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import static FunctionLayer.Calculation.Rules.*;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;

/**
 *
 * @author Michael & Christian
 */
public class ShedPolesCalculator {

    private ArrayList<Part> parts;

    public ArrayList<Part> calcPoles(int length, int width, int height, int shedLength, int shedWidth, ArrayList<Part> parts) throws FogException {
        this.parts = parts;
        calcMorePoles(shedLength, length, shedWidth, width, height);
        return parts;
    }

    private void calcMorePoles(int shedLength, int length, int shedWidth, int width, int height) throws FogException {
        int extraPolesForShed = POLESPERDOOR * DOORSPERSHED;
        if (shedLength - POLEHALFTHICKNESS < length - DOUBLEPOLEOFFSET) {
            extraPolesForShed++;
            if (shedWidth - POLEHALFTHICKNESS < width - DOUBLEPOLEOFFSET) {
                extraPolesForShed += 2;
            } else {
                extraPolesForShed++;
            }
        } else if (shedWidth - POLEHALFTHICKNESS < width - DOUBLEPOLEOFFSET) {
            extraPolesForShed += 2;
        }
        int calcHeight = height + POLELENGTHUNDERGROUND;
        addPartToList(extraPolesForShed, "Stolpe", "Trykimp Fyr", "97x97mm " + CalculatorHelper.getLengthOfPole(calcHeight) + "cm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < count; i++) {
            parts.add(part);
        }
    }
}
