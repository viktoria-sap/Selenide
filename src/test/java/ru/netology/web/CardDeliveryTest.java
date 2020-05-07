package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldRegisterForDelivery() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Волгоград");
        $("[placeholder='Дата встречи']").setValue("11.05.2020");
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79680000000");
        $("span[class='checkbox__text']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
    }
}