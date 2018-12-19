package FunctionLayer.Util;

import FunctionLayer.Enums.DrawingFace;
import static FunctionLayer.Calculation.Rules.*;

/**
 *
 * @author Michael & Christian
 */
public class UtilCarportDrawing {

    public static String drawSchematicViewFromAbove(int carportLength, int carportWidth, boolean angledRoof) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawSVG(carportWidth, carportLength, DrawingFace.ABOVE)); // SVG
        SB.append(drawPolesFromAbove(carportWidth, carportLength)); // Poles
        SB.append(drawFramesFromAbove(carportLength, carportWidth)); // Frame (Ramme)
        SB.append(drawRaftsFromAbove(carportLength, carportWidth)); // Rafts
        if (angledRoof) {
            SB.append(drawRoofPlanksFromAbove(carportLength, carportWidth)); // Angled Roof
        }
        return SB.toString();
    }

    public static String drawSchematicViewFromAside(int carportLength, int carportHeight) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawSVG(carportLength, carportHeight, DrawingFace.ASIDE));
        return SB.toString();
    }

    public static String drawSchematicViewFromFront(int carportWidth, int carportHeight) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawSVG(carportWidth, carportHeight, DrawingFace.FRONT));
        return SB.toString();
    }

    private static String drawSVG(int width, int height, DrawingFace face) {
        String backgroundColor = "#f2f2f2"; // #f2f2f2 = lightgrey
        int correctHeight = getCorrectHeight(face);
        StringBuilder SB = new StringBuilder();
        SB.append("<SVG width=\"600\" height=\"")
                .append(correctHeight)
                .append("\" viewBox=\"0 0 ")
                .append(width)
                .append(" ")
                .append(height)
                .append("\" style=\"background-color: ")
                .append(backgroundColor)
                .append(";\">");
        return SB.toString();
    }

    private static int getCorrectHeight(DrawingFace face) {
        switch (face) {
            case ABOVE:
                return 624;
            case ASIDE:
                return 272;
            case FRONT:
                return 272;
            default:
                return 404;
        }
    }

    private static String drawPolesFromAbove(int width, int height) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawPolesCornerFromAbove(width, height));
        SB.append(drawPolesBetweenFromAbove(width, height));
        return SB.toString();
    }

    private static String drawPolesCornerFromAbove(int width, int height) {
        StringBuilder SB = new StringBuilder();
        int offset = 15;
        double poleSize = 9.7;
        SB.append(drawPoleFromAbove(offset, offset)); // UpperLeft
        SB.append(drawPoleFromAbove(width - offset - poleSize, offset)); // UpperRight
        SB.append(drawPoleFromAbove(offset, height - offset - poleSize)); // LowerLeft
        SB.append(drawPoleFromAbove(width - offset - poleSize, height - offset - poleSize)); // LowerRight
        return SB.toString();
    }

    private static String drawPolesBetweenFromAbove(int width, int height) {
        double poleSize = 9.7, doublePoleSize = poleSize * 2;
        int poleCountHeight = (int) Math.floor((height - doublePoleSize) / (300 + poleSize));
        int poleCountWidth = (int) Math.floor((width - doublePoleSize) / (300 + poleSize));
        StringBuilder SB = new StringBuilder();
        // Sides
        for (int i = 0; i < poleCountHeight; i++) {
            double distance = (height - doublePoleSize) / (poleCountHeight + 1);
            double offset = 15 + (distance * (i + 1)) - (poleSize / 2);
            SB.append(drawPoleFromAbove(15, offset)); // Left
            SB.append(drawPoleFromAbove(width - 15 - 9.7, offset)); // Right
        }
        // Back
        for (int i = 0; i < poleCountWidth; i++) {
            double distance = (width - doublePoleSize) / (poleCountWidth + 1);
            double x = 15 + (distance * (i + 1));
            double y = 15;
            SB.append(drawPoleFromAbove(x, y));
        }
        return SB.toString();
    }

    private static String drawPoleFromAbove(double x, double y) {
        StringBuilder SB = new StringBuilder();
        SB.append("<rect x=\"")
                .append(x)
                .append("\" y=\"")
                .append(y)
                .append("\" height=\"9.7\" width=\"9.7\" stroke=\"black\" style=\"fill:white\"/>");
        return SB.toString();
    }

    private static String drawFramesFromAbove(int h, int w) {
        StringBuilder SB = new StringBuilder();
        int offset = 15;
        double plankWidth = 4.7, poleWidth = 9.7, halfPoleWidth = poleWidth / 2;
        // Left
        double x = offset + halfPoleWidth, y = 0;
        SB.append(drawPlankFromAbove(x, y, h, plankWidth));
        // Right
        x = w - offset - poleWidth;
        SB.append(drawPlankFromAbove(x, y, h, plankWidth));
        // Top
        x = 0;
        y = offset + halfPoleWidth;
        SB.append(drawPlankFromAbove(x, y, plankWidth, w));
        // Bot
        y = h - offset - poleWidth;
        SB.append(drawPlankFromAbove(x, y, plankWidth, w));
        return SB.toString();
    }

    private static String drawPlankFromAbove(double x, double y, double h, double w) {
        StringBuilder SB = new StringBuilder();
        SB.append("<rect x=\"")
                .append(x)
                .append("\" y=\"")
                .append(y)
                .append("\" height=\"")
                .append(h)
                .append("\" width=\"")
                .append(w)
                .append("\" stroke=\"black\" style=\"fill:white\"/>");
        return SB.toString();
    }

    private static String drawRaftsFromAbove(int h, int w) {
        StringBuilder SB = new StringBuilder();
        int countRaft = UtilMiddleMan.getRaftCount();
        double plankWidth = 4.7;
        double space = (h - plankWidth) / countRaft;
        int x = 0, y = 0;
        for (int i = 0; i < countRaft; i++) {
            SB.append(drawPlankFromAbove(x, y, plankWidth, w));
            y += space;
        }
        SB.append(drawPlankFromAbove(x, h - plankWidth, plankWidth, w));
        return SB.toString();
    }

    private static String drawRoofPlanksFromAbove(int h, int w) {
        StringBuilder SB = new StringBuilder();
        // Middle
        SB.append(drawPlankFromAbove((w / 2) - (RAFT_THICKNESS / 2), 0, h, RAFT_THICKNESS));
        // Sides
        /* Triangle math...
        lowercase = sides, uppercase = angles
                A
              c b c
            B a C a B
         */
        double sideC = PLANK_WIDTH;
        double angleC = 90, angleB = UtilMiddleMan.getAngle(), angleA = 180 - angleB - angleC;
        double sinC = Math.sin(Math.toRadians(angleC)), sinA = Math.sin(Math.toRadians(angleA));
        double sideA = (sideC * sinA) / sinC;
        // true code
        double plankWidth = sideA;
        int planksPerSide = UtilMiddleMan.getAngledRoofPlankOnSides() / 2;
        double distance = (((w / 2) - (RAFT_THICKNESS / 2)) - (planksPerSide * plankWidth)) / planksPerSide;
        double x = 0;
        for (int i = 0; i < planksPerSide; i++) {
            SB.append(drawPlankFromAbove(x, 0, h, sideA));
            double reverseX = w - x - plankWidth;
            SB.append(drawPlankFromAbove(reverseX, 0, h, sideA));
            x += plankWidth + distance;
        }
        return SB.toString();
    }

}
