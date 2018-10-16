package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class WorkingWithXPathTest {

    static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    // By xpath - id
    @Test
    public void byIDTest() {
        WebElement idToXpath;
        idToXpath = driver.findElement(By.xpath("//*[@name='pName31']"));
        assertEquals("Name should be pName31", "pName31", idToXpath.getAttribute("name"));
    }

    // By xpath - name
    @Test
    public void byNameTest() {
        WebElement nameToXpath;
        nameToXpath = driver.findElement(By.xpath("//div/ul[@name='ulName1']"));
        assertEquals("ID should be ul1", "ul1" , nameToXpath.getAttribute("id"));
    }

    // By xpath - class name
    @Test
    public void byClassNameTest() {
        WebElement classNameToXpath;
        classNameToXpath = driver.findElement(By.xpath("//*[@class='specialDiv']"));
        assertEquals("ID should be div1", "div1", classNameToXpath.getAttribute("id") );

    }

    // By xpath - tag name
    @Test
    public void byTagNameTest() {
        WebElement tagNameTest;
        tagNameTest = driver.findElement(By.xpath("//*[@name='liName1']"));
        assertEquals("Name should be liName1", "liName1", tagNameTest.getAttribute("name"));
    }

    @AfterClass
    public static void teardownDriver() {
        driver.quit();
    }

}
