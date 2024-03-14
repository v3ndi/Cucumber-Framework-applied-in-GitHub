package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {
    @FindBy(className = "flex-1")
    List<WebElement> searchBox;

    @FindBy(className = "QueryBuilder-Input")
    WebElement searchBoxTextField;

    @FindBy(css = "[id=query-builder-test]")
    WebElement hitEnter;

    @FindBy(className = "cgQapc")
    WebElement resultText;

    @FindBy(className = "search-title")
    WebElement searchResultTitle;


    public LandingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void passingSearchKeyWord(String keyWord) {
        searchBox.get(3).click();
        searchBoxTextField.sendKeys(keyWord);
    }
    public void pressEnter()  {
        searchBoxTextField.sendKeys(Keys.ENTER);

    }

    public void assertResultText (){
        Assert.assertTrue(resultText.getText().contains("results"));
    }

    public void assertSearchResultTitle (){
        Assert.assertTrue(searchResultTitle.getText().contains("facebook/create-react-app"));
    }
}