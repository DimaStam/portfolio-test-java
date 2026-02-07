package library.modules.users.registration;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import library.main.TestDrivers;
import library.pages.store1.common.customer.CreateAccountPage;

public class CreateAccountForm extends TestDrivers{

    protected CreateAccountPage createAccountPage;

    public CreateAccountForm(Page page){
        this.page = page;
        this.createAccountPage = new CreateAccountPage(page);
    }

    public CreateAccountForm fillMainRegisterForm(CreateAccountDto createAccount){
        (new CreateAccountData(page))
                .fillFirstName(createAccount.getFirstName())
                .fillLastName(createAccount.getLastName())
                .fillEmailAddress(createAccount.getEmailAddress())
                .fillPassword(createAccount.getPassword())
                .confirmPassword(createAccount.getPassword());
        return this;
    }

    public CreateAccountForm selectAllRequiredAgreements(){
        for (Locator checkbox: createAccountPage.requiredAgreementsCheckboxes.all()){
            checkbox.click();
        }
        return this;
    }

    public CreateAccountForm selectNewsletterAgreements(){
        if (createAccountPage.newsletterAgreementsCheckbox.isVisible()){
            createAccountPage.newsletterAgreementsCheckbox.click();
        }
        return this;
    }

    public CreateAccountForm joiningToTheClubDecision(boolean joiningToTheClubDecision){
        if ((createAccountPage.joiningToTheClubDecisionCheckbox.isVisible() && joiningToTheClubDecision)){
            createAccountPage.joiningToTheClubDecisionCheckbox.click();
        }
        return this;
    }

    public CreateAccountForm fillClubRegisterForm(CreateAccountDto createAccount){
        (new CreateAccountData(page))
                .fillClubPhoneNumber(createAccount.getClubPhoneNumber())
                .fillEmailAddress(createAccount.getEmailAddress())
                .fillClubDayOfBirth(createAccount.getClubDayOfBirth())
                .closeDatePicker();
        return this;
    }

    public CreateAccountForm expandAdditionalAgreements(){
        createAccountPage.additionalAgreementsCheckbox.click();
        return this;
    }

    public CreateAccountForm selectAllAdditionalAgreements(){
        for (Locator checkbox: createAccountPage.allAdditionalAgreementsCheckboxes
                .all()){ checkbox.click(); }
        return this;
    }

    public CreateAccountForm sendRegisterForm(){
        createAccountPage.buttonCreateAccount.click();
        return this;
    }
}
