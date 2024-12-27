package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme yapilamadi");
        }
    }

    public static List<String> stringListeDonustur( List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement each: webElementList){

            stringList.add(each.getText());
        }

        return stringList;
    }


}
