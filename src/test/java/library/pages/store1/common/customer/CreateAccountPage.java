package library.pages.store1.common.customer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.modules.users.registration.CreateAccountDto;
import library.modules.users.registration.CreateAccountForm;

public class CreateAccountPage extends TestDrivers {

    public Locator firstNameInput;
    public Locator lastNameInput;
    public Locator emailAddressInput;
    public Locator passwordInput;
    public Locator confirmPasswordInput;
    public Locator clubPhoneNumberInput;
    public Locator clubEmailAddressInput;
    public Locator clubDayOfBirthInput;
    public Locator closeDatePicker;
    public Locator breadcrumbsItem;
    public Locator successRegistrationMessage;
    public Locator successRegistrationMessageIt;
    public Locator welcomeText;
    public Locator welcomeTextIt;
    public Locator buttonCreateAccount;
    public Locator requiredAgreementsCheckboxes;
    public Locator newsletterAgreementsCheckbox;
    public Locator joiningToTheClubDecisionCheckbox;
    public Locator additionalAgreementsCheckbox;
    public Locator allAdditionalAgreementsCheckboxes;

    public CreateAccountPage(Page page){
        this.page = page;
        this.firstNameInput = page.locator("#firstname");
        this.lastNameInput = page.locator("#lastname");
        this.emailAddressInput = page.locator("#email_address");
        this.passwordInput = page.locator("#password");
        this.confirmPasswordInput = page.locator("#password-confirmation");
        this.clubPhoneNumberInput = page.locator("#phone-life");
        this.clubEmailAddressInput = page.locator("#email-life");
        this.clubDayOfBirthInput = page.locator("//div[@class='field field-date-birthday-register lifestyle-filed']//input[@name='dateOfBirth']");
        this.closeDatePicker = page.locator("//p[@class='info-life second']");
        this.breadcrumbsItem = page.locator("//div[@class='breadcrumbs']//li[2]");
        this.successRegistrationMessage = page.locator("//div[@id='swal2-content' and text()='Thank you for registering.']");
        this.successRegistrationMessageIt = page.locator("//div[@id='swal2-content' and text()='Thank you for registering.']");
        this.welcomeText = page.locator("//p[contains(text(), 'Welcome')]");
        this.welcomeTextIt = page.locator("//p[contains(text(), 'Welcome')]");
        this.buttonCreateAccount = page.locator("//form[@class='form create account form-create-account']//button[@class='action submit primary']");
        this.requiredAgreementsCheckboxes = page.locator("//fieldset[@class='fieldset create account']//div[contains(@class, 'required')]/child::input[@type='checkbox']");
        this.newsletterAgreementsCheckbox = page.locator("//fieldset[@class='fieldset create account']//div[contains(@class, 'newsletter')]/child::input[@type='checkbox']");
        this.joiningToTheClubDecisionCheckbox = page.locator("#is_lifestyle");
        this.additionalAgreementsCheckbox = page.locator("//fieldset[@class='fieldset create lifestyle']//span[@class='show-more-aggrements']");
        this.allAdditionalAgreementsCheckboxes = page.locator("//input[contains(@id, 'is_agreements')]");
    }

    @Step("Wait for create account page")
    public CreateAccountPage waitForCreateAccountPage() {
        page.waitForURL("**/customer/account/create/");
        buttonCreateAccount.waitFor();
        return this;
    }

    @Step("Fill main register form")
    public CreateAccountPage fillMainRegisterForm(CreateAccountDto createAccount, boolean joiningToTheClubDecision) {
        (new CreateAccountForm(page))
                .fillMainRegisterForm(createAccount)
                .selectAllRequiredAgreements()
                .selectNewsletterAgreements()
                .joiningToTheClubDecision(joiningToTheClubDecision);
        return this;
    }

    @Step("Fill Club registration form")
    public CreateAccountPage fillClubRegisterForm(CreateAccountDto createAccount) {
        (new CreateAccountForm(page))
                .fillClubRegisterForm(createAccount)
                .selectAllAdditionalAgreements();
        return this;
    }

    @Step("Send register form")
    public CreateAccountPage sendRegisterForm() {
        (new CreateAccountForm(page)).sendRegisterForm();
        return this;
    }
}