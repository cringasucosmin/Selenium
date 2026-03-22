package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);}
    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name ="submitButton")
    private WebElement submitButton;
    public void performLogin(String Username, String Password){
        usernameInput.sendKeys(Username);
        passwordInput.sendKeys(Password);
        submitButton.click();
    }
}
