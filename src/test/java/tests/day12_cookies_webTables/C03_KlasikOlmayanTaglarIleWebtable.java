package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C03_KlasikOlmayanTaglarIleWebtable extends TestBase_Each {

    @Test
    public void test01(){
        //         //*[@role='trow'][2]/*[@role='tdata'][3]

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikDataElementleriList =
                driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikDataElementleriList));

        //  3. 3.sutunun basligini yazdirin
        System.out.println(baslikDataElementleriList.get(2).getText()); // Price

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tablodakiTumElementlerList =
                driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(tablodakiTumElementlerList));

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        System.out.println("tablodaki data sayisi : " + tablodakiTumElementlerList.size());

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("tablodaki satir sayisi : " + satirElementleriList.size()); // 5


        //  7. Tablodaki sutun sayisini yazdirin
        //     Webtablosunda sutun olmaz, satirdaki data olur
        //     Sutun sayisini bulmak icin herhangi bir satirdaki data sayisini yazdirabiliriz

        List<WebElement> birinciSatirDataElementleriList =
                driver.findElements(By.xpath("//*[@role='trow'][1]/*[@role='tdata']"));

        System.out.println("tablodaki sutun sayisi : " + birinciSatirDataElementleriList.size());//4




        //  8. Tablodaki 3.kolonu yazdirin
        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
    }
}
