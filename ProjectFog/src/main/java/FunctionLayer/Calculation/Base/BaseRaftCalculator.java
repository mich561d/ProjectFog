package FunctionLayer.Calculation.Base;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.Rules;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;

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
            int lengthOfRaft = getLengthOfRaft(w);
            for (int i = 0; i < 2; i++) {
                AddPartToList(lengthOfRaft, parts);
            }
            w -= lengthOfRaft;
        }
    }

    private void calcRoofRafterLength(ArrayList<Part> parts, int length) throws FogException {
        for (int l = length; l >= 0;) {
            int lengthOfRaft = getLengthOfRaft(l);
            for (int i = 0; i < 2; i++) {
                AddPartToList(lengthOfRaft, parts);
            }
            l -= lengthOfRaft;
        }
    }

    private void calcRoofRafterMiddle(ArrayList<Part> parts, int length, int width) throws FogException {
        int calcLength = length - Rules.MAXDISTANCEBEWTEENPOLES;
        for (double distance = 0; distance < calcLength;) {
            distance += Rules.RAFTTHICKNESS + Rules.DISTANCEBETWEENRAFTS;
            AddPartToList(width, parts);
        }
    }

    private int getLengthOfRaft(int width) {
        int lengthOfRaft;
        if (width >= 720) {
            lengthOfRaft = 720;
        } else if (width >= 660) {
            lengthOfRaft = 660;
        } else if (width >= 600) {
            lengthOfRaft = 600;
        } else if (width >= 540) {
            lengthOfRaft = 540;
        } else if (width >= 480) {
            lengthOfRaft = 480;
        } else if (width >= 420) {
            lengthOfRaft = 420;
        } else if (width >= 360) {
            lengthOfRaft = 360;
        } else {
            lengthOfRaft = 300;
        }
        return lengthOfRaft;
    }

    private void AddPartToList(int lengthOfRaft, ArrayList<Part> parts) throws FogException {
        Part part = GetCorrectPart(lengthOfRaft);
        parts.add(part);
    }

    private Part GetCorrectPart(int lengthOfRaft) throws FogException {
        String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
        Part part = DatabaseFacade.getPart(type, material, size);
        while (part == null) {
            size = "47x200mm " + ++lengthOfRaft + "cm";
            part = DatabaseFacade.getPart(type, material, size);
        }
        return part;
    }
}
