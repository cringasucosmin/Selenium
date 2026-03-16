import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TemaSesiunea2 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup()
    {   driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        }
    @AfterMethod
    public void tearDown()
    {   driver.quit();}
 /*   @Test //loginsucces
    public void testLoginCuSucces(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement mesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        Assert.assertTrue(mesaj.getText().contains("You logged into a secure area!"));
        System.out.println("Testul a trecut, credentialele sunt corecte");}
    @Test //loginfail
    public void testLoginEsuat(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("nopassword123si");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement mesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        Assert.assertFalse(driver.getCurrentUrl().contains("secure"));
        Assert.assertTrue(mesaj.getText().contains("invalid"));
        System.out.println("Testul a trecut, credentialele sunt incorecte");}*/
   /* @Test //checkboxes
    public void testCheckboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        Assert.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());}*/




}



