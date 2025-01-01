package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_KontrolsuzAcilanWindow extends TestBase_Each {

    /*
        Eger test calisirken
        KONTROLSUZ bir window acilirsa
        driver objesi eski window'da kalir

        driver'i yeni window'a gecirebilmek icin
        bizim yeni window'un windowhandleDegerini bulmamiz
        ve sonra driver.switchTo().window(yeniWindowWhd) yazarak
        driver'i yeni window'a gecirmemiz gerekir

        Yeni window'un windowhandleDegerini bulmak icin
        1- eski window'un whd'ini kaydederiz
        2- acik olan 2 window'un whd'lerini bir Set olarak kaydederiz
        3- bir for-each loop ile Set'deki whd'lerine bakip
           eskiWindowun whd'ine esit olmayani
           yeniSayfaWhd olarak kaydederiz.
     */


    @Test
    public void test01(){

        // https://testotomasyonu.com/discount  sayfasina gidin
        driver.get("https://testotomasyonu.com/discount");


        // url'i ve windowHande degerini yazdirin
        System.out.println("discount url : "+ driver.getCurrentUrl());
        System.out.println("discount whd : "+driver.getWindowHandle());
        ReusableMethods.bekle(3);

        // fashion bolumundeki ilk urunu tiklayin

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);
        driver.findElement(By.id("men-slim-shirt")).click();

        ReusableMethods.bekle(3);

        // url'i ve windowHande degerini yazdirin
        System.out.println("ilk urunu tikladiktan sonra url : "+ driver.getCurrentUrl());
        System.out.println("ilk urunu tikladiktan sonra whd : "+driver.getWindowHandle());


        // acik olan tum window'larin window handle degerlerini yazdirin
        System.out.println("Tum window'lari whd'leri : " + driver.getWindowHandles());

        ReusableMethods.bekle(20);


    }
}
