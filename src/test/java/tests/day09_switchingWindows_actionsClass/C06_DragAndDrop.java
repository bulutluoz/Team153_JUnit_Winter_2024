package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement acceptableElementi = driver.findElement(By.xpath("//div[@id='draggable2']"));
        WebElement dropHereKutuElementi = driver.findElement(By.xpath("//div[@id='droppable2']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptableElementi,dropHereKutuElementi)
                .perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedyazi = "Dropped!";
        String actualYazi = dropHereKutuElementi.getText();

        Assertions.assertEquals(expectedyazi,actualYazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        ReusableMethods.bekle(1);
        WebElement notAcceptableElementi = driver.findElement(By.xpath("//div[@id='draggable-nonvalid2']"));
        dropHereKutuElementi = driver.findElement(By.xpath("//div[@id='droppable2']"));

        actions.dragAndDrop(notAcceptableElementi,dropHereKutuElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        expectedyazi = "Drop Here";
        actualYazi = dropHereKutuElementi.getText();

        Assertions.assertEquals(expectedyazi,actualYazi);


    }
}
