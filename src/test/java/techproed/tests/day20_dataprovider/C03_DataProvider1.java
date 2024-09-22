package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C03_DataProvider1 {

    // BlueRentalCar Sayfasına Gidelim
    // Login butonuna tıklayalım
    // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
    // Sayfayı kapatalım
    @DataProvider (name = "blue")
    public static Object[][] blueRental() {
        ExcelReader excelReader=new ExcelReader("src/test/java/techproed/resources/data_sheet.xlsx",
                "employee_credentials");

            return new Object[][]{
                    {"ayhancan@bluerentalcars.com", "ayhan"},
                    {excelReader.getCellData(1,0),excelReader.getCellData(1,1)},
                    {"johnson@bluerentalcars.com", "johnson"}
                     };
        }


        //CREDENTIALS:
        //    {"ayhancan@bluerentalcars.com", "ayhan"},
        //    {"beyhancan@bluerentalcars.com", "beyhan"},
        //    {"johnson@bluerentalcars.com", "johnson"}

        @Test (dataProvider = "blue")
        public void test01 (String email, String pass) {
            BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
            // BlueRentalCar Sayfasına Gidelim
            Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));

            // Login butonuna tıklayalım
            blueRentalCarPage.loginButton.click();

            // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
            blueRentalCarPage.emailBox.sendKeys(email);
            blueRentalCarPage.passwordBox.sendKeys(pass, Keys.ENTER);
            Driver.closeDriver();
        }
    }
