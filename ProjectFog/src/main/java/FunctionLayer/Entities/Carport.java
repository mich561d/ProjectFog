package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Carport {

    int id, carportLength, carportWidth, carportHeight, angle, shedLength, shedWidth;
    boolean angledRoof, shed;
    String roofing, flooring;

    public Carport(int id, int carportLength, int carportWidth, int carportHeight, boolean angledRoof, int angle, String roofing, boolean shed, int shedLength, int shedWidth, String flooring) {
        this.id = id;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        this.carportHeight = carportHeight;
        this.angledRoof = angledRoof;
        this.angle = angle;
        this.roofing = roofing;
        this.shed = shed;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.flooring = flooring;
    }

    public int getId() {
        return id;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public boolean isAngledRoof() {
        return angledRoof;
    }

    public int getAngle() {
        return angle;
    }

    public String getRoofing() {
        return roofing;
    }

    public boolean isShed() {
        return shed;
    }

    public int getShedLength() {
        return shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public String getFlooring() {
        return flooring;
    }

}
