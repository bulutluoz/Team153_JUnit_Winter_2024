package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static void titleIleWindowGecisi(WebDriver driver , String hedefWindowTitle){
        // 1- acik tum window'larin whd'lerini kaydedelim
        Set<String> acikTumWindowlarinWhdSeti = driver.getWindowHandles();

        // 2- gecmek istedigimiz window'un title'ini kaydedelim
        // String hedefWindowTitle = "New Window";
        // yukarda parametre olarak var

        // 3- set'deki herbir whd'inin ait oldugu window'a gecis yapip
        //    gectigimiz window'un title'i hedefTitle ile ayni ise
        //    o window'da kalalim

        for (String eachWhd : acikTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getTitle().equals(hedefWindowTitle)){
                break;
            }

        }
    }

    public static void urlIleWindowGecisi(WebDriver driver , String hedefWindowUrl){
        // 1- acik tum window'larin whd'lerini kaydedelim
        Set<String> acikTumWindowlarinWhdSeti = driver.getWindowHandles();

        // 2- gecmek istedigimiz window'un title'ini kaydedelim
        // String hedefWindowTitle = "New Window";
        // yukarda parametre olarak var

        // 3- set'deki herbir whd'inin ait oldugu window'a gecis yapip
        //    gectigimiz window'un title'i hedefTitle ile ayni ise
        //    o window'da kalalim

        for (String eachWhd : acikTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefWindowUrl)){
                break;
            }

        }
    }

}
