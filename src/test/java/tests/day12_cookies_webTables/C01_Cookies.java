package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_Cookies extends TestBase_Each {

    @Test
    public void test01(){

        //1- google anasayfaya gidin
        driver.get("https://www.google.com");

        //2- cookies cikarsa kabul edin
        driver.findElement(By.xpath("//div[text()='Accept all']"))
                .click();
        ReusableMethods.bekle(1);

        //3- Sayfadaki cookies sayisinin 3’veya daha fazla oldugunu test edin

        Set<Cookie> cookiesSeti = driver.manage().getCookies();

        Assertions.assertTrue(cookiesSeti.size() >= 3);

        //4- sayfadaki cookie'leri yazdirin

        System.out.println(cookiesSeti);

        // daha anlasilir olmasi icin foe-each loop ile yazdiralim

        int siraNo = 1;

        for (Cookie eachCookie : cookiesSeti){
            System.out.println(siraNo+". cookie : \n" + eachCookie);
            siraNo++;
        }

        //5- cookie'lerin isimlerini yazdirin
        siraNo = 1;

        for (Cookie eachCookie : cookiesSeti){
            System.out.println(siraNo+". cookie ismi : " + eachCookie.getName());
            siraNo++;
        }

        //6- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        Cookie benimCookiem = new Cookie("en sevdigim cookie","cikolatali");

        //   ve sayfaya ekleyin
        driver.manage().addCookie(benimCookiem);


        //7- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("=================");
        cookiesSeti = driver.manage().getCookies();






        //8- ismi SOCS olan cookie’yi silin ve silindigini test edin
        //9- tum cookie’leri silin ve silindigini test edin

        ReusableMethods.bekle(2);

    }
}
