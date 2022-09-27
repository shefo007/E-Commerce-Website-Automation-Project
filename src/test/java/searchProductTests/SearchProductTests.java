package searchProductTests;

import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchProductTests extends BaseTests {

    /*
    Test Case - Automate 'Search Product' feature of e-commerce website with Selenium.
    Steps to Automate:
    1. Open link http://automationpractice.com/index.php
    2. Move your cursor over Women's link.
    3. Click on sub menu 'T-shirts'
    4. Get Name/Text of the first product displayed on the page.
    5. Now enter the same product name in the search bar
     present on top of page and click search button.
    6. Validate that same product is displayed on searched page
     with same details which were displayed on T-Shirt's page.
     */
    @Test
    public void testSearchProductFeature() {

        homePage.hoverOverWomenTap();
        var tShirtPage = homePage.click_TShirtsLink();
        String productName = tShirtPage.getProductName();
        homePage.search(productName);
        var searchPage = homePage.clickSearch();

        assertEquals(searchPage.getProductName(), productName);
    }
}
