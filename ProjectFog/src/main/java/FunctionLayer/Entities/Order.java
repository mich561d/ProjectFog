package FunctionLayer.Entities;

import FunctionLayer.Enums.OrderStatus;

/**
 *
 * @author Michael & Christian
 */
public class Order {

    private final int ID, PRODUCT_ID, CUSTOMER_ID;
    private final OrderStatus STATUS;
    private final String BOUGHT_DATE, SENT_DATE;

    public Order(int id, OrderStatus status, String boughtDate, String sentDate, int productsID, int customerID) {
        this.ID = id;
        this.STATUS = status;
        this.BOUGHT_DATE = boughtDate;
        this.SENT_DATE = sentDate;
        this.PRODUCT_ID = productsID;
        this.CUSTOMER_ID = customerID;
    }

    public int getId() {
        return ID;
    }

    public OrderStatus getStatus() {
        return STATUS;
    }

    public String getBoughtDate() {
        return BOUGHT_DATE;
    }

    public String getSentDate() {
        return SENT_DATE;
    }

    public int getProductsID() {
        return PRODUCT_ID;
    }

    public int getCustomerID() {
        return CUSTOMER_ID;
    }

}
