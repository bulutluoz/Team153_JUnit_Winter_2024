package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_DropdownMenu extends TestBase_Each {

    @Test
    public void dropdownmenuTesti(){

        //    https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

            // dropdown menu ile islem yapmak icin 3 adim atmaliyiz
            // 1.adim : kullanilacak dropdown menuyu locate edip kaydedelim
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

            // 2.adim : Bir select objesi olusturalim
        Select selectGun = new Select(gunDdm);

            // 3.adim select objesi ile istenen islemi yapalim
       selectGun.selectByIndex(5); // secenek 5'in index'i de 5

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByValue("nisan");


        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");


        //	4. Secilen değerleri konsolda yazdirin
        System.out.println("Gun : "+ selectGun.getFirstSelectedOption().getText());
        System.out.println("Ay : " + selectAy.getFirstSelectedOption().getText());
        System.out.println("Yil : " + selectYil.getFirstSelectedOption().getText());


        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın

            // 1. alternatif direkt ddm webelementinden yazdiraabiliriz
        System.out.println(ayDdm.getText());
        /*
                  Ay
                  Ocak
                  Şubat
                  Mart
                  Nisan
                  Mayıs
                  Haziran
                  Temmuz
                  Ağustos
                  Eylül
                  Ekim
                  Kasım
                  Aralık

         */

            // 2.alternatif select objesi kullanilarak,
            //              tum option'lari bir liste olarak kaydedebiliriz

        List<WebElement> ayDdmOptionElementleriList = selectAy.getOptions();
        // bu liste Webelement'lerden olustugu icin direkt yazdiramayiz
        // bir loop ile tum elementleri tek tek alip getText() ile yazilari yazdirabiliriz

        for (WebElement each: ayDdmOptionElementleriList){
            System.out.println(each.getText());
        }


        // ay dropdown menusunde mart kelimesinin gecmedigini test edin




        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        ReusableMethods.bekle(3);

    }
}
