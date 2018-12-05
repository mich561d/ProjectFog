package FunctionLayer;

import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.RegisterException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class PasswordTest {

    @Test
    public void ComparePasswords() throws RegisterException {
        // Arrange:
        String pass1 = "password", pass2 = "password";
        // Act:
        boolean check = PasswordComparator.checkPasswords(pass1, pass2);
        // Assert:
        assertTrue(check);
    }

    @Test
    public void ComparePasswordsCorrectError1() throws RegisterException {
        // Arrange:
        String pass1 = "password", pass2 = null;
        // Act:
        try {
            PasswordComparator.checkPasswords(pass1, pass2);
        } catch (RegisterException ex) {
            // Assert:
            assertEquals("Password was null!", ex.getMessage());
        }
    }

    @Test
    public void ComparePasswordsCorrectError2() throws RegisterException {
        // Arrange:
        String pass1 = "password", pass2 = "notTheSame";
        // Act:
        try {
            PasswordComparator.checkPasswords(pass1, pass2);
        } catch (RegisterException ex) {
            // Assert:
            assertEquals("Passwords not equal!", ex.getMessage());
        }
    }

    @Test
    public void ComparePasswordsCorrectError3() throws RegisterException {
        // Arrange:
        String pass1 = "short", pass2 = "short";
        // Act:
        try {
            PasswordComparator.checkPasswords(pass1, pass2);
        } catch (RegisterException ex) {
            // Assert:
            assertEquals("Passwords too small!", ex.getMessage());
        }
    }

    @Test
    public void ComparePasswordsCorrectError4() throws RegisterException {
        // Arrange:
        String pass1 = "ThisIsAVeryLongPasswordWhichLengthIsMoreThan45Chars", pass2 = "ThisIsAVeryLongPasswordWhichLengthIsMoreThan45Chars";
        // Act:
        try {
            PasswordComparator.checkPasswords(pass1, pass2);
        } catch (RegisterException ex) {
            // Assert:
            assertEquals("Passwords too big!", ex.getMessage());
        }
    }

    @Test
    public void ComparePasswordsCorrectError5() throws RegisterException {
        // Arrange:
        String pass1 = "#Hashtag", pass2 = "#Hashtag";
        // Act:
        try {
            PasswordComparator.checkPasswords(pass1, pass2);
        } catch (RegisterException ex) {
            // Assert:
            assertEquals("Password contains illegal characters!", ex.getMessage());
        }
    }

    @Test
    public void NotTheSameSaltValue() {
        // Arrange & Act:
        String salt1 = Hashing.getRandomSaltString(0), salt2 = Hashing.getRandomSaltString(0);
        // Assert:
        assertNotEquals(salt1, salt2);
    }

    @Test
    public void ZeroMeansTwentyFive() {
        // Arrange & Act:
        String salt1 = Hashing.getRandomSaltString(0);
        // Assert:
        assertEquals(25, salt1.length());
    }

    @Test
    public void TwentyMeansTwenty() {
        // Arrange & Act:
        String salt1 = Hashing.getRandomSaltString(20);
        // Assert:
        assertEquals(20, salt1.length());
    }

    @Test
    public void HashingPassword() throws FogException {
        // Arrange:
        String password = "password";
        String salt = Hashing.getRandomSaltString(0);
        // Act:
        String hashed = Hashing.hashPassword(password.concat(salt));
        // Assert:
        assertNotEquals(password.concat(salt), hashed);
    }
}
