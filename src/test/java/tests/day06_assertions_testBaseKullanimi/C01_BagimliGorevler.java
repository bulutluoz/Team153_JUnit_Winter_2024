package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_BagimliGorevler {

    /*
        8- bu class'daki gorevler incelenirse
           her @Test method'undan sonra driver'in KAPANMAMASI gerektigi anlasiliyor

           driver'in class calismaya basladigi ilk anda olusturulmasi
           ve tum @Test method'lari calistirilip bittikten sonra kapatilmasi gereklidir

           @BeforeAll ==> hicbir @Test method'u calismadan once 1 kere calisir
           @AfterAll ==> tum @Test method'lari calisip bittikten sonra 1 kez calisir
        9- @BeforeAll ve @AfterAll notasyonu kullanan method'larin
           MUTLAKA static olmasi gerekir
     */

    // 3 farkli test method'u olusturup asagidaki gorevleri tamamlayin
    // 1- testotomasyonu anasayfaya gidip, url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, acilan sayfadaki urun isminde
    //    case sensitive olmadan "phone" bulundugunu test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("setup calisti");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("teardown calisti");
        driver.quit();
    }


    @Test
    public void test01(){
        // 1- testotomasyonu anasayfaya gidip,
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        } else System.out.println("Url testi FAILED");

    }

    @Test
    public void test02(){
        // 2- phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        if (actualSonucSayisi>0){
            System.out.println("Urun bulma testi PASSED");
        } else System.out.println("Urun bulma testi FAILED");

    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayip,
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();

        // acilan sayfadaki urun isminde
        // case sensitive olmadan "phone" bulundugunu test edin

        WebElement urunisimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = urunisimElementi.getText()
                                                .toLowerCase();

        if (actualUrunIsmi.contains(expectedIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");

    }

}
