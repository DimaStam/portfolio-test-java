package tests.pl.store1.productcard.floatingcard;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.Header;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.orders.ProductPage;
import library.pages.store1.pl.orders.SearchResultPage;
import library.testdata.header.PageTitles;
import library.testdata.orders.ProductData;
import library.testdata.productcard.ProductCardData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckFloatingCardPickupStore1Test extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Check floating card pickup store1 tab")
    public void  checkPickupStore1Tab() {

        SearchResultPage searchResultPage = (new Header(page)).findProduct(ProductData.TEST_PRODUCT_NAME.getValue());

        assertThat(searchResultPage.getProductTile()).isVisible();

        ProductPage productPage = searchResultPage.selectProduct();
        productPage
                .waitForProductPage()
                .scrollPageDown();

        assertThat(productPage.getPickupStore1Button()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        productPage.clickPickupStore1Button();

        assertThat(productPage.getPickupStore1Tab()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));

        productPage.searchStoreByAdress(ProductCardData.ADRESS_NAME.getValue());

        assertThat(productPage.getSearchStoreName()).hasText(ProductCardData.STORE_NAME.getValue());

        productPage.clickStore1OpenHours();

        assertThat(productPage.getOpenHours()).hasText(ProductCardData.STORE_OPEN_HOURS.getValue());
        assertThat(productPage.getRouteButton()).isVisible();

        productPage.closePickupStore1Tab();

        assertThat(productPage.getPickupStore1Tab()).isHidden();
    }
}