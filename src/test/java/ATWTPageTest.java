import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ATWTHomePage;
import utils.MyWebDriverManger;

import java.util.concurrent.TimeUnit;

public class ATWTPageTest {
    static WebDriver driver;

    // Home Page with POM
    ATWTHomePage homePage;

    @BeforeTest
    public void setDriver() {
        driver = new MyWebDriverManger().initBrowser("CHROME");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.automatedtestingwithtuyen.com");
    }

    @Test(priority = 0)
    public void goToForumTest() throws InterruptedException {
        homePage = new ATWTHomePage(driver);
        homePage.clickBtnForum();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/forum"), "User is in Forum page");
    }

    @Test(priority = 1)
    public void goToAuthorTest() throws InterruptedException {
        homePage.clickBtnAuthor();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/about"), "User is in Author page");
    }

    @Test(priority = 2)
    public void searchTest() throws InterruptedException {
        homePage.clickBtnHome();

        Thread.sleep(2000);

        homePage.search("S.O.L.I.D");

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/home/search/s.o.l.i.d"), "User is in Search result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
