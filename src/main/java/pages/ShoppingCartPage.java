package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartPage {

    private final WebDriver driver;
    private final By proceedToCheckout_Button = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddressesPage click_proceedToCheckout() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(proceedToCheckout_Button)).perform();
        driver.findElement(proceedToCheckout_Button).click();
        return new AddressesPage(driver);
    }

}
