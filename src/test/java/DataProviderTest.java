import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderTest {
    private static WebDriver webDriver;

    @DataProvider(name = "CalculationAdd")
    public static Object[][] Add() {
        return new Object[][]{{"15", "100", "115"}, {"1564", "6", "1570"}};
    }

    @BeforeTest
    public void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://www.calculator.net/");
    }

    @Test(dataProvider = "CalculationAdd")
    public void test(String first, String second, String result) {
        pressNumber(first);
        webDriver.findElement(By.xpath("//span[.='+']")).click();
        pressNumber(second);
        webDriver.findElement(By.xpath("//span[.='=']")).click();
        Assert.assertTrue(result.equals(webDriver.findElement(By.xpath("//div[@id='sciOutPut']")).getText().trim()), "Result is correct");
    }

    @AfterMethod
    public void clearAfter() {
        webDriver.findElement(By.xpath("//span[.='AC']")).click();
    }

    @AfterTest
    public void close() {
        webDriver.close();
    }

    public void pressNumber(String number) {
        for (char i : number.toCharArray()) {
            webDriver.findElement(By.xpath("//span[.='" + i + "']")).click();
        }
    }
}
