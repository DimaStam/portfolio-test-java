package library.pages.store1.pl.orders;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.modules.orders.add.DeliveryDto;
import library.modules.orders.add.DeliveryForm;
import library.modules.orders.deliverymethods.LockerPickupDeliveryPoints;
import library.modules.orders.deliverymethods.PersonalPickupPoints;
import lombok.Getter;

@Getter
public class CheckoutDeliveryPage extends TestDrivers {

    private Locator goToCheckoutSummaryPageButton;
    private Locator checkoutDeliveryArea;
    private Locator checkoutCartButton;
    private Locator premiumPostcodeSummaryInformation;
    private Locator checkoutLoader1;
    private Locator checkoutLoader2;
    private Locator orderSummaryLoader;
    private Locator bodyLoaderPL;
    private Locator bodyLoaderIT;
    private Locator userEmailField;
    private Locator loggedInUserAddressDataTile;
    private Locator premiumPostcodeAddressTile;
    private Locator otherPaymentMethods;
    private Locator userFullNameFromShippingTile;
    private Locator firstName;
    private Locator lastName;
    private Locator company;
    private Locator street;
    private Locator houseNumber;
    private Locator apartmentNumber;
    private Locator postCode;
    private Locator city;
    private Locator phoneNumber;

    public CheckoutDeliveryPage(Page page){
        this.page = page;
        this.goToCheckoutSummaryPageButton = page.locator("//div[@class='step-three-primary clearfix']//button");
        this.checkoutDeliveryArea = page.locator("//div[@class='checkout-shipping-address']");
        this.checkoutCartButton = page.locator("//li[@class='step-one opc-progress-bar-item _complete']");
        this.premiumPostcodeSummaryInformation = page.locator("//tr[@class='totals shipping excl nowrap']//span[contains(text(), 'Premium postcode')]");
        this.checkoutLoader1 = page.locator("//div[@class='checkout-container']//div[@id='checkout-loader']");
        this.checkoutLoader2 = page.locator("//div[@class='checkout-container']//div[@class='opc-block-summary step-content _block-content-loading']//div[@class='loading-mask']");
        this.orderSummaryLoader = page.locator("//div[@class='order-summary']//div[@class='loader']");
        this.bodyLoaderPL = page.locator("//body[@id='html-body']//img[@alt='Loading...']");
        this.bodyLoaderIT = page.locator("//body[@id='html-body']//img[@alt='Loading...']");
        this.userEmailField = page.locator("#customer-email");
        this.loggedInUserAddressDataTile = page.locator("#shipping");
        this.premiumPostcodeAddressTile = page.locator("//div[@class='wrapper-item-address']//*[contains(text(),'99999')]");
        this.otherPaymentMethods = page.locator("//div[@class='gateway-collapsible']/child::a");
        this.userFullNameFromShippingTile = page.locator("//div[@class='shipping-address-item selected-item']//li[@class='title']");
        this.firstName = page.locator("//div[@name='shippingAddress.firstname']//input");
        this.lastName = page.locator("//div[@name='shippingAddress.lastname']//input");
        this.company = page.locator("//div[@name='shippingAddress.company']//input");
        this.street = page.locator("//div[@name='shippingAddress.street.0']//input");
        this.houseNumber = page.locator("//div[@name='shippingAddress.street.1']//input");
        this.apartmentNumber = page.locator("//div[@name='shippingAddress.street.2']//input");
        this.postCode = page.locator("//div[@name='shippingAddress.postcode']//input");
        this.city = page.locator("//div[@name='shippingAddress.city']//input");
        this.phoneNumber = page.locator("//div[@name='shippingAddress.telephone']//input");
    }

    @Step("Wait for requests to load")
    public CheckoutDeliveryPage waitForTotalsRequest(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return this;
    }

    @Step("Wait for checkout delivery page")
    public CheckoutDeliveryPage waitForCheckoutDeliveryPage(){
        getCheckoutLoader1().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        getCheckoutLoader2().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        getOrderSummaryLoader().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        getBodyLoaderPL().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        return this;
    }

    @Step("Wait for checkout delivery loaders to disappear")
    public CheckoutDeliveryPage waitForCheckoutDeliveryInternationalLoaders(){
        getCheckoutLoader1().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        getCheckoutLoader2().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        getOrderSummaryLoader().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        getBodyLoaderIT().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(45000));
        return this;
    }

    @Step("Wait for user email field")
    public CheckoutDeliveryPage waitForUserEmailField(){
        getUserEmailField().waitFor(new Locator.WaitForOptions().setTimeout(15000));
        return this;
    }

    @Step("Wait for logged in user address data tile")
    public CheckoutDeliveryPage waitForLoggedInUserAddressDataTile(){
        getLoggedInUserAddressDataTile().waitFor(new Locator.WaitForOptions().setTimeout(15000));
        return this;
    }

    @Step("Select premium postcode address")
    public CheckoutDeliveryPage selectPremiumPostcodeAddress(){
        getPremiumPostcodeAddressTile().click();
        return this;
    }

    @Step("Fill checkout delivery form")
    public CheckoutDeliveryPage fillCheckoutDeliveryForm(DeliveryDto delivery){
        new DeliveryForm(page).fillCheckoutDeliveryForm(delivery);
        return this;
    }

    @Step("Fill checkout delivery form (premium postcode)")
    public CheckoutDeliveryPage fillPremiumCheckoutDeliveryForm(DeliveryDto delivery){
        new DeliveryForm(page).fillPremiumCheckoutDeliveryForm(delivery);
        return this;
    }

    @Step("Select delivery method")
    public CheckoutDeliveryPage selectDeliveryMethod(String deliveryMethod){
        page.locator(deliveryMethod).click();
        return this;
    }

    @Step("Select payment method")
    public CheckoutDeliveryPage selectPaymentMethod (String paymentMethod){
        page.locator(paymentMethod).click();
        return this;
    }

    @Step("Expand other payment methods")
    public CheckoutDeliveryPage expandOtherPaymentMethods(){
        getOtherPaymentMethods().click();
        return this;
    }

    @Step("Go to checkout summary page")
    public CheckoutSummaryPage clickGoToCheckoutSummaryPageButton(){
        getGoToCheckoutSummaryPageButton().waitFor();
        getGoToCheckoutSummaryPageButton().click();
        return new CheckoutSummaryPage(page);
    }

    @Step("Select locker pickup delivery point")
    public CheckoutDeliveryPage selectLockerPickupDeliveryPoint(){
        (new LockerPickupDeliveryPoints(page))
                .openMap()
                .enterDeliveryPointsAddressName("Sample Street 10, Sample City")
                .selectDeliveryPoint();
        return this;
    }

    @Step("Select store pickup delivery point")
    public CheckoutDeliveryPage selectPersonalPickupDeliveryPoint(){
        (new PersonalPickupPoints(page))
                .openStoreLocatorMap()
                .enterPersonalPickupAddressName("Sample Street 5, Sample City")
                .selectDeliveryPoint();
        return this;
    }

    @Step("Get user full name from shipping tile")
    public String getUserFullNameFromShippingTile(){
        return userFullNameFromShippingTile.textContent();
    }

    @Step("Click checkout cart button")
    public CheckoutCartPage clickCheckoutCartButton(){
        getCheckoutCartButton().click();
        return new CheckoutCartPage(page);
    }
}
