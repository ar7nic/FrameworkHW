package google.cloud.model;

public class CalculatorValues {

    private String platformName;
    private String resultHeader;
    private String numberOfInstances;

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getResultHeader() {
        return resultHeader;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setResultHeader(String resultHeader) {
        this.resultHeader = resultHeader;
    }

    public CalculatorValues(String platformName, String resultHeader, String numberOfInstances) {
        this.platformName = platformName;
        this.resultHeader = resultHeader;
        this.numberOfInstances = numberOfInstances;
    }
}
