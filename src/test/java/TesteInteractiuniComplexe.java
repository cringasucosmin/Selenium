import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class TesteInteractiuniComplexe {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "Exemplu complet pentru Dropdown")
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Pas 1: Gasim elementul de tip select
        WebElement dropElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));

        // Pas 2: Initializam clasa Select
        Select selectObj = new Select(dropElement);

        // Pas 3: Alegem o optiune
        selectObj.selectByVisibleText("Option 2");

        // Validare: Verificam daca optiunea selectata este cea corecta
        String textSelectat = selectObj.getFirstSelectedOption().getText();
        Assert.assertEquals(textSelectat, "Option 2", "Eroare: Nu s-a selectat optiunea corecta!");
    }

    @Test(description = "Exemplu complet pentru Checkboxes")
    public void testCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Gasim primul checkbox
        WebElement check1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        // Verificam starea initiala (nu ar trebui sa fie bifat)
        Assert.assertFalse(check1.isSelected(), "Eroare: Checkbox-ul era deja bifat!");

        // Bifam elementul
        check1.click();

        // Validam starea finala
        Assert.assertTrue(check1.isSelected(), "Eroare: Checkbox-ul nu s-a bifat dupa click!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

