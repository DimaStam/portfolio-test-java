package tests.pl.store1.elements.homepage.desktop.footer.hotline;

import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayHotlineOpenHoursTest extends TestCase {

    protected String hotlineOpenHoursFromMondayToFridayXpath = "//p[@class='open-hours']//span[1]";
    protected String hotlineOpenHoursFromSaturdayToSundayXpath = "//p[@class='open-hours']//span[2]";

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());

        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Store1 display hotline open hours")
    public void testDisplayHotlineOpenHours(){

        assertThat(page.locator(hotlineOpenHoursFromMondayToFridayXpath)).hasText("Mon-Fri: 09:00-18:00");

        assertThat(page.locator(hotlineOpenHoursFromSaturdayToSundayXpath)).hasText("Sat-Sun: 10:00-14:00");
    }
}
