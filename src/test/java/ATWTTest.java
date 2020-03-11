import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ATWTHomePage;

import java.util.concurrent.TimeUnit;

public class ATWTTest {
    static WebDriver driver;

    // Home Page with POM
    ATWTHomePage homePage;

    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\automationFramework\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
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

        homePage.search("SOLID");

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automatedtestingwithtuyen.com/home/search/solid"), "User is in Search result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
