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

public class C01_ExplicitWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    WebDriver driver;

    @Test
    public void implictlyWaitTesti() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textboxElementi.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();


        // implicitly wait 2 islem icin bekler
        // 1- sayfanin yuklenmesi
        // 2- webElement'in locate edilebilmesi
        // bu gorevde sayfa zaten yuklu, textbox da zaten locate edildi
        // bu durumda implicitly wait bekleme yapmaz, hemen assertion'a gecer
        // ama enable olmasi icin zamana ihtiyac oldugundan assertion failed olur
        // bu gorevin tamamlanabilmesi icin explicitly wait veya Thread.sleep() kullanmak zorundayiz

        Thread.sleep(3000);
        // bu zamani ayarlarken
        // hem gorevin yerine getirilmesini
        // hem de fazladan bekleme yapilmamasini dikkate alacak
        // optimum cozumu bulmaya gayret etmeliyiz

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue( textboxElementi.isEnabled()  );

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi =
                driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        //                                                //*[.="It's enabled!"]

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        driver.quit();
    }

    @Test
    public void explictlyWaitTesti(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textboxElementi.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();

        // explicit wait icin 3 adim kullanacagiz
        //1.adim: bir WebDriverWait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(120));

        //2.adim: wait ile kullanilacak elementi locate etmek mumkunse, locate edip kaydedin
        //       bu gorevde textbox'i kullanacagiz ve onu zaten locate edip kaydettik


        //3.adim: wait objesine hangi islem icin bekleyecegini tanimlayin
        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue( textboxElementi.isEnabled()  );

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi =
                driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        driver.quit();
    }


}
