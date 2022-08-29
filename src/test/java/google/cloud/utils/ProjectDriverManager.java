package google.cloud.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            System.out.println(System.getProperty("browser"));
            if (System.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(OptionsManager.getChromeOptions());
            }
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
