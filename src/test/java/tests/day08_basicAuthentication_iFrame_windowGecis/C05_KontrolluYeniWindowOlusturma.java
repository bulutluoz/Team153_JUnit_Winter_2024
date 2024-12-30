package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_KontrolluYeniWindowOlusturma extends TestBase_Each {

    @Test
    public void test01(){
        /*
            Eger bir test sirasinda
            birden fazla window aciliyorsa ve gorevde bu window'lar arasinda gecis varsa
            acilan her yeni window'un windowHandleDegerini alip kaydetmeliyiz.

            daha onceden acilan bir window'a donebilmek icin
            o window'un windowhandleDegerini girmemiz yeterli olur
         */

        // Testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");
        // url'i ve windowHande degerini yazdirin
        System.out.println("anasayfa url : "+ driver.getCurrentUrl());
        System.out.println("anasayfa whd : "+driver.getWindowHandle());

        String testotomasyonuWhd = driver.getWindowHandle();

        ReusableMethods.bekle(3);


        // Yeni bir tab acarak wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");

        // url'i ve windowHande degerini yazdirin
        System.out.println("wisequarter url : "+ driver.getCurrentUrl());
        System.out.println("wisequarter whd : "+driver.getWindowHandle());

        String wisequarterWhd = driver.getWindowHandle();

        ReusableMethods.bekle(3);


        // yeni bir window acarak youtube anasayfaya gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");

        // url'i ve windowHande degerini yazdirin
        System.out.println("youtube url : "+ driver.getCurrentUrl());
        System.out.println("youtube whd : "+driver.getWindowHandle());

        String youtubeWhd = driver.getWindowHandle();

        ReusableMethods.bekle(3);

        System.out.println(driver.getWindowHandles());

        // testotomasyonu'nun acik oldugu window'a donun
        driver.switchTo().window(testotomasyonuWhd);

        // url'in "testotomasyonu" icerdigini test edin

        String expectedurlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedurlIcerik));

        ReusableMethods.bekle(3);



        // wisequarter'in acik oldugu window'a gecis yapin
        driver.switchTo().window(wisequarterWhd);

        // url'in "wisequarter" icerdigini test edin

        expectedurlIcerik = "wisequarter";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedurlIcerik));

        ReusableMethods.bekle(3);


        // youtube'un acik oldugu window'a gecis yapin
        driver.switchTo().window(youtubeWhd);

        // url'in "youtube" icerdigini test edin

        expectedurlIcerik = "youtube";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedurlIcerik));

        ReusableMethods.bekle(3);



    }
}
