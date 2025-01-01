package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C02_KontrolsuzAcilanWindowGecisleri extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String expectedYazi = "Opening a new window";

        WebElement ilkSayfaYaziElementi = driver.findElement(By.tagName("h3"));
        String actualIlkSayfaYazisi = ilkSayfaYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualIlkSayfaYazisi);


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        // acilan window kontrolsuz acildigi icin
        // driver otomatik olarak yeni window'a gecmez, eski window'da kalir
        // bulmaca cozerek yeni window'un windowHandle degerini bulup
        // driver'i yeni window'a gecirmeliyiz
        ReusableMethods.bekle(2);
        // 1- eski window'un whd'ini kaydedelim
        String eskiWindowWhd = driver.getWindowHandle();

        // 2- acik tum window'larin whd'lerini bir set olarak kaydedelim
        Set<String> acikTumWindowlarinWhdSeti = driver.getWindowHandles();

        // 3- bir for-each loop ile Set'deki windowHandle degerlerini gozden gecirip
        //    eskiWindowWhd'ine ESIT OLMAYANI
        //    yeniWindowWhd'i olarak kaydedin

        String yeniWindowWhd ="";

        for(String eachWhd : acikTumWindowlarinWhdSeti){

            if ( !eachWhd.equals(eskiWindowWhd) ){
                yeniWindowWhd = eachWhd;
            }
        }

        // 4- yeniWindowWhd'ini kullanarak yeni window'a gecin
        driver.switchTo().window(yeniWindowWhd);
        ReusableMethods.bekle(2);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String yeniWindowExpectedYazi = "New Window";

        String actualYeniWindowYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(yeniWindowExpectedYazi,actualYeniWindowYazi);


        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu test edin

        driver.switchTo().window(eskiWindowWhd);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(2);

    }
}
