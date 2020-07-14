import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ATWTHomePageFactory;
import utils.MyWebDriverManger;

import java.util.concurrent.TimeUnit;

public class ATWTPageFactoryTest {
    static WebDriver driver;

    // Home Page with POM - Page Factory
    ATWTHomePageFactory homePageFactory;

    @BeforeTest
    public void setDriver() {

        // Old way to initialize web driver
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        // driver = new ChromeDriver();

        driver = new MyWebDriverManger().initBrowser("CHROME");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.automatedtestingwithtuyen.com");
    }

    @Test(priority = 0)
    public void goToForumTest() throws InterruptedException {
        homePageFactory = new ATWTHomePageFactory(driver);
        homePageFactory.clickBtnForum();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/forum"), "User is in Forum page");
    }

    @Test(priority = 1)
    public void goToAuthorTest() throws InterruptedException {
        homePageFactory.clickBtnAuthor();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/about"), "User is in Author page");
    }

    @Test(priority = 2)
    public void searchTest() throws InterruptedException {
        homePageFactory.clickBtnHome();

        Thread.sleep(2000);

        homePageFactory.search("SOLID");

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/home/search/solid"), "User is in Search result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
