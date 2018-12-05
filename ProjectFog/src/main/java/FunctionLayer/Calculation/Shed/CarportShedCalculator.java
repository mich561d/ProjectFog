package FunctionLayer.Calculation.Shed;

import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;

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
        new ShedPolesCalculator().calcPoles(LENGTH, WIDTH, HEIGHT, SHEDLENGTH, SHEDWIDTH, PARTS);
        new ShedCladdingCalculator().calcCladdingAndInterTies(SHEDLENGTH, SHEDWIDTH, PARTS);
        new ShedDoorCalculator().calcDoor(PARTS);
        return PARTS;
    }

}
