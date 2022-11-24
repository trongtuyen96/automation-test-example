import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;
import utils.MyWebDriverManger;

import java.util.concurrent.TimeUnit;

public class ExcelPOITest {
    private static WebDriver webDriver;

    @DataProvider(name = "CalculationAdd")
    public static Object[][] Add() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src\\main\\resources\\Data.xlsx", "Sheet1", 3);
        return (testObjArray);
    }

    @BeforeTest
    public void setWebDriver() {
        webDriver = new MyWebDriverManger().initBrowser("CHROME");
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
