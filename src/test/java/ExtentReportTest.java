import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.MyWebDriverManger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExtentReportTest {
    private ExtentReports extentReports;
    private ExtentTest logger;
    private WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        setUpExtentReport();
    }

    @BeforeMethod
    public void before() {
        setUpWebDriver();
    }

    @Test
    public void testOne() {
        // Remember to set logger
        logger = extentReports.createTest("Test 20 + 25 = 45").assignCategory("Category 1");

        pressKey("20");
        pressKey("+");
        pressKey("25");
        webDriver.findElement(By.xpath("//span[.='=']")).click();
        Assert.assertEquals(webDriver.findElement(By.xpath("//div[@id='sciOutPut']")).getText().trim(), "45", "Ensure the result is correct");
        logger.log(Status.PASS, "Pass test");
        webDriver.findElement(By.xpath("//span[.='AC']")).click();
    }

    @Test
    public void testTwo() {
        // Remember to set logger
        logger = extentReports.createTest("Test 11 + 10").assignCategory("Category 2");

        pressKey("11");
        pressKey("+");
        pressKey("10");
        webDriver.findElement(By.xpath("//span[.='=']")).click();
        Assert.assertEquals(webDriver.findElement(By.xpath("//div[@id='sciOutPut']")).getText().trim(), "20", "Ensure the result is correct");
        logger.log(Status.FAIL, "Force to fail");
        webDriver.findElement(By.xpath("//span[.='AC']")).click();
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case FAILED", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case FAILED", ExtentColor.RED));

            /* Add screenshot as FILE
            String screenshotPath = getScreenShot(webDriver);
            logger.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            */

            // Add screenshot as BASE64
            logger.info("Screenshot: ", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot(webDriver)).build());

        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
        }
        webDriver.quit();
    }

    @AfterTest
    public void close() {
        extentReports.flush();
    }

    private void pressKey(String key) {
        for (char i : key.toCharArray()) {
            webDriver.findElement(By.xpath("//span[.='" + i + "']")).click();
        }
    }

    private void setUpWebDriver() {

        // Old way to initialize web driver
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        // driver = new ChromeDriver();

        webDriver = new MyWebDriverManger().initBrowser("CHROME");
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://www.calculator.net/");
    }

    private void setUpExtentReport() {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport_" + dateName + ".html");
        // Create an object of Extent Reports
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        /*
        Config report by code line

        extentReports.setSystemInfo("Host Name", "SoftwareTesting");
        extentReports.setSystemInfo("Environment", "Production");
        extentReports.setSystemInfo("User Name", "Tuyen Nguyen");
        htmlReporter.config().setDocumentTitle("Test Suite 1.0");
        // Name of the report
        htmlReporter.config().setReportName("Extent Report");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);
        */

        // Config report by html config file
        htmlReporter.loadXMLConfig("src\\main\\resources\\extent-config.xml");
    }

    //This method is to capture the screenshot and return the path of the screenshot.
    private static String getScreenShot(WebDriver driver) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + dateName + ".png";
        File dest = new File(destination);
        FileUtils.copyFile(source, dest);
        return destination;
    }

    //This method is to capture the screenshot and return the base64 string of the screenshot.
    private static String getBase64ScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BASE64);
    }
}
