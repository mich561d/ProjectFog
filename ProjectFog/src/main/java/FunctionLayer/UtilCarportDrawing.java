package FunctionLayer;

/**
 *
 * @author Michael
 */
public class UtilCarportDrawing {

    public static String drawSchematicViewFromAbove(int carportLength, int carportWidth) {
        StringBuilder SB = new StringBuilder();
        SB.append(drawSVG(carportWidth, carportLength));
        return SB.toString();
    }

    public static String drawSchematicViewFromAside(int carportLength, int carportHeight) {
        return "TODO: make this method and sub methods";
    }

    public static String drawSchematicViewFromFront(int carportWidth, int carportHeight) {
        return "TODO: make this method and sub methods";
    }

    private static String drawSVG(int width, int height) {
        String backgroundColor = "#f2f2f2"; // #f2f2f2 = lightgrey
        StringBuilder SB = new StringBuilder();
        SB.append("<SVG width=\"")
                .append(600)
                .append("\" height=\"")
                .append(624)
                .append("\" viewBox=\"0 0 ")
                .append(width)
                .append(" ")
                .append(height)
                .append("\" style=\"background-color: ")
                .append(backgroundColor)
                .append(";\">");
        return SB.toString();
    }
}
