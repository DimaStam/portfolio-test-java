package library.modules.users.registration;

import com.microsoft.playwright.Page;
import library.main.TestDrivers;
import library.pages.store1.common.customer.CreateAccountPage;

public class CreateAccountData extends TestDrivers{

    protected CreateAccountPage createAccountPage;

    public CreateAccountData(Page page){
        this.page = page;
        this.createAccountPage = new CreateAccountPage(page);
    }

    public CreateAccountData fillFirstName (String firstName){
        createAccountPage.firstNameInput.fill(firstName);
        return this;
    }

    public CreateAccountData fillLastName(String lastName){
        createAccountPage.lastNameInput.fill(lastName);
        return this;
    }

    public CreateAccountData fillEmailAddress(String emailAddress){
        createAccountPage.emailAddressInput.fill(emailAddress);
        return this;
    }

    public CreateAccountData fillPassword(String password){
        createAccountPage.passwordInput.fill(password);
        return this;
    }

    public CreateAccountData confirmPassword(String password){
        createAccountPage.confirmPasswordInput.fill(password);
        return this;
    }

    public CreateAccountData fillClubPhoneNumber(String clubPhoneNumber){
        if (createAccountPage.clubPhoneNumberInput.isVisible()){
            createAccountPage.clubPhoneNumberInput.fill(clubPhoneNumber);
        }
        return this;
    }

    public CreateAccountData fillClubEmailAddress(String emailAddress){
        if (createAccountPage.clubEmailAddressInput.isVisible()){
            createAccountPage.clubEmailAddressInput.fill(emailAddress);
        }
        return this;
    }

    public CreateAccountData fillClubDayOfBirth(String $clubDayOfBirth){
        if (createAccountPage.clubDayOfBirthInput.isVisible()){
            createAccountPage.clubDayOfBirthInput.fill($clubDayOfBirth);
        }
        return this;
    }

    public CreateAccountData closeDatePicker (){
        createAccountPage.closeDatePicker.click();
        return this;
    }
}
