package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
    LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
    MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
    Map<String, String> headers = new HashMap<>();

    @Test
    void sendTestRussian() {
        Mockito.when(geoServiceImpl.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.168.5.251");
        String expected = "Добро пожаловать";
        String actual = messageSenderImpl.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sendTestEnglish() {
        Mockito.when(geoServiceImpl.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("New York", Country.USA, "10th Avenue", 32));
        Mockito.when(localizationServiceImpl.locale(Country.USA))
                .thenReturn("Welcome");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.168.5.251");
        String expected = "Welcome";
        String actual = messageSenderImpl.send(headers);
        Assertions.assertEquals(expected, actual);
    }
}