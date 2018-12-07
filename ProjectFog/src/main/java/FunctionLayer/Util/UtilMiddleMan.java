package FunctionLayer.Util;

/**
 *
 * @author Michael & Christian
 */
public class UtilMiddleMan {

    private static int raftCount;
    private static int angledRoofPlankOnSides;
    private static int angle;

    public static int getRaftCount() {
        return raftCount;
    }

    public static void setRaftCount(int raftCount) {
        UtilMiddleMan.raftCount = raftCount;
    }

    public static int getAngledRoofPlankOnSides() {
        return angledRoofPlankOnSides;
    }

    public static void setAngledRoofPlankOnSides(int angledRoofPlankOnSides) {
        UtilMiddleMan.angledRoofPlankOnSides = angledRoofPlankOnSides;
    }

    public static int getAngle() {
        return angle;
    }

    public static void setAngle(int angle) {
        UtilMiddleMan.angle = angle;
    }

}
