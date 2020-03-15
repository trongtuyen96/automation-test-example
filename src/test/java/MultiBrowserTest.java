import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserTest {
    static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setDriver(String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get("http://google.com");
    }

    @Test
    public void Search() throws InterruptedException {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().length() > 0, "In result page");
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
