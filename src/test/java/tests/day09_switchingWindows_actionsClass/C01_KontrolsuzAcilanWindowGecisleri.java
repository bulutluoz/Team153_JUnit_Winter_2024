package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_KontrolsuzAcilanWindowGecisleri extends TestBase_Each {

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


        // eski window'un windowHandle degerini kaydedin
        String eskiWindowWhd = driver.getWindowHandle();

        // acik olan tum window'larin window handle degerlerini kaydedin
        Set<String> acikTumWindowlarinWhd = driver.getWindowHandles();


        // bir for-each loop ile Set'deki windowHandle degerlerini gozden gecirip
        // eskiWindowWhd'ine ESIT OLMAYANI
        // yeniWindowWhd'i olarak kaydedin

        String yeniWindowWhd = "";

        for (String eachWhd  :acikTumWindowlarinWhd){

            if ( !eachWhd.equals(eskiWindowWhd) ){
                yeniWindowWhd = eachWhd;
            }
        }

        System.out.println("eski Window Whd : " + eskiWindowWhd);
        System.out.println("yeni Window Whd : " + yeniWindowWhd);


        // yeni window'a gecis yapin
        driver.switchTo().window(yeniWindowWhd);

        // urun isminin "Fancy Blue Shirt and pant" oldugunu test edin
        WebElement urunisimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "Fancy Blue Shirt and pant";
        String actualUrunIsmi = urunisimElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        ReusableMethods.bekle(3);


    }
}
