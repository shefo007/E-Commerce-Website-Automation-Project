package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SearchPage {

    private final WebDriver driver;

    private final By productName = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }


}
