package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_TitleIleWindowGecisi extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        // hedefTitle ile window gecisi

        ReusableMethods.titleIleWindowGecisi(driver,"New Window");

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        String expectedYeniWindowTitle = "New Window";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedYeniWindowTitle,actualTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String yeniWindowExpectedYazi = "New Window";

        String actualYeniWindowYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(yeniWindowExpectedYazi,actualYeniWindowYazi);

        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu test edin

        ReusableMethods.titleIleWindowGecisi(driver,"The Internet");

        String expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(2);


    }
}
