package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplMockTest {

    @Test
    void byIpMoscowTest() {
        GeoServiceImplMock geoServiceImpl = new GeoServiceImplMock();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actual = geoServiceImpl.byIp(GeoServiceImpl.MOSCOW_IP);
        Assertions.assertEquals(expected, actual);
    }
}