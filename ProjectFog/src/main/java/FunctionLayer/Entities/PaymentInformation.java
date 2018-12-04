package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class PaymentInformation {

    private int id;
    private String cardNumber, expireDate;

    public PaymentInformation(int id, String cardNumber, String expireDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
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
