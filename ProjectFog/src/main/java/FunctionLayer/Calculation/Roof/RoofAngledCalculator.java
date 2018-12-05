package FunctionLayer.Calculation.Roof;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
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

    public ArrayList<Part> calcAngledRoof(ArrayList<Part> parts, int length, int width, int angle, String roofing) throws FogException {
        this.parts = parts;
        UtilMiddleMan.setAngle(angle);
        /* Triangle math
        lowercase = sides, uppercase = angles
                A
              c b c
            B a C a B
         */
        double sideA = (width / 2) - (RAFT_THICKNESS / 2);
        double angleC = 90, angleB = angle, angleA = 180 - angleB - angleC;
        double sinB = Math.sin(Math.toRadians(angleB)), sinA = Math.sin(Math.toRadians(angleA));
        double sideB = (sideA * sinB) / sinA;
        double sideC = Math.sqrt((sideA * sideA) + (sideB * sideB));
        // Carport calculations
        calcSideRafts(sideC);
        calcLongPlank(length);
        calcRoofPlank(sideC, length);
        calcRoofing(sideC, length, roofing);
        calcScrewsForFelt(((sideC * 2) + RAFT_THICKNESS), length);
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
        int plankCount = (int) (Math.ceil(sideC / (DISTANCE_BETWEEN_PLANKS + PLANK_WIDTH)) * 2);
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

    private void calcRoofing(double sideC, int length, String roofing) throws FogException {
        Double area = ((sideC * length) * 2) + (RAFT_THICKNESS * length);
        area += area * ROOFING_FELT_OVERLAP;
        int squareMetersCount = (int) Math.ceil(area / 10000); // Square Cm to Square m
        String type = roofing;
        if ("Sort".equals(roofing.split(" ")[0])) {
            type = "Sort højglas";
        }
        addPartToList(squareMetersCount, type, CalculatorHelper.getCorrectRoofing(roofing), "100x100cm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < count; i++) {
            parts.add(part);
        }
    }

    private void calcScrewsForFelt(double length, int width) throws FogException {
        double screwsPerFelt = (Math.ceil((double) FELT_LENGTH / (double) SCREWS_PER_FELT) * 2.0) + (Math.ceil((double) FELT_WIDTH / (double) SCREWS_PER_FELT) * 2.0);
        double screws = (screwsPerFelt * (length / (double) FELT_LENGTH)) + (screwsPerFelt * ((double) width / (double) FELT_WIDTH));
        int packOfScrews = (int) Math.ceil(screws / (double) SCREWS_PER_PACK);
        addPartToList(packOfScrews, "Basic skrue", "Stål", "4.5x60mm");
    }

}
