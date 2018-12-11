package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Address {

    private int id, customerID;
    private String city, zip, street, number;

    public Address(int id, String city, String zip, String street, String number, int customerID) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.zip = zip;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public int getCustomerID() {
        return customerID;
    }

}
