package tests.pl.store1.listing.producttile;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.Header;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.orders.SearchResultPage;
import library.testdata.header.PageTitles;
import library.testdata.orders.ProductData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChangeCartValueTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Change cart value")
    public void  ChangeCartValue() {

        SearchResultPage searchResultPage = new Header(page).findProduct(ProductData.TEST_PRODUCT_NAME.getValue());

        assertThat(searchResultPage.getProductTile()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));

        searchResultPage.addProductToTheCart();

        assertThat(searchResultPage.getProductQtyDecrementButton()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));

        searchResultPage
                .increaseProductQty()
                .waitForInputLoader()
                .openMiniCart()
                .waitForIncreasedValue();

        Assert.assertEquals(searchResultPage.getProductCountValue(), "2 szt.");

        searchResultPage
                .decreaseProductQty()
                .waitForInputLoader()
                .openMiniCart()
                .waitForDecreasedValue();

        Assert.assertEquals(searchResultPage.getProductCountValue(), "1 szt.");
    }
}