package tests.day08_basicAuthentication_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_IFrame extends TestBase_Each {

    @Test
    public void iFrameTest(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // WebSayfasini inceledigimizde
        // Elektronics Products yazisinin bir iframe icerisinde oldugunu gorduk
        // ONCE bu iframe'i locate edip kaydedip, iframe'e gecis yapmaliyiz
        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(electronicsIFrame);
        ReusableMethods.bekle(1);

        WebElement electronicsText= driver.findElement(By.xpath("//h2[.='Electronics Products']"));
        Assertions.assertTrue(electronicsText.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        String expectedYazi="DELL Core I3 11th Gen";
        WebElement dellPC = driver.findElement(By.xpath("//*[.='DELL Core I3 11th Gen ']"));

        Assertions.assertEquals(expectedYazi,dellPC.getText());

        //4- ‘Here are some products’ yazisinin gorunur olduğunu test edin
        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        //6- Fashion bolumundeki ilk urunu tiklayin
        //   ve ilk urun isminde "Men Slim Fit" gectigini test edin

        ReusableMethods.bekle(3);
    }
}
