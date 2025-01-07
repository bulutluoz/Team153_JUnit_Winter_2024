package tests.day14_getScreenshot_jsExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_EkranGoruntusuKaydetme extends TestBase_Each {

    @Test
    public void test01(){

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



    }
}
