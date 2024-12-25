package tests.day05_jUnit_annotations;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_OrtakIslemleriMethodlastirma {
    /*
        5- Java OOP consept ayni kodlari tekrar tekrar yazmak yerine
           method'lastirmamizi tavsiye eder
           Biz de baslangictaki driver edinme adimlarini
           ve sondaki kapatmayi ayri bir method olarak kullanabiliriz
     */
    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown(){
        driver.quit();
    }

    @Test
    public void testotomasyonuTesti() throws InterruptedException {
        setup();
        // 1- testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // ve url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Testi PASSED");
        } else System.out.println("Testotomasyonu Testi FAILED");

        Thread.sleep(1000);
        teardown();
    }

    // @Disabled  Gecici olarak bu method'un kullanilmamasini istedigimizde
    @Test
    public void youtubeTesti() throws InterruptedException {
        setup();
        // 2- youtube ana sayfaya gidin ve
        driver.get("https://www.youtube.com");

        // Title'in YouTube oldugunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Youtube testi PASSED");
        } else System.out.println("Youtube testi FAILED");

        Thread.sleep(1000);
        teardown();
    }

    @Test
    public void wisequarterTesti() throws InterruptedException {
        setup();
        // 3- wisequarter anasayfaya gidin ve
        driver.get("https://www.wisequarter.com");

        // Title'in case sensitive olmadan wisequarter icerdigini test edin

        String expectedTitleIcerik = "wisequarter";
        String actualTitle = driver.getTitle().toLowerCase();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

        Thread.sleep(1000);
        teardown();
    }
}
