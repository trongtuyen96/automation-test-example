import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.MyWebDriverManger;

public class SampleTest {
    public String baseURL = "http://google.com";
    public WebDriver driver;

    @BeforeTest
    public void setUp() {

        //// Old way to initialize web driver
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        // driver = new ChromeDriver();

        driver = new MyWebDriverManger().initBrowser("CHROME");
        driver.get(baseURL);
    }

    @Test(priority = 0)
    public void Search() throws InterruptedException {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Test", Keys.ENTER);
    }

    @Test(priority = 1)
    public void validateResult() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().length() > 0, "In result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
