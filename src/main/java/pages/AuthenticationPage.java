package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    /*AUTHENTICATION Page is a page
    *to choose to create an account or register as a customer
    */

    private final WebDriver driver;

    //Create Account Locators
    private final By emailTOCreateAccount_Field = By.id("email_create");
    private final By createAccountButton = By.id("SubmitCreate");

    //Sign in Locators
    private final By emailToSignIn_Field = By.id("email");
    private final By passwordToSignIn_Field = By.id("passwd");
    private final By signInButton = By.id("SubmitLogin");

    //Errors messages Locators
    private final By signInErrorMessage = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private final By createAccountError = By.xpath("//*[@id=\"create_account_error\"]/ol/li");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailTOCreateAccount(String email) {
        driver.findElement(emailTOCreateAccount_Field).sendKeys(email);
    }

    public CreateAccountPage clickCreateAnAccount() {
        driver.findElement(createAccountButton).click();
        return new CreateAccountPage(driver);
    }

    public void setEmailToSignIn(String email) {
        driver.findElement(emailToSignIn_Field).sendKeys(email);
    }

    public void setPasswordToSignIn(String password) {
        driver.findElement(passwordToSignIn_Field).sendKeys(password);
    }

    public My_AccountPage click_SignIn() {
        driver.findElement(signInButton).click();
        return new My_AccountPage(driver);
    }

    public String getSignInError() {
        return driver.findElement(signInErrorMessage).getText();
    }

    public String getCreateAccountError() {
        return driver.findElement(createAccountError).getText();
    }

}
