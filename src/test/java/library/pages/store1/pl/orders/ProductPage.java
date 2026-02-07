package library.pages.store1.pl.orders;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ProductPage extends TestDrivers {

    private Locator productArea;
    private Locator addProductToTheWishlistIcon;
    private Locator manufacturerLogo;
    private Locator pricePerUnit;
    private Locator productPrice;
    private Locator orderBefore12Button;
    private Locator orderBefore12Tab;
    private Locator pickupStore1Button;
    private Locator pickupStore1Tab;
    private Locator searchStoreName;
    private Locator openHours;
    private Locator routeButton;
    private Locator availabilityInStoresButton;
    private Locator availabilityTab;
    private Locator onlyInStoreCheckbox;
    private Locator productCapacity;
    private Locator pickupStoreName;
    private Locator addProductToTheCartButton;
    private Locator openMiniCartButton;
    private Locator fullScreenButton;
    private Locator wishlistIcon;
    private Locator availabilityButton;
    private Locator store1AdressInput;
    private Locator store2AdressInput;
    private Locator closeStoreAvailabilityButton;
    private Locator closeOrderBefore12Button;
    private Locator store1OpenHoursButton;
    private Locator closePickupStore1Button;
    private Locator productSectionTitle;
    private Locator exitFullScreenButton;
    private Locator rightArrowButton;
    private Locator productMainImage;
    private Locator productMiniImage;
    private Locator productName;
    private Locator productMenu;
    private Locator productReviews;
    private Locator productComposition;
    private Locator productDescription;
    private Locator productDisclaimer;
    private Locator stockLabel;
    private Locator floatingCardProductName;
    private Locator installmentLabel;
    private Locator installmentLabelText;
    private Locator floatingCardStockLabel;
    private Locator leftArrowButton;
    private Locator customerReviews;

    public ProductPage(Page page){
        this.page = page;
        this.productArea = page.locator("//div[@class='product-info-main']");
        this.addProductToTheWishlistIcon = page.locator("//div[@class='product media']//span[@class='action towishlist']");
        this.manufacturerLogo = page.locator("//div[@class='product-info-main']//div[@class='producer-logo']");
        this.pricePerUnit = page.locator("//div[@class='product-info-main-left']//div[@id='price-per-unit']");
        this.productPrice = page.locator("//div[@class='product-info-main-right']//div[@class='product-info-price']");
        this.orderBefore12Button = page.locator("//div[@class='product-info-main-right']//div[@class='container-delivery-times d-flex']");
        this.orderBefore12Tab = page.locator("//div[@class='modal-text']");
        this.pickupStore1Button = page.locator("//div[@class='product-info-main-right']//div[@class='container-pickup-times d-flex']");
        this.pickupStore1Tab = page.locator("//div[@class='stock-city stores-list']");
        this.searchStoreName = page.locator("//p[@class='stock-city-name']");
        this.openHours = page.locator("//div[@class='show-open-hours open']//p[@class='stock-open-hours selected']");
        this.routeButton = page.locator("//div[@class='stock-available-route']");
        this.availabilityInStoresButton = page.locator("//div[@class='container-available-shop d-flex']");
        this.availabilityTab = page.locator("//div[@class='stock-available-top']");
        this.onlyInStoreCheckbox = page.locator("//div[@class='only-in-the-store']");
        this.productCapacity = page.locator("//div[@class='selected-variant']");
        this.pickupStoreName = page.locator("//div[@class='product-info-main-right']//div[@class='container-pickup-times d-flex']//span[@class='choose-store']");
        this.addProductToTheCartButton = page.locator("//button[@id='product-addtocart-button']");
        this.openMiniCartButton = page.locator("//div[@class='minicart-wrapper']");
        this.fullScreenButton = page.locator("//div[@class='fotorama__fullscreen-icon']");
        this.wishlistIcon = page.locator("//ul[@class='header links']/child::li[@class='link wishlist']");
        this.availabilityButton = page.locator("//div[@class='product-info-stock-sku stock-sku-desktop w-100']//div[@id='container-available-shop']");
        this.store1AdressInput = page.locator("//input[@placeholder='Search Store 1']");
        this.store2AdressInput = page.locator("//input[@placeholder='Search Store 2']");
        this.closeStoreAvailabilityButton = page.locator("//span[@class='stock-available-close sp-icon sp-icon-close']");
        this.closeOrderBefore12Button = page.locator("//aside[@class='modal-slide container-select-store1 _show']//button[@class='action-close']");
        this.store1OpenHoursButton = page.locator("//p[@class='btn-stock']");
        this.closePickupStore1Button = page.locator("//span[@class='stock-available-close sp-icon sp-icon-close']");
        this.productSectionTitle = page.locator("//div[@id='attrid-description']//h2[@class='product-section-title']");
        this.exitFullScreenButton = page.locator("//div[@aria-label='Exit fullscreen']");
        this.rightArrowButton = page.locator("//div[@class='fotorama__arr fotorama__arr--next']");
        this.productMainImage = page.locator("//div[@class='product media']");
        this.productMiniImage = page.locator("//div[@class='fotorama__nav fotorama__nav--thumbs']");
        this.productName = page.locator("//span[@class='base']");
        this.productMenu = page.locator("#product-menu");
        this.productReviews = page.locator("#product-review");
        this.productComposition = page.locator("#composition");
        this.productDescription = page.locator("#attrid-description");
        this.productDisclaimer = page.locator("//div[@class='product-disclaimers']");
        this.stockLabel = page.locator("//div[@class='stock available']");
        this.floatingCardProductName = page.locator("//div[@class='product-info-main-right']//span[@class='name']");
        this.installmentLabel = page.locator("//div[@class='product-info-main-right']//div[@class='payment-installment']");
        this.installmentLabelText = page.locator("//div[@class='product-info-main-right']//span[@class='installment-text']");
        this.floatingCardStockLabel = page.locator("//div[@class='product-info-main-right']//div[@class='stock available']");
        this.leftArrowButton = page.locator("//div[@class='fotorama__arr fotorama__arr--prev']");
        this.customerReviews = page.locator("#customer-reviews");
    }

    @Step("Add product to the cart")
    public ProductPage addProductToTheCart(){
        getAddProductToTheCartButton().click();
        return this;
    }

    @Step("Open mini cart")
    public MiniCart openMiniCart(){
        openMiniCartButton.click();
        return new MiniCart(page);
    }

    @Step("Get product page name and price")
    public Map<String, String> getProductData(){
        Map<String, String> productData = new HashMap<>();
        productData.put("productName", page.locator("//span[@data-ui-id='page-title-wrapper']").textContent().replace(" 75 ml", ""));
        productData.put("productPrice", page.locator("//div[@class='product-info-main-right']//span[@data-price-type='finalPrice']").textContent());
        return productData;
    }

    @Step("Click full screen button")
    public ProductPage clickFullScreenButton(){
        fullScreenButton.click();
        return this;
    }

    @Step("Click wishlist icon")
    public ProductPage clickWishlistIcon(){
        getAddProductToTheWishlistIcon().click();
        return this;
    }

    @Step("Navigate to wishlist page")
    public ProductPage navigateToWishlistPage(){
        wishlistIcon.click();
        return this;
    }

    @Step("Click availability button")
    public ProductPage clickStoreAvailabilityButton(){
        availabilityButton.waitFor();
        availabilityButton.click();
        return this;
    }

    @Step("Wait for ptofuct page to load")
    public ProductPage waitForProductPage(){
        page.waitForLoadState();
        getProductArea().waitFor();
        return this;
    }

    @Step("Search store in the product right tab by adress")
    public ProductPage searchStoreByAdress(String adressName){
        store1AdressInput.fill(adressName);
        return this;
    }

    @Step("Search store2 in the product right tab by adress")
    public ProductPage searchStore2ByAdress(String adressName){
        store2AdressInput.fill(adressName);
        return this;
    }

    @Step("Close store availability tab")
    public ProductPage closeStoreAvailabilityTab(){
        closeStoreAvailabilityButton.click();
        return this;
    }

    @Step("Click order before 12 button")
    public ProductPage clickOrderBefore12Button(){
        getOrderBefore12Button().waitFor();
        getOrderBefore12Button().click();
        return this;
    }

    @Step("Close order before 12 tab")
    public ProductPage closeOrderBefore12Tab(){
        closeOrderBefore12Button.click();
        return this;
    }

    @Step("Click pickup store1 button")
    public ProductPage clickPickupStore1Button(){
        getPickupStore1Button().waitFor();
        getPickupStore1Button().click();
        return this;
    }

    @Step("Click store1 open hours information")
    public ProductPage clickStore1OpenHours(){
        store1OpenHoursButton.waitFor();
        store1OpenHoursButton.click();
        return this;
    }

    @Step("Close pickup store1 tab")
    public ProductPage closePickupStore1Tab(){
        closePickupStore1Button.click();
        return this;
    }

    @Step("Scroll page down")
    public ProductPage scrollPageDown(){
        productSectionTitle.waitFor();
        productSectionTitle.evaluate("element => element.scrollIntoView()");
        return this;
    }
}
