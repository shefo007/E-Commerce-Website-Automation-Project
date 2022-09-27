package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private WebDriver driver;
    private final By verifyText = By.xpath("//*[@id=\"center_column\"]/div/p/strong");


    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String OrderConfirmationText() {
        return driver.findElement(verifyText).getText();
    }
}
