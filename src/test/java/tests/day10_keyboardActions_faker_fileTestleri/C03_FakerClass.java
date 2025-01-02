package tests.day10_keyboardActions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClass {

    @Test
    public void test01(){

        // fake datalar uretmek icin Faker Class'daki method'lari kullaniriz
        // Faker Class'i kullanabilmek icin
        // dependency'sini pom.xml'e ekleyelim

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); // Lacy
        System.out.println(faker.name().lastName()); // Considine
        System.out.println(faker.name().nameWithMiddle()); // Brock Wunsch Sauer
        System.out.println(faker.name().fullName()); // Jasmin Champlin Sr.


        System.out.println(faker.internet().emailAddress()); // vickie.friesen@gmail.com
        System.out.println(faker.internet().password()); // freos1u2

        System.out.println(faker.internet().url()); // www.renato-krajcik.com

        System.out.println(faker.address().cityName());
        System.out.println(faker.address().streetName());
        System.out.println(faker.address().state()); // Maryland
        System.out.println(faker.address().country()); // Poland
        System.out.println(faker.address().fullAddress());
        // 827 Aimee Overpass, Haroldville, NY 61744-5089



    }
}
