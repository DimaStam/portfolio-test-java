package tests.pl.store1.listing.filters;

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

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckPriceFilterTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(enabled = false, description = "Check is the price filter working properly")
    public void checkPriceFilter(){

        CategoryMenu categoryMenu = (new CategoryMenu(page)).expandSubMenu(MenuLinksTexts.MAKEUP_URL_PL.getValue());

        assertThat(categoryMenu.getViewAllButton()).isVisible();

        ListingPage listingPage = categoryMenu.navigateToCategoryPage();
        listingPage.waitForProductsGrid();

        assertThat(categoryMenu.getProductsGrid()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        assertThat(listingPage.getFiltersDropdown()).isVisible();

        listingPage.openFiltersDropdown()
                .waitForFiltersArea();

        assertThat(listingPage.getFiltersArea()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));

        listingPage
                .dragMinimalPriceSlider()
                .openSortingDropdown()
                .dragMaximalPriceSlider()
                .clickAcceptFiltersButton()
                .openShowProductsCountDropdown()
                .clickShow120Products()
                .waitForProductsGrid();

        List<Double> prices = listingPage.getProductPrices();

        Assert.assertTrue(listingPage.validatePrices(prices), "Ceny produktów są poza zakresem filtra");
    }
}
