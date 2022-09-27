package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private final WebDriver driver;

    private final By sign_in = By.xpath("//a[@class=\"login\"]");
    private final By logout = By.xpath("//a[@class=\"logout\"]");
    private final By customerProfile = By.xpath("//a[@class=\"account\"]");
    private final By search_input = By.id("search_query_top");
    private final By searchButton = By.cssSelector("#searchbox button");
    private final By womenTap = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    private final By tShirtsTap = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage click_sign_in() {
        driver.findElement(sign_in).click();
        return new AuthenticationPage(driver);
    }

    public AuthenticationPage click_Logout() {
        driver.findElement(logout).click();
        return new AuthenticationPage(driver);
    }

    public My_AccountPage click_customerAccount() {
        driver.findElement(customerProfile).click();
        return new My_AccountPage(driver);
    }

    public void search(String item) {
        driver.findElement(search_input).sendKeys(item);
    }

    public SearchPage clickSearch(){
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public void hoverOverWomenTap() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(womenTap)).perform();
    }
    public TShirtsPage click_TShirtsLink() {
        driver.findElement(tShirtsTap).click();
        return new TShirtsPage(driver);
    }


}
