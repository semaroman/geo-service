package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplMockTest {
    GeoServiceImplMock geoServiceImpl = new GeoServiceImplMock();

    @Test
    void byIpTestRussia() {
        Location RUS = geoServiceImpl.byIp("172.168.5.251");
        Assertions.assertEquals(Country.RUSSIA, RUS.getCountry());
    }

    @Test
    void byIpTestUsa() {
        Location US = geoServiceImpl.byIp("96.168.5.251");
        Assertions.assertEquals(Country.USA, US.getCountry());
    }
}