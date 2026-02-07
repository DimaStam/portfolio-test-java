package library.pages.store1.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.pages.store1.pl.orders.MiniCart;
import library.main.TestDrivers;
import library.pages.store1.pl.orders.SearchResultPage;
import lombok.Getter;

@Getter
public class Header extends TestDrivers{

    private Locator myAccountIcon;
    private Locator actualNewspaperLink;
    private Locator miniCartIcon;
    private Locator miniCartCounterNumber;
    private Locator mainLogo;
    private Locator store1ClubLink;
    private Locator wishlistIcon;
    private Locator store2ListButton;
    private Locator mainSearchBarInput;
    private Locator submitSearchButton;
    private Locator loginLink;
    private Locator createAccountLink;
    private Locator store2Link;
    private Locator store2LinkActive;
    private Locator store1Link;
    private Locator store1LinkActive;
    private Locator legalStore2Button;

    public Header(Page page){
        this.page = page;
        this.myAccountIcon = page.locator("//a[@class='my-account-link']");
        this.actualNewspaperLink = page.locator("//ul[@class='sp-header-links']//a[@class='newspaper-link']");
        this.miniCartIcon = page.locator("//a[@class='action showcart show-cart-button-active']");
        this.miniCartCounterNumber = page.locator("//span[@class='counter-number']");
        this.mainLogo = page.locator("//a[@class='sp-logo logo-desktop']");
        this.store1ClubLink = page.locator("//a[@class='club-store1']");
        this.wishlistIcon = page.locator("//ul[@class='header links']/child::li[@class='link wishlist']");
        this.store2ListButton = page.locator("//li[@class='shops-list']");
        this.mainSearchBarInput = page.locator("#autocomplete-0-input");
        this.submitSearchButton = page.locator("//button[@class='aa-SubmitButton']");
        this.loginLink = page.locator("//span[@class='tooltip-content']/child::a[contains(@href, 'customer/account/login/')]");
        this.createAccountLink = page.locator("//span[@class='tooltip-content']/child::a[contains(@href, 'customer/account/create/')]");
        this.store2Link = page.locator("//li[@class='store-item store2']");
        this.store2LinkActive = page.locator("//li[@class='store-item store2 active']");
        this.store1Link = page.locator("//li[@class='store-item store1']");
        this.store1LinkActive = page.locator("//li[@class='store-item store1 active']");
        this.legalStore2Button = page.locator("//li[@class='legal-store2']//a[contains(@href, 'example.test')]");
    }

    @Step("Find product")
    public SearchResultPage findProduct(String productName){
        getMainSearchBarInput().fill(productName);
        getSubmitSearchButton().click();
        return new SearchResultPage(page);
    }

    @Step("Open account selector")
    public Header openAccountSelector(){
        getMyAccountIcon().hover();
        return this;
    }

    @Step("Navigate to actual newspaper page")
    public Header navigateToActualNewsPaperPage(){
        getActualNewspaperLink().click();
        return this;
    }

    @Step("Wait for mini cart")
    public Header waitForMiniCart(){
        getMiniCartIcon().isVisible();
        getMiniCartCounterNumber().isVisible();
        return this;
    }

    @Step("Open mini cart")
    public MiniCart openMiniCart(){
        getMiniCartIcon().click();
        return new MiniCart(page);
    }

    @Step("Click main logo")
    public Header clickMainLogo(){
        getMainLogo().click();
        return this;
    }

    @Step("Navigate to Store 1 club page")
    public Header navigateToStore1ClubPage(){
        getStore1ClubLink().click();
        return this;
    }

    @Step("Navigate to wishlist page")
    public Header navigateToWishlistPage(){
        getWishlistIcon().click();
        return this;
    }

    @Step("Navitage to store2 list page")
    public Header navigateToStore2ListPage(){
        getStore2ListButton().click();
        return this;
    }
}
