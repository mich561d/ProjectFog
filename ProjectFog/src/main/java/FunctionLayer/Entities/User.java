package FunctionLayer.Entities;

/**
 *
 * @author Michael
 */
public class User {

    private int id, hashedPassword;
    private String email, salt;

    // Get created User
    public User(int id, int hashedPassword, String salt) {
        this.id = id;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    // Create new User
    public User(String email, String password) {
        this.email = email;

    }

    public int getId() {
        return id;
    }

}
