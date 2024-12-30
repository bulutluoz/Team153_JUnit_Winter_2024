package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C04_WindowVsSayfa extends TestBase_Each {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");
        // url'i ve windowHande degerini yazdirin
        System.out.println("anasayfa url : "+ driver.getCurrentUrl());
        System.out.println("anasayfa whd : "+driver.getWindowHandle());

        // electronics linkine tiklayin
        driver.findElement(By.xpath("(//*[.='Electronics'])[5]")).click();
        // url'i ve windowHandle degerini yazdirin
        System.out.println("electronics url : "+ driver.getCurrentUrl());
        System.out.println("electronics whd : "+driver.getWindowHandle());

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box mb-2 pb-1'])[1]")).click();

        // url'i ve windowHandle degerini yazdirin
        System.out.println("ilk urun url : "+ driver.getCurrentUrl());
        System.out.println("ilk urun whd : "+driver.getWindowHandle());

        // acount butonuna basin
        driver.findElement(By.xpath("(//*[.='Account'])[1]")).click();

        // url'i ve windowHandle degerini yazdirin
        System.out.println("acount url : "+ driver.getCurrentUrl());
        System.out.println("acount whd : "+driver.getWindowHandle());

    }
}
