package tests.day14_getScreenshot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_JavascriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // isitme kaybi checkbox gorunecek kadar asagi inin

        // 1.adim : bir JavascriptExecutor objesi olusturun,
        //          deger olarak driver'i atayin ve cast edin
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // 2.adim : kullanmak istediginiz webElement'i locate edip kaydedin
        WebElement isitmeKaybiCheckbox = driver.findElement(By.id("hastalikCheck5"));


        // 3.adim : jse objesi ile executeScript() kullanin
        //jse.executeScript("arguments[0].scrollIntoView(true);", isitmeKaybiCheckbox);

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",isitmeKaybiCheckbox);

        ReusableMethods.bekle(10);
        isitmeKaybiCheckbox.click();



        // jse kullanarak isitme kaybi checkbox'i isaretleyin



        // javascript Alert kullanarak "JUnit BITTTIIIII" yazdirin


        ReusableMethods.bekle(4);

    }
}
