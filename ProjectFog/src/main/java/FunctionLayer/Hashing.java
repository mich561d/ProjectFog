package FunctionLayer;

import FunctionLayer.Exceptions.RegisterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Michael
 */
public class Hashing {

    public static String hashPassword(String password) throws RegisterException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] toHash = md.digest();
            String ans = DatatypeConverter.printHexBinary(toHash);
            return ans;
        } catch (NoSuchAlgorithmException ex) {
            throw new RegisterException("An error occurred while trying to hash password!");
        }
    }

    public static String getRandomSaltString(int stringLength) {
        Random random = new SecureRandom();
        String salt = "";
        for (int i = 0; i < stringLength; i++) {
            boolean uppercase = random.nextBoolean();
            if (uppercase) {
                char c = 'A';
                c += random.nextInt(25); // 25 = all the different uppercase letters
                salt += c;
            } else {
                char c = 'a';
                c += random.nextInt(25); // 25 = all the different lowercase letters
                salt += c;
            }
        }
        return salt;
    }
}
