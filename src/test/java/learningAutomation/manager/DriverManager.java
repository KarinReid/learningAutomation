package learningAutomation.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver get() {

        return new ChromeDriver();

    }



}
