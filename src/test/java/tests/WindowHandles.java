package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandles extends BaseTest {
    @Test
    public void windowHandles(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String originalTab = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allTabs =  driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
            }
        }
        String text = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text, "New Window");

    }
}
