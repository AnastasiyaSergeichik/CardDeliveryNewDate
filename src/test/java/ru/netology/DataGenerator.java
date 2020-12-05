package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
            Faker faker = new Faker(new Locale("ru"));
        }

        public static Meeting generate() {
            Faker faker = new Faker(new Locale("ru"));

            return new Meeting(
                    faker.address().city(),
                    faker.phoneNumber().phoneNumber());
        }

        public static String generateDate(int days) {
            String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

        public static String generateInvalidCity() {
            Faker faker = new Faker(new Locale("en"));
            return faker.address().city();
        }

        public static String generateFullName() {
            Faker faker = new Faker(new Locale("ru"));
            return faker.name().firstName() + " " + faker.name().lastName();
        }

        public static String generateInvalidFullName() {
            Faker faker = new Faker(new Locale("en"));
            return faker.name().firstName() + " " + faker.name().lastName();
        }

        public static String generateInvalidPhone() {
            Random rand = new Random();
            List<String> phoneList = Arrays.asList("+34", "58585858585", "+5676");
            String phone = phoneList.get(rand.nextInt(phoneList.size()));

            return phone;
        }
    }
}

