package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class User {

    private int id, customerID, employeeID;
    private String email, hashedPassword, salt;

    public User(int id, String email, String hashedPassword, String salt, int customerID, int employeeID) {
        this.id = id;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.customerID = customerID;
        this.employeeID = employeeID;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

}
