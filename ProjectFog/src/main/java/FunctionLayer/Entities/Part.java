package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Part {

    private final int ID;
    private final String TYPE, MATERIAL, SIZE, DESCRIPTION, BRAND;
    private final double PRICE;

    public Part(int id, String type, String material, String size, String description, String brand, double price) {
        this.ID = id;
        this.TYPE = type;
        this.MATERIAL = material;
        this.SIZE = size;
        this.DESCRIPTION = description;
        this.BRAND = brand;
        this.PRICE = price;
    }

    public int getId() {
        return ID;
    }

    public String getType() {
        return TYPE;
    }

    public String getMaterial() {
        return MATERIAL;
    }

    public String getSize() {
        return SIZE;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getBrand() {
        return BRAND;
    }

    public double getPrice() {
        return PRICE;
    }

}
