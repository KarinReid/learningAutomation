package learningAutomation.junit;

import cucumber.api.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CookiesTest {

    WebDriver driver;
    String searchPage = "http://compendiumdev.co.uk/selenium/search.php";
    private static Logger logger = LogManager.getLogger(CookiesTest.class);

    @FindBy(css = "input[type='submit'][value='Search']")
    private WebElement searchButton;

    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void getLastSearchCookieTest() {
        driver.navigate().to(searchPage);
        Cookie aCookie = driver.manage().getCookieNamed("seleniumSimplifiedLastSearch");
        Assert.assertEquals("Should be no last search cookie", null, aCookie);

        driver.findElement(By.cssSelector("input[type='submit'][value='Search']")).click();
        Cookie lastSearch = driver.manage().getCookieNamed("seleniumSimplifiedLastSearch");
        Assert.assertTrue("Last search cookie does not have a null value", lastSearch != null);
    }

    @Test
    public void deleteLastSearchCookieTest() {
        driver.navigate().to(searchPage);
        driver.findElement(By.cssSelector("input[type='submit'][value='Search']")).click();
        driver.manage().deleteAllCookies();
        Cookie lastSearchCookie = driver.manage().getCookieNamed("seleniumSimplifiedLastSearch");
        Assert.assertEquals("Should be no last search cookie", null, lastSearchCookie);
    }

    @Test
    public void buildingANewCookieTest() {
        driver.navigate().to(searchPage);
        driver.manage().deleteAllCookies();
        // Builds a new cooke template with name and value.
        Cookie.Builder aNewCookie = new Cookie.Builder("newCookie","myValue");
        // New cookie conditions can then be added
        aNewCookie.isSecure(true);
        aNewCookie.domain("www.mydomain.com");
        Assert.assertTrue("Should be a new cookie created", aNewCookie != null);
        // TODO: Not happy that this is working. Cannot see a new cookie in Application > cookies
    }

    @Test
    public void getCookieSearchNumVisits() {
        // Test 1
        driver.navigate().to(searchPage);
        Cookie browserCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        Assert.assertEquals("Should only be 1 number of visits", "1", browserCookie.getValue());
        driver.manage().deleteAllCookies();
    }

    @After
    public void teardownDriver() {
        driver.quit();
    }


}
