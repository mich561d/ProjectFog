package FunctionLayer;

import FunctionLayer.Exceptions.FogException;

/**
 *
 * @author Michael
 */
public class SaltAndHashGenerator {

    private static final int SALTLENGTH = 25;
    private static final String PASSWORD = "KnockKnock";

    public static void main(String[] args) throws FogException {
        String salt = LogicFacade.getRandomSaltString(SALTLENGTH);
        System.out.println("Salt: " + salt);
        String hashedPassword = LogicFacade.hashPassword(PASSWORD, salt);
        System.out.println(hashedPassword);
    }

}
