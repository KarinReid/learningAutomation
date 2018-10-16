package learningAutomation.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WorkingWithFramesTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void switchToANewFrame() {
        driver.get("https://www.compendiumdev.co.uk/selenium/frames/");
        assertEquals("Frameset Example Title (Example 6)", driver.getTitle() );

        driver.switchTo().frame("menu");
        driver.findElement(By.cssSelector("a[href='frames_example_1.html")).click();
        String frameExample1PageTitle = "Frameset Example Title (Example 1)";
        new WebDriverWait(driver, 20).until(ExpectedConditions.titleIs(frameExample1PageTitle));
        assertEquals(frameExample1PageTitle, driver.getTitle());
    }

    @Test
    public void switchToGreenAndBackToMain() {
        driver.get("https://www.compendiumdev.co.uk/selenium/frames/");
        assertEquals("Frameset Example Title (Example 6)", driver.getTitle() );

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='green.html']")).click();

        WebElement linkBackToOriginalPage = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='content.html']")));
        linkBackToOriginalPage.click();
        assertEquals("Content", driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void switchingAcrossMultipleFrames() {
        driver.manage().window().maximize();
        driver.get("https://www.compendiumdev.co.uk/selenium/frames/");
        assertThat(driver.getTitle(), is("Frameset Example Title (Example 6)") );

        driver.switchTo().frame("topNav");
        driver.findElement(By.cssSelector("a[href='menu_1.html']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menu");
        assertThat(driver.findElement(By.tagName("h3")).getText(), is("Menu 1") );

        driver.findElement(By.cssSelector("a[href='iframe.html']")).click();
        assertThat(driver.getTitle(), is("HTML Frames Example - iFrame Contents") );

        WebElement iframeExample = driver.findElement(By.cssSelector("iframe[src='iframe_contents.html']"));
        driver.switchTo().frame(iframeExample);
        driver.findElement(By.cssSelector("a[href='frames_example_5.html'")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("content");
        assertThat(driver.findElement(By.tagName("h1")).getText(), is("Content") );

        driver.findElement(By.cssSelector("a[href='index.html']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("related");
        assertThat(driver.findElement(By.tagName("h3")).getText(), is("Related") );
    }

    @After
    public void tearDownDriver() {
        driver.quit();
    }

}

