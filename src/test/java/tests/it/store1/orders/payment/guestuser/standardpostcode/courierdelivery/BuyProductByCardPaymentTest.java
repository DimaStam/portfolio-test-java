package tests.it.store1.orders.payment.guestuser.standardpostcode.courierdelivery;

import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PageAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.orders.add.DeliveryFactory;
import library.pages.store1.common.Header;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.orders.*;
import library.testdata.header.PageTitles;
import library.testdata.orders.DeliveryMethods;
import library.testdata.orders.PaymentData;
import library.testdata.orders.PaymentMethods;
import library.testdata.orders.ProductData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BuyProductByCardPaymentTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_IT_PAGE_TITLE.getValue());
    }

    @Test(description = "Store 1 buy product by Courier delivery and Card payment")
    public void buyProductByCardPaymentTest() {

        SearchResultPage searchResultPage = (new Header(page)).findProduct(ProductData.TEST_PRODUCT_NAME.getValue());

        assertThat(searchResultPage.getProductTile()).isVisible();

        ProductPage productPage = searchResultPage.selectProduct();

        assertThat(productPage.getProductArea()).isVisible();

        Map<String, String> productDetailsFromProductPage = productPage.getProductData();
        MiniCart miniCart = productPage
                .addProductToTheCart()
                .openMiniCart();

        assertThat(miniCart.getNavigateToCheckoutCartButton()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        Assert.assertTrue(productDetailsFromProductPage.entrySet().containsAll(miniCart.getProductData().entrySet()), "Incorrect product Data");

        CheckoutCartPage checkoutCartPage = miniCart.navigateToCheckoutCart();
        checkoutCartPage.waitForCheckoutCart();

        assertThat(checkoutCartPage.getCheckoutCartArea()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(20000));
        Assert.assertTrue(productDetailsFromProductPage.entrySet().containsAll(checkoutCartPage.getProductData().entrySet()), "Incorrect product Data");

        CheckoutDeliveryPage checkoutDeliveryPage = checkoutCartPage
                .navigateToCheckoutDeliveryPage();
        checkoutDeliveryPage
                .waitForTotalsRequest()
                .waitForCheckoutDeliveryInternationalLoaders();

        assertThat(checkoutDeliveryPage.getCheckoutDeliveryArea()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(20000));

        checkoutDeliveryPage
                .waitForUserEmailField()
                .fillCheckoutDeliveryForm(DeliveryFactory.createDeliveryData())
                .selectDeliveryMethod(DeliveryMethods.checkoutDeliveryMethodCourierXpath);
        checkoutDeliveryPage
                .waitForTotalsRequest()
                .waitForCheckoutDeliveryInternationalLoaders();
        CheckoutSummaryPage checkoutSummaryPage = checkoutDeliveryPage
                .selectPaymentMethod(PaymentMethods.PaymentProviderCard)
                .clickGoToCheckoutSummaryPageButton();

        assertThat(checkoutSummaryPage.getCheckoutSummaryAddressAndPaymentData()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        checkoutSummaryPage
                .waitForCreditCard()
                .fillCreditCardFields(PaymentData.cardNumber, PaymentData.cardExpiryDate, PaymentData.cardCvvCode);
        checkoutSummaryPage
                .expandBlockItemsInCart();

        Assert.assertTrue(productDetailsFromProductPage.entrySet().containsAll(checkoutSummaryPage.getProductDataIT().entrySet()), "Incorrect product Data");

        checkoutSummaryPage
                .clickPrivacyPolicyAgreementCheckbox()
                .clickPlaceOrderButton();

        assertThat(page).hasTitle(PageTitles.SUCCESS_PAGE_PL.getValue(), new PageAssertions.HasTitleOptions().setTimeout(30000));
    }
}
