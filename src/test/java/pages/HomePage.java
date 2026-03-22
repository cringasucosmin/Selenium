package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
       super(driver);
        PageFactory.initElements(driver, this);}
    @FindBy(css = "a[href='search.php']")
    private WebElement searchButton;
    @FindBy(css = "a[href='shows.php']")
    private WebElement showsButton;
    public void goToSearch(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void goToShows(){
        wait.until(ExpectedConditions.visibilityOf(showsButton)).click();
    }

}


