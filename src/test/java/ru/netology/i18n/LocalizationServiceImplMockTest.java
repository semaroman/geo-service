package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplMockTest {

    LocalizationServiceImplMock localizationServiceImpl = new LocalizationServiceImplMock();

    @Test
    void localeTestRussia() {
        String expected = "Добро пожаловать";
        String actual = localizationServiceImpl.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void localeTestDefault() {
        String expected = "Welcome";
        String actual = localizationServiceImpl.locale(Country.USA);
        Assertions.assertEquals(expected, actual);
    }
}