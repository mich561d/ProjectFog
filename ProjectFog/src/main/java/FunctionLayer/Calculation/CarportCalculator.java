package FunctionLayer.Calculation;

import FunctionLayer.Calculation.Shed.CarportShedCalculator;
import FunctionLayer.Calculation.Roof.RoofCalculator;
import FunctionLayer.Calculation.Base.BaseCalculator;
import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.ListToMap;
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

    public HashMap<String, ArrayList<Part>> getProductMap() {
        return ListToMap.convertListToMap(parts);
    }

    // Calc  method:
    public void calcCarport() throws FogException {
        BaseCalculator cbc = new BaseCalculator(LENGTH, WIDTH, HEIGHT, parts);
        parts = cbc.calcBase();
        calcScrewsBeslag();

        RoofCalculator crc = new RoofCalculator(LENGTH, WIDTH, ANGLE, ANGLEDROOF, parts);
        parts = crc.calcRoof();

        if (SHED) {
            CarportShedCalculator csc = new CarportShedCalculator(LENGTH, WIDTH, HEIGHT, SHEDLENGTH, SHEDWIDTH, parts);
            parts = csc.calcShed();
        }
    }

    private void calcScrewsBeslag() throws FogException {
        int rafterCount = ListToMap.convertListToMap(parts).get("Spær").size();
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
}
