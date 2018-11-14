package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author Christian & Michael
 */
public class CarportCalculator {

    // Data
    private final int HEIGHT, LENGTH, WIDTH;
    private ArrayList<String> products;

    // Constructor
    public CarportCalculator(int HEIGHT, int LENGTH, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.products = new ArrayList();
    }

    // Calc price
    private double CalcTotalPrice() {
        double totalPrice = 0.0;
        for (int i = 0; i < products.size(); i++) {
            // TODO: totalPrice += products.get(i).getPrice; ect...
        }
        return totalPrice;
    }

    public ArrayList<String> getProductList() {
        return products;
    }

    // Calc  method:
    public double CalcCarport() {
        // Calc hjørne stolper
        CalcPoles();
        // Calc tag spær
        CalcRoofRafter();
        // Calc vandbræt
        CalcWaterBoard();
        // Calc beklædning
        CalcCladding();
        // Calc tag
        CalcRoof();

        return CalcTotalPrice();
    }

    private void CalcPoles() {
        int calcHeight = HEIGHT + 90; // height to be calc'ed
        int poles = 0;
        poles += CalcPolesSides();
        poles += CalcPolesBack();

        for (int i = 0; i < poles; i++) {
            products.add("Pole, length: " + calcHeight);
        }
    }

    public int CalcPolesSides() {
        int poles = 0;
        int maxDistance = 300;
        double estPolesSides = ((float) LENGTH - 30) / (float) maxDistance;
        poles += Math.ceil(estPolesSides) + 1;
        poles *= 2; // For both sides
        return poles;
    }

    public int CalcPolesBack() {
        int poles = 0;

        if (WIDTH >= 300) {
            int maxDistance = 300;
            double estPolesSides = ((float) WIDTH - 30) / (float) maxDistance;
            poles += Math.ceil(estPolesSides) - 1;
        }
        return poles;
    }

    private void CalcRoofRafter() {
        CalcRoofRafterWidth();
        CalcRoofRafterLength();
        CalcRoofRafterMiddle();
    }

    public void CalcRoofRafterWidth() {
        for (int width = WIDTH; width > 0;) {
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
            } else if (width >= 300) {
                lengthOfRaft = 300;
            } else {
                // What to do:
                lengthOfRaft = 300;
                // or
                // lengthOfRaft = width;
            }
            products.add("Raft, length: " + lengthOfRaft);
            width -= lengthOfRaft;
        }
    }

    public void CalcRoofRafterLength() {
        for (int length = LENGTH; length > 0;) {
            int lengthOfRaft;
            if (length >= 720) {
                lengthOfRaft = 720;
            } else if (length >= 660) {
                lengthOfRaft = 660;
            } else if (length >= 600) {
                lengthOfRaft = 600;
            } else if (length >= 540) {
                lengthOfRaft = 540;
            } else if (length >= 480) {
                lengthOfRaft = 480;
            } else if (length >= 420) {
                lengthOfRaft = 420;
            } else if (length >= 360) {
                lengthOfRaft = 360;
            } else if (length >= 300) {
                lengthOfRaft = 300;
            } else {
                // What to do:
                lengthOfRaft = 300;
                // or
                // lengthOfRaft = width;
            }
            products.add("Raft, length: " + lengthOfRaft);
            length -= lengthOfRaft;
        }
    }

    public void CalcRoofRafterMiddle() {
        int calcLength = LENGTH - 30;
        double raftThickness = 4.7;
        int distanceBetweenRafts = 70;
        for (double distance = 0; distance < calcLength;) {
            distance += raftThickness + distanceBetweenRafts;
            products.add("Middle Raft, length: " + WIDTH);
        }
    }

    private void CalcWaterBoard() { // Give better name
        CalcRoofRafterWidth();
        CalcRoofRafterLength();
    }

    private void CalcRoof() {
        CalcRoofLength(CalcRoofWidth());
    }

    public void CalcRoofLength(int width) {
        int lengthOfOverlap = 15;
        for (int length = LENGTH; length > 0;) {
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
                products.add("Trapez, length: " + lengthOfTrapez);
            }
            length -= lengthOfTrapez - lengthOfOverlap;
        }
    }

    public int CalcRoofWidth() {
        int widthOfOverlap = 10;
        int widthOfTrapez = 109;
        int count = 0;
        for (int width = WIDTH; width > 0;) {
            count++;
            width -= widthOfTrapez - widthOfOverlap;
        }
        return count;
    }

    private void CalcCladding() { // only shed or hole carport

    }
}
