package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class PaymentInformation {

    private int id;
    private String cardNumber, expireDate;

    public PaymentInformation(String cardNumber, String expireDate) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
    }

    public void setId(int id) {
        this.id = id;
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

}
