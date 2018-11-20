package FunctionLayer;

/**
 *
 * @author Michael
 */
public class UtilCarportDrawing {

    public static String drawSchematicViewFromAbove(int carportLength, int carportWidth) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawSVG(carportWidth, carportLength, DrawingFace.ABOVE));
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
        SB.append("<SVG width=\"")
                .append(600)
                .append("\" height=\"")
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
                return 624;
        }
    }

}
