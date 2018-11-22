package FunctionLayer.Calculation;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;

/**
 *
 * @author Christian & Michael
 */
public class CarportCalculator {

    // Data
    private final int HEIGHT, LENGTH, WIDTH, ANGLE;
    private final boolean ANGLEDROOF;
    private ArrayList<Part> parts;

    // Constructor
    public CarportCalculator(int HEIGHT, int LENGTH, int WIDTH, int ANGLE, boolean ANGLEDROOF) {
        this.HEIGHT = HEIGHT;
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.ANGLE = ANGLE;
        this.ANGLEDROOF = ANGLEDROOF;
        this.parts = new ArrayList();
    }

    // Calc price
    private double calcTotalPrice() {
        double totalPrice = 0.0;
        for (Part part : parts) {
            totalPrice += part.getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Part> getProductList() {
        return parts;
    }

    // Calc  method:
    public double calcCarport() throws FogException {
        // Calc hjørne stolper
        calcPoles();
        // Calc tag spær
        calcRoofRafter();
        // Calc vandbræt
        calcWaterBoard();
        // Calc tag
        calcRoof();
        // Calc skruer vandbrædder
        calcScrewsWaterBoard();
        //Calc skruer beslag
        calcScrewsBeslag();

        return calcTotalPrice();
    }

    private void calcPoles() throws FogException {
        int calcHeight = HEIGHT + 90; // height to be calc'ed
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
            parts.add(part);
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
                parts.add(part);
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
                parts.add(part);
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
            parts.add(part);
        }
    }

    private void calcWaterBoard() throws FogException { // Give better name
        calcRoofWaterBoardWidth();
        calcRoofWaterBoardLength();
    }

    public void calcRoofWaterBoardWidth() throws FogException {
        double thincknessOfWaterBoard = 1.9 * 2;
        for (double width = WIDTH + thincknessOfWaterBoard; width >= 0;) {
            int lengthOfWaterBoard = getLengthOfWaterBoard(width);
            for (int i = 0; i < 2; i++) {
                String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + lengthOfWaterBoard + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            width -= lengthOfWaterBoard;
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

    public void calcRoofWaterBoardLength() throws FogException {
        double thincknessOfWaterBoard = 1.9 * 2;
        for (double length = LENGTH + thincknessOfWaterBoard; length >= 0;) {
            int lengthOfWaterBoard = getLengthOfWaterBoard(length);
            for (int i = 0; i < 2; i++) {
                String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + lengthOfWaterBoard + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            length -= lengthOfWaterBoard;
        }
    }

    private void calcRoof() throws FogException {
        if (ANGLEDROOF) {
            calcAngledRoof();
        } else {
            calcRoofLength(calcRoofWidth());
        }
    }

    private void calcAngledRoof() throws FogException {
        // Calc triangle
        /* en fin trækænt
        små = sider, store = vinkler
                A
              c b c
            B a C a B
         */
        double plankSize = 4.7;
        double halfWidth = WIDTH / 2;
        double halfPlank = plankSize / 2;
        double sideA = halfWidth - halfPlank;
        double angleC = 90, angleB = ANGLE, angleA = 180 - angleB - angleC;
        double sinB = Math.sin(angleB);
        double sinA = Math.sin(angleA);
        double tempCalc = sideA * sinB;
        double sideB = tempCalc * sinA;
        double sideC = Math.sqrt((sideA * sideA) + (sideB * sideB));
        // Long plank/raft
        calcAngledRoofRafter(LENGTH, 1);
        // Calc planks
        int raftCount = 10; // TODO: FIX THIS
        for (int i = 0; i < raftCount; i++) {
            calcAngledRoofRafter((int) Math.ceil(sideA), 2);
        }
        // Calc other way planks + Long plank
        int plankWidth = 10, space = 30;
        int plankCount = (int) Math.ceil(sideC / (space + plankWidth)); // TODO: FIX THIS
        for (int i = 0; i < plankCount; i++) {
            calcAngledRoofPlanks(LENGTH);
        }
        // Calc roofing
        Part roofing = DatabaseFacade.getPart("Tagpap", "Krydsfiner med tagpap", "100x100cm");
        Double area = ((sideC * LENGTH) * 2) + plankSize;
        int squareMetersCount = (int) Math.ceil(area / 100);
        for (int i = 0; i < squareMetersCount; i++) {
            parts.add(roofing);
        }

    }

    public void calcAngledRoofRafter(int l, int times) throws FogException {
        for (int length = l; length >= 0;) {
            int lengthOfRaft = getLengthOfRaft(length);
            for (int i = 0; i < times; i++) {
                String type = "Spær", material = "Ubh. Fyr", size = "47x200mm " + lengthOfRaft + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            length -= lengthOfRaft;
        }
    }

    public void calcAngledRoofPlanks(int l) throws FogException {
        for (int length = l; length >= 0;) {
            int lengthOfPlank = getLengthOfRaft(length);
            for (int i = 0; i < 2; i++) {
                String type = "Vandbrædt", material = "Trykimp Fyr", size = "19x100mm " + lengthOfPlank + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            length -= lengthOfPlank;
        }
    }

    public void calcRoofLength(int width) throws FogException {
        int lengthOfOverlap = 15;
        for (int length = LENGTH; length >= 0;) {
            int lengthOfTrapez;
            if (length >= 600) {
                lengthOfTrapez = 600;
            } else if (length >= 480) {
                lengthOfTrapez = 480;
            } else if (length >= 420) {
                lengthOfTrapez = 420;
            } else if (length >= 360) {
                lengthOfTrapez = 360;
            } else if (length >= 300) {
                lengthOfTrapez = 300;
            } else {
                lengthOfTrapez = 240;
            }
            for (int i = 0; i < width; i++) {
                String type = "Trapezplade", material = "PVC", size = "109x" + lengthOfTrapez + "cm";
                Part part = DatabaseFacade.getPart(type, material, size);
                parts.add(part);
            }
            if (length == lengthOfTrapez) {
                length -= lengthOfTrapez;
            } else {
                length -= lengthOfTrapez - lengthOfOverlap;
            }
        }
    }

    public int calcRoofWidth() {
        int widthOfOverlap = 10;
        int widthOfTrapez = 109;
        int count = 0;
        for (int width = WIDTH; width >= 0;) {
            count++;
            width -= widthOfTrapez - widthOfOverlap;
        }
        return count;
    }

    private void calcScrewsWaterBoard() throws FogException {
        int plankCount = 4;
        int screws = 0;
        for (int i = 0; i < plankCount; i++) {
            int length = 600;
            double number = length / 100;
            screws += (int) Math.ceil(number * 4);
        }
        int packs = (int) Math.ceil((double) screws / 200.0);
        for (int i = 0; i < packs; i++) {
            String type = "Basic skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
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
            parts.add(part);
        }
        int packsOfScrews = (int) Math.ceil(((double) beslag * 8.0) / 200.0);
        for (int i = 0; i < packsOfScrews; i++) {
            String type = "Basic skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
        }
    }
    //Calc skruer, 4pr. brædt pr meter. og 4 pr. universalbeslag. 200 pr pakke.
    //calc bolte 2 pr spær 18 pr pakke.
    //Calc firkantskiver 1 pr. bolt. 25 pr. pakke.
    //calc bundskruer til trapez 12 pr. bredde pr. plade x hver 70cm. 200pr pakke.
    //PASLODE UNIVERSALBESLAG, HØJRE 190 mm 2 pr. spær. pris 43.95 pr stk.
    //PASLODE UNIVERSALBESLAG, VENSTRE 190mm 2 pr. spær pris 43.95 pr stk.

}
