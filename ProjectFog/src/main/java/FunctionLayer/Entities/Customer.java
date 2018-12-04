package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class Customer {

    private int id;
    private String firstName, lastName, phone;
    private int paymentID, addressID, userID;

    public Customer(int id, String firstName, String lastName, String phone, int paymentID, int addressID, int userID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.paymentID = paymentID;
        this.addressID = addressID;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getAddressID() {
        return addressID;
    }

    public int getUserID() {
        return userID;
    }
}
