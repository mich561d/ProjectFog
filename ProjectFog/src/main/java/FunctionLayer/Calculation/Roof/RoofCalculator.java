package FunctionLayer.Calculation.Roof;

import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;

/**
 *
 * @author Michael & Christian
 */
public class RoofCalculator {

    private final int LENGTH, WIDTH, ANGLE;
    private final boolean ANGLEDROOF;
    private final ArrayList<Part> PARTS;

    public RoofCalculator(int LENGTH, int WIDTH, int ANGLE, boolean ANGLEDROOF, ArrayList<Part> PARTS) {
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.ANGLE = ANGLE;
        this.ANGLEDROOF = ANGLEDROOF;
        this.PARTS = PARTS;
    }

    public ArrayList<Part> calcRoof() throws FogException {
        if (ANGLEDROOF) {
            new RoofAngledCalculator().calcAngledRoof(PARTS, LENGTH, WIDTH, ANGLE);
        } else {
            new RoofFlatCalculator().calcFlatRoof(PARTS, LENGTH, WIDTH);
        }
        return PARTS;
    }
}
