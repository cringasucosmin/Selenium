package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();}
    @AfterMethod
    public void tearDown() {
        if (driver!= null)
        {driver.quit();}}
    public String takeScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";
        try {
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            src.renameTo(dest);
        } catch (Exception e) {
            System.out.println("Eroare screenshot: " + e.getMessage());
        }
        return path;
    }
    }
