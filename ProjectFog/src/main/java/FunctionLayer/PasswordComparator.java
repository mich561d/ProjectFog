package FunctionLayer;

import FunctionLayer.Exceptions.RegisterException;

/**
 *
 * @author Michael
 */
public class PasswordComparator {

    private static final char[] BADCHARS = {'!', '"', '#', '¤', '%', '&', '/', '(', ')', '=', '?', '`',
        '@', '£', '$', '€', '{', '[', ']', '}', '½', '§', '|', '¨', '^', '~', '\'', '*', ',', '.', '-',
        ';', ':', '_', '+', 'µ', '<', '>', '\\'};

    public static boolean checkPasswords(String pass1, String pass2) throws RegisterException {
        if (pass1 == null || pass2 == null) {
            throw new RegisterException("Password was null!");
        }
        if (pass1.length() < 8) {
            throw new RegisterException("Passwords too small!");
        }
        if (pass1.length() > 45) {
            throw new RegisterException("Passwords too big!");
        }
        for (int i = 0; i < BADCHARS.length; i++) {
            if (pass1.contains("" + BADCHARS[i])) {
                throw new RegisterException("Password contains illegal characters!");
            }
        }
        if (!pass1.equals(pass2)) {
            throw new RegisterException("Passwords not equal!");
        }
        return true;
    }
}
