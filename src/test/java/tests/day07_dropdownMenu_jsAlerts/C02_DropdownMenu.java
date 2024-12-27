package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_DropdownMenu extends TestBase_Each {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        ReusableMethods.bekle(1);

        WebElement dropdownMenuElementi = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownMenuElementi);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);

        //4.Tüm dropdown değerleri(value) yazdırın

            // 1.yontem (sadece yazdirmak istendiginde kullanilabilir)
        System.out.println(dropdownMenuElementi.getText());
        /*
                Please select an option
                Option 1
                Option 2
         */

            // 2.yontem (sadece yazdirmak degil, testler de yapmak istersek tercih edilir)
        List<String> optionYazilariList = ReusableMethods.stringListeDonustur(  select.getOptions()  );

        System.out.println("Liste olarak options : " + optionYazilariList);
        // Liste olarak options : [Please select an option, Option 1, Option 2]

        ReusableMethods.bekle(1);

        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedBoyut = 4;
        int actualBoyut = optionYazilariList.size();

        Assertions.assertEquals(expectedBoyut,actualBoyut);

        //Expected :4
        //Actual   :3


    }
}
