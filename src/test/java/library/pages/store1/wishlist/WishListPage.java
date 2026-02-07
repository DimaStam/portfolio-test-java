package library.pages.store1.wishlist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;
import library.main.TestDrivers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WishListPage extends TestDrivers {

    private Locator startShoppingButton;
    private Locator selectAllProductsCheckbox;
    private Locator wishlistDropdown;
    private Locator dropdownMenu;
    private Locator deleteSelected;
    private Locator productCheckbox;

    public WishListPage(Page page){
        this.page = page;
        this.startShoppingButton =  page.locator("//a[@class='action shopping']");
        this.selectAllProductsCheckbox = page.locator("//div[@class='action share-all']//input[@type='checkbox']");
        this.wishlistDropdown = page.locator("//div[@class='wishlist-dropdown']");
        this.dropdownMenu = page.locator("//div[@class='wishlist-dropdown-menu']");
        this.deleteSelected = page.locator("//div[@class='wishlist-dropdown-menu']//button[@type='submit' and @class='action']");
        this.productCheckbox = page.locator("//div[@class='product-item-actions-toolbar']//input[@type='checkbox']");
    }

    @Step("Check is wishlist page is empty, if not, delete products")
    public WishListPage checkWishlistPageAfterLogin(){
        page.waitForLoadState(LoadState.LOAD);
        if (startShoppingButton.isVisible()) {
            startShoppingButton.click();
        } else {
            selectAllProductsCheckbox.waitFor();
            selectAllProductsCheckbox.check();
            assertThat(productCheckbox.first()).isChecked(new LocatorAssertions.IsCheckedOptions().setTimeout(10000));
            wishlistDropdown.click();
            dropdownMenu.waitFor();
            deleteSelected.click();
            startShoppingButton.waitFor();
        }
        return this;
    }
}
