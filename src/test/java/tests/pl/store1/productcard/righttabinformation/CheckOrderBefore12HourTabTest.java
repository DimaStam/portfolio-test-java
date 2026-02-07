package tests.pl.store1.productcard.righttabinformation;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.Header;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.orders.ProductPage;
import library.pages.store1.pl.orders.SearchResultPage;
import library.testdata.header.PageTitles;
import library.testdata.orders.ProductData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckOrderBefore12HourTabTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Check Order before 12:00 tab")
    public void checkOrderBefore12HourTab() {

        SearchResultPage searchResultPage = new Header(page).findProduct(ProductData.TEST_PRODUCT_NAME.getValue());

        assertThat(searchResultPage.getProductTile()).isVisible();

        ProductPage productPage = searchResultPage.selectProduct();
        productPage.waitForProductPage();

        assertThat(productPage.getOrderBefore12Button()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        productPage.clickOrderBefore12Button();

        assertThat(productPage.getOrderBefore12Tab()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));

        productPage.closeOrderBefore12Tab();

        assertThat(productPage.getOrderBefore12Tab()).isHidden();
    }
}