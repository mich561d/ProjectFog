package FunctionLayer.Calculation.Base;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;
import FunctionLayer.Util.UtilMiddleMan;

/**
 *
 * @author Christian & Michael
 */
public class BaseRaftCalculator {

    private ArrayList<Part> parts;
    private int raftCount = 0;

    public ArrayList<Part> calcRafts(ArrayList<Part> parts, int length, int width) throws FogException {
        this.parts = parts;
        raftCount = 0;
        calcRoofRafterLength(length);
        calcRoofRafterWidth(width);
        calcRoofRafterMiddle(length, width);
        UtilMiddleMan.setRaftCount(raftCount);
        return this.parts;
    }

    private void calcRoofRafterWidth(int width) throws FogException {
        for (int w = width; w >= 0;) {
            int lengthOfRaft = CalculatorHelper.getLengthOfRaft(w);
            for (int i = 0; i < 2; i++) {
                addPartToList(lengthOfRaft);
                raftCount++;
            }
            w -= lengthOfRaft;
        }
    }

    private void calcRoofRafterLength(int length) throws FogException {
        for (int l = length; l >= 0;) {
            int lengthOfRaft = CalculatorHelper.getLengthOfRaft(l);
            for (int i = 0; i < 2; i++) {
                addPartToList(lengthOfRaft);
            }
            l -= lengthOfRaft;
        }
    }

    private void calcRoofRafterMiddle(int length, int width) throws FogException {
        double calcLength = length - POLEOFFSET - RAFTTHICKNESS;
        for (double distance = 0; distance < calcLength;) {
            distance += RAFTTHICKNESS + DISTANCEBETWEENRAFTS;
            addPartToList(width);
            raftCount++;
        }
    }

    private void addPartToList(int length) throws FogException {
        int lengthOfRaft = CalculatorHelper.getLengthOfRaft(length);
        Part part = DatabaseFacade.getPart("Spær", "Ubh. Fyr", "47x200mm " + lengthOfRaft + "cm");
        parts.add(part);
    }
}
