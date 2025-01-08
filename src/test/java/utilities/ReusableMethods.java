package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
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

    public static void tumSayfaScreenshot(WebDriver driver) {
        // dosya ismine eklemek icin tarih etiketi olusturalim



        // 1.adim TakesScreenshot objesi olusturun ve deger olarak driver'i atayip cast edin
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim : ekran goruntusunu kaydedecegimiz File'i olusturun
        //          parametre olarak kaydetmek istediginiz dosyanin, dosya yolunu girin
        File asilResim = new File("target/screenshots/tumSayfaScreenshot"+".jpg");

        // 3.adim : olusturdugumuz takeScreenshot objesi ile ekran goruntusunu alip
        //          gecici bir File'a kaydedelim
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asilResim dosyasina kopyalayin

        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }

    }

    public static void isimliTumSayfaScreenshot(WebDriver driver,String resimIsmi) {
        // 1.adim TakesScreenshot objesi olusturun ve deger olarak driver'i atayip cast edin
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim : ekran goruntusunu kaydedecegimiz File'i olusturun
        //          parametre olarak kaydetmek istediginiz dosyanin, dosya yolunu girin
        File asilResim = new File("target/screenshots/" + resimIsmi + ".jpg");

        // 3.adim : olusturdugumuz takeScreenshot objesi ile ekran goruntusunu alip
        //          gecici bir File'a kaydedelim
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asilResim dosyasina kopyalayin

        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }

    }

}
