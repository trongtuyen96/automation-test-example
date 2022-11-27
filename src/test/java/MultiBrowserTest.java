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
        driver.get("https://www.automatedtestingwithtuyen.com/");
    }

    @Test
    public void navigateToPage() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automatedtestingwithtuyen.com/", "In ATWT page");
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

}
