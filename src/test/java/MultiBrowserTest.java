import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.MyWebDriverManger;

public class MultiBrowserTest {
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setDriver(String browser) {

        // Old way to initialize web driver
        /* if (browser.toLowerCase().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        } */

        driver = new MyWebDriverManger().initBrowser(browser.toUpperCase());
        driver.get("https://www.google.com");
    }

    @Test
    public void Search() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/", "In Google page");
        Thread.sleep(1000);
        driver.get("https://www.automatedtestingwithtuyen.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automatedtestingwithtuyen.com/", "In ATWT page");
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

}
