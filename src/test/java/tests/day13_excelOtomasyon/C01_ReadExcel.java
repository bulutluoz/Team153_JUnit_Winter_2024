package tests.day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
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

        String actualData = sayfa1.getRow(0).getCell(1).getStringCellValue();

        //  	ve degerinin “Başkent (İngilizce)” oldugunu test edin

        String expectedData = "Başkent (İngilizce)";

        Assertions.assertEquals(expectedData,actualData);

        //- 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin

        expectedData = "Kabil";
        actualData = sayfa1.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expectedData,actualData);

        //- Ulke sayisinin 190 oldugunu test edin

        int expectedUlkeSayisi = 190 ;
        int actualUlkeSayisi = sayfa1.getLastRowNum() + 1 -1 ;

        // getLastRowNum() kullanilan son satirin index'ini verir
        // ulke sayisini bulurken index + 1 yapmamiz lazim
        // ancak en basta baslik satiri oldugu icin
        // kullanilan satir sayisindan 1 cikarmamiz gerekir

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        //- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKullanilanSatirSayisi = 191;
        int actualKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);

        //- Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1
                                                        .getRow(i)
                                                        .getCell(0)
                                                        .getStringCellValue();

            if (satirdakiIngilizceUlkeIsmi.equals("Netherlands")){

                String satirdakiTurkceBaskentIsmi = sayfa1.getRow(i)
                                                            .getCell(3)
                                                            .getStringCellValue();

                Assertions.assertEquals(satirdakiTurkceBaskentIsmi,"Amsterdam");
                break;
            }
        }


        //- Turkce baskent isimlerinde Ankara bulundugunu test edin

        boolean ankaraVarMi = false;

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiTurkceBaskentIsmi = sayfa1.getRow(i)
                                                        .getCell(3)
                                                        .getStringCellValue();

            if (satirdakiTurkceBaskentIsmi.equalsIgnoreCase("Ankara")){
                ankaraVarMi = true;
                break;
            }

        }

        Assertions.assertTrue(ankaraVarMi);




    }
}
