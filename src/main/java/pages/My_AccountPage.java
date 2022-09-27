package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class My_AccountPage {

    private WebDriver driver;
    private final By welcome_message = By.xpath("//p[@class=\"info-account\"]");

    public My_AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String get_WelcomeMessage() {
        return driver.findElement(welcome_message).getText();
    }


}
