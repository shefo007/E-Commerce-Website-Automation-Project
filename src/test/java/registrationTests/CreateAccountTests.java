package registrationTests;

import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateAccountTests extends BaseTests {

    /*
    Test Case - Automate User Registration process of e-commerce website.
        Steps to Automate:
        1. Open this url  http://automationpractice.com/index.php
        2. Click on sign in link.
        3. Enter your email address in 'Create and account' section.
        4. Click on Create an Account button.
        5. Enter your Personal Information, Address and Contact info.
        6. Click on Register button.
        7. Validate that user is created.
     */
    /*
    Email: Magicano@example.com
    Password: Real Madrid
    Notify this test passed and to make it pass again,
    We should delete the account first.
     */

    @Test
    public void testSuccessfulRegistration() {
        String validEmail = "Magicano@example.com";

        var authPage = homePage.click_sign_in();

        authPage.setEmailTOCreateAccount(validEmail);
        var createAccountPage = authPage.clickCreateAnAccount();

        createAccountPage.genderSelection("Mr");
        createAccountPage.enter_Firstname("Magi");
        createAccountPage.enter_Lastname("Cano");
        createAccountPage.enter_Password("Real Madrid");
        createAccountPage.select_dateOfBirth("5", "6", "2020");
        createAccountPage.enter_Address("1 Microsoft Way");
        createAccountPage.enter_City("Redmond");
        createAccountPage.select_State("Washington");
        createAccountPage.enter_postalCode("98052");
        createAccountPage.select_Country("United States");
        createAccountPage.enter_MobileNumber("123-4567-890");
        createAccountPage.enter_AliasAddress("No other Address");

        var myAccountPage = createAccountPage.click_Register();

        assertTrue(myAccountPage.get_WelcomeMessage().contains("Welcome to your account."));
    }

    /*
    Test Case - Verify invalid email address error.
        Steps to Automate:
        1. Open this url  http://automationpractice.com/index.php
        2. Click on sign in link.
        3. Enter invalid email address in the email box and click enter.
        4. Validate that an error message is displaying
         saying "Invalid email address."
     */

    @Test
    public void testInvalidEmailRegistration() {
        String invalidEmail = "Magicano[@]example.com";

        var authPage = homePage.click_sign_in();

        authPage.setEmailTOCreateAccount(invalidEmail);
        authPage.clickCreateAnAccount();

        assertEquals(authPage.getCreateAccountError(), "Invalid email address.");
    }

    /*
    Test Case - Verify error messages for mandatory fields.
        Steps to Automate:
        1. Open this url  http://automationpractice.com/index.php
        2. Click on sign in link.
        3. Enter email address and click Register button.
        4. Leave the mandatory fields (marked with *) blank and click Register button.
        5. Verify that error has been displayed for the mandatory fields.
     */

    @Test
    public void testMandatoryError() {
        String validEmail = "MoSala@example.com";

        var authPage = homePage.click_sign_in();

        authPage.setEmailTOCreateAccount(validEmail);
        var createAccountPage = authPage.clickCreateAnAccount();

        createAccountPage.click_Register();

        assertTrue(createAccountPage.getFieldsError().contains("There are 8 errors"));
    }


    /*
    Test Case - Verify error messages for entering incorrect values in fields.
        Steps to Automate:
        1. Open this url  http://automationpractice.com/index.php
        2. Click on sign in link.
        3. Enter email address and click Register button.
        4. Enter incorrect values in fields like., enter numbers in first and last name
           ,and click on 'Register' button.
        5. Verify that error messages fpr respective fields are displaying.
     */

    @Test
    public void testSetIncorrectValues() {
        String validEmail = "MoSala@example.com";

        var authPage = homePage.click_sign_in();

        authPage.setEmailTOCreateAccount(validEmail);
        var createAccountPage = authPage.clickCreateAnAccount();

        createAccountPage.genderSelection("Mr");
        createAccountPage.enter_Firstname("1234");
        createAccountPage.enter_Lastname("5678");
        createAccountPage.enter_Password("Real Madrid");
        createAccountPage.select_dateOfBirth("5", "6", "2020");
        createAccountPage.enter_Address("1 Microsoft Way");
        createAccountPage.enter_City("Redmond");
        createAccountPage.select_State("Washington");
        createAccountPage.enter_postalCode("98052");
        createAccountPage.select_Country("United States");
        createAccountPage.enter_MobileNumber("123-4567-890");
        createAccountPage.enter_AliasAddress("No other Address");

        createAccountPage.click_Register();

        assertTrue(createAccountPage.getFieldsError().contains("There are 2 errors"));
    }

}
