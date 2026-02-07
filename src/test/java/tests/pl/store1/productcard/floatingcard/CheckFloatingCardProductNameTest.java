package tests.pl.store1.productcard.floatingcard;

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

public class CheckFloatingCardProductNameTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Check floating card product name")
    public void  checkProductName() {

        SearchResultPage searchResultPage = (new Header(page)).findProduct(ProductData.TEST_PRODUCT_NAME.getValue());

        assertThat(searchResultPage.getProductName()).isVisible();

        ProductPage productPage = searchResultPage.selectProduct();
        productPage
                .waitForProductPage()
                .scrollPageDown();

        assertThat(productPage.getFloatingCardProductName()).containsText(ProductData.TEST_PRODUCT_NAME.getValue());
    }
}