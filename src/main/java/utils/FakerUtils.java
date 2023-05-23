package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class FakerUtils {

    private static final Faker faker = new Faker();
    private static final int MAX_PHOTO_URLS = 10;
    private static final Random random = new Random();

    public static String generateName() {
        return faker.name().firstName();
    }

    public static String[] generateUrls() {
        int photoUrlsSize = random.nextInt(MAX_PHOTO_URLS) + 1;
        String[] photoUrls = new String[photoUrlsSize];
        for (int i = 0; i < photoUrls.length; i++) {
            photoUrls[i] = faker.internet().url();
        }
        return photoUrls;
    }
}
