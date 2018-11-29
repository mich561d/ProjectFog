package FunctionLayer.Calculation;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.util.ArrayList;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Michael & Christian
 */
public class CarportShedCalculator {

    private final int LENGTH, WIDTH, HEIGHT, SHEDLENGTH, SHEDWIDTH;
    private final ArrayList<Part> PARTS;

    public CarportShedCalculator(int LENGTH, int WIDTH, int HEIGHT, int SHEDLENGTH, int SHEDWIDTH, ArrayList<Part> PARTS) {
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.SHEDLENGTH = SHEDLENGTH;
        this.SHEDWIDTH = SHEDWIDTH;
        this.PARTS = PARTS;
    }

    public ArrayList<Part> calcShed() throws FogException {
        calcPoles();
        door();
        calcReglar();
        calcCladding();
        return PARTS;
    }

    private void calcPoles() throws FogException {
        // Check to see if we need more poles than we allready have place via basecalculations

        // Hvad nu hvis length er 720 og shed length er 719???
        int extraPolesForShed = 0;
        if (SHEDLENGTH < LENGTH) {
            // We need more poles
        }
        if (SHEDWIDTH < WIDTH) {
            // We need more poles
        }
        int calcHeight = HEIGHT + 90;
        for (int i = 0; i < extraPolesForShed; i++) {
            String type = "Stolpe", material = "Trykimp Fyr", size = "97x97mm " + calcHeight + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            while (part == null) {
                size = "97x97mm " + ++calcHeight + "cm";
                part = DatabaseFacade.getPart(type, material, size);
            }
        }
    }

    private void door() throws FogException {
        //mål 90x200
        // 4 screws pr. plank, 33cm between planks.
        double calcSpace = Rules.DOORWIDTH - (Rules.CLADDINGBOARDWIDTH * 2);
        int backPlanks = (int) Math.ceil((calcSpace / 150) + 2);
        int frontPlanks = (int) Math.floor((calcSpace / 150) + 2);
        int planks = backPlanks + frontPlanks;
        //4 screws for handle
        int handle = 1;
        //6 screws pr. hinge
        int hinge = 2;
        double heightOfLath = 4.7;
        //Krydsmål udregning på dør'
        double pcd = Math.sqrt((Rules.DOORWIDTH * Rules.DOORWIDTH) + ((Rules.DOORHEIGHT - heightOfLath) * (Rules.DOORHEIGHT - heightOfLath)));
        // lægter til opbygning af ramme på dør og z.
        //top og bund 90cm, sider 190.6, krydsmål 210.78.
        int lath = 0;
        for (int i = 0; i < 2; i++) {
            String type = "Regler", material = "Trykimp Fyr", size = getLengthOfLath(DOORWIDTH) + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
        for (int i = 0; i < 2; i++) {
            String type = "Regler", material = "Trykimp Fyr", size = getLengthOfLath(Rules.DOORHEIGHT - heightOfLath) + "cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }

        String type = "Regler", material = "Trykimp Fyr", size = getLengthOfLath(pcd) + "cm";
        Part part = DatabaseFacade.getPart(type, material, size);
        PARTS.add(part);

        type = "Stalddørsgreb";
        material = "Galvvaniseret Stål";
        size = "19-50mm";
        part = DatabaseFacade.getPart(type, material, size);
        PARTS.add(part);

        for (int i = 0; i < hinge; i++) {
            type = "T-hængsel";
            material = "Galvvaniseret Stål";
            size = "390mm";
            part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);

        }

        for (int i = 0; i < planks; i++) {
            type = "Vandbrædt";
            material = "Trykimp Fyr";
            size = "19x100mm " + calcPlankHeight(Rules.DOORHEIGHT) + "cm";
            part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }

        int screws = 0;
        for (int i = 0; i < planks + handle + hinge; i++) {
            if (i < planks) {
                screws += Rules.SCREWSPERPLANK;
            } else if (i < planks + handle) {
                screws += Rules.SCREWSPERHANDLE;
            } else {
                screws += Rules.SCREWSPERHINGE;
            }
        }
        int packsOfScrews = (int) Math.ceil((double) screws / (double) Rules.SCREWPERPACK);

        for (int i = 0; i < packsOfScrews; i++) {
            type = "Basic Skrue";
            material = "Stål";
            size = "4.5x60mm";
            part = DatabaseFacade.getPart(type, material, size);
            PARTS.add(part);
        }
    }

    private int calcPlankHeight(double width) {
        int plankHeight;
        if (width >= 420) {
            plankHeight = 420;
        } else if (width >= 360) {
            plankHeight = 360;
        } else if (width >= 300) {
            plankHeight = 300;
        } else if (width >= 270) {
            plankHeight = 270;
        } else if (width >= 240) {
            plankHeight = 240;
        } else if (width >= 210) {
            plankHeight = 210;
        } else {
            plankHeight = 180;
        }
        return plankHeight;
    }

    private int getLengthOfLath(double width) {
        int lengthOfLath;
        if (width <= 240) {
            lengthOfLath = 240;
        } else if (width <= 270) {
            lengthOfLath = 270;
        } else if (width <= 300) {
            lengthOfLath = 300;
        } else if (width <= 330) {
            lengthOfLath = 330;
        } else if (width <= 360) {
            lengthOfLath = 360;
        } else if (width <= 390) {
            lengthOfLath = 390;
        } else if (width <= 420) {
            lengthOfLath = 420;
        } else if (width <= 450) {
            lengthOfLath = 450;
        } else if (width <= 480) {
            lengthOfLath = 480;
        } else if (width <= 510) {
            lengthOfLath = 510;
        } else {
            lengthOfLath = 540;
        }
        return lengthOfLath;
    }

    private void calcReglar() {
        //calc inter-ties with our rules, and add angle brackets.
    }

    private void calcCladding() {
        // Calc our cladding with our rules.
    }
    //Et skur har 4 hjørner, de to hjørner er allerede sat fra carporten. Vi skal have mindst én ekstra stolpe til midten af forsiden.
    //Et skur har en beklædning af bræder, 25mm overlap pr. brædt. så to til en pr. brædt. 
    //Et skur har én dør. 
}
