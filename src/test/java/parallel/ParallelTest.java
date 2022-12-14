package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.MyWebDriverManger;

public class ParallelTest {
    private WebDriver driver;

    @BeforeClass
    public void initialize() {
        if (ExtentManager.getInstance() == null)
            ExtentManager.createInstance();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setDriver(String browser) {
        driver = new MyWebDriverManger().initBrowser(browser);
        driver.get("https://www.automatedtestingwithtuyen.com/");
    }

    @Test
    public void navigateToPatterns() throws InterruptedException {
        driver.get("https://www.automatedtestingwithtuyen.com/home/categories/patterns");
        Thread.sleep(1000);
        ExtentTestManager.createTest("Navigate to Patterns Test");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automatedtestingwithtuyen.com/home/categories/patterns", "In ATWT Patterns page");
    }

    @Test
    public void navigateToTools() throws InterruptedException {
        driver.get("https://www.automatedtestingwithtuyen.com/home/categories/tools");
        Thread.sleep(1000);
        ExtentTestManager.createTest("Navigate to Tools Test");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automatedtestingwithtuyen.com/home/categories/tools", "In ATWT Tools page");
    }

    @Test
    public void navigateToFrameworks() throws InterruptedException {
        driver.get("https://www.automatedtestingwithtuyen.com/home/categories/frameworks");
        Thread.sleep(1000);
        ExtentTestManager.createTest("Navigate to Frameworks Test");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automatedtestingwithtuyen.com/home/categories/frameworks", "In ATWT Frameworks page");
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            ExtentTestManager.getTest().fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            ExtentTestManager.getTest().skip(result.getThrowable());
        else
            ExtentTestManager.getTest().pass("TEST PASSED");

        ExtentManager.getInstance().flush();
        driver.close();
    }
}
