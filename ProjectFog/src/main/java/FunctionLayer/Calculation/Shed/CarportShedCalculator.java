package FunctionLayer.Calculation.Shed;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Calculation.Rules;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Michael & Christian
 */
public class CarportShedCalculator {

    private final int LENGTH, WIDTH, HEIGHT, SHEDLENGTH, SHEDWIDTH;
    private final ArrayList<Part> PARTS;

    public CarportShedCalculator(int LENGTH, int WIDTH, int HEIGHT, int SHEDLENGTH, int SHEDWIDTH, ArrayList<Part> PARTS) {
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.SHEDLENGTH = SHEDLENGTH;
        this.SHEDWIDTH = SHEDWIDTH;
        this.PARTS = PARTS;
    }

    public ArrayList<Part> calcShed() throws FogException {
        calcPoles();
        new ShedDoorCalculator().calcDoor(PARTS);
        calcAllInterTies(SHEDLENGTH, SHEDWIDTH);
        calcAllCladding(SHEDLENGTH, SHEDWIDTH);
        return PARTS;
    }

    private void calcPoles() throws FogException {
        int extraPolesForShed = POLESPERDOOR * DOORSPERSHED;
        // From left back corner to left front corner
        if (SHEDLENGTH - POLEHALFTHICKNESS < LENGTH - DOUBLEPOLEOFFSET) {
            extraPolesForShed++;
            // From left back corner to right back corner and last pole
            if (SHEDWIDTH - POLEHALFTHICKNESS < WIDTH - DOUBLEPOLEOFFSET) {
                extraPolesForShed += 2;
            } else {
                extraPolesForShed++;
            }
        } else if (SHEDWIDTH - POLEHALFTHICKNESS < WIDTH - DOUBLEPOLEOFFSET) {
            // From left back corner to right back corner
            extraPolesForShed += 2;
        }


        /*String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + CalculatorHelper.getLengthOfPole(HEIGHT) + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                PARTS.add(part);
         */
        int calcHeight = HEIGHT + 90;
        for (int i = 0; i < extraPolesForShed; i++) {
            String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + calcHeight + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
    }

    private void calcAllInterTies(int length, int width) throws FogException {
        calcInterTies(length, false); // back
        calcInterTies(width, false); // left
        calcInterTies(width, false); // right
        calcInterTies(length, true); // front (with door)
    }

    private void calcInterTies(int width, boolean door) throws FogException {
        double lengthOfInterTies = width - POLEDOUBLETHICKNESS;
        if (door) {
            lengthOfInterTies -= DOORWIDTH + POLETHICKNESS;
        }
        int brackets = ANGLEBRACKETSPERINTERTIE * INTERTIESPERSIDE;
        int packsOfScrews = (int) Math.ceil((brackets * SCREWSPERANGLEBRACKET) / SCREWSPERPACK);
        for (int i = 0; i < INTERTIESPERSIDE; i++) {
            String type = "Regler", material = "Trykimp Fyr", size = "47x100mm " + CalculatorHelper.getLengthOfInterTies(lengthOfInterTies) + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
        for (int i = 0; i < ANGLEBRACKETSPERINTERTIE; i++) {
            String type = "Regler", material = "Trykimp Fyr", size = "47x100mm " + CalculatorHelper.getLengthOfInterTies(lengthOfInterTies) + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
        for (int i = 0; i < packsOfScrews; i++) {
            String type = "Basic Skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
    }

    private void calcAllCladding(int length, int width) throws FogException {
        calcCladding(length, false); // back
        calcCladding(width, false); // right
        calcCladding(width, false); // left
        calcCladding(length, true); // front
    }

    private void calcCladding(int length, boolean door) throws FogException {
        // Calc our cladding with our rules.
        double calcSpace = length - (CLADDINGBOARDWIDTH * 2);
        if (door) {
            calcSpace -= DOORWIDTH + POLETHICKNESS;
        }
        int backPlanks = (int) Math.ceil((calcSpace / 150) + 2);
        int frontPlanks = (int) Math.floor((calcSpace / 150) + 2);
        int planks = backPlanks + frontPlanks;
        for (int i = 0; i < planks; i++) {
            String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + CalculatorHelper.getLengthOfWaterBoard(DOORHEIGHT) + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
        // Screws
        calcCladdingScrews(frontPlanks);
    }

    private void calcCladdingScrews(int frontPlanks) throws FogException {
        int screws = frontPlanks * INTERTIESPERSIDE * SCREWSPERCLADDINGPERINTERTIE;
        int packsOfScrews = (int) Math.ceil((double) screws / (double) SCREWSPERPACK);
        for (int i = 0; i < packsOfScrews; i++) {
            String type = "Basic Skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
    }
}
