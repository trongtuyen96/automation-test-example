import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.MyWebDriverManger;

public class RetryAnalyzerTest {
    private String baseURL = "http://google.com";
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new MyWebDriverManger().initBrowser("CHROME");
    }

    // This allows this test run a number of times after failed
    // Number of retry is defined in RetryAnalyzer class
    // @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test()
    public void validateResult() throws InterruptedException {
        driver.get(baseURL);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Test");

        Thread.sleep(2000);

        // Force it to fail
        driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
