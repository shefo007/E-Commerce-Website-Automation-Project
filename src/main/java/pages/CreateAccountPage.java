package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    private final WebDriver driver;

    //Personal information locators
    private final By Mr = By.xpath("//*[@id=\"id_gender1\"]");
    private final By Mrs = By.xpath("//*[@id=\"id_gender2\"]");
    private final By firstName_Field = By.id("customer_firstname");
    private final By lastName_Field = By.id("customer_lastname");
    private final By password_Field = By.id("passwd");

    //Date of birth locators.
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    //Address Locators
    private final By address_Field = By.id("address1");
    private final By city_Field = By.id("city");
    private final By drp_state = By.id("id_state");
    private final By zip_postal_codeField = By.id("postcode");
    private final By drp_country = By.id("id_country");
    private final By mobilePhone_Field = By.id("phone_mobile");
    private final By address_Alias_Field = By.id("alias");
    private final By registerButton = By.id("submitAccount");
    private final By requiredFieldsError = By.xpath("//*[@id=\"center_column\"]/div/p");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void genderSelection(String gender) {

        WebElement genderMr = driver.findElement(Mr);
        WebElement genderMrs = driver.findElement(Mrs);

        if (gender.equals("Mr")){
            genderMr.click();
        } else if(gender.equals("Mrs")) {
            genderMrs.click();
        }
    }

    public void enter_Firstname(String firstname) {
        driver.findElement(firstName_Field).sendKeys(firstname);
    }

    public void enter_Lastname(String lastname) {
        driver.findElement(lastName_Field).sendKeys(lastname);
    }

    public void enter_Password(String password) {
        driver.findElement(password_Field).sendKeys(password);
    }

    public void select_dateOfBirth(String day, String month, String year) {
        Select select_Day = new Select(driver.findElement(days));
        Select select_Month = new Select(driver.findElement(months));
        Select select_Years = new Select(driver.findElement(years));
        select_Day.selectByValue(day);
        select_Month.selectByValue(month);
        select_Years.selectByValue(year);
    }

    public void enter_Address(String address){
        driver.findElement(address_Field).sendKeys(address);
    }

    public void enter_City(String city) {
        driver.findElement(city_Field).sendKeys(city);
    }

    public void select_State(String state) {
        Select selectState = new Select(driver.findElement(drp_state));
        selectState.selectByVisibleText(state);
    }

    public void enter_postalCode(String num){
        driver.findElement(zip_postal_codeField).sendKeys(num);
    }

    public void select_Country(String country) {
        Select selectCountry = new Select(driver.findElement(drp_country));
        selectCountry.selectByVisibleText(country);
    }

    public void enter_MobileNumber(String num) {
        driver.findElement(mobilePhone_Field).sendKeys(num);
    }

    public void enter_AliasAddress(String address) {
        driver.findElement(address_Alias_Field).sendKeys(address);
    }

    public My_AccountPage click_Register() {
        driver.findElement(registerButton).click();
        return new My_AccountPage(driver);
    }

    public String getFieldsError() {
        return driver.findElement(requiredFieldsError).getText();
    }

}
