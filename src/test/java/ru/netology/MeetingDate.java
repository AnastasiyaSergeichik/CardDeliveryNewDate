package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeetingDate {
    private final String city;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
}
