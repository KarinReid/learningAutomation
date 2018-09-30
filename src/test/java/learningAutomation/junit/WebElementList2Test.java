package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebElementList2Test {

    private static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void countTheDivElements() {

        List<WebElement> elements;
        elements = driver.findElements(By.tagName("div"));

        assertEquals("There are 19 web elements", 19, elements.size());
    }

    @Test
    public void countTheAHrefElements() {

        List<WebElement> anchorElements;
        anchorElements = driver.findElements(By.partialLinkText("jump to para"));

        assertEquals("The are 25 anchors with jump to para text", 25, anchorElements.size());
    }

    @AfterClass
    public static void tearDownDriver() {
        driver.quit();
    }

}
