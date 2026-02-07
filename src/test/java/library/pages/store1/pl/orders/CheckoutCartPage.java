package library.pages.store1.pl.orders;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import lombok.Getter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CheckoutCartPage extends TestDrivers{

    private Locator checkoutCartArea;
    private Locator goToCheckoutDeliveryButton;
    private Locator startShoppingButton;
    private Locator deleteProductButtons;
    private Locator acceptDeleteButton;
    private Locator mainLogoButton;
    private Locator productQuantityInput;
    private Locator readyToGoToCheckoutDeliveryDataTag;
    private Locator checkoutCartLoadingMask;
    private Locator checkoutCartLoader;
    private Locator productName;
    private Locator productPrice;

    public CheckoutCartPage(Page page){
        this.page = page;
        this.checkoutCartArea = page.locator("//div[@class='cart-summary']//tr[@class='discount-code-wrapper']");
        this.goToCheckoutDeliveryButton = page.locator("//div[@class='cart-summary']//button[@data-role='proceed-to-checkout']");
        this.startShoppingButton = page.locator("//a[@class='action primary']");
        this.deleteProductButtons = page.locator("//span[@class='action action-delete ico ico-trash cart-product-remove']");
        this.acceptDeleteButton = page.locator("//button[@class='action-primary action-accept']");
        this.mainLogoButton = page.locator("//a[@class='sp-logo logo-desktop']");
        this.productQuantityInput = page.locator("//input[@class='input-text qty primary-text']");
        this.readyToGoToCheckoutDeliveryDataTag = page.locator("//div[@class='cart-summary']//button[@data-test-ready-to-go-to-checkout='true']");
        this.checkoutCartLoadingMask = page.locator("//div[@class='cart-summary']//div[@id='cart-totals']//div[@class='loading-mask']");
        this.checkoutCartLoader = page.locator("//div[@class='cart-summary']//div[@id='cart-totals']//div[@class='loader']");
        this.productName = page.locator("//h2[@class='product-item-name']//a");
        this.productPrice = page.locator("//span[@class='cart-price']//span");
    }

    @Step("Wait for checkout cart page")
    public CheckoutCartPage waitForCheckoutCart(){
        page.waitForLoadState(LoadState.LOAD);
        getReadyToGoToCheckoutDeliveryDataTag().waitFor();
        waitForLoadersToDisappear();
        return this;
    }

    private void waitForLoadersToDisappear(){
        getCheckoutCartLoadingMask().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        getCheckoutCartLoader().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    @Step("Go to checkout delivery")
    public CheckoutDeliveryPage navigateToCheckoutDeliveryPage(){
        getGoToCheckoutDeliveryButton().waitFor();
        getGoToCheckoutDeliveryButton().click();
        return new CheckoutDeliveryPage(page);
    }

    @Step("Get product checkout cart name and price")
    public Map<String, String> getProductData(){
        Map<String, String> checkoutCartProductData = new HashMap<>();
        checkoutCartProductData.put(
                "productName", getProductName().textContent());
        checkoutCartProductData.put(
                "productPrice", getProductPrice().textContent());
        return checkoutCartProductData;
    }

    @Step("Check cart value before login")
    public CheckoutCartPage checkCartValueAfterLogin() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        if (getStartShoppingButton().isVisible()) {
            getStartShoppingButton().click();
        } else {
            List<Locator> elements = getDeleteProductButtons().all();

            for (int i = elements.size() - 1; i >= 0; i--) {
                page.waitForTimeout(2000);
                elements.get(i).click();
                getAcceptDeleteButton().waitFor();
                getAcceptDeleteButton().click();
                waitForLoadersToDisappear();
            }
        }
        getMainLogoButton().click();
        return this;
    }

    @Step("Check cart value before order")
    public CheckoutCartPage checkCartValueBeforeOrder(){
        String productQuantityValue = getProductQuantityInput().getAttribute("value");
        if (!productQuantityValue.equals("1")){
            getProductQuantityInput().clear();
            getProductQuantityInput().fill("1");
            getProductQuantityInput().press("Enter");
            getGoToCheckoutDeliveryButton().click();
        } else
            getGoToCheckoutDeliveryButton().click();
        return this;
    }
}