import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.MyWebDriverManger;

import java.util.concurrent.TimeUnit;

public class RealTimeResultTest {
    private static WebDriver webDriver;

    @BeforeTest
    public void setWebDriver() {
        webDriver = new MyWebDriverManger().initBrowser("CHROME");
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://github.com/trongtuyen96");
    }

    @Test
    public void testOverviewTab() {
        String nickname = webDriver.findElement(By.cssSelector(".p-nickname")).getText();
        Assert.assertEquals(nickname,"trongtuyen96", "Validate nickname is trongtuyen96");
    }

    @Test
    public void testRepoTab() throws InterruptedException {
        webDriver.get("https://github.com/trongtuyen96?tab=repositories");

        // First Repo
        WebElement firstRepo = webDriver.findElement(By.xpath("(//ul//a[@itemprop='name codeRepository'])[1]"));
        String firstRepoHref = firstRepo.getAttribute("href");
        firstRepo.click();

        Thread.sleep(1000);

        Assert.assertTrue(webDriver.getCurrentUrl().equals(firstRepoHref), "Validate current repo is first repository");
    }

    @AfterTest
    public void close() {
        webDriver.close();
    }
}
