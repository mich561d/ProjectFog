package FunctionLayer.Entities;

import FunctionLayer.Enums.OrderStatus;

/**
 *
 * @author Michael & Christian
 */
public class Order {

    int id, productsID, customerID;
    OrderStatus status;
    String boughtDate, sentDate;

    public Order(int id, OrderStatus status, String boughtDate, String sentDate, int productsID, int customerID) {
        this.id = id;
        this.status = status;
        this.boughtDate = boughtDate;
        this.sentDate = sentDate;
        this.productsID = productsID;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getBoughtDate() {
        return boughtDate;
    }

    public String getSentDate() {
        return sentDate;
    }

    public int getProductsID() {
        return productsID;
    }

    public int getCustomerID() {
        return customerID;
    }

}
