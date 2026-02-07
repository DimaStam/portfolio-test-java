package library.main;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Attachment;
import library.main.environments.EnvironmentConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.nio.file.Paths;

public class TestCase extends TestDrivers{

    protected static EnvironmentConfig config;

    @BeforeClass(description = "Launch application")
    @Parameters({"headless"})
    public void launchApplication(@Optional("true") String headlessParam){
        String headlessValue = System.getProperty("headless", headlessParam);
        boolean headless = Boolean.parseBoolean(headlessValue);
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext();
        page = browser.newPage();
        page.setViewportSize(1700, 900);
        page.setDefaultNavigationTimeout(30000);

        config = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());
    }

    @AfterMethod(description = "Get failure screenshots")
    public void getFailureScreenshots(ITestResult result) {
        if (result.getStatus() != 1){
            takeScreenshotToAttachOnAllureReport();
        }
    }

    @AfterClass(description = "Tear down")
    public void tearDown(){
        playwright.close();
    }

    @Attachment(value = "Test screenshot", type = "image/png")
    public byte[] takeScreenshotToAttachOnAllureReport() {
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        return page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
    }
}
