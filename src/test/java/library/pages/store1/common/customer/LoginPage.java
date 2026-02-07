package library.pages.store1.common.customer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.pages.store1.wishlist.WishListPage;
import lombok.Getter;

@Getter
public class LoginPage extends TestDrivers {

    private Locator loginForm;
    private Locator createAccountButton;
    private Locator inputUsername;
    private Locator inputPassword;
    private Locator loginButton;
    private Locator negativeLoginPopup;
    private Locator requiredLoginField;
    private Locator requiredPasswordField;
    private Locator wishlistButton;
    private String loginTitleIt;
    private String fakePassword;
    protected String url;

    public LoginPage (Page page){
        this.page = page;
        this.loginForm = page.locator("//div[@class='col-lg-7 col-md-7']");
        this.createAccountButton = page.locator("//a[contains(@href, '/account/create/')]/parent::div[@class='primary']");
        this.inputUsername = page.locator("//input[@name='login[username]']");
        this.inputPassword = page.locator("//input[@name='login[password]']");
        this.loginButton = page.locator("//form[@id='login-form']//button[@name='send']");
        this.negativeLoginPopup = page.locator("//div[@class='swal2-popup swal2-modal swal2-show']");
        this.requiredLoginField = page.locator("#email-error");
        this.requiredPasswordField = page.locator("#pass-error");
        this.wishlistButton = page.locator("//li[@class='link wishlist']");
        this.loginTitleIt ="Login";
        this.fakePassword = "Fakepassword123!";
        this.url = "**/customer/account/login/";
    }

    @Step("Login to system")
    public void logInToSystem(String username, String password){
        fillLoginForm(username, password);
        clickLoginButton();
    }

    @Step("Fill login form")
    public LoginPage fillLoginForm(String username, String password){
        getInputUsername().fill(username);
        getInputPassword().fill(password);
        return this;
    }

    @Step("Click Login button")
    public LoginPage clickLoginButton(){
        getLoginButton().click();
        return this;
    }

    @Step("Wait for login page")
    public LoginPage waitForLoginPage(){
        page.waitForURL(url);
        getLoginForm().waitFor();
        return this;
    }

    @Step("Navigate to create account form")
    public CreateAccountPage navigateToCreateAccountForm(){
        getCreateAccountButton().click();
        return new CreateAccountPage(page);
    }

    @Step("Navigate to the wishlist page")
    public WishListPage navigateToWishlistPage(){
        getWishlistButton().click();
        return new WishListPage(page);
    }
}