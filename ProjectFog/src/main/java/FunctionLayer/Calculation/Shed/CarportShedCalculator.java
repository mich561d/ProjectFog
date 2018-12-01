package FunctionLayer.Calculation.Shed;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
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
        calcDoor();
        calcReglar();
        calcCladding();
        return PARTS;
    }

    private void calcPoles() throws FogException {
        // Check to see if we need more poles than we allready have place via basecalculations

        // Hvad nu hvis length er 720 og shed length er 719???
        int extraPolesForShed = 0;
        if (SHEDLENGTH < LENGTH - DOUBLEPOLEOFFSET) {
            // We need more poles
            if (LENGTH - DOUBLEPOLEOFFSET <= 300) {
                String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + CalculatorHelper.getLengthOfPole(HEIGHT) + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                PARTS.add(part);
            } else {
                int numberOfPoles = ((LENGTH - DOUBLEPOLEOFFSET) / 300);

            }

        } else {
            //cladding all around.
        }

        if (SHEDWIDTH < WIDTH - DOUBLEPOLEOFFSET) {
            // We need more poles
        } else {
            //cladding all around.
        }

        int calcHeight = HEIGHT + 90;
        for (int i = 0; i < extraPolesForShed; i++) {
            String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + calcHeight + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            while (part == null) {
                size = "97x97mm " + ++calcHeight + "cm";
                part = DatabaseFacade.getPart(type, material, size);
            }
        }
    }

    private void calcDoor() throws FogException {
        double calcSpace = DOORWIDTH - (CLADDINGBOARDWIDTH * 2);
        int backPlanks = (int) Math.ceil((calcSpace / 150) + 2);
        int frontPlanks = (int) Math.floor((calcSpace / 150) + 2);
        int planks = backPlanks + frontPlanks;
        int handle = HANDLESPERDOOR, hinge = HINGESPERDOOR;
        double heightOfLath = HEIGHTOFLATH;
        double pcd = Math.sqrt((DOORWIDTH * DOORWIDTH) + ((DOORHEIGHT - heightOfLath) * (DOORHEIGHT - heightOfLath)));
        
        CalcLaths(heightOfLath, pcd);
        CalcHandleAndHinges(hinge);
        addPartToList(planks, "Vandbrædt", "Trykimp Fyr", "19x100mm " + CalculatorHelper.getLengthOfWaterBoard(DOORHEIGHT) + "cm");
        CalcScrews(planks, handle, hinge);
    }

    private void CalcHandleAndHinges(int hinge) throws FogException {
        addPartToList(1, "Stalddørsgreb", "Galvvaniseret Stål", "19-50mm");
        addPartToList(hinge, "T-hængsel", "Galvvaniseret Stål", "390mm");
    }

    private void CalcLaths(double heightOfLath, double pcd) throws FogException {
        addPartToList(2, "Regler", "Trykimp Fyr", CalculatorHelper.getLengthOfLath(DOORWIDTH) + "cm");
        addPartToList(2, "Regler", "Trykimp Fyr", CalculatorHelper.getLengthOfLath(DOORHEIGHT - heightOfLath) + "cm");
        addPartToList(1, "Regler", "Trykimp Fyr", CalculatorHelper.getLengthOfLath(pcd) + "cm");
    }

    private void CalcScrews(int planks, int handle, int hinge) throws FogException {
        int screws = 0;
        for (int i = 0; i < planks + handle + hinge; i++) {
            if (i < planks) {
                screws += SCREWSPERPLANK;
            } else if (i < planks + handle) {
                screws += SCREWSPERHANDLE;
            } else {
                screws += SCREWSPERHINGE;
            }
        }
        int packsOfScrews = (int) Math.ceil((double) screws / (double) SCREWPERPACK);
        addPartToList(packsOfScrews, "Basic Skrue", "Stål", "4.5x60mm");
    }

    private void addPartToList(int times, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < times; i++) {
            PARTS.add(part);
        }
    }

    private void calcReglar() {
        //calc inter-ties with our rules, and add angle brackets.
    }

    private void calcCladding() {
        // Calc our cladding with our rules.
    }
    //Et skur har 4 hjørner, de to hjørner er allerede sat fra carporten. Vi skal have mindst én ekstra stolpe til midten af forsiden.
    //Et skur har en beklædning af bræder, 25mm overlap pr. brædt. så to til en pr. brædt. 
    //Et skur har én dør. 
}
