package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {

    }

    @Data
    @RequiredArgsConstructor
    public static class UserInfo {
        private final String city;
        private final String name;
        private final String phone;
        private final String date;
        private final String dateRescheduling;
    }

    public static UserInfo getUserInfo() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Faker faker = new Faker(new Locale("ru"));
        return new UserInfo(faker.address().city(),
                faker.name().fullName(),
                faker.phoneNumber().phoneNumber(),
                LocalDate.now().plusDays(3).format(df),
                LocalDate.now().plusDays(6).format(df));
    }
}

