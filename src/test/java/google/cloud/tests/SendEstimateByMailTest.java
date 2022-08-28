package google.cloud.tests;

import google.cloud.model.CalculatorValues;
import google.cloud.model.EmailService;
import google.cloud.pages.CalculatorPage;
import google.cloud.service.ValuesCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendEstimateByMailTest extends BaseTest{

    @Test
    public void estimateOnSiteIsEqualInEmail() {
        EmailService service = new EmailService(FREE_EMAIL_SERVICE);
        CalculatorValues cValues = ValuesCreator.withValuesFromProperty();
         getHomePage()
                .moveToCalculatorPage(cValues.getPlatformName())
                .countingEstimateCost(cValues.getNumberOfInstances());
         service.setEmailAddress(getCalculatorPage()
                 .createNewTabAndSwitchToMailPage(service.getFreeMailService())
                 .createRandomEmail());
         getMailPage().switchToParentTab();
         getCalculatorPage().sendEstimatesByMail(service.getEmailAddress());
         String costFromMail = getCalculatorPage()
                 .switchToChildTab()
                 .getEstimatedCostFromMail();
        Assert.assertEquals(costFromMail, CalculatorPage.getCostOnSite());
    }


}
