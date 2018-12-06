package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class PaymentInformation {

    private int id, customerID;
    private String cardNumber, expireDate;

    public PaymentInformation(int id, String cardNumber, String expireDate, int customerID) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public int getCustomerID() {
        return customerID;
    }
}
