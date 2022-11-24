package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MyWebDriverManger {
    public WebDriver initBrowser(String browserType) {
        WebDriver webDriver;
        switch (browserType.toUpperCase()) {
            case "FIREFOX": {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            }
            case "IE": {
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                break;
            }
            case "EDGE":{
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            }
            case "OPERA":{
                WebDriverManager.operadriver().setup();
                webDriver = new OperaDriver();
                break;
            }
            case "SAFARI":{
                WebDriverManager.safaridriver().setup();
                webDriver = new SafariDriver();
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            }
        }
        return webDriver;
    }
}
