package FunctionLayer;

/**
 *
 * @author Michael
 */
public class UtilCarportDrawing {

    public static String drawSchematicViewFromAbove(int carportLength, int carportWidth) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawSVG(carportWidth, carportLength, DrawingFace.ABOVE)); // SVG
        SB.append(drawPolesFromAbove(carportWidth - 30, carportLength - 30)); // Poles
        SB.append(drawFramesFromAbove(carportLength, carportWidth)); // Frame (Ramme)
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
        SB.append(drawPoleFromAbove(15, 15)); // UpperLeft
        SB.append(drawPoleFromAbove(width - 15, 15)); // UpperRight
        SB.append(drawPoleFromAbove(15, height - 15)); // LowerLeft
        SB.append(drawPoleFromAbove(width - 15, height - 15)); // LowerRight
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
            SB.append(drawPoleFromAbove(width - 15, offset)); // Right
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
        double x = 15 - (9.7 / 2), y = 15 - (9.7 / 2);
        SB.append(drawFrameFromAbove(x, y, h, 4.7)); // Left
        x = w - x;
        SB.append(drawFrameFromAbove(x, y, h, 4.7)); // Right
        x = x - w;
        y = h - y;
        SB.append(drawFrameFromAbove(x, y, w, 4.7)); // Top
        x = w - x;
        SB.append(drawFrameFromAbove(x, y, w, 4.7)); // Bot
        return SB.toString();
    }

    private static String drawFrameFromAbove(double x, double y, double h, double w) {
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

}
