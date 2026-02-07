package tests.pl.store1.listing.subcategory;

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

public class CheckSubcategoryTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Select subcategory test")
    public void checkTopRightpaginationArrow() {

        CategoryMenu categoryMenu = (new CategoryMenu(page)).expandSubMenu(MenuLinksTexts.MAKEUP_URL_PL.getValue());

        assertThat(categoryMenu.getViewAllButton()).isVisible();

        ListingPage listingPage = categoryMenu
                .navigateToCategoryPage()
                .waitForProductsGrid();

        assertThat(categoryMenu.getProductsGrid()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        int productCategoryCount = listingPage.getProductsPageCount();

        listingPage
                .selectSubcategoryAndWaitForResponse("manicure-i-pedicure", "ep.content_group3=manicure_i_pedicure", 200)
                .waitForProductsGrid();

        int productSubcategoryCount = listingPage.getProductsPageCount();

        Assert.assertTrue(productCategoryCount > productSubcategoryCount,
                "Wybranie podkategorii nie zawężyło wyników");
    }
}
