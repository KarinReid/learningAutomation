package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WebElementListTest {

    private static WebDriver driver;

    @BeforeClass
    public static void driverSetup() {
        driver = new ChromeDriver();
        driver.get("http://compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void findElementsExercise() {

        // Make a WebElement list and store them in a variable called elements
        List<WebElement> elements;
        // Find a list of all className elements, called normal
        elements = driver.findElements(By.className("normal"));

        // Create a new String set of elements and store them in a variable called foundTags
        // HashSet does not allow duplicate elements. This means you can not store duplicate values in HashSet.
        // The list will only hold 1 <p> value, 1 <li> value etc
        Set<String> foundTags = new HashSet<String>();

        // forEach loop iterating through elements
        // for each WebElement e, called elements
        // get the tag name and add it to foundTags HashSet?
        for(WebElement e : elements) {
            foundTags.add(e.getTagName());
            // If e is printed out it prints the class name normal
        }

        // Assert types of tags found
        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("ul"));
        assertTrue("expected li tag", foundTags.contains("li"));
        assertTrue("expected a tag", foundTags.contains("a"));
        assertFalse("did not expect div tag", foundTags.contains("div"));

    }

    @AfterClass
    public static void teardownDriver() {
        driver.quit();
    }

}
