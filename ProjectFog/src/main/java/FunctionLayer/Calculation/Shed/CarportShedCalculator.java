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
        if (SHEDLENGTH - POLEHALFTHICKNESS < LENGTH - DOUBLEPOLEOFFSET) {
            extraPolesForShed++;
            if (SHEDWIDTH - POLEHALFTHICKNESS < WIDTH - DOUBLEPOLEOFFSET) {
                extraPolesForShed += 2;
            } else {
                extraPolesForShed++;
            }
        } else if (SHEDWIDTH - POLEHALFTHICKNESS < WIDTH - DOUBLEPOLEOFFSET) {
            extraPolesForShed += 2;
        }
        int calcHeight = HEIGHT + 90;
        addPartToList(extraPolesForShed, "Stolpe", "Trykimp Fyr", "97x97mm " + CalculatorHelper.getLengthOfPole(calcHeight) + "cm");
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
        addPartToList(INTERTIESPERSIDE, "Regler", "Trykimp Fyr", "47x100mm " + CalculatorHelper.getLengthOfInterTies(lengthOfInterTies) + "cm");
        addPartToList(brackets, "Vinkelbeslag", "Stål", "35mm");
        addPartToList(packsOfScrews, "Basic Skrue", "Stål", "4.5x60mm");
    }

    private void calcAllCladding(int length, int width) throws FogException {
        calcCladding(length, false); // back
        calcCladding(width, false); // right
        calcCladding(width, false); // left
        calcCladding(length, true); // front
    }

    private void calcCladding(int length, boolean door) throws FogException {
        double calcSpace = length - (CLADDINGBOARDWIDTH * 2);
        if (door) {
            calcSpace -= DOORWIDTH + POLETHICKNESS;
        }
        int backPlanks = (int) Math.ceil((calcSpace / 150) + 2);
        int frontPlanks = (int) Math.floor((calcSpace / 150) + 2);
        int planks = backPlanks + frontPlanks;
        addPartToList(planks, "Vandbrædt", "Trykimp Fyr", "19x100mm " + CalculatorHelper.getLengthOfWaterBoard(DOORHEIGHT) + "cm");
        calcCladdingScrews(frontPlanks);
    }

    private void calcCladdingScrews(int frontPlanks) throws FogException {
        int screws = frontPlanks * INTERTIESPERSIDE * SCREWSPERCLADDINGPERINTERTIE;
        int packsOfScrews = (int) Math.ceil((double) screws / (double) SCREWSPERPACK);
        addPartToList(packsOfScrews, "Basic Skrue", "Stål", "4.5x60mm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < count; i++) {
            PARTS.add(part);
        }
    }
}
