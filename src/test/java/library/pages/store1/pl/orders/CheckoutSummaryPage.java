package library.pages.store1.pl.orders;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import library.defaultdata.checkoutsummarypage.WalletCPlaceholders;
import library.main.TestDrivers;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CheckoutSummaryPage extends TestDrivers {

    private Locator checkoutSummaryAddressAndPaymentData;
    private Locator expandBlockItemsButton;
    private Locator privacyPolicyAgreementCheckbox;
    private Locator placeOrderButton;
    private Locator placeWalletBOrderButton;
    private Locator codePaymentCodeField;
    private Locator bankTransferBankSelector;
    private Locator creditCardSpinner;
    private Locator creditCardArea;
    private Locator productName;
    private Locator productPrice;
    private Locator creditCardNumberInputPlaceholder;
    private Locator creditCardExpiryCodeInputPlaceholder;
    private Locator creditCardCvvCodePlaceholder;
    private Locator bankTransferPlaceOrderButton;
    private final Locator codePaymentConfirmWindow;
    private FrameLocator creditCardNumberInput;
    private FrameLocator creditCardExpiryCodeInput;
    private FrameLocator creditCardCvvCodeInput;
    private FrameLocator walletEmailInput;

    public CheckoutSummaryPage(Page page){
        this.page = page;
        this.checkoutSummaryAddressAndPaymentData = page.locator("//div[@class='checkout-step-shipping-methods']");
        this.expandBlockItemsButton = page.locator("//div[@class='block items-in-cart']");
        this.privacyPolicyAgreementCheckbox = page.locator("//div[@class='opc-col-right']//input[contains(@id,'agreement')]");
        this.placeOrderButton = page.locator("//button[@class='action primary checkout original-payment-buttons-handler']");
        this.placeWalletBOrderButton = page.locator("//div[@class='wallet-b-placeholder-container']");
        this.codePaymentCodeField = page.locator("//input[@name='codePayment']");
        this.bankTransferBankSelector = page.locator("//div[@class='payment payment-method _active']//div[@class='payment-checkout__dropdown__button']");
        this.creditCardSpinner = page.locator("//div[@data-testid='spinner']");
        this.creditCardArea = page.locator("//fieldset[@id='payment_form_payment_cc']");
        this.productName = page.locator("//a[contains(@data-bind, '$parent.name')]");
        this.productPrice = page.locator("//span[@class='price' and contains(@data-bind, 'getRowDisplayPriceExclTax')]");
        this.creditCardNumberInputPlaceholder = page.getByPlaceholder("1234 5678 9012 3456");
        this.creditCardExpiryCodeInputPlaceholder = page.getByPlaceholder("MM/YY");
        this.creditCardCvvCodePlaceholder = page.getByPlaceholder("3 digits");
        this.bankTransferPlaceOrderButton = page.locator("#bank_transfer_confirm");
        this.codePaymentConfirmWindow = page.locator("//div[@class='payment-checkout__await payment-checkout__await--code']");
        this.creditCardNumberInput = page.frameLocator("//span[@data-cse='encryptedCardNumber']//iframe");
        this.creditCardExpiryCodeInput = page.frameLocator("//span[@data-cse='encryptedExpiryDate']//iframe");
        this.creditCardCvvCodeInput = page.frameLocator("//span[@data-cse='encryptedSecurityCode']//iframe");
        this.walletEmailInput = page.frameLocator("#login_emaildiv");
    }

    @Step("Expand block items cart")
    public CheckoutSummaryPage expandBlockItemsInCart(){
        getExpandBlockItemsButton().click();
        return this;
    }

    @Step("Click on privacy agreement checkbox")
    public CheckoutSummaryPage clickPrivacyPolicyAgreementCheckbox(){
        getPrivacyPolicyAgreementCheckbox().click();
        return this;
    }

    @Step("Place order")
    public CheckoutSummaryPage clickPlaceOrderButton(){
        getPlaceOrderButton().click();
        return this;
    }

    @Step("Place Wallet B order")
    public CheckoutSummaryPage clickPlaceWalletBOrderButton(){
        getPlaceWalletBOrderButton().click();
        return this;
    }

    @Step("Get product summary page name and price")
    public Map<String, String> getProductData(){
        Map<String, String> summaryPageProductData = new HashMap<>();
        summaryPageProductData.put("productName", getProductName().textContent().replace(" 75ml", ""));
        summaryPageProductData.put("productPrice", getProductPrice().textContent());
        return summaryPageProductData;
    }

    @Step("Get product summary page name and price (IT)")
    public Map<String, String> getProductDataIT(){
        return getProductData();
    }

    @Step("Fill code payment field")
    public CheckoutSummaryPage fillCodePaymentCodeField(String code){
        getCodePaymentCodeField().fill(code);
        return this;
    }

    public CheckoutSummaryPage waitForCreditCard(){
        getCreditCardSpinner().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        getCreditCardArea().waitFor();
        return this;
    }

    @Step("Fill credit card fields")
    public CheckoutSummaryPage fillCreditCardFields(String cardNumber, String expiryDate, String cvvCode){
        getCreditCardNumberInput().locator(getCreditCardNumberInputPlaceholder()).waitFor();
        fillCreditCardNumber(cardNumber);
        fillCreditCardExpiryDate(expiryDate);
        fillCreditCardCvvCode(cvvCode);
        return this;
    }

    @Step("Select bank transfer option")
    public CheckoutSummaryPage selectBankTransferBank(String bankTransferBank){
        getBankTransferBankSelector().click();
        page.locator(bankTransferBank).click();
        return this;
    }

    private CheckoutSummaryPage fillCreditCardNumber(String cardNumber){
        getCreditCardNumberInput().locator(getCreditCardNumberInputPlaceholder()).fill(cardNumber);
        return this;
    }

    private CheckoutSummaryPage fillCreditCardExpiryDate(String expiryDate){
        getCreditCardExpiryCodeInput().locator(getCreditCardExpiryCodeInputPlaceholder()).fill(expiryDate);
        return this;
    }

    private CheckoutSummaryPage fillCreditCardCvvCode(String cvvCode){
        getCreditCardCvvCodeInput().locator(getCreditCardCvvCodePlaceholder()).fill(cvvCode);
        return this;
    }

    @Step("Switch to the Wallet C window")
    public Page switchToWalletCWindowAndPlaceOrder(String walletEmail, String walletPassword){
        Page popup = page.waitForPopup(() -> {
            getPlaceOrderButton().evaluate("element => element.scrollIntoView()");
            getPlaceOrderButton().click();
        });
        popup.getByPlaceholder(WalletCPlaceholders.EMAIL_INPUT.getValue()).fill(walletEmail);
        popup.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(WalletCPlaceholders.CONTINUE_BUTTON_NAME.getValue())).click();
        popup.getByPlaceholder(WalletCPlaceholders.PASSWORD_INPUT.getValue()).fill(walletPassword);
        popup.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(WalletCPlaceholders.LOGIN_BUTTON_NAME.getValue())).click();
        popup.getByTestId(WalletCPlaceholders.PLACE_ORDER_BUTTON_ID.getValue()).click();
        return popup;
    }

    @Step("Confirm bank transfer order")
    public CheckoutSummaryPage confirmBankTransferOrder(){
        getBankTransferPlaceOrderButton().click();
        return this;
    }
}
