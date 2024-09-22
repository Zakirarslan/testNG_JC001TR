package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    //Boundary Value Analysis (sınır değer analizi)
    //Equivalance Partitioning (eş değer analizi)

    @DataProvider(name = "positiveTestData")
    public static Object[][] provideBoundaryValueTestData() {
        return new Object[][]{
                {"18"},    // Alt sınır
                {"30"},  // Geçerli yaş
                {"100"},   // Üst sınır
        };
    }

    @DataProvider(name = "negativeTestData")
    public static Object[][] provideNegativeTestData() {
        return new Object[][]{
                {"17"},   // Alt sınırın altı
                {"101"}   // Üst sınırın üstü
        };
    }

    @DataProvider(name = "invalidTestData")
    public static Object[][] provideinvalidTestData() {
        return new Object[][]{
                {"ali"},   // invalidTestData
                {"?"},
                {"-5"}
        };
    }
    @DataProvider (name = "boundaryPositive")
    public static Object[][] boundaryPositive(){
        return new Object[][]{
                {"18"},
                {"19"},
                {"99"},
                {"100"}
        };
    }
    @DataProvider (name = "boundaryNegative")
    public static Object[][] boundaryNegative(){
        return new Object[][]{
                {"17"},
                {"101"}
        };
    }

    @DataProvider (name = "equivalanceNegative")
    public static Object[][] equivalanceNegative(){
        return new Object[][]{
                {"1"},{"0"},{"5"},{"110"}
        };
    }
    @DataProvider (name = "equivalancePositive")
    public static Object[][] equivalancePositive(){
        return new Object[][]{
                {"20"},{"35"},{"70"}
        };
    }
    @DataProvider (name = "invalidData")
    public static Object[][] invalidData(){
        return new Object[][]{
                {"-1"},
                {"k"},
                {"ali"},
                {"!"},
        };
    }


}
