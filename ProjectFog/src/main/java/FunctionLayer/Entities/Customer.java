package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Customer {

    private final int ID, USER_ID;
    private final String FIRST_NAME, LAST_NAME, PHONE;

    public Customer(int id, String firstName, String lastName, String phone, int userID) {
        this.ID = id;
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.PHONE = phone;
        this.USER_ID = userID;
    }

    public int getId() {
        return ID;
    }

    public String getFirstName() {
        return FIRST_NAME;
    }

    public String getLastName() {
        return LAST_NAME;
    }

    public String getFullName() {
        return FIRST_NAME + " " + LAST_NAME;
    }

    public String getPhone() {
        return PHONE;
    }
    
    public int getUserID() {
        return USER_ID;
    }
}
