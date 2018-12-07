package FunctionLayer.Calculation.Shed;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;

/**
 *
 * @author Christian & Michael
 */
public class ShedFloorCalculator {

    private ArrayList<Part> parts;

    public ArrayList<Part> calcFloor(int shedLength, int shedWidth, ArrayList<Part> parts) throws FogException {
        this.parts = parts;
        calcShedFloor(shedLength, shedWidth, "Sort");
        return parts;
    }

    private void calcShedFloor(int shedLength, int shedWidth, String color) throws FogException {
        int shedFloorArea = (int) Math.ceil((shedLength * shedWidth) / 10000);
        addPartToList(shedFloorArea, color + "gummiflise", "Gummi", "500x500x30mm");

    }

    private void addPartToList(int times, String type, String material, String size) throws FogException {
        Part part = DatabaseFacade.getPart(type, material, size);
        for (int i = 0; i < times; i++) {
            parts.add(part);
        }
    }
}
