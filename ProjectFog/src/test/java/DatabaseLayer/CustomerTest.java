/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import DatabaseLayer.Mappers.AddressMapper;
import DatabaseLayer.Mappers.CustomerMapper;
import DatabaseLayer.Mappers.PaymentInformationMapper;
import DatabaseLayer.Mappers.UserMapper;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.RegisterException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class CustomerTest {
/*
    private static int id;
    private Customer customer;

    @BeforeClass
    public static void setUpClass() {
        try {
            // Arrange & Act:
            int PaymentID = PaymentInformationMapper.createPaymentInformation("1234567812345678", "12/34");
            int AddressID = AddressMapper.createAddress("TestCity", "1234", "TestStreet", "1");
            int UserID = UserMapper.createUser("TestEmail@gmail.com", "TestHashedPassword", "TestSalt");
            id = CustomerMapper.createCustomer("TestFirstName", "TestLastName", "12345678", PaymentID, AddressID, UserID);
            // Assert:
        } catch (RegisterException e) {
            // Delete customer

            // Try again?
        }
    }

    @AfterClass
    public static void tearDownClass() {
        // Delete customer
    }

    @Test
    public void GetCustomer() {
        try {
            // Arrange & Act:
            customer = CustomerMapper.getCustomerByID(id);
            // Assert:
        } catch (FogException e) {
            fail("Should not throw exception!");
        }
    }

    @Test
    public void GetAddressFromCreatedCustomer() {
        try {
            // Arrange & Act:
            AddressMapper.getAddressByID(customer.getAddressID());
            // Assert:
        } catch (FogException e) {
            fail("Should not throw exception!");
        }
    }

    @Test
    public void GetPaymentInformationFromCreatedCustomer() {
        try {
            // Arrange & Act:
            PaymentInformationMapper.getPaymentInformationByID(customer.getPaymentID());
            // Assert:
        } catch (FogException e) {
            fail("Should not throw exception!");
        }
    }

    @Test
    public void GetUserFromCreatedCustomer() {
        try {
            // Arrange & Act:
            UserMapper.getUserByID(customer.getUserID());
            // Assert:
        } catch (FogException e) {
            fail("Should not throw exception!");
        }
    }
*/
}
