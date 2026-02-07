package tests.pl.store1.listing.productcount;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.defaultdata.menu.MenuLinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.CategoryMenu;
import library.pages.store1.common.HomePage;
import library.pages.store1.listing.ListingPage;
import library.testdata.header.PageTitles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Check120ProductsTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Check listing show 120 products")
    public void check120Products() {

        CategoryMenu categoryMenu = (new CategoryMenu(page)).expandSubMenu(MenuLinksTexts.MAKEUP_URL_PL.getValue());

        assertThat(categoryMenu.getViewAllButton()).isVisible();

        ListingPage listingPage = categoryMenu.navigateToCategoryPage();
        listingPage.waitForProductsGrid();

        assertThat(categoryMenu.getProductsGrid()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        Assert.assertEquals(listingPage.getProductTilesCount().count(), 20);

        listingPage
                .openShowProductsCountDropdown()
                .clickShow120Products()
                .waitFor120Products();

        Assert.assertEquals(listingPage.getProductTilesCount().count(), 120);
    }
}
