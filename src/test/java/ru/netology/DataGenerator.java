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
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().cellPhone());
        }

        public static String generateFirstDate() {
            LocalDate now = LocalDate.now().plusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return now.format(formatter);
        }

        public static String generateSecondDate() {
            LocalDate now = LocalDate.now().plusDays(7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return now.format(formatter);
        }

        public static String generateCity() {
            String[] CityList = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный", "Чебоксары", "Края", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда", "Воронеж", "Иваново", "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан", "Москва", "Красногорск", "Мурманск", "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Севастополь", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард"};
            int city = (int) Math.floor(Math.random() * CityList.length);
            return CityList[city];
        }
    }
}


