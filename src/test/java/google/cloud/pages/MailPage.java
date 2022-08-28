package google.cloud.pages;

import google.cloud.utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MailPage extends BasePage{

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#listeliens a[href=email-generator]")
    private WebElement emailGenerator;

    @FindBy(id = "egen")
    private WebElement email;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement checkEmail;

    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost')]")
    private WebElement estimatedFromEmail;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//div[@id='nbmail' and text()='1 mail']")
    private WebElement numberOfMails;

    @FindBy(xpath = "//div[@currentmail]//span[contains(text(),'Google Cloud Sales')]")
    private WebElement mailFromGoogle;

    public String createRandomEmail() {
        emailGenerator.click();
        waitVisibilityOfElement(DEFAULT_TIMEOUT_SEC,email);
        logger.info("Random mail [" + email.getText() + "] created");
        return email.getText();
    }

    public void switchToParentTab() {
        driver.switchTo().window(CalculatorPage.getParentHandle());
    }

    public boolean oneMailInbox() {
        refreshButton.click();
        int tries = 3;
        while (tries > 0) {
            try {
                waitVisibilityOfElement(3,numberOfMails);
                if (numberOfMails.isDisplayed()) {
                    logger.info("The letter has been arrived.");
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                refreshButton.click();
                tries--;
            }
        }
        logger.warn("Waiting for the email too long.");
        return false;
    }

    public String getEstimatedCostFromMail() {
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,checkEmail);
        checkEmail.click();
        if (oneMailInbox()) {
            driver.switchTo().frame("ifmail");
            logger.info("The letter with estimates has been checked.");
            return Helper.getTotalEstimatedCost(estimatedFromEmail.getText());
        }
        return null;
    }

    public MailPage(WebDriver driver) {
        super(driver);
    }

}
