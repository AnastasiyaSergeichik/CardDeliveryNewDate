package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static MeetingDate generate()  {
     Faker faker = new Faker(new Locale("ru"));
            LocalDate FirstMeetingDate = LocalDate.now().plusDays(3);
            LocalDate SecondMeetingDate = LocalDate.now().plusDays(7);

            return new MeetingDate (
                    faker.address().city(),
                    FirstMeetingDate,
                    faker.name().fullName(),
                    faker.phoneNumber().cellPhone(),
                    SecondMeetingDate);
        }
    }
}
