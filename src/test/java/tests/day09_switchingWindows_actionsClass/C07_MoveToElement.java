package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_MoveToElement extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//a[.='Kids Wear'])[3]"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.moveToElement(kidsWearElementi).perform();

        //3- “Boys” linkine basin
        driver.findElement(By.linkText("Boys")).click();

        //4- Acilan sayfadaki ilk urunu tiklayin

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"))
                                        .getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        ReusableMethods.bekle(2);


    }
}
