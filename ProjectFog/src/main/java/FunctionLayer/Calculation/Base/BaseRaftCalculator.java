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
                AddPartToList(lengthOfRaft, parts);
            }
            w -= lengthOfRaft;
        }
    }

    private void calcRoofRafterLength(ArrayList<Part> parts, int length) throws FogException {
        for (int l = length; l >= 0;) {
            int lengthOfRaft = CalculatorHelper.getLengthOfRaft(l);
            for (int i = 0; i < 2; i++) {
                AddPartToList(lengthOfRaft, parts);
            }
            l -= lengthOfRaft;
        }
    }

    private void calcRoofRafterMiddle(ArrayList<Part> parts, int length, int width) throws FogException {
        double calcLength = length - POLEOFFSET - RAFTTHICKNESS;
        for (double distance = 0; distance < calcLength;) {
            distance += RAFTTHICKNESS + DISTANCEBETWEENRAFTS;
            AddPartToList(width, parts);
        }
    }

    private void AddPartToList(int lengthOfRaft, ArrayList<Part> parts) throws FogException {
        Part part = GetCorrectPart(lengthOfRaft);
        parts.add(part);
    }

    private Part GetCorrectPart(int lengthOfRaft) throws FogException {
        String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + CalculatorHelper.getLengthOfRaft(lengthOfRaft) + "cm";
        Part part = DatabaseFacade.getPart(type, material, size);
        return part;
    }
}
