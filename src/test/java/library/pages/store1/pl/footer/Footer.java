package library.pages.store1.pl.footer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.modules.navigation.FooterMenu;
import lombok.Getter;

@Getter
public class Footer extends TestDrivers {

    private Locator footerContentSection;
    private Locator facebookLink;
    private Locator instagramLink;
    private Locator youtubeLink;
    private Locator tiktokLink;

    public Footer(Page page){
        this.page = page;
        this.footerContentSection = page.locator("//footer[@class='page-footer']");
        this.facebookLink = page.locator("//div[@class='footer-block-links']//a[@class='sp-icon sp-icon-facebook']");
        this.instagramLink = page.locator("//div[@class='footer-block-links']//a[@class='sp-icon sp-icon-instagram']");
        this.youtubeLink = page.locator("//div[@class='footer-block-links']//a[@class='sp-icon sp-icon-youtube']");
        this.tiktokLink = page.locator("//div[@class='footer-block-links']//a[@class='sp-icon sp-icon-tiktok']");
    }

    public Locator getLinkAriaLabelAttribute(String ariaLabelAttribute){
        return page.locator("//div[@class='footer-block-links']//a[@aria-label='" + ariaLabelAttribute + "']");
    }

    @Step("Switch to the external window and get Title")
    public String switchToExternalWindowReturnTitle(String staticLink){
        Page popup = page.waitForPopup(() -> (new FooterMenu(page)).navigateByStaticLink(staticLink));
        popup.waitForLoadState();
        return popup.title();
    }

    @Step("Switch to the external window")
    public Page switchToExternalWindow(String staticLink){
        Page popup = page.waitForPopup(() -> (new FooterMenu(page)).navigateByStaticLink(staticLink));
        popup.waitForLoadState();
        return popup;
    }
}