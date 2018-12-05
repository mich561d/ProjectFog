package FunctionLayer.Calculation.Shed;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import static FunctionLayer.Calculation.Rules.*;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class ShedDoorCalculator {

    private ArrayList<Part> parts;

    public ArrayList<Part> calcDoor(ArrayList<Part> parts) throws FogException {
        this.parts = parts;

        double calcSpace = DOOR_WIDTH - (CLADDING_BOARD_WIDTH * 2);
        int backPlanks = (int) Math.ceil((calcSpace / CLADDING_SPACING) + 2);
        int frontPlanks = (int) Math.floor((calcSpace / CLADDING_SPACING) + 2);
        int planks = backPlanks + frontPlanks;
        int handle = HANDLES_PER_DOOR, hinge = HINGES_PER_DOOR;
        double heightOfLath = HEIGHT_OF_LATH;
        double pcd = Math.sqrt((DOOR_WIDTH * DOOR_WIDTH) + ((DOOR_HEIGHT - heightOfLath) * (DOOR_HEIGHT - heightOfLath)));

        CalcLaths(heightOfLath, pcd);
        CalcHandleAndHinges(hinge);
        addPartToList(planks, "Vandbrædt", "Trykimp Fyr", "19x100mm " + CalculatorHelper.getLengthOfWaterBoard(DOOR_HEIGHT) + "cm");
        CalcScrews(planks, handle, hinge);

        return this.parts;
    }

    private void CalcHandleAndHinges(int hinge) throws FogException {
        addPartToList(1, "Stalddørsgreb", "Galvvaniseret Stål", "19-50mm");
        addPartToList(hinge, "T-hængsel", "Galvvaniseret Stål", "390mm");
    }

    private void CalcLaths(double heightOfLath, double pcd) throws FogException {
        addPartToList(2, "Regler", "Trykimp Fyr", "47x100mm " + CalculatorHelper.getLengthOfLath(DOOR_WIDTH) + "cm");
        addPartToList(2, "Regler", "Trykimp Fyr", "47x100mm " + CalculatorHelper.getLengthOfLath(DOOR_HEIGHT - heightOfLath) + "cm");
        addPartToList(1, "Regler", "Trykimp Fyr", "47x100mm " + CalculatorHelper.getLengthOfLath(pcd) + "cm");
    }

    private void CalcScrews(int planks, int handle, int hinge) throws FogException {
        int screws = 0;
        for (int i = 0; i < planks + handle + hinge; i++) {
            if (i < planks) {
                screws += SCREWS_PER_PLANK;
            } else if (i < planks + handle) {
                screws += SCREWS_PER_HANDLE;
            } else {
                screws += SCREWS_PER_HINGE;
            }
        }
        int packsOfScrews = (int) Math.ceil((double) screws / (double) SCREWS_PER_PACK);
        addPartToList(packsOfScrews, "Basic Skrue", "Stål", "4.5x60mm");
    }

    private void addPartToList(int times, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < times; i++) {
            parts.add(part);
        }
    }
}
