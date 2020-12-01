package ru.netology;

import org.junit.jupiter.api.BeforeEach;

import java.time.format.DateTimeFormatter;

public class CardDeliveryNewDateTest {
    private MeetingDate meetingDate = DataGenerator.Registration.generate();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @BeforeEach
    void setUp () {
        open("http://localhost:9999");
    }

}
