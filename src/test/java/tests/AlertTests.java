package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest{
  /*  @Test
    public void JsAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[1]/button")).click();
        driver.switchTo().alert().accept();}*/
    /*@Test
    public void JsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        String textAlerta = alert.getText();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");

    }*/
    @Test
    public void alertPrompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Hello World");
    }
   /* @Test
    public void testCarePica() {
        driver.get("https://the-internet.herokuapp.com/login");
        Assert.assertEquals("text gresit", "text corect");
    }*/ //Acesta e un test care pica pentru a testa functia de screenshot a ExtentReport))))))____
}
