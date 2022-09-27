package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddressesPage {

    private WebDriver driver;
    private final By proceedToCheckout_Button = By.xpath("//*[@id=\"center_column\"]/form/p/button");



    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShippingPage click_proceedToCheckout() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(proceedToCheckout_Button)).perform();
        driver.findElement(proceedToCheckout_Button).click();
        return new ShippingPage(driver);
    }

}
