package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class C02_DataProvider1 {

    @DataProvider(name = "gpro")
    public static Object[][] product() {
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

   @Test (dataProvider = "gpro")
    public void test01(String asd) throws InterruptedException {
       GooglePage googlePage=new GooglePage();
       Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
       Thread.sleep(1000);
       googlePage.handleCookies();
       googlePage.searchBox.sendKeys(asd, Keys.ENTER);
       Thread.sleep(1000);
       Driver.closeDriver();
   }
    //aynı data provider'ı farklı test methodlarıyla kardeş kardeş kullanmanın örneği:
   @Test (dataProvider = "pro")
    public void test02(String p){
       AmazonPage amazonPage = new AmazonPage();
        //amazon sayfasına gidelim,
       Driver.getDriver().get(ConfigReader.getProperties("amazonUrl"));
       amazonPage.handleCaptcha();
       //aramakutusunda dataprovider'dan gelen verileri aratalım
       amazonPage.searchBox.sendKeys(p);

       Driver.closeDriver();

   }
   @Test (dataProvider = "product")
    public void test03(){

   }

}
