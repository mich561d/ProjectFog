package FunctionLayer.Entities;

/**
 *
 * @author Michael & Christian
 */
public class User {

    private final int ID;
    private final String EMAIL, HASHED_PASSWORD, SALT;

    public User(int id, String email, String hashedPassword, String salt) {
        this.ID = id;
        this.EMAIL = email;
        this.HASHED_PASSWORD = hashedPassword;
        this.SALT = salt;
    }

    public int getId() {
        return ID;
    }

    public String getEmail() {
        return EMAIL;
    }

    public String getHashedPassword() {
        return HASHED_PASSWORD;
    }

    public String getSalt() {
        return SALT;
    }

}
