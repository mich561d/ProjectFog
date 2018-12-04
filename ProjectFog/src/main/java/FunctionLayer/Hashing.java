package FunctionLayer;

import FunctionLayer.Exceptions.FogException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Michael
 */
public class Hashing {
    
    private static final int SALTLENGTH = 25;

    public static String hashPassword(String password) throws FogException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] toHash = md.digest();
            String ans = DatatypeConverter.printHexBinary(toHash);
            return ans;
        } catch (NoSuchAlgorithmException ex) {
            throw new FogException("An error occurred while trying to hash password!", Level.SEVERE);
        }
    }

    public static String getRandomSaltString(int stringLength) {
        if (stringLength < 1) {
            stringLength = SALTLENGTH;
        }
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
