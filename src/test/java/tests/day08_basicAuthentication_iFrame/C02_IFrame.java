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

        // driver'i bir iFrame'e gecis yaptirdigimizda
        // biz tekrar driver'i anasayfaya dondurmedikce
        // driver iframe'de kalir

        //driver.switchTo().parentFrame(); // ic ice iframe'ler varsa bir ust iframe'e cikar
        driver.switchTo().defaultContent(); // ic ice iframe'ler varsa anasayfaya doner


        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[.='Here are some products.']"));

        Assertions.assertTrue(hereAreYaziElementi.isDisplayed());


        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin

        // once fashion iFrame'e gecis yapalim
        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[.='Fashion']"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        //6- Fashion bolumundeki ilk urun isminde "Men Slim Fit" gectigini test edin
        WebElement fashionIlkUrun = driver.findElement(By.id("men-slim-shirt"));

        String expectedIsimIcerik = "Men Slim Fit";
        String actualUrunIsmi = fashionIlkUrun.getText();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        ReusableMethods.bekle(1);
    }
}
