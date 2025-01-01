package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C04_UrlIleWindowGecis extends TestBase_Each {
    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement addRemoveyaziElementi = driver.findElement(By.xpath("//*[.='Add/Remove Elements']"));

        String expectedyazi = "Add/Remove Elements";
        String actualYazi = addRemoveyaziElementi.getText();

        Assertions.assertEquals(expectedyazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[.='Electronics Products']"))
                .click();

        // once yeni window'a gecis yapmaliyiz
        String hedefWindowUrl = "https://testotomasyonu.com/category/7/products";

        ReusableMethods.urlIleWindowGecisi(driver,hedefWindowUrl);

        //● Electronics sayfasinin acildigini test edin
        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//li[@class='current']"));

        String expectedYazi = "Electronics";
        actualYazi = electronicsYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Bulunan urun sayisinin 16 olduğunu test edin
        List<WebElement> yeniSayfadaUrunlerList = driver.findElements(By.className("prod-img"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = yeniSayfadaUrunlerList.size();

        Assertions.assertEquals(expectedUrunSayisi,actualUrunSayisi);

        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun
        hedefWindowUrl = "https://testotomasyonu.com/addremove/";

        ReusableMethods.urlIleWindowGecisi(driver,hedefWindowUrl);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }
}
