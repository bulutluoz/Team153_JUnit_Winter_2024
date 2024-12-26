package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C03_AssertionMethodlari {

    String str1 = "Java candir";
    String s = "Java";
    String t = "Hava";
    String k = "java";

    @Test
    public  void test01() {

        // str1'in "Java" icerdigini test edin
        Assertions.assertTrue(str1.contains("Java"));

        // str1'in "Ali" icermedigini test edin
        Assertions.assertFalse(str1.contains("Ali"));

        if (! str1.contains("Ali")){
            // if kullandigimizda ! kullanacagimiz durumlar icin
            // assertFalse() uygun olur
        }


        // s'in degerinin "Java" oldugunu test edin
        Assertions.assertEquals("Java",s);

        // ayni assertion'i assertTrue() ile de yapabiliriz
        Assertions.assertTrue(s.equals("Java"));



        // t'nin degerinin "Tava" olmadigini test edin
        Assertions.assertNotEquals(t,"Tava");

        // ayni assertion'i assertfalse() ile de yapabiliriz
        Assertions.assertFalse(t.equals("Tava"));


    }

    @Test
    public void test02(){

        // s'in degerinin k ile ayni oldugunu test edin
        Assertions.assertEquals(s,k);
        //Expected :Java
        //Actual   :java

        // aynisini assertTrue ile de yapabiliriz
        //Assertions.assertTrue( s.equals(k)  );
        //Expected :true
        //Actual   :false


    }

}
