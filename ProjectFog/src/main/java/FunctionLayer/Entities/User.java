package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class User {

    private int id;
    private String email, hashedPassword, salt;

    // Get created User
    public User(int id, String email, String hashedPassword, String salt) {
        this.id = id;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
