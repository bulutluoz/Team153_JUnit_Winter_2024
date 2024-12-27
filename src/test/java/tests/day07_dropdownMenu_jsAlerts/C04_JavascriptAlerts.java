package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_JavascriptAlerts extends TestBase_Each {

    //3 test method'u olusturup asagidaki gorevi tamamlayin



    @Test
    public void alertTesti(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[.='Click for JS Alert']"))
                .click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertyazisi  = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo()
                                            .alert()
                                            .getText();

        Assertions.assertEquals(expectedAlertyazisi,actualAlertYazisi);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo()
                .alert()
                .accept();
    }


    @Test
    public void alertConfirmTesti(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']"))
                .click();

        //	- Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.id("result"))
                                            .getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }


    @Test
    public void alertPromptTesti(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']"))
                .click();

        //	- Cikan prompt ekranina "Yusuf" yazdiralim
        driver.switchTo().alert().sendKeys("Yusuf");


        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Yusuf icerdigini test edelim

        String expectedSonucIcerik ="Yusuf";

        String actualSonucYazisi = driver.findElement(By.id("result"))
                                            .getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));
    }

}
