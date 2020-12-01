package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static MeetingDate generate() {
            Faker faker = new Faker(new Locale("ru"));

            return new MeetingDate(
                    faker.address().city(),
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().cellPhone());

        }

        public static String generateFirstDate() {
            LocalDate now = LocalDate.now().plusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            return now.format(formatter);
        }

        public static String generateSecondDate() {
            LocalDate now = LocalDate.now().plusDays(10);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            return now.format(formatter);
        }
    }
}


