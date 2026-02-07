package library.pages.store1.pl.orders;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.pages.store1.common.Header;
import lombok.Getter;

@Getter
public class SearchResultPage extends TestDrivers {

    private Locator productTile;
    private Locator productName;
    private Locator productPrice;
    private Locator productImage;
    private Locator productImagePL;
    private Locator productWishlistButton;
    private Locator getProductWishlistButtonActive;
    private Locator addToTheCartButton;
    private Locator productReviews;
    private Locator productCapacity;
    private Locator productQtyIncrenentButton;
    private Locator productQtyDecrementButton;
    private Locator productIncreased;
    private Locator productDecreased;
    private Locator inputLoader;
    private Locator miniCartIcon;
    private Locator miniCartProductCount;

    public SearchResultPage(Page page){
        this.page = page;
        this.productTile = page.locator("//div[@class='result-sub-content']//a[@class='result']");
        this.productName = page.locator("//h3[@class='result-title text-ellipsis']");
        this.productPrice = page.locator("//span[@data-item-price='lowPrice']");
        this.productImage = page.locator("//div[@class='result-thumbnail']");
        this.productImagePL = page.locator("//div[@class='result-thumbnail ']");
        this.productWishlistButton = page.locator("//i[@data-action='add-to-wishlist']");
        this.getProductWishlistButtonActive = page.locator("//i[@class='ico ico-wishlist active']");
        this.addToTheCartButton = page.locator("//button[@class='action tocart primary']");
        this.productReviews = page.locator("//div[@class='product-reviews-summary short']");
        this.productCapacity = page.locator("//div[@class='product-attribute']");
        this.productQtyIncrenentButton = page.locator("//button[@class='btn-qty-update increment']");
        this.productQtyDecrementButton = page.locator("//button[@class='btn-qty-update decrement']");
        this.productIncreased = page.locator("//span[@class='values' and text()='2']");
        this.productDecreased = page.locator("//span[@class='values' and text()='1']");
        this.inputLoader = page.locator("//div[@class='loader-input']");
        this.miniCartIcon = page.locator("//a[@class='action showcart show-cart-button-active']");
        this.miniCartProductCount = page.locator("//div[@class='option']//span[@class='values']");
    }

    @Step("Select product")
    public ProductPage selectProduct(){
        getProductTile().click();
        return new ProductPage(page);
    }

    @Step("Add product to the cart")
    public Header addProductToTheCart(){
        getAddToTheCartButton().waitFor();
        getAddToTheCartButton().click();
        return new Header(page);
    }

    @Step("Wait for input loader to disappear")
    public SearchResultPage waitForInputLoader(){
        inputLoader.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        return this;
    }

    @Step("Increase product quantity")
    public SearchResultPage increaseProductQty(){
        getProductQtyIncrenentButton().click();
        return this;
    }

    @Step("Decrease product quantity")
    public SearchResultPage decreaseProductQty(){
        productQtyDecrementButton.click();
        return this;
    }

    @Step("Open mini cart")
    public SearchResultPage openMiniCart(){
        miniCartIcon.click();
        return this;
    }

    @Step("Get product count value")
    public String getProductCountValue(){
        Locator miniCartCountData = miniCartProductCount.first();
        String  minicartProductCount = miniCartCountData.textContent();
        return minicartProductCount;
    }

    @Step("Add product to the wishlist")
    public SearchResultPage addProductToTheWishlist(){
        productWishlistButton.waitFor();
        productWishlistButton.click();
        return this;
    }

    @Step("Wait for wishlist button to be active")
    public SearchResultPage waitForActiveWishlistButton(){
        getGetProductWishlistButtonActive().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED).setTimeout(15000));
        return this;
    }

    @Step("Wait for increased value")
    public SearchResultPage waitForIncreasedValue(){
        getProductIncreased().waitFor();
        return this;
    }

    @Step("Wait for decreased value")
    public SearchResultPage waitForDecreasedValue(){
        getProductDecreased().waitFor();
        return this;
    }
}
