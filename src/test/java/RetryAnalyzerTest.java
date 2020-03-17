import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.RetryAnalyzer;

public class RetryAnalyzerTest {
    private String baseURL = "http://google.com";
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    // This allows this test run a number of times after failed
    // Number of retry is defined in RetryAnalyzer class
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validateResult() throws InterruptedException {
        driver.get(baseURL);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().length() < 0, "In result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
