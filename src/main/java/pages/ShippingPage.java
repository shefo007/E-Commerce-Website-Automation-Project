package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShippingPage {

    private final WebDriver driver;
    private final By proceedToCheckout_Button = By.xpath("//*[@id=\"form\"]/p/button");
    private final By termsOfServices = By.xpath("//*[@id=\"cgv\"]");


    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void check_termsOfServices(){
        driver.findElement(termsOfServices).click();
    }

    public PaymentPage click_proceedToCheckout() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(proceedToCheckout_Button)).perform();
        driver.findElement(proceedToCheckout_Button).click();
        return new PaymentPage(driver);
    }

}
