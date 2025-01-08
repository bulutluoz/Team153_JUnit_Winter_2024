package tests.day14_getScreenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C01_EkranGoruntusuKaydetme extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // 1- testotomasyonu anasayfaya gidip,
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        ReusableMethods.bekle(1);
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 2- phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucElementi.getText();

        ReusableMethods.bekle(1);
        Assertions.assertNotEquals(unExpectedSonuc,actualSonuc);

        // 3- ilk urunu tiklayip,
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acilan sayfadaki urun isminde
        // case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = "phone";

        WebElement isimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualIsim = isimElementi.getText()
                                        .toLowerCase(); // case sensitive olmamasi icin
        ReusableMethods.bekle(1);
        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        // testin sorunsuz calistigini ispatlamak icin
        // sayfanin screenshot'ini alip kaydedin

        // 1.adim TakesScreenshot objesi olusturun ve deger olarak driver'i atayip cast edin
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim : ekran goruntusunu kaydedecegimiz File'i olusturun
        //          parametre olarak kaydetmek istediginiz dosyanin, dosya yolunu girin
        File asilResim = new File("target/screenshots/tumSayfaScreenshot.jpg");

        // 3.adim : olusturdugumuz takeScreenshot objesi ile ekran goruntusunu alip
        //          gecici bir File'a kaydedelim
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asilResim dosyasina kopyalayin
        FileUtils.copyFile(geciciResim,asilResim);

        driver.quit();

    }
}
