package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Meeting {
    private final String city;
    private final String phone;
}
