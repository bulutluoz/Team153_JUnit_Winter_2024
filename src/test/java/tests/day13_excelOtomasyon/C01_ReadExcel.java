package tests.day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/tests/day13_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1"); // excel deki sayfa ismini tam olarak yazmaliyiz
                                                      // buyuk-kucuk harf veya bosluk varsa bizde yazmaliyiz

        // workbook objesi bizim class'imizda olusturdugumuz bir objedir
        // ammma biz fiziki excel dosyasindaki tum bilgileri
        // fileInputStream sayesinde excel dosyasindan aldik
        // ve workbook objesine kaydettik
        // yani workbook objesi excel degil ama excel'in bire-bir kopyasi


        //- 1.satirdaki 2.hucreye gidelim ve yazdirin

        Row row1 = sayfa1.getRow(1);
        Cell hucre2 = row1.getCell(2);

        System.out.println("1.satirdaki 2.hucre : "+ hucre2); // Afganistan

        // Excel satir ve cell'leri index ile tutar
        // java'daki gibi index 0'dan baslar
        //- 1.satirdaki 2.hucreye gidelim ve yazdirin

        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)


        //- 1.satirdaki 2.hucreyi bir string degiskene atayin
        //  	ve degerinin “Başkent (İngilizce)” oldugunu test edin
        //- 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        //- Ulke sayisinin 190 oldugunu test edin
        //- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        //- Ingilizce ismi Netherland olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        //- Turkce baskent isimlerinde Ankara bulundugunu test edin
    }
}
