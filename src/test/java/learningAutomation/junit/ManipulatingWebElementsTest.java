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

public class ManipulatingWebElementsTest {

    private static WebDriver driver;

    /**
     * Helper Methods
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

    /**
     * Tests have been designed to run individually. If the whole class is run, the tests will fail.
     */

    @Test
    public void submitForm() {
        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();
        assertEquals("Title should be, Processed Form Details", "Processed Form Details" , driver.getTitle());
    }

    @Test
    public void clearForm() {
        WebElement comment = driver.findElement(By.cssSelector("[name='comments']"));
        comment.clear();
        comment.sendKeys("New comment");
        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();
        WebElement submittedComment = driver.findElement(By.cssSelector("#_valuecomments"));
        assertEquals("Comment should be, New comment", "New comment", submittedComment.getText());
    }

    @Test
    public void radioBtnSbmit() {
        WebElement radioBtn2;
        radioBtn2 = driver.findElement(By.cssSelector("[value='rd2']"));

        // If the button is not selected, select it
        if(!radioBtn2.isSelected()) {
            radioBtn2.click();
        }

        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();
        WebElement selectedRadioBtn = driver.findElement(By.cssSelector("#_valueradioval"));
        assertEquals("Radio button value shoud be rd2", "rd2", selectedRadioBtn.getText());
    }

    @Test
    public void chkBox1Sbmt() {

        WebElement chkBox1;
        WebElement chkBox3;
        chkBox1 = driver.findElement(By.cssSelector("[value='cb1']"));

        if(!chkBox1.isSelected()) {
            chkBox1.click();
        }

        chkBox3 = driver.findElement(By.cssSelector("[value='cb3']"));
        if(chkBox3.isSelected()) {
            chkBox3.click();
        }

        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();

        WebElement slctdChkBox = driver.findElement(By.cssSelector("#_valuecheckboxes0"));
        assertEquals("Selected checkbox should be cb1", "cb1", slctdChkBox.getText());
    }

    @Test
    public void drpDwn5Sbmt() {

        WebElement dropDownSelect;
        WebElement dropDownOption;

        dropDownSelect = driver.findElement(By.cssSelector("select[name='dropdown']"));
        dropDownOption = dropDownSelect.findElement(By.cssSelector("[value='dd5']"));
        dropDownOption.click();

        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();

        WebElement ddOption5IsDisplayed;
        ddOption5IsDisplayed = driver.findElement(By.cssSelector("#_valuedropdown"));
        assertEquals("ddOption5 is not displayed", "dd5", ddOption5IsDisplayed.getText());
    }

    @Test
    public void drpDwnWithSelect() {
        Select dropDownValue5 = new Select(driver.findElement(By.cssSelector("select[name='dropdown']")));
        dropDownValue5.selectByVisibleText("Drop Down Item 5");

        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();

        WebElement ddOption5IsDisplayed;
        ddOption5IsDisplayed = driver.findElement(By.cssSelector("#_valuedropdown"));
        assertEquals("ddOption5 is not displayed", "dd5", ddOption5IsDisplayed.getText());
    }

    @Test
    public void multiSelectSbmt() {

        WebElement multiSelect;
        WebElement dropDownOptions;

        multiSelect = driver.findElement(By.cssSelector("select[multiple='multiple']"));
        List<WebElement> multiSelectOptions = multiSelect.findElements(By.tagName("option"));

        multiSelectOptions.get(0).click();
        multiSelectOptions.get(1).click();
        multiSelectOptions.get(2).click();

        if(multiSelectOptions.get(3).isSelected()) {
            multiSelectOptions.get(3).click();
        }

        clickSubmitButton();
        verifyProcessedFormDetailsPageIsDisplayed();

        assertEquals("ms1", "ms1", driver.findElement(By.id("_valuemultipleselect0")).getText() );
        assertEquals("ms2", "ms2", driver.findElement(By.id("_valuemultipleselect1")).getText() );
        assertEquals("ms3", "ms3", driver.findElement(By.id("_valuemultipleselect2")).getText() );
        assertTrue("ms4 should not be selected", driver.findElements(By.id("_valuemultipleselect4")).isEmpty() );
    }

    @Test
    public void uploadFileSbmt() {
        String filePath = System.getProperty("user.dir") + "/certificate.pdf";
        driver.findElement(By.cssSelector("[name='filename']")).sendKeys(filePath);
        System.out.println(filePath);
        clickSubmitButton();

        WebElement fileName = driver.findElement(By.cssSelector("#_valuefilename"));
        assertEquals("File name should be certificate.pdf", "certificate.pdf", fileName.getText());
    }

    @AfterClass
    public static void teardownDriver() {
        driver.quit();
    }

}

