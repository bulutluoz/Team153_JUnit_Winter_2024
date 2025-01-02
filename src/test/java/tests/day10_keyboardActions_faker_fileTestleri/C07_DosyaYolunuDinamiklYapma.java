package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyaYolunuDinamiklYapma {

    @Test
    public void test01(){

        // downloads klasorunde deneme.txt dosyasinin varoldugunu test edin

        // String dowloadsDosyayolu= "/Users/ahmetbulutluoz/Downloads/deneme.txt";

        // Bu dosya yolu ahmetbulutluoz'un bilgisayarinda calisir
        // ama baska bilgisayarda calismaz
        // cunku her bilgisayarin klasor yapisi birbirinden farklidir
        // AMACIMIZ dosyayolunu her bilgisayarda calisacak sekilde DINAMIK hale getirmek

        //    /Users/ahmetbulutluoz         /Downloads/deneme.txt
        //    C:\\Users\\arche              \\Downloads\\deneme.txt
        //    C:\Users\yusuf                \Downloads\deneme.txt
        //    C:\\Users\\SÜMEYRA            \\Downloads/deneme.txt

        // dosya yolunu dinamik yapabilmemiz icin
        // Java bize 2 konumu dinamik olarak alabilecegimiz hazir method vermistir

        // 1.konum : Bilgisayarimizin Ana dosya yolu (home path)

        String herkesteFarkliOlanKisim = System.getProperty("user.home");
        //       /Users/ahmetbulutluoz

        String herkesteAyniOlanKisim = "/Downloads/deneme.txt";

        String downloadsDenemeDosyaYolu = herkesteFarkliOlanKisim + herkesteAyniOlanKisim;

        Assertions.assertTrue(Files.exists(Paths.get(downloadsDenemeDosyaYolu)));



        // 2.konum : projemizin icinde oldugu klasorun dosya yolunu veren kod

        String herkesteFarkliOlanProjeDosyasiDosyaYolu = System.getProperty("user.dir");

        // benim bilgisayarimda proje dosya yolu :
        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team153_JUnit

        // projede calisan herkeste ortak olan dosya yolu
        //    src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt

        String herkesteAyniOlanProjedekiDenemeDosyaYolu = "src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";

        String projedekiDenemeDinamikDosyaYolu = herkesteFarkliOlanProjeDosyasiDosyaYolu + "/"
                                                    +herkesteAyniOlanProjedekiDenemeDosyaYolu;


        Assertions.assertTrue( Files.exists( Paths.get(projedekiDenemeDinamikDosyaYolu) ));


    }
}
