package learningAutomation.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ManagingWindowsTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.compendiumdev.co.uk/selenium/bounce.html");
    }

    @Test
    public void maximiseWindow() {
        driver.manage().window().maximize();
        // Get the size of the window
        Dimension winSize = driver.manage().window().getSize();
        assertEquals(1200, winSize.getWidth() );
        assertEquals(877, winSize.getHeight() );

    }

    @Test
    public void reduceWidowSizeToHalf() {
        // Maximize size of the window
        driver.manage().window().maximize();

        //Get the maximum size of the window i.e. width & height
        Dimension fullScreenSize = driver.manage().window().getSize();

        // Reduce the size of the window to half
        driver.manage().window().setSize(new Dimension(fullScreenSize.getWidth()/2, fullScreenSize.getHeight()/2));
        assertEquals("Get width half size", fullScreenSize.getWidth()/2, driver.manage().window().getSize().getWidth());
        assertEquals("Get height half size", fullScreenSize.getHeight()/2, driver.manage().window().getSize().getHeight());
    }

    @Test
    public void reduceWidowSizeToHalfAndMoveToCentreOfScreen() {
        // Maximize size of the window
        driver.manage().window().maximize();

        // Get the maximum size of the window i.e. width & height
        Dimension fullScreenSize = driver.manage().window().getSize();
        // Get the position of the window
        Point pos = driver.manage().window().getPosition();

        // Reduce the size of the window to half
        driver.manage().window().setSize(new Dimension(fullScreenSize.getWidth()/2, fullScreenSize.getHeight()/2));

        // Position the browser in the middle of the screen
        driver.manage().window().setPosition(new Point(fullScreenSize.getWidth() / 4, fullScreenSize.getHeight() / 4));
    }

    @Test
    public void bouncingWindow() {

        // Maximize size of the window
        driver.manage().window().maximize();

        //Get the maximum size of the window i.e. width & height
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        // Reduce the size of the window to half
        width = (width / 2) / 2;
        height = (height / 2) / 2;
        driver.manage().window().setSize(new Dimension(width, height));

        for (int i = 0; i < 25; i++) {

            Random coordinate = new Random();
            int x1 = 22;
            int x2 = 1000;
            int x = coordinate.nextInt(x2 - x1) + x1;
            int y = coordinate.nextInt(x2 - x1) + x1;
            System.out.println(x);
            System.out.println(y);

            driver.manage().window().setPosition(new Point(x, y));
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
