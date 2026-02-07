package library.pages.store1.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.pages.store1.common.customer.LoginPage;
import lombok.Getter;

@Getter
public class HomePage extends TestDrivers {

    private Locator blogCarouselSection;
    private Locator countVisibleBlogCarouselItems;
    private Locator carouselNavigateLeftArrow;
    private Locator carouselNavigateRightArrow;
    private Locator blogSection;
    private Locator store2GuideSection;
    private Locator blogSectionTitle;
    private Locator navigateToBlogLink;
    private Locator store2navigateToBlogLink;
    private Locator hotlineLinkStore1IT;
    private Locator hotlineLinkStore1PL;
    private Locator hotlineLinkStore2;
    private Locator hotlineOpenHoursFromMondayToFriday;
    private Locator hotlineOpenHoursFromSaturdayToSunday;
    private Locator store2HotlineOpenHoursFromMondayToFriday;
    private Locator mainHeader;
    private Locator accountIcon;

    public HomePage(Page page){
        this.page = page;
        this.blogCarouselSection = page.locator("//div[@class='glider-contain amblog-list']");
        this.countVisibleBlogCarouselItems = page.locator("//div[@class='glider-contain amblog-list']//div[contains(@class, 'visible')]");
        this.carouselNavigateLeftArrow = page.locator("//div[@class='glider-contain amblog-list']//button[contains(@class,'glider-prev')]");
        this.carouselNavigateRightArrow = page.locator("//div[@class='glider-contain amblog-list']//button[@class='glider-next']");
        this.blogSection = page.locator("//div[@class='widget-blog']");
        this.store2GuideSection = page.locator("//div[@class='amblog-widget-container -post']");
        this.blogSectionTitle = page.locator("//div[@class='amblog-title']/child::p");
        this.navigateToBlogLink = page.locator("//div[@class='amblog-title']/child::a[contains(@href, '/blog')]/child::span");
        this.store2navigateToBlogLink = page.locator("//div[@class='amblog-title']/child::a[contains(@href, '/poradnik')]/child::span");
        this.hotlineLinkStore1IT = page.locator("//div[@class='footer-block-links']//a[contains(@href, 'tel:+10000000001')]");
        this.hotlineLinkStore1PL = page.locator("//div[@class='footer-block-links']//a[contains(@href, 'tel:+10000000002')]");
        this.hotlineLinkStore2 = page.locator("//div[@class='col-lg']//a[contains(@href, 'tel:+10000000003')]");
        this.hotlineOpenHoursFromMondayToFriday = page.locator("//p[@class='open-hours']//span[1]");
        this.hotlineOpenHoursFromSaturdayToSunday = page.locator("//p[@class='open-hours']//span[2]");
        this.store2HotlineOpenHoursFromMondayToFriday = page.locator("//p[@class='hours']");
        this.mainHeader = page.locator("//header[@class='page-header']");
        this.accountIcon = page.locator("#account_link");
    }

    @Step("Wait for Store1 homepage")
    public HomePage waitForHomePage() {
        getMainHeader().waitFor(new Locator.WaitForOptions().setTimeout(15000));
        return this;
    }

    @Step("Navigate to login page")
    public LoginPage navigateToLoginPage() {
        getAccountIcon().click();
        return new LoginPage(page);
    }

    @Step("Wait for each blog post inside the widget")
    public HomePage waitForBlogPosts() {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForTimeout(2000);
        return this;
    }
}
