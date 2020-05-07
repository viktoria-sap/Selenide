package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldRegisterForDelivery() {
        Calendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_YEAR, 5);
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Волгоград");
        $("[placeholder='Дата встречи']").setValue(String.valueOf(date));
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79680000000");
        $("span[class='checkbox__text']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
    }
}