package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ATWTHomePage {
    private WebDriver webDriver;

    private By btnHome = By.xpath("//p[.='HOME']");
    private By btnForum = By.xpath("//p[.='FORUM']");
    private By btnAuthor = By.xpath("//p[.='AUTHOR']");
    private By icFind = By.cssSelector("[role='button']");
    private By txtSearch = By.cssSelector("[placeholder='Search']");

    public ATWTHomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void clickBtnHome() {
        webDriver.findElement(btnHome).click();
    }

    public void clickBtnForum() {
        webDriver.findElement(btnForum).click();
    }

    public void clickBtnAuthor() {
        webDriver.findElement(btnAuthor).click();
    }

    public void search(String text) {
        webDriver.findElement(icFind).click();
        webDriver.findElement(txtSearch).sendKeys(text);
        webDriver.findElement(txtSearch).sendKeys(Keys.ENTER);
    }
}
