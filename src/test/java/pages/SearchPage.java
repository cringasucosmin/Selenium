package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);}
    @FindBy(className = "searchInput")
    private WebElement searchInput;
    public void searchFor(String text){
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(text);}
    public boolean isResultDisplayed(String title){
        WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='" + title + "']")));
    return check.isDisplayed();
    }

}

