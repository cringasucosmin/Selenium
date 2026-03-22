    package tests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.testng.annotations.Test;

    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.List;

    public class PhoneScrapperTests extends BaseTest{
        @Test
        public void PhoneScrapper(){
            driver.get("https://webscraper.io/test-sites/e-commerce/allinone/phones/touch");

            try {
                List<WebElement> phones = driver.findElements(By.cssSelector("div.thumbnail"));

            PrintWriter writer = new PrintWriter(new FileWriter("telefoane.csv"));
            writer.println("Nume Telefon,Pret,Descriere");
            for (WebElement phone : phones){
                String name = phone.findElement(By.cssSelector("a.title")).getText();
                String price = phone.findElement(By.cssSelector(".price")).getText();
                price = price.replace("$","");
                Double pretul = Double.parseDouble(price);
                String description = phone.findElement(By.cssSelector(".description")).getText();
                writer.println(name + "," + price + "," + description + ",");
                if(pretul < 200)
                    System.out.println(name + "\n" + price + "\n" + description + "\n");}
            writer.close();}
            catch (IOException e){
                System.out.println("Eroare la scriere: " + e.getMessage());
            }
        }
    }
