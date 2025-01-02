package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C08_DosyaYuklemeTesti extends TestBase_Each {

    /*
        Bir websayfasina gidip
        o sayfaya yuklemek icin dosyaSec butonuna bastigimizda
        otomatik olarak bilgisayarimizdaki klasor yapisi aciliyor
        ve bizden o klasor yapisindan
        yuklemek istedigimiz dosyuayi secmemiz isteniyor


        ANCAAAKKKK selenium bilgisayarimizdaki dosyalara erisemez
        secim icin selenium ozel bir yontem gelistirmis
        dosya secmek icin
        ddosyaSec butonunu locate edip
        sendkeys ile dosya yolunu gondermemiz yeterli olur

        ancak bu dosya yolu absolute path
        yani bilgisayardan baslayan tum yol olmali

        /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team153_JUnit
        /
        src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt





     */

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //day10 package'i altindaki deneme dosyasini secelim.
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.dir") + "/"
                +"src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();


        //“File Uploaded!” textinin goruntulendigini test edelim.

        String actualYazi = driver.findElement(By.tagName("h3")).getText();
        String expectedYazi = "File Uploaded!";

        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(1);



    }
}
