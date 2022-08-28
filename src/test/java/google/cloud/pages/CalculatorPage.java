package google.cloud.pages;

import google.cloud.utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;


public class CalculatorPage extends BasePage{

    private final Logger logger = LogManager.getRootLogger();
    private static final String iframeInnerId = "myFrame";
    private static String parentHandle;
    private static String childHandle;
    private static String costOnSite;

    @FindBy(xpath = "//iframe[contains(@name,'goog')]")
    private static WebElement iframeOuter;

    @FindBy(xpath = "//h2[contains(text(),'Google Cloud Pricing Calculator')]")
    private WebElement googleCloudCalculatorHeader;

    @FindBy(xpath = "//h2[contains(text(),'Estimate')]")
    private WebElement estimate;

    @FindBy(xpath = "//md-tab-item//div[contains(@class,'name') and contains(text(),'Compute Engine')]")
    private WebElement computeEngine;

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//label[contains(text(),'Software')]/following-sibling::md-select")
    private WebElement operatingSystemSelect;

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement operatingSystemValue;

    @FindBy(xpath = "//md-select[contains(@aria-label,'VM Class: Regular')]")
    private WebElement vmClassInput;

    @FindBy(xpath = "//md-option[@value='regular']")
    private WebElement vmClassValue;

    @FindBy(xpath = "//md-select[@name='series']")
    private WebElement seriesInput;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesValue;

    @FindBy(xpath = "//label[contains(text(),'Machine type')]/following-sibling::md-select")
    private WebElement machineTypeInput;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeValue;


    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//md-select[@aria-label='GPU type']")
    private WebElement gpuTypeInbox;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuTypeValue;

    @FindBy(xpath = "//label[contains(text(),'Number of GPUs')]/following-sibling::md-select")
    private WebElement numberOfGPUInput;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'supportedGpuNumbers') and @value='1']")
    private WebElement numberOfGPUValue;

//  ошибка  @FindBy(xpath = "//form[@name='ComputeEngiForm']//label[contains(text(),'Local SSD')]/following-sibling::md-select")
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(),'Local SSD')]/following-sibling::md-select")
    private WebElement localSSDInput;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'dynamicSsd') and @value='2']/div[contains(text(),'2x375')]")
    private WebElement localSSDValue;

    @FindBy(xpath = "//label[contains(text(),'Datacenter location')]/following-sibling::md-select")
    private WebElement dataCentreLocationInput;

//    @FindBy(xpath = "//md-option[@value='europe-west3' and contains(@ng-repeat,'computeServer')]")
    @FindBy(xpath = "//md-option[@value='us-central1' and contains(@ng-repeat,'computeServer')]")
    private WebElement dataCentreLocationValue;

    @FindBy(xpath = "//label[contains(text(),'Committed usage')]/following-sibling::md-select")
    private WebElement commitedUsageInput;

    @FindBy(xpath = "//body/div//div[contains(text(),'1 Year')]/ancestor::md-option")
    private WebElement commitedUsageValue;

    @FindBy(xpath = "//button[contains(@aria-label,'Add to Estimate') and contains(@ng-click,'ComputeEngineForm')]")
    private WebElement addButton;

    @FindBy(id = "email_quote")
    private WebElement emailButton;

    @FindBy(css = "form[name=emailForm]")
    private WebElement emailForm;

    @FindBy(xpath = "//label[contains(text(),'Email')]/following-sibling::input")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement estimatedCost;


public String getGoogleCloudCalculatorPageHeader() {
    switchToFrame();
    return googleCloudCalculatorHeader.getText();
}


    public void countingEstimateCost(String number) {
        logger.info("Google Cloud Pricing Calculator Page loaded.");
        switchToFrame();
        computeEngine.click();
        numberOfInstances.click();
        numberOfInstances.sendKeys(number);
        operatingSystemSelect.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,operatingSystemValue);
        operatingSystemValue.click();
        vmClassInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,vmClassValue);
        vmClassValue.click();
        seriesInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,seriesValue);
        seriesValue.click();
        machineTypeInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,machineTypeValue);
        machineTypeValue.click();
        addGpuCheckbox.click();
        gpuTypeInbox.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,gpuTypeValue);
        gpuTypeValue.click();
        numberOfGPUInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,numberOfGPUValue);
        numberOfGPUValue.click();
        localSSDInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,localSSDValue);
        localSSDValue.click();
        dataCentreLocationInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,dataCentreLocationValue);
        dataCentreLocationValue.click();
        commitedUsageInput.click();
        waitElementIsClickable(DEFAULT_TIMEOUT_SEC,commitedUsageValue);
        commitedUsageValue.click();
        addButton.click();
        waitVisibilityOfElement(DEFAULT_TIMEOUT_SEC,emailButton);
        costOnSite = Helper.getTotalEstimatedCost(estimatedCost.getText());
        logger.info("The Estimated Monthly Cost has calculated: " + costOnSite);
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframeOuter);
        driver.switchTo().frame(iframeInnerId);
    }

    public void sendEstimatesByMail(String email) {
        driver.switchTo().frame(iframeOuter);
        driver.switchTo().frame(iframeInnerId);
        emailButton.click();
        waitVisibilityOfElement(DEFAULT_TIMEOUT_SEC,emailInput);
        emailInput.sendKeys(email);
        sendEmailButton.click();
        logger.info("The estimated cost has been sent to email.");
    }

    public MailPage createNewTabAndSwitchToMailPage(String email) {

        parentHandle = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open('"+ email +"','_blank');");
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        childHandle = driver.getWindowHandle();
        logger.info("The free email service page has downloaded.");
        return new MailPage(driver);
    }

    public MailPage switchToChildTab() {
        driver.switchTo().window(childHandle);
        return new MailPage(driver);
    }

    public static String getParentHandle() {
        return parentHandle;
    }


    public static String getCostOnSite() {
        return costOnSite;
    }


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
}
