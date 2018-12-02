package FunctionLayer.Calculation.Base;

import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;

/**
 *
 * @author Michael & Christian
 */
public class BaseCalculator {

    private final int LENGTH, WIDTH, HEIGHT;
    private final ArrayList<Part> PARTS;

    public BaseCalculator(int LENGTH, int WIDTH, int HEIGHT, ArrayList<Part> PARTS) {
        this.HEIGHT = HEIGHT;
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.PARTS = PARTS;
    }

    public ArrayList<Part> calcBase() throws FogException {
        new BasePoleCalculator().calcPoles(PARTS, LENGTH, WIDTH, HEIGHT);
        new BaseRaftCalculator().calcRafts(PARTS, LENGTH, WIDTH);
        return PARTS;
    }

}
