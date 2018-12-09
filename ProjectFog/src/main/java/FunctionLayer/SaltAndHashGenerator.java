package FunctionLayer;

import FunctionLayer.Exceptions.FogException;

/**
 *
 * @author Michael & Christian
 */
public class SaltAndHashGenerator {

    private static final String PASSWORD = "testtest";

    public static void main(String[] args) throws FogException {
        String salt = LogicFacade.getRandomSaltString(0);
        System.out.println("Salt: " + salt);
        String hashedPassword = LogicFacade.hashPassword(PASSWORD, salt);
        System.out.println(hashedPassword);
    }

}
