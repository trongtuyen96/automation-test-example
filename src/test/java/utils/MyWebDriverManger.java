package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyWebDriverManger {
    public WebDriver initBrowser(String browserType) {
        WebDriver webDriver;
        switch (browserType.toUpperCase()) {
            case "CHROME": {
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                webDriver = new ChromeDriver();
                break;
            }
            case "FIREFOX": {
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                webDriver = new FirefoxDriver();
                break;
            }
            case "IE": {
                InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                webDriver = new InternetExplorerDriver();
                break;
            }
            default: {
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                webDriver = new ChromeDriver();
                break;
            }
        }
        return webDriver;
    }
}
