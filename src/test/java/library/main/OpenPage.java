package library.main;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class OpenPage extends TestDrivers{

    protected Locator cookieAcceptButton;

    public OpenPage(Page page){
        this.page = page;
        this.cookieAcceptButton = page.locator("//div[@class='cky-consent-bar']//button[@class='cky-btn cky-btn-accept']");
    }

    @Step("Open page")
    public OpenPage openPage(String url){
        page.navigate(url);
        cookieAcceptButton.click();
        return this;
    }
}
