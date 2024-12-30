package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_BasicAuthentication extends TestBase_Each {

    @Test
    public void test01(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower


        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basicAuthYaziElementi = driver.findElement(By.tagName("h1"));

        String expectedyazi = "Basic Auth";
        String actualYazi = basicAuthYaziElementi.getText();

        Assertions.assertEquals(expectedyazi,actualYazi);


        ReusableMethods.bekle(1);

    }
}
