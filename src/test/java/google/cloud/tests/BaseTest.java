package google.cloud.tests;

import google.cloud.pages.CalculatorPage;
import google.cloud.pages.HomePage;
import google.cloud.pages.MailPage;
import google.cloud.utils.ProjectDriverManager;
import google.cloud.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected static final String FREE_EMAIL_SERVICE = "https://yopmail.com/";
    protected final String BASE_URL = "https://cloud.google.com/";

    @BeforeMethod()
    public void setUp()
    {
        driver = ProjectDriverManager.getDriver();
        driver.get(BASE_URL);

    }


    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        ProjectDriverManager.closeDriver();
    }

    HomePage getHomePage() {
        return new HomePage(driver);
    }

    CalculatorPage getCalculatorPage() {
        return new CalculatorPage(driver);
    }
    MailPage getMailPage() {return new MailPage(driver);}

}
