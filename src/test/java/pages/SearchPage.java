package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    @FindBy(className = "Link--secondary")
    List<WebElement> gitFooterAbout;

    @FindBy(className = "f2-mktg")
    WebElement aboutDescription;
    public WebDriver driver;

    public SearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void scroll(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void clickAbout(){
        gitFooterAbout.get(48).click();
    }
    public void aboutTitle(){
        String expectedTitle = "The complete developer platform to build, scale, and deliver secure software.";
        String actualTitle = aboutDescription.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
