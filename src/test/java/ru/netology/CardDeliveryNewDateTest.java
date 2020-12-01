package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

import static org.openqa.selenium.By.cssSelector;

public class CardDeliveryNewDateTest {
    private SelenideElement form;
    private MeetingDate meetingDate;


    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
        form = $("[action]");
        meetingDate = DataGenerator.Registration.generate();
    }

    @Test
    void shouldSubmitRequest() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
        $(".notification_status_ok").shouldBe(exist);
    }

    @Test
    void shouldSubmitRequestNewDate() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$("[data-test-id=agreement]").click();
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Успешно")).waitUntil(visible, 15000);
        $(".button__text").click();
        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).waitUntil(visible, 15000);
        form.$("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateSecondDate());
        $(cssSelector(".notification_status_error .button")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
        $(".notification_status_ok").shouldBe(exist);
    }

    @Test
    void shouldSubmitRequestWithoutCity() {
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldSubmitRequestInvalidCity() {
        form.$("[data-test-id=city] input").setValue("Тольятти");
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void shouldSubmitRequestWithoutName() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldSubmitInvalidName() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        $("[name=name]").setValue("Ivan Petrov");
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldSubmitRequestWithoutPhone() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldSubmitInvalidPhone() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=phone] input").setValue("7927000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldSubmitRequestWithoutCheckbox() {
        form.$("[data-test-id=city] input").setValue(meetingDate.getCity());
        form.$("[data-test-id=date] input").setValue(DataGenerator.Registration.generateFirstDate());
        form.$("[data-test-id=name] input").setValue(meetingDate.getFirstName() + " " + meetingDate.getLastName());
        form.$("[data-test-id=phone] input").setValue("+7" + meetingDate.getPhoneNumber());
        form.$(".button").click();
        $(".input_invalid .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных"));
    }
}

