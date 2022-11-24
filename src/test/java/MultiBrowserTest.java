import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.MyWebDriverManger;

public class MultiBrowserTest {
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setDriver(String browser) {
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
