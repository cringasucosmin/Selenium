package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TemaSesiunea4 extends BaseTest {
    @Test
/*    public void testLoginCuSucces(){
        // 1. Navighezi la site
        driver.get("https://the-internet.herokuapp.com/login");

        // 2. Introduci username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // 3. Introduci parola
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // 4. Dai click pe buton
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // 5. Verifici rezultatul
        WebElement mesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        Assert.assertTrue(mesaj.getText().contains("You logged into a secure area!"));}
    @Test
    public void testLoginEsuat(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement mesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        Assert.assertFalse(mesaj.getText().contains("You logged into a secure area!"));}*/
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
                { "tomsmith", "SuperSecretPassword!", true },
                { "tomsmith", "parolaGresita123", false }
        };}
    @Test(dataProvider = "loginData")
        public void testLogin(String user, String password, boolean succes){
            driver.get("https://the-internet.herokuapp.com/login");
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            WebElement mesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

            if(succes){
                Assert.assertTrue(mesaj.getText().contains("secure"));}
                else{Assert.assertTrue(mesaj.getText().contains("invalid"));}
            }
        }




