package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TShirtsPage {

    private final WebDriver driver;

    private final By productName = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
    private final By products = By.xpath("//*[@id=\"center_column\"]/ul/li");
    private final By ErrorLoginMessage = By.xpath("//*[@id=\"category\"]/div[2]/div/div/div/div/p");
    private final By product_con = By.className("product-container");

    public TShirtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }



    /**
     *
     * @param index starts at 1
     */
    public Product hoverOverProduct(int index){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(products)).perform();
        WebElement product = driver.findElements(products).get(index - 1);

        actions.moveToElement(product).perform();

        return new Product(product.findElement(product_con));
    }

    public String verify_ErrorLoginMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorLoginMessage)).getText();
    }

    public class Product {

        private final WebElement productContainer;
        private final By moreButton = By.xpath("//*[@class=\"right-block\"]/div[2]/a[2]");
        private final By addToWishList_Button = By.xpath("//*[@class=\"functional-buttons clearfix\"]/div[1]/a[1]");

        public Product(WebElement webElement) {
            this.productContainer = webElement;
        }

        public ProductFullPage click_More() {
            productContainer.findElement(moreButton).click();
            return new ProductFullPage(driver);
        }

        public TShirtsPage click_AddToWishList() {
            productContainer.findElement(addToWishList_Button).click();
            return new  TShirtsPage(driver);
        }

    }


}
