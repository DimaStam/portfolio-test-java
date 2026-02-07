package library.pages.store1.pl.orders;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MiniCart extends TestDrivers {

    private Locator miniCartContent;
    private Locator navigateToCheckoutCartButton;
    private Locator miniCartProductName;
    private Locator miniCartProductPrice;
    private Locator emptyCartTitle;
    private Locator readyToGoToCheckoutCartDataTag;

    public MiniCart(Page page){
        this.page = page;
        this.miniCartContent = page.locator("//div[@id='minicart-content-wrapper']");
        this.navigateToCheckoutCartButton = page.locator("//a[@class='action primary checkout']");
        this.miniCartProductName = page.locator("//span[@class='product-item-name']//a");
        this.miniCartProductPrice = page.locator("//span[@class='price-wrapper' and contains(@data-bind, 'subtotal_with_discount')]");
        this.emptyCartTitle = page.locator("//div[@class='empty-info']");
        this.readyToGoToCheckoutCartDataTag = page.locator("//a[@data-test-ready-to-go-to-checkout='true']");
    }

    @Step("Get product mini cart name and price")
    public Map<String, String> getProductData(){
        Map<String, String> miniCartProductData = new HashMap<>();
        miniCartProductData.put("productName", getMiniCartProductName().textContent());
        miniCartProductData.put("productPrice", getMiniCartProductPrice().textContent());
        return miniCartProductData;
    }

    @Step("Go to checkout cart")
    public CheckoutCartPage navigateToCheckoutCart(){
        getReadyToGoToCheckoutCartDataTag().waitFor();
        getNavigateToCheckoutCartButton().click();
        return new CheckoutCartPage(page);
    }
}
