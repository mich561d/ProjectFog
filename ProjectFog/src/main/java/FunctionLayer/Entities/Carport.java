package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Carport {

    private final int ID, CARPORT_LENGTH, CARPORT_WIDTH, CARPORT_HEIGHT, ANGLE, SHED_LENGTH, SHED_WIDTH;
    private final boolean ANGLED_ROOF, SHED;
    private final String ROOFING, FLOORING;

    public Carport(int id, int carportLength, int carportWidth, int carportHeight, boolean angledRoof, int angle, String roofing, boolean shed, int shedLength, int shedWidth, String flooring) {
        this.ID = id;
        this.CARPORT_LENGTH = carportLength;
        this.CARPORT_WIDTH = carportWidth;
        this.CARPORT_HEIGHT = carportHeight;
        this.ANGLED_ROOF = angledRoof;
        this.ANGLE = angle;
        this.ROOFING = roofing;
        this.SHED = shed;
        this.SHED_LENGTH = shedLength;
        this.SHED_WIDTH = shedWidth;
        this.FLOORING = flooring;
    }

    public int getId() {
        return ID;
    }

    public int getCarportLength() {
        return CARPORT_LENGTH;
    }

    public int getCarportWidth() {
        return CARPORT_WIDTH;
    }

    public int getCarportHeight() {
        return CARPORT_HEIGHT;
    }

    public boolean isAngledRoof() {
        return ANGLED_ROOF;
    }

    public int getAngle() {
        return ANGLE;
    }

    public String getRoofing() {
        return ROOFING;
    }

    public boolean isShed() {
        return SHED;
    }

    public int getShedLength() {
        return SHED_LENGTH;
    }

    public int getShedWidth() {
        return SHED_WIDTH;
    }

    public String getFlooring() {
        return FLOORING;
    }

}
