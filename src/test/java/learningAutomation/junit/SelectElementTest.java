package learningAutomation.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SelectElementTest {

    private static WebDriver driver;

    /**
     * Helper methods
     */

    private void clickSubmitButton() {
        WebElement sbmtButton;
        sbmtButton = driver.findElement(By.cssSelector("[value='submit']"));
        sbmtButton.click();
    }

    private void verifyProcessedFormDetailsPageIsDisplayed() {
        new WebDriverWait(driver, 100, 10).until(ExpectedConditions.titleContains("Processed Form Details"));
    }

    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void multipleSelectMenu() {

        WebElement multipleSelectMenu;
        multipleSelectMenu = driver.findElement(By.cssSelector("select[name='multipleselect[]']"));

        Select multipleSelect = new Select(multipleSelectMenu);
        assertTrue(multipleSelect.isMultiple());

        List<WebElement> selectedItems = multipleSelect.getAllSelectedOptions();
        assertEquals("By default only 1 selected", 1, selectedItems.size());

        multipleSelect.deselectAll();
        selectedItems = multipleSelect.getAllSelectedOptions();
        assertEquals("None selected", 0, selectedItems.size());

        multipleSelect.selectByVisibleText("Selection Item 1");
        multipleSelect.selectByIndex(1); // List starts from 0
        multipleSelect.selectByValue("ms3");

        selectedItems = multipleSelect.getAllSelectedOptions();
        assertEquals("Three items selected", 3, selectedItems.size());

        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();

        assertEquals("Expected 1st option selected", "ms1", driver.findElement(By.id("_valuemultipleselect0")).getText());
        assertEquals("Expected 2nd option selected", "ms2", driver.findElement(By.id("_valuemultipleselect1")).getText());
        assertEquals("Expected 3rd option selected", "ms3", driver.findElement(By.id("_valuemultipleselect2")).getText());
        assertTrue("Expected no 4th element", driver.findElements(By.id("_valuemultipleselect3")).isEmpty());

    }

    @AfterClass
    public static void tearDownDriver() {
        driver.quit();
    }
}
