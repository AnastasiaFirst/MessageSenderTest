package geo;


import com.example.SpringBootApp.entity.Country;
import com.example.SpringBootApp.entity.Location;
import com.example.SpringBootApp.geo.GeoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @ParameterizedTest
    @CsvSource(value = {
            "172.0.32.11, Moscow, RUSSIA, Lenina, '15'",
            "96.44.183.149, New York, USA, 10th Avenue, '32'",
            "172.0.0.1, Moscow, RUSSIA,  , '0'",
            "172.0.32.11, Moscow, RUSSIA, Lenina, '15'",
            "96.44.183.149, New York, USA, 10th Avenue, '32'"
    })
    void testByIp(String ip, String city, Country country, String street, int builing) {
        try {
            GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
            int building = Integer.parseInt(String.valueOf(builing));
            Location location = geoServiceImpl.byIp(ip);

            assertEquals(city.toString(), location.getCity());
            assertEquals(country.toString(), String.valueOf(location.getCountry()));//location.getCountry());
            assertEquals(street.toString(), location.getStreet());
            assertEquals(building, location.getBuiling());
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении программы: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testByCoordinates() {
        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();

        // Ожидаем, что метод byCoordinates выбросит RuntimeException
        assertThrows(RuntimeException.class, () -> {
            geoServiceImpl.byCoordinates(55.7522, 37.6156);
        });
        }
}