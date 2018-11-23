package FunctionLayer.Calculation;

import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import java.util.HashMap;

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
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Part part : parts) {
            totalPrice += part.getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Part> getProductList() {
        return parts;
    }

    private HashMap<String, ArrayList<Part>> convertListToMap() {
        HashMap<String, ArrayList<Part>> list = new HashMap();
        for (Part part : parts) {
            String key = part.getType();
            ArrayList<Part> al;
            if (list.containsKey(key)) {
                al = (ArrayList<Part>) list.get(key);
            } else {
                al = new ArrayList();
            }
            al.add(part);
            list.put(key, al);
        }
        return list;
    }

    // Calc  method:
    public void calcCarport() throws FogException {
        CarportBaseCalculator cbc = new CarportBaseCalculator(HEIGHT, LENGTH, WIDTH, parts);
        parts = cbc.calcBase();

        CarportRoofCalculator crc = new CarportRoofCalculator(LENGTH, WIDTH, ANGLE, ANGLEDROOF, parts);
        parts = crc.calcRoof();

        // TODO: CarportShedCalculator constructor
        // TODO: CarportShedCalcualtor calcShed()
    }

    //TODO LIST:
    //Calc skruer, 4pr. brædt pr meter. og 4 pr. universalbeslag. 200 pr pakke.
    //calc bolte 2 pr spær 18 pr pakke.
    //Calc firkantskiver 1 pr. bolt. 25 pr. pakke.
    //calc bundskruer til trapez 12 pr. bredde pr. plade x hver 70cm. 200pr pakke.
    //PASLODE UNIVERSALBESLAG, HØJRE 190 mm 2 pr. spær. pris 43.95 pr stk.
    //PASLODE UNIVERSALBESLAG, VENSTRE 190mm 2 pr. spær pris 43.95 pr stk.
}
