package FunctionLayer.Calculation.Roof;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import FunctionLayer.ListToMap;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;
import FunctionLayer.Util.UtilMiddleMan;

/**
 *
 * @author Michael
 */
public class RoofAngledCalculator {

    private ArrayList<Part> parts;

    public ArrayList<Part> calcAngledRoof(ArrayList<Part> parts, int length, int width, int angle) throws FogException {
        this.parts = parts;
        UtilMiddleMan.setAngle(angle);
        /* Triangle math
        lowercase = sides, uppercase = angles
                A
              c b c
            B a C a B
         */
        double sideA = (width / 2) - (RAFTTHICKNESS / 2);
        double angleC = 90, angleB = angle, angleA = 180 - angleB - angleC;
        double sinB = Math.sin(Math.toRadians(angleB)), sinA = Math.sin(Math.toRadians(angleA));
        double sideB = (sideA * sinB) / sinA;
        double sideC = Math.sqrt((sideA * sideA) + (sideB * sideB));
        // Carport calculations
        calcSideRafts(sideC);           // Calc side rafts
        calcLongPlank(length);          // Long raft
        calcRoofPlank(sideC, length);   // Horizontal planks
        calcRoofing(sideC, length);     // Roofing
        return this.parts;
    }

    private void calcSideRafts(double length) throws FogException {
        int raftCount = ListToMap.convertListToMap(parts).get("Spær").size();
        for (int i = 0; i < raftCount; i++) {
            calcAngledRoofRafter((int) Math.ceil(length), 2);
        }
    }

    private void calcAngledRoofRafter(int l, int times) throws FogException {
        for (int length = l; length >= 0;) {
            int lengthOfRaft = CalculatorHelper.getLengthOfRaft(length);
            addPartToList(times, "Spær", "Ubh. Fyr", "47x200mm " + lengthOfRaft + "cm");
            length -= lengthOfRaft;
        }
    }

    private void calcLongPlank(int length) throws FogException {
        int lengthOfPlank = CalculatorHelper.getLengthOfRaft(length);
        addPartToList(1, "Spær", "Ubh. Fyr", "47x200mm " + lengthOfPlank + "cm");
    }

    private void calcRoofPlank(double sideC, int length) throws FogException {
        int plankCount = (int) (Math.ceil(sideC / (DISTANCEBETWEENPLANK + PLANKWIDTH)) * 2);
        UtilMiddleMan.setAngledRoofPlankOnSides(plankCount);
        for (int i = 0; i < plankCount; i++) {
            calcSideRoofPlanks(length);
        }
    }

    private void calcSideRoofPlanks(int l) throws FogException {
        for (int length = l; length >= 0;) {
            int lengthOfPlank = CalculatorHelper.getLengthOfWaterBoard(length);
            addPartToList(2, "Vandbrædt", "Trykimp Fyr", "19x100mm " + lengthOfPlank + "cm");
            length -= lengthOfPlank;
        }
    }

    private void calcRoofing(double sideC, int length) throws FogException {
        Double area = ((sideC * length) * 2) + (RAFTTHICKNESS * length);
        area += area * ROOFINGFELTOVERLAP;
        int squareMetersCount = (int) Math.ceil(area / 10000); // Square Cm to Square m
        addPartToList(squareMetersCount, "Tagpap", "Krydsfiner med tagpap", "100x100cm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < count; i++) {
            parts.add(part);
        }
    }

}
