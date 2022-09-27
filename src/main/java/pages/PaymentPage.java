package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PaymentPage {

    private WebDriver driver;
    private final By byBankWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private final By byCheck = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
    private final By confirmButton = By.xpath("//*[@id=\"cart_navigation\"]/button");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void PayByBankWire() {
        driver.findElement(byBankWire).click();
    }

    public void PayByCheck() {
        driver.findElement(byCheck).click();
    }

    public OrderConfirmationPage click_Confirm() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(confirmButton)).perform();
        driver.findElement(confirmButton).click();
        return new OrderConfirmationPage(driver);
    }

}
