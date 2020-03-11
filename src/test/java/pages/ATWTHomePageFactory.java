package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATWTHomePageFactory {
    private WebDriver webDriver;

    // Page Factory is an inbuilt Page Object Model concept
    // All WebElements are identified by @FindBy annotation

    @FindBy(xpath = "//p[.='HOME']")
    private WebElement btnHome;

    @FindBy(xpath = "//p[.='FORUM']")
    private WebElement btnForum;

    @FindBy(xpath = "//p[.='AUTHOR']")
    private WebElement btnAuthor;

    @FindBy(css = "._3p7bQ")
    private WebElement icFind;

    @FindBy(css = "[placeholder='Search']")
    private WebElement txtSearch;

    public ATWTHomePageFactory(WebDriver driver) {
        this.webDriver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

        // Advanced feature of Page Factory - AjaxElementLocatorFactory
        /*
        when an operation is performed on an element the wait for its visibility starts from that moment only.
        If the element is not found in the given time interval, Test Case execution will throw 'NoSuchElementException' exception.

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
        */

    }

    public void clickBtnHome() {
        btnHome.click();
    }

    public void clickBtnForum() {
        btnForum.click();
    }

    public void clickBtnAuthor() {
        btnAuthor.click();
    }

    public void search(String text) {
        icFind.click();
        txtSearch.sendKeys(text);
        txtSearch.sendKeys(Keys.ENTER);
    }
}
