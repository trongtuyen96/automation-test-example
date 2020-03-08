import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {
    public String baseURL = "http://google.com";
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\automationFramework\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test(priority = 0)
    public void Search() throws InterruptedException {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
    }

    @Test (priority = 1)
    public void validateResult() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().length() > 0, "In result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
