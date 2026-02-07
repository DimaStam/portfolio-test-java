package tests.pl.store1.elements.homepage.desktop.menu.items;

import library.defaultdata.menu.MenuLinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.CategoryMenu;
import library.pages.store1.common.HomePage;
import library.testdata.header.PageTitles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayDermocosmeticsCategoryTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display dermocosmetics category link in main menu")
    public void displayDermocosmeticsCategory(){

        CategoryMenu categoryMenu = (new CategoryMenu(page));

        assertThat(categoryMenu.menu(MenuLinksTexts.DERMOCOSMETICS_URL_PL.getValue())).isVisible();

        categoryMenu.
                expandSubMenu(MenuLinksTexts.DERMOCOSMETICS_URL_PL.getValue());

        Assert.assertTrue(page.url().contains(MenuLinksTexts.DERMOCOSMETICS_URL_PL.getValue()));
    }
}
