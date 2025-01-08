package tests.day14_getScreenshot_jsExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_PozitifLoginTesti extends TestBase_Each {

    @Test
    public void pozitifLoginTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // account linkine tiklayin
        driver.findElement(By.xpath("(//span[text()='Account'])[1]"))
                .click();

        // kullanici adi olarak wise@gmail.com
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("12345");

        // submit butonuna basin
        driver.findElement(By.id("submitlogin"))
                .click();

        // giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaScreenshot(driver);

        // logout butonuna basarak cikis yapin
        logoutButonu.click();


    }
}
