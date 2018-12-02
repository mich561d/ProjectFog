package FunctionLayer.Calculation.Shed;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
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
