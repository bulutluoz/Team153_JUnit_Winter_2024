package tests.day11_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitWait {

    WebDriver driver;

    @Test
    public void implicitlyWaitTesti(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));

        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());

        driver.quit();
    }



    @Test
    public void explicitlyWaitTesti(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        // Yukardaki method'da bu islemi implicitlywait'in cozebildigini gorduk
        // normal hayatta bunun icin explicit wait kullanmaya gerek yok

        // 1.adim : WebDriverWait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        //2.adim: wait ile kullanilacak elementi locate etmek mumkunse, locate edip kaydedin
        //        Bu gorev bir onceki class'dan farkli
        //        onceki class'da kullanacagimiz webelement zaten gorunur durumdaydi
        //        Bu gorevde kullanacagimiz webElement'in  gorunur olmasi icin
        //        oncelikle beklememiz gerekiyor
        //        Eger boyle bir durumla karsilasirsaniz 2. ve 3. adimlari birlikte yapabiliriz
        //3.adim: wait objesine hangi islem icin bekleyecegini tanimlayin

        WebElement itsGoneYaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']"))
                .click();


        //5. It’s back mesajinin gorundugunu test edin

        //1.adim wait objesi yukarda olusturuldu

        // elementin gorunur olmasi ve locate edebilmemiz icin oncelikle beklememiz gerekiyor
        // 2. ve 3. adimi birlikte yapalim (locate ve bekleme)

        WebElement itsBackYaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());

        driver.quit();
    }



}
