package google.cloud.service;


import google.cloud.model.CalculatorValues;

public class ValuesCreator {

    public static final String TESTDATA_PLATFORM_NAME = "testdata.platform.name";
    public static final String TESTDATA_RESULT_HEADER = "testdata.result.header";
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.instances";

    public static CalculatorValues withValuesFromProperty(){
        return new CalculatorValues(TestDataReader.getTestData(TESTDATA_PLATFORM_NAME),
                TestDataReader.getTestData(TESTDATA_RESULT_HEADER),TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES));
    }

}
