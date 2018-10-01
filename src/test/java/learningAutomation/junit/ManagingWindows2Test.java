package learningAutomation.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ManagingWindows2Test {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.compendiumdev.co.uk/selenium/frames");
        driver.manage().window().maximize();
    }

    @Test
    public void manageWindow() {
        // Create a new Point Object, that setPosition will use

        /*
        Weird issue where setPosition only gets set from 23 onwards
        nothing below that. Is there a minimum setPosition size for Chrome on Linux?
         */

        driver.manage().window().setPosition(new Point(10, 23));

        Point pos = driver.manage().window().getPosition();

        // references the pos variable and gets the x/y coordinate
        assertEquals(10, pos.getX()) ;
        assertEquals(23, pos.getY() );

        /*
        Create a new Dimension object, that setSize will use
         */
        driver.manage().window().setSize(new Dimension(400, 400) );
        Dimension winSize = driver.manage().window().getSize();

        /*
        Weird issue where setSize getWidth only gets set from 400 onwards
        nothing below that. Is there a minimum window size for Chrome on Linux?
         */

        assertEquals(400, winSize.getWidth() );
        assertEquals(400, winSize.getHeight() );
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
