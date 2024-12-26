package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class C07_TestBaseKullanimi extends TestBase_Each {

    // testotomasyonu anasayfaya gidin
    // phone icin arama yapin
    // arama sonucunda urun bulunabildigini test edin

    /*
        Bir test class'i olusturdugumuzda
        ilk yapmamiz gereken sey
        WebDriver objesi edinmektir

        Her class'da WebDriver objesi olusturmak
        ve gerekli ayarlari yapmak,
        driver'in kapanmasi icin teardown method'u olusturmak yerine
        OOP kullanarak 1 kere olusturup
        gerektigi yerden kullanmak daha mantikli olacaktir
     */

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // 2- phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualSonucSayisi>0);

    }


}
