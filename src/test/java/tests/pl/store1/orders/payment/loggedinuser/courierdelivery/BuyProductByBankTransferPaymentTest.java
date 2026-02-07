package tests.pl.store1.orders.payment.loggedinuser.courierdelivery;

import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PageAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.Header;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.pages.store1.pl.orders.*;
import library.testdata.header.PageTitles;
import library.testdata.orders.DeliveryMethods;
import library.testdata.orders.PaymentMethods;
import library.testdata.orders.ProductData;
import library.testdata.users.UsersEmail;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BuyProductByBankTransferPaymentTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Buy product as logged in user by courier delivery and BankTransfer")
    public void  byuProductByBankTransferTest(){

        LoginPage loginPage = (new HomePage(page)).navigateToLoginPage();

        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.
                logInToSystem(
                        UsersEmail.STORE1_USER_EMAIL.getValue(),
                        config.getTestUserPassword()
                );

        assertThat(page).hasTitle(PageTitles.MY_ACCOUNT_TITLE_PL.getValue(), new PageAssertions.HasTitleOptions().setTimeout(10000));

        page.navigate(config.getStore1Url() + "checkout/cart");
        CheckoutCartPage checkoutCartPage = (new CheckoutCartPage(page));
        checkoutCartPage.checkCartValueAfterLogin();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());

        SearchResultPage searchResultPage = (new Header(page).findProduct(ProductData.TEST_PRODUCT_NAME.getValue()));

        assertThat(searchResultPage.getProductTile()).isVisible();

        ProductPage productPage = searchResultPage.selectProduct();

        assertThat(productPage.getProductArea()).isVisible();

        Map<String, String> productDetailsFromProductPage = productPage.getProductData();
        MiniCart miniCart = productPage
                .addProductToTheCart()
                .openMiniCart();

        assertThat(miniCart.getNavigateToCheckoutCartButton()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        Assert.assertTrue(productDetailsFromProductPage.entrySet().containsAll(miniCart.getProductData().entrySet()), "Incorrect product Data");

        miniCart
                .navigateToCheckoutCart();
        checkoutCartPage
                .waitForCheckoutCart();

        assertThat(checkoutCartPage.getCheckoutCartArea()).isVisible();
        Assert.assertTrue(productDetailsFromProductPage.entrySet().containsAll(checkoutCartPage.getProductData().entrySet()), "Incorrect checkout cart product data");

        CheckoutDeliveryPage checkoutDeliveryPage = checkoutCartPage
                .navigateToCheckoutDeliveryPage();
        checkoutDeliveryPage
                .waitForTotalsRequest()
                .waitForCheckoutDeliveryPage();

        assertThat(checkoutDeliveryPage.getCheckoutDeliveryArea()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(20000));

        checkoutDeliveryPage
                .waitForLoggedInUserAddressDataTile()
                .selectDeliveryMethod(DeliveryMethods.checkoutDeliveryMethodCourierXpath)
                .waitForTotalsRequest()
                .waitForCheckoutDeliveryPage();
        CheckoutSummaryPage checkoutSummaryPage = checkoutDeliveryPage
                .selectPaymentMethod(PaymentMethods.PaymentProviderBankTransfer)
                .clickGoToCheckoutSummaryPageButton();

        assertThat(checkoutSummaryPage.getCheckoutSummaryAddressAndPaymentData()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        checkoutSummaryPage
                .selectBankTransferBank(PaymentMethods.bankTransferDefaultXpath)
                .expandBlockItemsInCart();

        Assert.assertTrue(productDetailsFromProductPage.entrySet().containsAll(checkoutSummaryPage.getProductData().entrySet()), "Incorrect product Data");

        checkoutSummaryPage
                .clickPrivacyPolicyAgreementCheckbox()
                .clickPlaceOrderButton();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue(), new PageAssertions.HasTitleOptions().setTimeout(30000));

        checkoutSummaryPage.confirmBankTransferOrder();

        assertThat(page).hasTitle(PageTitles.SUCCESS_PAGE_PL.getValue(), new PageAssertions.HasTitleOptions().setTimeout(30000));
    }
}