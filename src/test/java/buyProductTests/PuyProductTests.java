package buyProductTests;

import Base.BaseTests;
import login_tests.SignInTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PuyProductTests extends BaseTests {

    protected SignInTests signInTests;

    @Test
    public void buyProduct() {
        /*
        1. Open link http://automationpractice.com/index.php
        2. Login to the website.
        3. Move your cursor over Women's link.
        4. Click on sub menu 'T-shirts'.
        5. Mouse hover on the first product displayed.
        6. 'More' button will be displayed, click on 'More' button.
        7. Increase quantity to 2.
        8. Select size 'L'
        9. Select color.
        10. Click 'Add to Cart' button.
        11. Click 'Proceed to checkout' button.
        12. Complete the buy order process till payment.
        13. Make sure that Product is ordered.
         */

        var signIn = homePage.click_sign_in();
        signIn.setEmailToSignIn("Magicano@example.com");
        signIn.setPasswordToSignIn("Real Madrid");
        signIn.click_SignIn();

        homePage.hoverOverWomenTap();
        var productPage = homePage.click_TShirtsLink()
                .hoverOverProduct(1)
                .click_More();

        productPage.click_IncreaseQuantity(); //Will increase by 1
        productPage.chooseSize("L");
        productPage.chooseColor("orange");
        productPage.click_AddToCart();

        var shippingPage = productPage.click_proceedToCheckout()
                .click_proceedToCheckout()
                .click_proceedToCheckout();

        shippingPage.check_termsOfServices();

        var payment = shippingPage.click_proceedToCheckout();
        payment.PayByBankWire();
        var orderConfirm = payment.click_Confirm();

        assertEquals(orderConfirm.OrderConfirmationText(), "Your order on My Store is complete.");
    }

    /*
    Test Case - Verify that 'Add to Wishlist' only works after login.
        Steps to Automate:
        1. Open link http://automationpractice.com/index.php
        2. Move your cursor over Women's link.
        3. Click on sub menu 'T-shirts'.
        4. Mouse hover on the first product displayed.
        5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
        6. Verify that error message is displayed 'You must be logged in to manage your wish list.'
     */

    @Test
    public void testAddToWishlist() {

        homePage.hoverOverWomenTap();

        var tShirtPage = homePage.click_TShirtsLink();
        var productBox = tShirtPage.hoverOverProduct(1);
        productBox.click_AddToWishList();

        assertEquals(tShirtPage.verify_ErrorLoginMessage(),
                "You must be logged in to manage your wishlist.");

    }

}
