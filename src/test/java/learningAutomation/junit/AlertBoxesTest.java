package learningAutomation.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AlertBoxesTest {

    static WebDriver driver;
    final private String ALERT_PAGE_URL = "https://www.compendiumdev.co.uk/selenium/alerts.html";
    private static Logger logger = LogManager.getLogger(AlertBoxesTest.class);

    @BeforeClass
    public static void setupDriver() {

        driver = new ChromeDriver();
        logger.info("Starting up the driver");
    }

    @Before
    public void setupPage() {
        driver.get(ALERT_PAGE_URL);
    }

    @Test
    public void alertBox() {
        WebElement showAlertBox = driver.findElement(By.cssSelector("#alertexamples"));
        showAlertBox.click();
        assertEquals("Expected alert box message", "I am an alert box!", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void confirmBox() {
        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmexample"));
        confirmBox.click();
        assertEquals("Expected confirm box message", "I am a confirm alert", driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        assertFalse(driver.findElement(By.cssSelector("#confirmreturn")).getText(), false); // Assert cancel button has been clicked
    }

    @Test
    public void promtBox() {
        String msg = "Hello world";
        WebElement promptBox = driver.findElement(By.cssSelector("#promptexample"));
        promptBox.click();
        assertEquals("Expected prompt box message", "I prompt you", driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys(msg);
        driver.switchTo().alert().accept();
        assertEquals("Expected message", msg, driver.findElement(By.cssSelector("#promptreturn")).getText());
    }

    @AfterClass
    public static void tearDownDriver() {

        driver.quit();
        logger.info("Shutting down the driver");
    }

}
