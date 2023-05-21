package utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String generateName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String[] generateUrls() {
        Faker faker = new Faker();
        return new String[]{faker.internet().url(), faker.internet().url(), faker.internet().url()};
    }
}
