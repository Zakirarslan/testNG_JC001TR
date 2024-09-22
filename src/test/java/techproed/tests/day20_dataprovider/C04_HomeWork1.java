package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtilities;
import techproed.utilities.Driver;

public class C04_HomeWork1 {
    //https://dataprovider.netlify.app/
    //Boundary Value Analysis (sınır değer analizi)
    //Equivalance Partitioning (eş değer analizi)


    @Test (dataProvider = "boundaryPositive",dataProviderClass = DataProviderUtilities.class)
    public void boundaryPositiveTest(String a){

        DataProviderPage dataProviderPage=new DataProviderPage();

        // 1. https://dataprovider.netlify.app/
        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        // 2. enter data to ageBox
        dataProviderPage.ageBox.sendKeys(a);

        // 3. Click on Yasi Dogrula button
        dataProviderPage.yasiDogrulaButton.click();

        // 4. Assert Yas Dogrulandı message is displayed
        String positiveText="Yaş doğrulandı!";
        Assert.assertEquals(dataProviderPage.resultText.getText(),positiveText);
        Driver.closeDriver();
    }

    @Test (dataProvider = "boundaryNegative",dataProviderClass = DataProviderUtilities.class)
    public void boundaryNegativeTest(String a){

        DataProviderPage dataProviderPage=new DataProviderPage();

        // 1. https://dataprovider.netlify.app/
        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        // 2. enter data to ageBox
        dataProviderPage.ageBox.sendKeys(a);

        // 3. Click on Yasi Dogrula button
        dataProviderPage.yasiDogrulaButton.click();

        // 4. Assert Yas Dogrulandı message is displayed
        String positiveText="Yaş 18 ile 100 arasında olmalıdır.";
        Assert.assertEquals(dataProviderPage.resultText.getText(),positiveText);
        Driver.closeDriver();
    }

    @Test (dataProvider = "equivalanceNegative",dataProviderClass = DataProviderUtilities.class)
    public void equivalanceNegativeTest(String a){

        DataProviderPage dataProviderPage=new DataProviderPage();

        // 1. https://dataprovider.netlify.app/
        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        // 2. enter data to ageBox
        dataProviderPage.ageBox.sendKeys(a);

        // 3. Click on Yasi Dogrula button
        dataProviderPage.yasiDogrulaButton.click();

        // 4. Assert Yas Dogrulandı message is displayed
        String positiveText="Yaş 18 ile 100 arasında olmalıdır.";
        Assert.assertEquals(dataProviderPage.resultText.getText(),positiveText);
        Driver.closeDriver();
    }
    @Test (dataProvider = "equivalancePositive",dataProviderClass = DataProviderUtilities.class)
    public void equivalancePositiveTest(String a){

        DataProviderPage dataProviderPage=new DataProviderPage();

        // 1. https://dataprovider.netlify.app/
        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        // 2. enter data to ageBox
        dataProviderPage.ageBox.sendKeys(a);

        // 3. Click on Yasi Dogrula button
        dataProviderPage.yasiDogrulaButton.click();

        // 4. Assert Yas Dogrulandı message is displayed
        String positiveText="Yaş doğrulandı!";
        Assert.assertEquals(dataProviderPage.resultText.getText(),positiveText);
        Driver.closeDriver();
    }

    @Test (dataProvider = "invalidData",dataProviderClass = DataProviderUtilities.class)
    public void invalidDataTest(String a){

        DataProviderPage dataProviderPage=new DataProviderPage();

        // 1. https://dataprovider.netlify.app/
        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        // 2. enter data to ageBox
        dataProviderPage.ageBox.sendKeys(a);

        // 3. Click on Yasi Dogrula button
        dataProviderPage.yasiDogrulaButton.click();

        // 4. Assert Yas Dogrulandı message is displayed
        String positiveText="Geçersiz yaş!";
        Assert.assertEquals(dataProviderPage.resultText.getText(),positiveText);
        Driver.closeDriver();
    }
}
