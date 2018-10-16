package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class NavigationTest {

    static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;

    private String seleniumPage = "/selenium/";
    private String basicForm = "/basic_html_form.html";
    private String basicPage = "/selenium/basic_web_page.html";
    private String searchPageFB = "/selenium/search.php";
    private String refreshPage = "/selenium/refresh.php";

    @BeforeClass
    public static void createDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void navigateUsingGet() {
        driver.get(ROOT_URL + seleniumPage);
        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void navigateToTest() {
        driver.navigate().to(ROOT_URL + basicForm);
        assertTrue(driver.getTitle().startsWith("HTML Form Elements"));
    }

    @Test
    public void navigateToURLTest() throws MalformedURLException {
        // MalformedURLException = will check if correct format, if not, throws exception
        // Creating a new object using inbuilt Java class i.e. URL
        URL searchPage = new URL(PROTOCOL,DOMAIN,"/selenium/search.php");
        driver.navigate().to(searchPage);
        assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void navigateForwardsAndBackwardsTest(){

        driver.navigate().to(ROOT_URL + basicPage);
        assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));

        driver.navigate().to(ROOT_URL + searchPageFB);
        assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));

        driver.navigate().back();
        assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));

        driver.navigate().forward();
        assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void refreshPageTest() {

        driver.navigate().to(ROOT_URL + refreshPage);

        final String firstTitle = driver.getTitle();
        System.out.println(firstTitle);
        assertTrue(driver.getTitle().startsWith("Refreshed Page on"));

        driver.navigate().refresh();
        final String secondTitle = driver.getTitle();
        System.out.println(secondTitle);
        assertTrue(secondTitle != firstTitle);
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}
