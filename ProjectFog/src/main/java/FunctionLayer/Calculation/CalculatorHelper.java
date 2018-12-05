package FunctionLayer.Calculation;

import FunctionLayer.Exceptions.FogException;
import java.util.logging.Level;

/**
 *
 * @author Michael & Christian
 */
public class CalculatorHelper {

    public static int getLengthOfPole(int length) {
        int lengthOfPole;
        if (length >= 420) {
            lengthOfPole = 420;
        } else if (length >= 360) {
            lengthOfPole = 360;
        } else {
            lengthOfPole = 300;
        }
        return lengthOfPole;
    }

    public static int getLengthOfRaft(int length) {
        int lengthOfRaft;
        if (length >= 780) {
            lengthOfRaft = 780;
        } else if (length >= 720) {
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
        } else {
            lengthOfRaft = 300;
        }
        return lengthOfRaft;
    }

    public static int getLengthOfTrapez(int length) {
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
        return lengthOfTrapez;
    }

    public static int getLengthOfWaterBoard(double length) {
        int lengthOfWaterBoard;
        if (length >= 420) {
            lengthOfWaterBoard = 420;
        } else if (length >= 360) {
            lengthOfWaterBoard = 360;
        } else if (length >= 300) {
            lengthOfWaterBoard = 300;
        } else if (length >= 270) {
            lengthOfWaterBoard = 270;
        } else if (length >= 240) {
            lengthOfWaterBoard = 240;
        } else if (length >= 210) {
            lengthOfWaterBoard = 210;
        } else {
            lengthOfWaterBoard = 180;
        }
        return lengthOfWaterBoard;
    }

    public static int getLengthOfLath(double length) {
        int lengthOfLath;
        if (length <= 240) {
            lengthOfLath = 240;
        } else if (length <= 270) {
            lengthOfLath = 270;
        } else if (length <= 300) {
            lengthOfLath = 300;
        } else if (length <= 330) {
            lengthOfLath = 330;
        } else if (length <= 360) {
            lengthOfLath = 360;
        } else if (length <= 390) {
            lengthOfLath = 390;
        } else if (length <= 420) {
            lengthOfLath = 420;
        } else if (length <= 450) {
            lengthOfLath = 450;
        } else if (length <= 480) {
            lengthOfLath = 480;
        } else if (length <= 510) {
            lengthOfLath = 510;
        } else {
            lengthOfLath = 540;
        }
        return lengthOfLath;
    }

    public static int getLengthOfInterTies(double length) {
        int lengthOfInterTies;
        if (length <= 240) {
            lengthOfInterTies = 240;
        } else if (length <= 270) {
            lengthOfInterTies = 270;
        } else if (length <= 300) {
            lengthOfInterTies = 300;
        } else if (length <= 330) {
            lengthOfInterTies = 330;
        } else if (length <= 360) {
            lengthOfInterTies = 360;
        } else if (length <= 390) {
            lengthOfInterTies = 390;
        } else if (length <= 420) {
            lengthOfInterTies = 420;
        } else if (length <= 450) {
            lengthOfInterTies = 450;
        } else if (length <= 480) {
            lengthOfInterTies = 480;
        } else if (length <= 510) {
            lengthOfInterTies = 510;
        } else {
            lengthOfInterTies = 540;
        }
        return lengthOfInterTies;
    }

    public static String getCorrectRoofing(String roofing) throws FogException {
        switch (roofing.split(" ")[0]) {
            case "Tagpap":
                return "Krydsfiner med tagpap";
            case "Vingetagsten":
                return "Tegl";
            case "Sort":
                return "Tegl";
            default:
                throw new FogException("Det valgte tag kan ikke findes!", Level.SEVERE);
        }
    }
}
