package FunctionLayer.Calculation;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;

/**
 *
 * @author Michael
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
                String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            w -= lengthOfRaft;
        }
    }

    private void calcRoofRafterLength(ArrayList<Part> parts, int length) throws FogException {
        for (int l = length; l >= 0;) {
            int lengthOfRaft = getLengthOfRaft(l);
            for (int i = 0; i < 2; i++) {
                String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            l -= lengthOfRaft;
        }
    }

    private void calcRoofRafterMiddle(ArrayList<Part> parts, int length, int width) throws FogException {
        int calcWidth = width;
        int calcLength = length - 30;
        double raftThickness = 4.7;
        int distanceBetweenRafts = 70;
        for (double distance = 0; distance < calcLength;) {
            distance += raftThickness + distanceBetweenRafts;
            String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + calcWidth + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            while (part == null) {
                size = "47x200mm " + ++calcWidth + "cm";
                part = DatabaseFacade.getPart(type, material, size);
            }
            parts.add(part);
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
}
