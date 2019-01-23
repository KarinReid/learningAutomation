package learningAutomation.junit;

import org.junit.After;
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
    public void deleteLastSearchCookieTest () {
        driver.navigate().to(searchPage);
        driver.findElement(By.cssSelector("input[type='submit'][value='Search']")).click();
        driver.manage().deleteAllCookies();
        Cookie lastSearchCookie = driver.manage().getCookieNamed("seleniumSimplifiedLastSearch");
        Assert.assertEquals("Should be no last search cookie", null, lastSearchCookie);
    }

    @After
    public void teardownDriver() {
        driver.quit();
    }


}
