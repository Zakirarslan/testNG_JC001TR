package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class C02_DataProvider1 {

    @DataProvider
    public static Object[][] products() {
        return new Object[][]{
                {"laptop"},
                {"phone"},
                {"mouse"},
                {"mousepad"}
        };
    }

    //Google sayfasına gidelim
    //DataProvider ile istediğimiz ürünleri aratalım
    //sayfayı kapatalım

   @Test (dataProvider = "products")
    public void test01(String asd) throws InterruptedException {
       GooglePage googlePage=new GooglePage();
       Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
       Thread.sleep(1000);
       googlePage.handleCookies();
       googlePage.searchBox.sendKeys(asd, Keys.ENTER);
       Thread.sleep(1000);
       Driver.closeDriver();



   }
}
