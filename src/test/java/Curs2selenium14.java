import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Curs2selenium14 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Configurăm locația driver-ului și pornim browser-ul
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://apps.qualiadept.eu/testaurant/login.html");
    }

    @Test(priority = 1, description = "Verifică logare reusita", groups = "Smoke")
    public void loginValid() throws InterruptedException {

        // 1. Identificare element
        // AAA -> Arrange, Act, Assert
        // Arrange

        // username field
        WebElement username = driver.findElement(By.id("username"));
        // password field
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
        // login btn
        WebElement loginBtn = driver.findElement(By.cssSelector("#login-btn"));

        Thread.sleep(1000);

        // Act

        // curatm fieldul inainte de a scrie text...
        username.clear();
        username.sendKeys("testuser");
        password.clear();
        password.sendKeys("password123");

        Thread.sleep(1000);

        // click pe login btn
        loginBtn.click();

        // Assert
        boolean loginSuccessfulMsg = driver.findElement(By.id("login-message")).isDisplayed();
        Assert.assertTrue(loginSuccessfulMsg, "Login successful! Welcome. should display");

//        String titlu = driver.getTitle();
//        Assert.assertEquals(titlu, "Google", "Titlul paginii nu coincide!");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Închide tot și eliberează memoria RAM
        }
    }
}