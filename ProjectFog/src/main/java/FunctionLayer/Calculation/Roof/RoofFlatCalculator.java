package FunctionLayer.Calculation.Roof;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.CalculatorHelper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Michael
 */
public class RoofFlatCalculator {

    private ArrayList<Part> parts;

    public ArrayList<Part> calcFlatRoof(ArrayList<Part> parts, int length, int width) throws FogException {
        this.parts = parts;
        calcRoofLength(length, calcRoofWidth(width));
        calcWaterBoard(length, width);
        calcScrewsWaterBoard(length);
        calcTrapezScrews();
        return this.parts;
    }

    public int calcRoofWidth(int width) {
        int count = 0;
        for (int w = width; w >= 0;) {
            count++;
            w -= TRAPEZWIDTH - TRAPEZOVERLAPHORI;
        }
        return count;
    }

    public void calcRoofLength(int length, int width) throws FogException {
        for (int l = length; l >= 0;) {
            int lengthOfTrapez = CalculatorHelper.getLengthOfTrapez(l);
            addPartToList(width, "Trapezplade", "PVC", "109x" + lengthOfTrapez + "cm");
            if (l == lengthOfTrapez) {
                l -= lengthOfTrapez;
            } else {
                l -= lengthOfTrapez - TRAPEZOVERLAPVERT;
            }
        }
    }

    private void calcWaterBoard(int length, int width) throws FogException {
        calcRoofWaterBoardWidth(width);
        calcRoofWaterBoardLength(length);
    }

    public void calcRoofWaterBoardWidth(int width) throws FogException {
        for (double w = width + WATERBOARDDOUBLETHICKNESS; w >= 0;) {
            int lengthOfWaterboard = CalculatorHelper.getLengthOfWaterBoard(w);
            addPartToList(2, "Vandbrædt", "Trykimp Fyr", "19x100mm " + lengthOfWaterboard + "cm");
            w -= lengthOfWaterboard;
        }
    }

    public void calcRoofWaterBoardLength(int length) throws FogException {
        for (double l = length + WATERBOARDDOUBLETHICKNESS; l >= 0;) {
            int lengthOfWaterBoard = CalculatorHelper.getLengthOfWaterBoard(l);
            addPartToList(2, "Vandbrædt", "Trykimp Fyr", "19x100mm " + lengthOfWaterBoard + "cm");
            l -= lengthOfWaterBoard;
        }
    }

    private void calcScrewsWaterBoard(int length) throws FogException {
        int screws = 0;
        for (int i = 0; i < WATERBOARDS; i++) {
            screws += (int) Math.ceil(((length + WATERBOARDDOUBLETHICKNESS) / DISTANCEBETWEENWATERBOARDSCREWS) * SCREWSPERPLANK);
        }
        int packs = (int) Math.ceil((double) screws / 200.0);
        addPartToList(packs, "Basic skrue", "Stål", "4.5x60mm");
    }

    private void addPartToList(int count, String type, String material, String size) throws FogException {
        for (int i = 0; i < count; i++) {
            Part part = DatabaseFacade.getPart(type, material, size);
            parts.add(part);
        }
    }
    
    private void calcTrapezScrews() {
        
    }
}
