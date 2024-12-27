package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_HtmlAlerts extends TestBase_Each {

    @Test
    public void htmlAlertTesti(){

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        ReusableMethods.bekle(1);

        // cookies cikarsa kabul edin
        driver.findElement(By.xpath("(//*[@*='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[2]"))
                .click();

        // Title'in YouTube oldugunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

    }
}
