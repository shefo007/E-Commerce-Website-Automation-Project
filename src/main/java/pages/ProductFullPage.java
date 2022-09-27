package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductFullPage {

    private final WebDriver driver;
    private final By decreaseQuantityButton = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[1]");
    private final By increaseQuantityButton = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]");
    private final By sizeSelection = By.id("group_1");
    private final By orangeColor = By.id("color_13");
    private final By blueColor = By.id("color_14");
    private final By addToCart_Button = By.cssSelector("#add_to_cart button");
    private final By proceedToCheckout_Button = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");


    public ProductFullPage(WebDriver driver) {
        this.driver = driver;
    }


    public void click_DecreaseQuantity() {
        driver.findElement(decreaseQuantityButton).click();
    }

    public void click_IncreaseQuantity() {
        driver.findElement(increaseQuantityButton).click();
    }

    public void chooseSize(String choice) {

        Select size = new Select(driver.findElement(sizeSelection));
        if (choice.equals("S") || choice.equals("s")) {
            size.selectByVisibleText(choice);
        }
        else if (choice.equals("M") || choice.equals("m")) {
            size.selectByVisibleText(choice);
        }
        else if (choice.equals("L") || choice.equals("l")) {
            size.selectByVisibleText(choice);
        }
    }

    public void chooseColor(String color) {

        WebElement orange = driver.findElement(orangeColor);
        WebElement blue = driver.findElement(blueColor);

        if (color.equals("Orange") || color.equals("orange")) {
            orange.click();
        } else if (color.equals("Blue") || color.equals("blue")) {
            blue.click();
        }
    }

    public void click_AddToCart() {
        driver.findElement(addToCart_Button).click();
    }

    public ShoppingCartPage click_proceedToCheckout() {
//
        driver.findElement(proceedToCheckout_Button).click();
        return new ShoppingCartPage(driver);
    }
    
}
