package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C05_Assertions {


    @Test
    public void hastaliktesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // sayfaya ilk gittigimizde
        // istenen checkbox'lar gorunmuyorsa
        // asagidaki 3 satir kodu kullanabiliriz
//        Actions actions = new Actions(driver);
//        Thread.sleep(1000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement carpintiCheckbox = driver.findElement(By.id("gridCheck4"));
        WebElement sirtAgrisiCheckbox = driver.findElement(By.id("gridCheck5"));

        carpintiCheckbox.click();
        sirtAgrisiCheckbox.click();


        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assertions.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assertions.assertTrue(carpintiCheckbox.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili
        //     olmadigini test edin


        driver.quit();

    }
}
