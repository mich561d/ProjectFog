package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Address {

    private final int ID, CUSTOMER_ID;
    private final String CITY, ZIP, STREET, NUMBER;

    public Address(int id, String city, String zip, String street, String number, int customerID) {
        this.ID = id;
        this.STREET = street;
        this.NUMBER = number;
        this.CITY = city;
        this.ZIP = zip;
        this.CUSTOMER_ID = customerID;
    }

    public int getId() {
        return ID;
    }

    public String getStreet() {
        return STREET;
    }

    public String getNumber() {
        return NUMBER;
    }

    public String getCity() {
        return CITY;
    }

    public String getZip() {
        return ZIP;
    }

    public int getCustomerID() {
        return CUSTOMER_ID;
    }

}
