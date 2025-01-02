package tests.day10_keyboardActions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_FakeBilgilerleFormDoldurma extends TestBase_Each {

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
        Faker faker = new Faker();
        ReusableMethods.bekle(1);
        String fakePassword = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword).perform();

        ReusableMethods.bekle(2);
        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin

        // kaydi olusturunca, bizi otomatik olarak login sayfasina yonlendiriyor
        // kaydin olustugunu test etmek icin kullandigimiz bilgilerle login olalim
        ReusableMethods.bekle(1);

        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));

        actions.click(emailKutusu)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword).perform();

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
