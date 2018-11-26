package FunctionLayer.Calculation;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class CarportBaseCalculator {

    private final int LENGTH, WIDTH, HEIGHT;
    private final ArrayList<Part> PARTS;

    public CarportBaseCalculator(int LENGTH, int WIDTH, int HEIGHT, ArrayList<Part> PARTS) {
        this.HEIGHT = HEIGHT;
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.PARTS = PARTS;
    }

    public ArrayList<Part> calcBase() throws FogException {
        calcPoles();
        calcRoofRafter();
        calcScrewsBeslag();

        return PARTS;
    }

    private void calcPoles() throws FogException {
        int calcHeight = HEIGHT + 90;
        int poles = 0;
        poles += calcPolesSides();
        poles += calcPolesBack();
        for (int i = 0; i < poles; i++) {
            String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + calcHeight + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            while (part == null) {
                size = "97x97mm " + ++calcHeight + "cm";
                part = DatabaseFacade.getPart(type, material, size);
            }
            PARTS.add(part);
        }
    }

    public int calcPolesSides() {
        int poles = 0;
        int maxDistance = 300;
        double estPolesSides = ((float) LENGTH - 30) / (float) maxDistance;
        poles += Math.ceil(estPolesSides) + 1;
        poles *= 2; // For both sides
        return poles;
    }

    public int calcPolesBack() {
        int poles = 0;

        if (WIDTH >= 300) {
            int maxDistance = 300;
            double estPolesSides = ((float) WIDTH - 30) / (float) maxDistance;
            poles += Math.ceil(estPolesSides) - 1;
        }
        return poles;
    }

    private void calcRoofRafter() throws FogException {
        calcRoofRafterWidth();
        calcRoofRafterLength();
        calcRoofRafterMiddle();
    }

    public void calcRoofRafterWidth() throws FogException {
        for (int width = WIDTH; width >= 0;) {
            int lengthOfRaft = getLengthOfRaft(width);
            for (int i = 0; i < 2; i++) {
                String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                PARTS.add(part);
            }
            width -= lengthOfRaft;
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

    public void calcRoofRafterLength() throws FogException {
        for (int length = LENGTH; length >= 0;) {
            int lengthOfRaft = getLengthOfRaft(length);
            for (int i = 0; i < 2; i++) {
                String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                PARTS.add(part);
            }
            length -= lengthOfRaft;
        }
    }

    public void calcRoofRafterMiddle() throws FogException {
        int calcWidth = WIDTH;
        int calcLength = LENGTH - 30;
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
            PARTS.add(part);
        }
    }

    private void calcScrewsBeslag() throws FogException {
        int rafterCount = 10;
        int beslag = 0;
        for (int i = 0; i < rafterCount; i++) {
            beslag += 4;
        }
        for (int i = 0; i < beslag; i++) {
            String type = "Basic beslag", material = "Stål", size = "190mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
        int packsOfScrews = (int) Math.ceil(((double) beslag * 8.0) / 200.0);
        for (int i = 0; i < packsOfScrews; i++) {
            String type = "Basic skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
    }
}
