package learningAutomation.junit;

import learningAutomation.manager.DriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DriverManagerTest {

    @Test
    public void createAFirefoxDriver() {

        WebDriver driver = DriverManager.get();
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_web_page.html");
        assertThat(driver.getTitle(), is("Basic Web Page Title"));

        driver.quit();
    }
}
