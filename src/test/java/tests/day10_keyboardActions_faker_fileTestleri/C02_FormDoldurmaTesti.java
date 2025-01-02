package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_FormDoldurmaTesti extends TestBase_Each {

    @Test
    public void formDoldurmaTesti(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(firstnameKutusu)
                .sendKeys("Yigit")
                .sendKeys(Keys.TAB)
                .sendKeys("Onal")
                .sendKeys(Keys.TAB)
                .sendKeys("yigit@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin

        // kaydi olusturunca, bizi otomatik olarak login sayfasina yonlendiriyor
        // kaydin olustugunu test etmek icin kullandigimiz bilgilerle login olalim
        ReusableMethods.bekle(1);

        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));

        actions.click(emailKutusu)
                .sendKeys("yigit@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // login olabildigimizi test etmek icin
        // logout butonunun gorunur olmasini kontrol edelim
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        ReusableMethods.bekle(3);
        // logout olun
        logoutButonu.click();
    }
}
