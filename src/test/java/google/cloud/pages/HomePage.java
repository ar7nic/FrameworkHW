package google.cloud.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".devsite-search-form input[role=searchbox]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//a//b[contains(text(),'Google Cloud Platform Pricing Calculator')]")
    private WebElement googleCloudPlatformPricingCalculator;

    public CalculatorPage moveToCalculatorPage(String keyword) {
        searchInput.click();
        searchInput.sendKeys(keyword, Keys.ENTER);
        waitVisibilityOfElement(DEFAULT_TIMEOUT_SEC,googleCloudPlatformPricingCalculator);
        googleCloudPlatformPricingCalculator.click();
        return new CalculatorPage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
