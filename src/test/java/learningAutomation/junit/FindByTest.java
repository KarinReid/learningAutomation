package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FindByTest {

    static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {

        driver = new ChromeDriver();
        driver.get("http://compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void findByIDTest() {
        WebElement p10 = driver.findElement(By.id("p10"));
        assertEquals("This is j paragraph text", p10.getText());
    }

    @Test
    public void findByLinkText() {
        WebElement para0LinkText = driver.findElement(By.linkText("jump to para 0"));
        assertEquals("jump to para 0", para0LinkText.getText());
    }

    @Test
    public void findByName() {
        WebElement paraName25 = driver.findElement(By.name("pName25"));
        assertEquals("This is y paragraph text", paraName25.getText());
    }

    @Test
    public void findByPartialLinkTest() {
        WebElement partialPName0 = driver.findElement(By.partialLinkText("para 0"));
        assertEquals("jump to para 0", partialPName0.getText());
    }

    @Test
    public void findByClassName() {
        WebElement aDiv = driver.findElement(By.className("specialDiv"));
        assertEquals("mydivname", aDiv.getAttribute("name"));
        System.out.println(aDiv);
    }

    @AfterClass
    public static void teardownDriver() {
        driver.quit();
    }

}
