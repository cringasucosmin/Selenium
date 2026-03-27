package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexFormTest extends BaseTest{
    @Test
    public void TestComplexForm(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Thomas");
        driver.findElement(By.id("lastName")).sendKeys("Shellby");
        driver.findElement(By.id("userEmail")).sendKeys("tomyshelby@yahoo.com");
        driver.findElement(By.cssSelector("label[for='gender-radio-3']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0712345678");
        driver.findElement(By.id("subjectsInput")).sendKeys("Ma");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Bucharest");
       /* driver.findElement(By.id("uploadPicture")).sendKeys("/Users/cosmin/Desktop/pozasite.png");*/
        driver.findElement(By.id("react-select-3-input")).sendKeys("Utta");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("react-select-4-input")).sendKeys("Agra");
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        String firstName = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
        Assert.assertEquals(firstName, "Thomas Shellby");
        String userNumber = driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td")).getText();
        Assert.assertEquals(userNumber, "0712345678");
        String currentAddress = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText();
        Assert.assertEquals(currentAddress, "Bucharest");
        String picture = driver.findElement(By.xpath("//td[text()='Picture']/following-sibling::td")).getText();
        Assert.assertEquals(picture, "pozasite.png");
        String gender = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText();
        Assert.assertEquals(gender, "Other");


    }
}
