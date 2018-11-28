package FunctionLayer.Calculation.Roof;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.Rules;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import FunctionLayer.ListToMap;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class RoofAngledCalculator {

    public ArrayList<Part> calcAngledRoof(ArrayList<Part> parts, int length, int width, int angle) throws FogException {
        /* Calc triangle
        små = sider, store = vinkler
                A
              c b c
            B a C a B
         */
        double sideA = (width / 2) - (Rules.RAFTTHICKNESS / 2);
        double angleC = 90, angleB = angle, angleA = 180 - angleB - angleC;
        double sinB = Math.sin(Math.toRadians(angleB)), sinA = Math.sin(Math.toRadians(angleA));
        double sideB = (sideA * sinB) / sinA;
        double sideC = Math.sqrt((sideA * sideA) + (sideB * sideB));
        // Calc planks
        int raftCount = ListToMap.convertListToMap(parts).get("Spær").size();
        for (int i = 0; i < raftCount; i++) {
            calcAngledRoofRafter(parts, (int) Math.ceil(sideA), 2);
        }
        calcAngledRoofRafter(parts, length, 1); // Long Plank
        CalcRoofRaft(sideC, parts, length); // Side Rafts
        CalcRoofing(sideC, length, parts); // Roofing
        return parts;
    }

    private void CalcRoofRaft(double sideC, ArrayList<Part> parts, int length) throws FogException {
        int plankCount = (int) Math.ceil(sideC / (Rules.DISTANCEBETWEENPLANK + Rules.PLANKWIDTH));
        for (int i = 0; i < plankCount; i++) {
            calcAngledRoofPlanks(parts, length);
        }
    }

    private void CalcRoofing(double sideC, int length, ArrayList<Part> parts) throws FogException {
        Part roofing = DatabaseFacade.getPart("Tagpap", "Krydsfiner med tagpap", "100x100cm");
        Double area = ((sideC * length) * 2) + (Rules.RAFTTHICKNESS * length);
        area += area * Rules.TRAPEZOVERLAP;
        int squareMetersCount = (int) Math.ceil(area / 10000); // Square Cm to Square m
        for (int i = 0; i < squareMetersCount; i++) {
            parts.add(roofing);
        }
    }

    private int getLengthOfRaft(int width) {
        int lengthOfRaft;
        if (width >= 720) {
            lengthOfRaft = 720;
        } else if (width >= 660) {
            lengthOfRaft = 660;
        } else if (width >= 600) {
            lengthOfRaft = 600;
        } else if (width >= 540) {
            lengthOfRaft = 540;
        } else if (width >= 480) {
            lengthOfRaft = 480;
        } else if (width >= 420) {
            lengthOfRaft = 420;
        } else if (width >= 360) {
            lengthOfRaft = 360;
        } else {
            lengthOfRaft = 300;
        }
        return lengthOfRaft;
    }

    private void calcAngledRoofRafter(ArrayList<Part> parts, int l, int times) throws FogException {
        for (int length = l; length >= 0;) {
            int lengthOfRaft = getLengthOfRaft(length);
            for (int i = 0; i < times; i++) {
                String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            length -= lengthOfRaft;
        }
    }

    private void calcAngledRoofPlanks(ArrayList<Part> parts, int l) throws FogException {
        for (int length = l; length >= 0;) {
            int lengthOfPlank = getLengthOfRaft(length);
            for (int i = 0; i < 2; i++) {
                String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + lengthOfPlank + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            length -= lengthOfPlank;
        }
    }

}
