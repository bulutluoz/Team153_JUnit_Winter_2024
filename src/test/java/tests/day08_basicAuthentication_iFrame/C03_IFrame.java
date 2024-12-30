package tests.day08_basicAuthentication_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C03_IFrame extends TestBase_Each {

    @Test
    public void test01(){

        //https://demoqa.com/frames sayfasina gidin
        driver.get("https://demoqa.com/frames");


        // "This is a sample page" yazisinin gorunur oldugunu test edin

        WebElement samplePageIFrame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(samplePageIFrame);


        WebElement thisIsYaziElementi = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));

        Assertions.assertTrue(thisIsYaziElementi.isDisplayed());

        // Frames yazisinin gorunur oldugunu test edin

        // Frames yazisi anasayfada oldugundan
        // once gecis yaptigimiz iframe'den anasayfaya donmeliyiz

        driver.switchTo().defaultContent();

        WebElement framesYaziElementi = driver.findElement(By.xpath("//h1[.='Frames']"));

        Assertions.assertTrue(framesYaziElementi.isDisplayed());



    }
}
