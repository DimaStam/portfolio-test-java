package tests.pl.store1.listing.producttile;

import com.microsoft.playwright.assertions.PageAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.Header;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.pages.store1.pl.orders.SearchResultPage;
import library.pages.store1.wishlist.WishListPage;
import library.testdata.header.PageTitles;
import library.testdata.orders.ProductData;
import library.testdata.users.UsersEmail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayWishlistPageLoggedInUserTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage() {
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display wishlist page from listing for logged in user")
    public void testDisplayWishlistForLoggedInUser() {

        LoginPage loginPage = (new HomePage(page)).navigateToLoginPage();
        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.logInToSystem(
                UsersEmail.STORE1_USER_EMAIL.getValue(),
                config.getTestUserPassword()
        );

        assertThat(page).hasTitle(PageTitles.MY_ACCOUNT_TITLE_PL.getValue(), new PageAssertions.HasTitleOptions().setTimeout(10000));

        WishListPage wishListPage = loginPage.navigateToWishlistPage();

        assertThat(page).hasTitle(PageTitles.WISHLIST_TITLE_PL.getValue(), new PageAssertions.HasTitleOptions().setTimeout(10000));

        wishListPage.checkWishlistPageAfterLogin();

        SearchResultPage searchResultPage = new Header(page).findProduct(ProductData.TEST_PRODUCT_NAME.getValue());

        assertThat(searchResultPage.getProductTile()).isVisible();

        searchResultPage.addProductToTheWishlist();
        loginPage.navigateToWishlistPage();

        assertThat(page).hasTitle(PageTitles.WISHLIST_TITLE_PL.getValue(), new PageAssertions.HasTitleOptions().setTimeout(30000));
    }
}
