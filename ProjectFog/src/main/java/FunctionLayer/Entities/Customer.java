package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Customer {

    private int id, userID;
    private String firstName, lastName, phone;

    public Customer(int id, String firstName, String lastName, String phone, int userID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
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
    
    public int getUserID() {
        return userID;
    }
}
