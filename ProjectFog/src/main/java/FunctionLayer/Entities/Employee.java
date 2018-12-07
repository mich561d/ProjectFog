package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class Employee {

    private int id;
    private String firstName, lastName, phone, workPhone, role;

    public Employee(int id, String firstName, String lastName, String phone, String workPhone, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.workPhone = workPhone;
        this.role = role;
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

    public String getWorkPhone() {
        return workPhone;
    }

    public String getRole() {
        return role;
    }

}
