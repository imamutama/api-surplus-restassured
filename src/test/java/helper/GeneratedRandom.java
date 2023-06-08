package helper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Random;

public class GeneratedRandom {
    static Faker faker = new Faker();

    public static String generatedTitle() {
        return faker.artist().name();
    }

    public static String generatedBody() {
        return faker.address().fullAddress();
    }

    public static int generatedId() {
        return Integer.parseInt(faker.number().digits(3));
    }

    @Test
    public void test() {
        System.out.println(generatedId());
    }

}
