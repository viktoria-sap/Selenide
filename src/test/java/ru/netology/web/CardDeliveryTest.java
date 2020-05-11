package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldRegisterForDelivery1() {
        Calendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_YEAR, 5);
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        String str = format1.format(date.getTime());
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Волгоград");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79680000000");
        $("span[class='checkbox__text']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
    }
}
//    public void setDatepicker(String cssCelector, String date) {
//        $("table[class='calendar__layout']").isDisplayed();
//        JavascriptExecutor.class.cast(???).executeScript(
//                String.format("$('%s').datepicker('setDate', '%s')", cssCelector, date);
//    }
//
//    @Test
//    void shouldRegisterForDelivery2() {
//        Calendar date = new GregorianCalendar();
//        date.add(Calendar.DAY_OF_YEAR, 7);
//        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
//        String str = format1.format(date.getTime());
//
//        open("http://localhost:9999");
//        $("[placeholder='Город']").setValue("Вол");
//        $("div[class='popup__inner']").selectOption("Волгоград");
//        $("[placeholder='Дата встречи']");
//        setDatepicker("table[class='calendar__layout']", str);
//        $("[name='name']").setValue("Иванов Иван");
//        $("[name='phone']").setValue("+79680000000");
//        $("span[class='checkbox__text']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        $(byText("Успешно!")).waitUntil(visible, 15000);
//    }
//}