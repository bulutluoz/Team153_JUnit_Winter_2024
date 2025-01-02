package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void test01(){

        // day10 package'i altinda deneme.txt diye bir dosya bulundugunu test edin

        // Selenium WebDriver objesi ile kullanilir
        // yani web sayfalari ile calisir
        // ancak fiziki olarak bilgisayarimizda bulunan bir dosyaya erismek
        // ve varligini test etmek icin Java'dan yardim alacagiz

        // Java'nin bir dosyaya ulasabilmesi icin
        // dosya yoluna ihtiyacimiz var

        String dosyaYolu = "src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";

        System.out.println(  Files.exists(Paths.get(dosyaYolu))  ); // true


        String yanlisDosyaYolu = "src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme1.txt";

        System.out.println(Files.exists(Paths.get(yanlisDosyaYolu))); // false


        // day10 package'i altinda deneme.txt diye bir dosya bulundugunu test edin
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        // deneme.txt dosyasini downloads klasorune kopyalayin
        // ve downloads klasorunde deneme.txt dosyasinin varoldugunu test edin

        String dowloadsDosyayolu= "/Users/ahmetbulutluoz/Downloads/deneme.txt";

        Assertions.assertTrue(   Files.exists(Paths.get(dowloadsDosyayolu))    );
    }
}
