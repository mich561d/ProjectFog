package FunctionLayer.Calculation;

import FunctionLayer.Calculation.Base.BaseCalculator;
import DatabaseLayer.DatabaseFacade;
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
    private final int LENGTH, WIDTH, HEIGHT, ANGLE, SHEDLENGTH, SHEDWIDTH;
    private final boolean ANGLEDROOF, SHED;
    private ArrayList<Part> parts;

    // Constructor
    public CarportCalculator(int LENGTH, int WIDTH, int HEIGHT, int ANGLE, boolean ANGLEDROOF, boolean SHED, int SHEDLENGTH, int SHEDWIDTH) {
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.ANGLE = ANGLE;
        this.SHEDLENGTH = SHEDLENGTH;
        this.SHEDWIDTH = SHEDWIDTH;
        this.ANGLEDROOF = ANGLEDROOF;
        this.SHED = SHED;
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
        BaseCalculator cbc = new BaseCalculator(LENGTH, WIDTH, HEIGHT, parts);
        parts = cbc.calcBase();
        calcScrewsBeslag();

        CarportRoofCalculator crc = new CarportRoofCalculator(LENGTH, WIDTH, ANGLE, ANGLEDROOF, parts);
        parts = crc.calcRoof();

        if (SHED) {
            CarportShedCalculator csc = new CarportShedCalculator(LENGTH, WIDTH, HEIGHT, SHEDLENGTH, SHEDWIDTH, parts);
            parts = csc.calcShed();
        }
    }

    private void calcScrewsBeslag() throws FogException {
        int rafterCount = convertListToMap().get("Spær").size();
        int brackets = 0;
        for (int i = 0; i < rafterCount; i++) {
            brackets += Rules.BRACKETSPERRAFT;
        }
        for (int i = 0; i < brackets; i++) {
            String type = "Basic beslag", material = "Stål", size = "190mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
        }
        int packsOfScrews = (int) Math.ceil(((double) brackets * (double) Rules.SCREWPERBRACKET) / (double) Rules.SCREWPERPACK);
        for (int i = 0; i < packsOfScrews; i++) {
            String type = "Basic skrue", material = "Stål", size = "4.5x60mm";
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
        }
    }

    //TODO LIST:
    //Calc skruer, 4pr. brædt pr meter. og 4 pr. universalbeslag. 200 pr pakke.
    //calc bolte 2 pr spær 18 pr pakke.
    //Calc firkantskiver 1 pr. bolt. 25 pr. pakke.
    //calc bundskruer til trapez 12 pr. bredde pr. plade x hver 70cm. 200pr pakke.
    //PASLODE UNIVERSALBESLAG, HØJRE 190 mm 2 pr. spær. pris 43.95 pr stk.
    //PASLODE UNIVERSALBESLAG, VENSTRE 190mm 2 pr. spær pris 43.95 pr stk.
}
