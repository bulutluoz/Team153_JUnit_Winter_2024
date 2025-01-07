package tests.day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Gerekli ayarlamalari yapip, ulkeler excel'indeki sayfa2'ye gidin

        String dosyaYolu = "src/test/java/tests/day13_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        // Kullanilan son satirin 20.satir oldugunu test edin
        int sonKullanilanSatirIndexi = sayfa2.getLastRowNum();

        int expectedSonSatirNo = 20;
        int actualSonSatirNo = sonKullanilanSatirIndexi+1;

        Assertions.assertEquals(expectedSonSatirNo,actualSonSatirNo);

        // Kullanilan (bos birakilmayan) satir sayisinin 8 oldugunu test edin

        int expectedKullanilanSatirSayisi = 8;
        int actualKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);


        // 17.satir 5.hucredeki bilgiyi yazdirin
        // kullanilan bir satirdaki, kullanilmayan hucre isteniyor

        System.out.println(sayfa2.getRow(16).getCell(4)); // null


        // 5.satir 3.hucredeki bilgiyi yazdirin
        // Kullanilmayan bir satirdaki hucre isteniyor

        // System.out.println(sayfa2.getRow(4).getCell(2)); // NullPointerException

        System.out.println(sayfa2.getRow(4)); // null

    }
}
