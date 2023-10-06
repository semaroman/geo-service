package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceImplMock extends LocalizationServiceImpl {

    @Override

    public String locale(Country country) {
        switch (country) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }
}