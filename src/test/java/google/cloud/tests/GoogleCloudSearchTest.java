package google.cloud.tests;

import google.cloud.model.CalculatorValues;
import google.cloud.service.ValuesCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudSearchTest extends BaseTest{

    @Test
    public void canFindKeywordOnSite() {
        CalculatorValues cValues = ValuesCreator.withValuesFromProperty();
        String header = getHomePage()
                .moveToCalculatorPage(cValues.getPlatformName())
                        .getGoogleCloudCalculatorPageHeader();
        Assert.assertEquals(cValues.getResultHeader(),header);
    }


}
