package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class Customer {

    private int id;
    private String firstName, lastName, phone;
    private int paymentID, addressID, userID;

    public Customer(String firstName, String lastName, String phone, PaymentInformation payment, Address address, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.paymentID = payment.getId();
        this.addressID = address.getId();
        this.userID = user.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

}
