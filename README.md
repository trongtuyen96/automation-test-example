<h1 align="center">
  <br>
  <a href="background"><img src="https://github.com/trongtuyen96/automationTestExample/blob/master/Background_with_title.PNG" alt="background"></a>
  <br>
  Automation Test Example
  <br>
</h1>

<h3 align="center" style="bold">Simple automation test framework examples based on Selenium, TestNG framework</h3>

## Table of Contents

- [Key Example](#key-examples)
- [How To Use](#how-to-use)
- [License](#license)

## Key Examples

- Sample Test: An example where setting up an chrome driver, run simple test and validate result.
```
public class SampleTest {
    public String baseURL = "http://google.com";
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test(priority = 0)
    public void Search() throws InterruptedException {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
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
```

- DataProvider Test: Apply dataProvider annotation from TestNG to parameterized input data.
```
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
```

- ExcelPOI Test: Data-Driven with data read from Excel file, excel utilities provided.
- MultiBrowser Test: Execute test on multiple browsers, parallel run allowed.
- ATWTT Test: An test with test page (automatedtestingwithtuyen.com) were built following Page Object Model.
- ATWTT Page Factory Test: An test with test page (automatedtestingwithtuyen.com) were built following Page Factory.
- ExtentReport Test: Apply ExtentReport to generate beautiful, fully-detailed, well-organized result report.
- Retry Analyzer Test: Automatically retry to execute failed test cases.

## How to use

## License

~~~~
Copyright 2020 Tuyen Nguyen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
~~~~
