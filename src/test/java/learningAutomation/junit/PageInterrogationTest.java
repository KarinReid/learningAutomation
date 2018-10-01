package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class PageInterrogationTest {

    private static WebDriver driver;
    final private static String PROTOCOL = "http";
    final private static String DOMAIN = "www.compendiumdev.co.uk";
    final private static String ROOT_URL = PROTOCOL + "://" + DOMAIN;

    private String basicPage = "/selenium/basic_web_page.html";

    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void verifyPage() {

        driver.get(ROOT_URL + basicPage);
        assertThat(driver.getTitle(), is("Basic Web Page Title"));
        assertThat(driver.getCurrentUrl(), is("http://www.compendiumdev.co.uk/selenium/basic_web_page.html"));
        assertThat(driver.getPageSource(), containsString("A paragraph of text"));
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
