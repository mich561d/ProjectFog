package FunctionLayer.Calculation.Roof;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Michael
 */
public class RoofFlatCalculator {

    public ArrayList<Part> calcFlatRoof(ArrayList<Part> parts, int length, int width) throws FogException {
        calcRoofLength(parts, length, calcRoofWidth(width));
        calcWaterBoard(parts, length, width);
        calcScrewsWaterBoard(parts, length);
        return parts;
    }

    public int calcRoofWidth(int width) {
        int count = 0;
        for (int w = width; w >= 0;) {
            count++;
            w -= TRAPEZWIDTH - TRAPEZOVERLAP;
        }
        return count;
    }

    public void calcRoofLength(ArrayList<Part> parts, int length, int width) throws FogException {
        int lengthOfOverlap = 15;
        for (int l = length; l >= 0;) {
            int lengthOfTrapez;
            if (l >= 600) {
                lengthOfTrapez = 600;
            } else if (l >= 480) {
                lengthOfTrapez = 480;
            } else if (l >= 420) {
                lengthOfTrapez = 420;
            } else if (l >= 360) {
                lengthOfTrapez = 360;
            } else if (l >= 300) {
                lengthOfTrapez = 300;
            } else {
                lengthOfTrapez = 240;
            }
            for (int i = 0; i < width; i++) {
                String type = "Trapezplade", material = "PVC", size = "109x" + lengthOfTrapez + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            if (l == lengthOfTrapez) {
                l -= lengthOfTrapez;
            } else {
                l -= lengthOfTrapez - lengthOfOverlap;
            }
        }
    }

    private void calcWaterBoard(ArrayList<Part> parts, int length, int width) throws FogException {
        calcRoofWaterBoardWidth(parts, width);
        calcRoofWaterBoardLength(parts, length);
    }

    public void calcRoofWaterBoardWidth(ArrayList<Part> parts, int width) throws FogException {
        for (double w = width + WATERBOARDDOUBLETHICKNESS; w >= 0;) {
            int lengthOfWaterBoard = getLengthOfWaterBoard(w);
            for (int i = 0; i < 2; i++) {
                String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + lengthOfWaterBoard + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            w -= lengthOfWaterBoard;
        }
    }

    public void calcRoofWaterBoardLength(ArrayList<Part> parts, int length) throws FogException {
        for (double l = length + WATERBOARDDOUBLETHICKNESS; l >= 0;) {
            int lengthOfWaterBoard = getLengthOfWaterBoard(l);
            for (int i = 0; i < 2; i++) {
                String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + lengthOfWaterBoard + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            l -= lengthOfWaterBoard;
        }
    }

    private int getLengthOfWaterBoard(double width) {
        int lengthOfWaterBoard;
        if (width >= 420) {
            lengthOfWaterBoard = 420;
        } else if (width >= 360) {
            lengthOfWaterBoard = 360;
        } else if (width >= 300) {
            lengthOfWaterBoard = 300;
        } else if (width >= 270) {
            lengthOfWaterBoard = 270;
        } else if (width >= 240) {
            lengthOfWaterBoard = 240;
        } else if (width >= 210) {
            lengthOfWaterBoard = 210;
        } else {
            lengthOfWaterBoard = 180;
        }
        return lengthOfWaterBoard;
    }

    private void calcScrewsWaterBoard(ArrayList<Part> parts, int length) throws FogException {
        int screws = 0;
        for (int i = 0; i < WATERBOARDS; i++) {
            screws += (int) Math.ceil(((length + WATERBOARDDOUBLETHICKNESS) / DISTANCEBETWEENWATERBOARDSCREWS) * SCREWSPERPLANK);
        }
        int packs = (int) Math.ceil((double) screws / 200.0);
        for (int i = 0; i < packs; i++) {
            String type = "Basic skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
        }
    }
}
