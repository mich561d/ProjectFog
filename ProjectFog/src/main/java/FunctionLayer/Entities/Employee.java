package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Employee {

    private final int ID, USER_ID;
    private final String FIRST_NAME, LAST_NAME, PHONE, WORK_PHONE, ROLE;

    public Employee(int id, String firstName, String lastName, String phone, String workPhone, String role, int UserID) {
        this.ID = id;
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.PHONE = phone;
        this.WORK_PHONE = workPhone;
        this.ROLE = role;
        this.USER_ID = UserID;
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

    public String getWorkPhone() {
        return WORK_PHONE;
    }

    public String getRole() {
        return ROLE;
    }
    
    public int getUserID() {
        return USER_ID;
    }

}
