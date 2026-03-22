import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserJourneyTests extends BaseTest {
    @Test(groups = {"smoke", "search"})
    public void TestDeCautare() {
        driver.get("https://apps.qualiadept.eu/hapiflix/login.php");
        driver.findElement(By.name("username")).sendKeys("cringasucosmin");
        driver.findElement(By.name("password")).sendKeys("cosmin123");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='search.php']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("searchInput")))).sendKeys("Friends");
        WebElement friends = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='Friends']")));
        Assert.assertTrue(friends.isDisplayed());
    }

    @Test(groups = {"regression", "navigation"})
    public void TestDeNavigare(){
        driver.get("https://apps.qualiadept.eu/hapiflix/login.php");
        driver.findElement(By.name("username")).sendKeys("cringasucosmin");
        driver.findElement(By.name("password")).sendKeys("cosmin123");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='shows.php']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("shows"));

    }
}
