package UserInterfaceTask.Utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class RandomUtils {
    private static final FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    private static final Faker faker = new Faker();

    public static String generateEmail() {
        return fakeValuesService.bothify("S????@##??.??");
    }

    public static String generatePassword() {
        return fakeValuesService.regexify("S[a-z1-9]{9}");
    }

    public static int generateRandomNumber(int start, int end) {
        return faker.number().numberBetween(start, end);
    }

}
