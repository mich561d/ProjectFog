package FunctionLayer.Calculation.Base;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Christian & Michael
 */
public class BaseRaftCalculator {

    public ArrayList<Part> calcRafts(ArrayList<Part> parts, int length, int width) throws FogException {
        calcRoofRafterLength(parts, length);
        calcRoofRafterWidth(parts, width);
        calcRoofRafterMiddle(parts, length, width);
        return parts;
    }

    private void calcRoofRafterWidth(ArrayList<Part> parts, int width) throws FogException {
        for (int w = width; w >= 0;) {
            int lengthOfRaft = CalculatorHelper.getLengthOfRaft(w);
            for (int i = 0; i < 2; i++) {
                addPartToList(lengthOfRaft, parts);
            }
            w -= lengthOfRaft;
        }
    }

    private void calcRoofRafterLength(ArrayList<Part> parts, int length) throws FogException {
        for (int l = length; l >= 0;) {
            int lengthOfRaft = CalculatorHelper.getLengthOfRaft(l);
            for (int i = 0; i < 2; i++) {
                addPartToList(lengthOfRaft, parts);
            }
            l -= lengthOfRaft;
        }
    }

    private void calcRoofRafterMiddle(ArrayList<Part> parts, int length, int width) throws FogException {
        double calcLength = length - POLEOFFSET - RAFTTHICKNESS;
        for (double distance = 0; distance < calcLength;) {
            distance += RAFTTHICKNESS + DISTANCEBETWEENRAFTS;
            addPartToList(width, parts);
        }
    }

    private void addPartToList(int length, ArrayList<Part> parts) throws FogException {
        int lengthOfRaft = CalculatorHelper.getLengthOfRaft(length);
        Part part = DatabaseFacade.getPart("Spær", "Ubh. Fyr", "47x200mm " + lengthOfRaft + "cm");
        parts.add(part);
    }
}
