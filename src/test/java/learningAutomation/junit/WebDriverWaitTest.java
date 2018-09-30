package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebDriverWaitTest {

    static WebDriver driver;

    String pageURL = "http://www.compendiumdev.co.uk/selenium/basic_html_form.html";
    String pageTitle = "HTML Form Elements";
    String dropDownBox = "Drop Down Item 1";

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void waitingForTitle() {
        driver.get(pageURL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs(pageTitle));
        assertEquals(pageTitle, driver.getTitle());
    }

    @Test
    public void webElementExpectedText() {
        driver.get(pageURL);
        WebElement element = driver.findElement(By.cssSelector("[name='dropdown'] [value='dd1']"));
        new WebDriverWait(driver, 10).until(visibilityOf(element));
        assertEquals("Drop Down Item 1", element.getText().trim());
        // Trim removes any spaces from before and after any returned text.
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
