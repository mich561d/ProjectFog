package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class Address {

    private int id, number, zip;
    private String street, city;

    public Address(String street, int number, String city, int zip) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zip = zip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

}
