package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class Part {

    int id;
    String type, material, size, description, brand;
    double price;

    public Part(int id, String type, String material, String size, String description, String brand, double price) {
        this.id = id;
        this.type = type;
        this.material = material;
        this.size = size;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

}
