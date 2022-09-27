package login_tests;

import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTests extends BaseTests {

    //Using Invalid Email
    @Test
    public void testInvalidEmailLogin() {
        var sign_in_page = homePage.click_sign_in();
        sign_in_page.setEmailToSignIn("dsfj@dsj");
        sign_in_page.setPasswordToSignIn("dlfsj75");
        sign_in_page.click_SignIn();
        assertEquals(sign_in_page.getSignInError(), "Invalid email address.");
    }

    @Test
    public void testLoginForNotRegisteredUser() {
        var sign_in_page = homePage.click_sign_in();
        sign_in_page.setEmailToSignIn("jacksparrow@example.com");
        sign_in_page.setPasswordToSignIn("Black Pearl");
        sign_in_page.click_SignIn();
        assertEquals(sign_in_page.getSignInError(), "Authentication failed.");
    }

    @Test
    public void testValidLogin() {
        var sign_in_page = homePage.click_sign_in();
        sign_in_page.setEmailToSignIn("Magicano@example.com");
        sign_in_page.setPasswordToSignIn("Real Madrid");
        var myAccountPage = sign_in_page.click_SignIn();
        assertTrue(myAccountPage.get_WelcomeMessage().contains("Welcome to your account."));
    }




}
