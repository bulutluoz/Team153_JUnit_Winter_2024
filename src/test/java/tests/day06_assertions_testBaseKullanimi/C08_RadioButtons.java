package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class C08_RadioButtons extends TestBase_All {

    @Test
    public void radioButtonTesti(){

        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. direk buton’dan size uygun olani secin
        erkekRadioButton.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }


    @Test
    public void yazidanRadioButtonTesti(){

        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. yazidan size uygun olani secin
        driver.findElement(By.xpath("//*[@for='inlineRadio2']"))
                .click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }
}
