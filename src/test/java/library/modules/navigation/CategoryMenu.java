package library.modules.navigation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import library.pages.store1.listing.ListingPage;
import lombok.Getter;

@Getter
public class CategoryMenu extends TestDrivers{

    private Locator subMenuPromotionsButton;
    private Locator graphicBanner;
    private Locator viewAllButton;
    private Locator bannerImage;
    private Locator menuPromotions;
    private Locator menuRightArrow;
    private Locator productsGrid;
    private Locator searchBox;

    public CategoryMenu(Page page){
        this.page = page;
        this.viewAllButton = page.locator("//div[contains(@class, 'menu-main')]//span[contains(@data-bind, 'Show all')]");
        this.bannerImage = page.locator("//div[contains(@class, 'menu-main')]//div[@class='menu-banner']//img[@alt='banner image']");
        this.menuPromotions = page.locator("a").filter(new Locator.FilterOptions().setHasText("Promocje"));
        this.subMenuPromotionsButton = page.locator("#main_menu").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Promocje"));
        this.graphicBanner = page.locator("//div[contains(@class, 'menu-main')]//div[@class='menu-banner']//img[@alt='banner image']");
        this.menuRightArrow = page.locator("//div[@class='owl-navigation next']");
        this.productsGrid = page.locator("#algolia-right-container");
        this.searchBox = page.locator("#algoliaAutocomplete");
    }

    public Locator menu(String categoryName){
        return page.locator("//div[@class='menu-main']//li[contains(@class, 'menu-item')]/child::a[contains(@href, '" + categoryName + "')]");
    }

    @Step("Expand submenu")
    public CategoryMenu expandSubMenu(String categoryName){
        getSearchBox().waitFor();
        menu(categoryName).click();
        return this;
    }

    @Step("Navigate to the category page by graphic baner")
    public CategoryMenu navigateToCategoryPageByGraphic(){
        getBannerImage().click();
        return this;
    }

    @Step("Navigate to the category page by link")
    public ListingPage navigateToCategoryPage(){
        getViewAllButton().click();
        return new ListingPage(page);
    }

    @Step("Navigate to the promotions page")
    public CategoryMenu navigateToPromotionsPage(){
        getMenuPromotions().first().click();
        getSubMenuPromotionsButton().click();
        return this;
    }

    @Step("Click menu right arrow")
    public CategoryMenu clickMenuRightArrow(){
        getMenuRightArrow().waitFor();
        getMenuRightArrow().click();
        return this;
    }
}