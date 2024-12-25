package tests.day05_jUnit_annotations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeEach_AfterEach {

    /*
        6- driver olusturmak icin kullandigimiz setup() ve
           driver'i kapatmak icin kullandigimiz teardown() method'lari
           bagimsiz calismasi gereken method'lar degil
           @Test method'undan once ve sonra calismasi gereken ozel method'lardir

        7- Eger setup() her @Test method'undan once calismasini isterseniz
           @BeforeEach kullanabilirsiniz
           Ayni sekilde teardown() her @Test method'undan sonra
           otomatik olarak calismasini isterseniz @AfterEach kullanabilirsiniz
     */

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testotomasyonuTesti() throws InterruptedException {
        // 1- testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // ve url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Testi PASSED");
        } else System.out.println("Testotomasyonu Testi FAILED");

        Thread.sleep(1000);
    }

    @Test
    public void youtubeTesti() throws InterruptedException {
        // 2- youtube ana sayfaya gidin ve
        driver.get("https://www.youtube.com");

        // Title'in YouTube oldugunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Youtube testi PASSED");
        } else System.out.println("Youtube testi FAILED");

        Thread.sleep(1000);
    }

    @Test
    public void wisequarterTesti() throws InterruptedException {
        // 3- wisequarter anasayfaya gidin ve
        driver.get("https://www.wisequarter.com");

        // Title'in case sensitive olmadan wisequarter icerdigini test edin

        String expectedTitleIcerik = "wisequarter";
        String actualTitle = driver.getTitle().toLowerCase();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

        Thread.sleep(1000);
    }
}
