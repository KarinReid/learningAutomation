package learningAutomation.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class WindowHandlesTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.compendiumdev.co.uk/selenium/frames/");
    }

    @Test
    public void swtichingHandles() {

        String framesWindowHandle = driver.getWindowHandle();
        assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size() );

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("#goevil")).click();
        driver.findElement(By.cssSelector("a[href='http://www.compendiumdev.co.uk']")).click();
        assertEquals("Expected windowHandles", 3, driver.getWindowHandles().size() );

        driver.switchTo().window("compdev");
        String conpendiumDevPageTitle = "Software Testing Consultancy, Books and Online Training";
        assertEquals("Expected window title", conpendiumDevPageTitle, driver.getTitle() );

        driver.switchTo().window("evil");
        String evilTesterPageTitle = "Evil Tester - Technical Testing with Skill, Attitude and Pragmatism";
        assertEquals("Expected window title", evilTesterPageTitle, driver.getTitle() );

        driver.switchTo().window(framesWindowHandle);
        String mainWindowHandleTitle = "Frameset Example Title (Example 6)";
        assertEquals("Expected window title", mainWindowHandleTitle, driver.getTitle() );


        driver.switchTo().window("compdev");
        driver.close();
        assertEquals("Expected windowHandles", 2, driver.getWindowHandles().size() );

        driver.switchTo().window("evil");
        driver.close();
        assertEquals("Expected windowHandles", 1, driver.getWindowHandles().size() );
    }

    @After
    public void tearDownDriver() {
        driver.quit();
    }

}

