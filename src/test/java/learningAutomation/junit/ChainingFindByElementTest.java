package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import static org.junit.Assert.assertEquals;


public class ChainingFindByElementTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpDriver() {

        driver = new ChromeDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void myCustomElements() {

        // We can write our own custom findElement by chaining these elements together
        WebElement element;
        element = driver.findElement(
                new ByChained(
                        By.id("div1"),
                        By.name("pName9"),
                        By.tagName("a")));

        assertEquals("Expecting a9", "a9", element.getAttribute("id"));
    }

    @AfterClass
    public static void tearDownDriver() {

        driver.quit();
    }

}
