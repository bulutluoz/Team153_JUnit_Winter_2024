package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class C02_KlasikTabloTaglariIleWebtable extends TestBase_Each {

    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));

        System.out.println("Tum table body : \n" + tumBodyElementi.getText());

        System.out.println("================");

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedTabloBodyIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBodyElementi.getText();

        Assertions.assertTrue(actualTumBody.contains(expectedTabloBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriList =
                                    driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin




        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //7. 3.sutunu yazdirin
        //8. Tablodaki basliklari yazdirin
        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

    }
}
