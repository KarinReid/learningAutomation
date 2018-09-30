package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CssSelectorsTest {

    static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    // By id
    @Test
    public void getIdAssertPname() {
        WebElement element;
        element = driver.findElement(By.id("p31"));
        assertEquals("pName31", element.getAttribute("name"));
        System.out.println(element);
    }

    // By css selector for id
    @Test
    public void getIDByCssAssertPname() {
        WebElement element2;
        element2 = driver.findElement(By.cssSelector("#p31"));
        assertEquals("Expected name of id", "pName31", element2.getAttribute("name"));
    }

    // By name
    @Test
    public void getNameAssertID() {
        WebElement name;
        name = driver.findElement(By.name("ulName1"));
        System.out.println(name);
        assertEquals("Expected name of name", "ul1", name.getAttribute("id"));
    }

    // By css selector for name
    @Test
    public void getNameByCssSelector() {
        WebElement name2;
        name2 = driver.findElement(By.cssSelector("[name='ulName1']"));
        assertEquals("Expected name of name", "ul1", name2.getAttribute("id"));
    }

    // By className
    @Test
    public void getClassNameAssertID() {
        WebElement myClassName;
        myClassName = driver.findElement(By.className("specialDiv"));
        assertEquals("div1", myClassName.getAttribute("id"));
    }

    // By css selector for className
    @Test
    public void getClassNameByCssAssertID() {
        WebElement myClassName2;
        myClassName2 = driver.findElement(By.cssSelector(".specialDiv"));
        assertEquals("div1", myClassName2.getAttribute("id"));
    }

    // By tagName
    @Test
    public void getTagNameAssertName() {
        WebElement myTagName;
        myTagName = driver.findElement(By.tagName("li"));
        assertEquals("liName1", myTagName.getAttribute("name"));
    }

    // By css selector for tagName
    @Test
    public void getTagNameByCssSelector() {
        WebElement myTagName2;
        myTagName2 = driver.findElement(By.cssSelector("li"));
        assertEquals("liName1", myTagName2.getAttribute("name"));
    }

    @AfterClass
    public static void teardownDriver() {
        driver.quit();
    }

}
