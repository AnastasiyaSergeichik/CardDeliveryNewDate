package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MeetingDate {
    private final String city;
    private final LocalDate FirstMeetingDate;
    private final String fullName;
    private final String phoneNumber;
    private final LocalDate dateSecondMeeting;
}
