package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
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
        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));


        // daha guzel gorunmesi icin satir satir yazdiralim

        for (int i = 0; i <satirElementleriList.size() ; i++) {

            System.out.println( 1+i +". satir : \n" +  satirElementleriList.get(i).getText());

        }


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //   WebTable'da sutun yapisi yoktur
        //   bunun yerine satirlar ve herbir satirdaki datalar vardir
        //   sutun sayisini bulmak icin HERHANGI bir satirdaki data sayisina bakabiliriz

        List<WebElement> birinciSatirDataElementleriList =
                driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedSutunSayisi = 4;
        int actualBirinciSatirdakiDataSayisi = birinciSatirDataElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualBirinciSatirdakiDataSayisi);

        //7. 3.sutunu yazdirin
        //   WebTable'da sutun yapisi yoktur
        //   bunun yerine satirlar ve herbir satirdaki datalar vardir
        //   3.sutunu yazdirmak icin satir no onemli degil, her satirdaki 3.data'yi yazdirmaliyiz

        List<WebElement> ucuncuSutunElementleriList =
                         driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        System.out.println(ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));



        //8. Tablodaki basliklari yazdirin

        // basliklari istersek tek bir WebElement olarak locate edip, yazdirabiliriz
        WebElement headerSatirElementi = driver.findElement(By.xpath("//thead/tr"));

        System.out.println(headerSatirElementi.getText());

        // basliklari daha belirgin olarak yazdirmak icin
        // baslik satirindaki datalari bir list olarak kaydedebilir ve o sekilde yazdirabiliriz

        List<WebElement> baslikDataElementleriList =
                driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikDataElementleriList));


        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

    }
}
