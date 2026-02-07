package library.modules.navigation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import library.defaultdata.footer.LinksTexts;
import library.main.TestDrivers;

public class FooterMenu extends TestDrivers {

    public FooterMenu(Page page){
        this.page = page;
    }

    public Locator staticLinkLocator(String staticLink){
        return page.locator("//div[@class='footer-block-links']//a[contains(@href, '" + staticLink + "')]");
    }

    public FooterMenu navigateByStaticLink(String staticLink) {
        staticLinkLocator(staticLink).click();
        return this;
    }

    @Step("Navigate to the About page")
    public FooterMenu navigateToAboutPage() {
        navigateByStaticLink(LinksTexts.ABOUT_US_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the actual newspaper page")
    public FooterMenu navigateToActualNewspaperPage() {
        navigateByStaticLink(LinksTexts.ACTUAL_NEWSPAPER_URL.getValue());
        return this;
    }

    @Step("Navigate to the Blog page")
    public FooterMenu navigateToBlogPage() {
        navigateByStaticLink(LinksTexts.BLOG_URL.getValue());
        return this;
    }

    @Step("Navigate to Career page")
    public FooterMenu navigateToCareerPage() {
        navigateByStaticLink(LinksTexts.CAREER_URL.getValue());
        return this;
    }

    @Step("Navigate to the Contact page")
    public FooterMenu navigateToContactPage() {
        navigateByStaticLink(LinksTexts.CONTACT_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the Customer account page")
    public FooterMenu navigateToCustomerAccountPage() {
        navigateByStaticLink(LinksTexts.CUSTOMMER_ACCOUNT_URL.getValue());
        return this;
    }

    @Step("Navigate to the Delivery page")
    public FooterMenu navigateToDeliveryPage() {
        navigateByStaticLink(LinksTexts.DELIVERY_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the FAQ page")
    public FooterMenu navigateToFaqPage() {
        navigateByStaticLink(LinksTexts.FAQ_URL_PL_IT.getValue());
        return this;
    }

    @Step("Navigate to the mobile app page")
    public FooterMenu navigateToMobileAppPage() {
        navigateByStaticLink(LinksTexts.MOBILE_APP_URL.getValue());
        return this;
    }

    @Step("Navigate to the Payment methods page")
    public FooterMenu navigateToPaymentMethodPage() {
        navigateByStaticLink(LinksTexts.PAYMENT_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the the Privacy Policy page")
    public FooterMenu navigateToPrivacyPolicyPage() {
        navigateByStaticLink(LinksTexts.PRIVACY_POLICY_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the the Promotions page")
    public FooterMenu navigateToPromotionsPage() {
        navigateByStaticLink(LinksTexts.PROMOTIONS_URL.getValue());
        return this;
    }

    @Step("Navigate to the Returns and Complaints online page")
    public FooterMenu navigateToReturnsAndComplaintsOnlinePage() {
        navigateByStaticLink(LinksTexts.RETURN_ONLINE_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the Returns and Complaints stationary page")
    public FooterMenu navigateToReturnsAndComplaintsStationaryPage() {
        navigateByStaticLink(LinksTexts.RETURN_STATIONARY_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the Shop Regulations page")
    public FooterMenu navigateToShopRegulationPage() {
        navigateByStaticLink(LinksTexts.REGULATION_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the Shop list page")
    public FooterMenu navigateToShopsListPage() {
        navigateByStaticLink(LinksTexts.SHOP_LIST_URL.getValue());
        return this;
    }

    @Step("Navigate to the Customer rights page")
    public FooterMenu navigateToConsumerRightsPage() {
        navigateByStaticLink(LinksTexts.CONSUMER_RIGHTS_URL.getValue());
        return this;
    }

    @Step("Navigate to the Store2 List Page")
    public FooterMenu navigateToStore2ListPage() {
        navigateByStaticLink(LinksTexts.STORE2_LIST_URL.getValue());
        return this;
    }

    @Step("Navigate to the Store2 Guide Page")
    public FooterMenu navigateToStore2GuidePage() {
        navigateByStaticLink(LinksTexts.STORE2_GUIDE_URL.getValue());
        return this;
    }

    @Step("Navigate to the Shop Regulations page")
    public FooterMenu navigateToStore2RegulationPage() {
        navigateByStaticLink(LinksTexts.SHOP_REGULATIONS_URL.getValue());
        return this;
    }

    @Step("Navigate to the Reservation Service Regulations Page")
    public FooterMenu navigateToReservationServiceRegulationsPage() {
        navigateByStaticLink(LinksTexts.RESERVATION_SERVICE_REGULATIONS_URL.getValue());
        return this;
    }

    @Step("Navigate to the Delivery page")
    public FooterMenu navigateToItDeliveryPage() {
        navigateByStaticLink(LinksTexts.DELIVERY_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the the Privacy Policy page")
    public FooterMenu navigateToItPrivacyPolicyPage() {
        navigateByStaticLink(LinksTexts.PRIVACY_POLICY_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the the Right of withdrawal page")
    public FooterMenu navigateToItRightOfWithdrawalPage() {
        navigateByStaticLink(LinksTexts.WITHDRAWAL_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the Returns and Complaints online page")
    public FooterMenu navigateToItReturnsAndComplaintsOnlinePage() {
        navigateByStaticLink(LinksTexts.RETURN_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the Payment methods page")
    public FooterMenu navigateToItPaymentMethodPage() {
        navigateByStaticLink(LinksTexts.PAYMENT_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the Shop Regulations page")
    public FooterMenu navigateToItShopRegulationPage() {
        navigateByStaticLink(LinksTexts.REGULATION_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the Contact page")
    public FooterMenu navigateToItContactPage() {
        navigateByStaticLink(LinksTexts.CONTACT_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the List of cookies page")
    public FooterMenu navigateToListOfCookiesPage() {
        navigateByStaticLink(LinksTexts.COOKIE_URL_PL.getValue());
        return this;
    }

    @Step("Navigate to the List of cookies page")
    public FooterMenu navigateToItListOfCookiesPage() {
        navigateByStaticLink(LinksTexts.COOKIE_URL_IT.getValue());
        return this;
    }

    @Step("Navigate to the About page")
    public FooterMenu navigateToItAboutUsPage() {
        navigateByStaticLink(LinksTexts.ABOUT_US_URL_IT.getValue());
        return this;
    }
}
