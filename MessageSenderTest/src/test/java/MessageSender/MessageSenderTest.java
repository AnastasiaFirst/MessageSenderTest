package MessageSender;

import com.example.SpringBootApp.entity.Country;
import com.example.SpringBootApp.entity.Location;
import com.example.SpringBootApp.geo.GeoService;
import com.example.SpringBootApp.i18n.LocalizationService;
import com.example.SpringBootApp.sender.MessageSenderImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSenderTest {
    @Test
    void MessageSenderTestMockitoRus() {
        entity.Country country1 = entity.Country.RUSSIA;
        String ipRus = "172.0.32.11";
        entity.Location location = new entity.Location("Moscow", entity.Country.RUSSIA, "Lenina", 15);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(sender.MessageSenderImpl.IP_ADDRESS_HEADER, ipRus);

        i18n.LocalizationService localizationService = Mockito.mock(i18n.LocalizationService.class);
        Mockito.when(localizationService.locale(country1))
                .thenReturn("Добро пожаловать");

        geo.GeoService geoService = Mockito.mock(geo.GeoService.class);
        Mockito.when(geoService.byIp(ipRus))
                .thenReturn(location);

        sender.MessageSenderImpl messageSender = new sender.MessageSenderImpl(geoService, localizationService);
        String result = messageSender.send(headers);

        assertEquals("Добро пожаловать", result);
    }

    @Test
    void MessageSenderTestMockitoEn() {
        entity.Country country1 = entity.Country.USA;
        String ipEn = "96.44.183.149";
        entity.Location location = new entity.Location("New York", entity.Country.USA, "10th Avenue", 32);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(sender.MessageSenderImpl.IP_ADDRESS_HEADER, ipEn);

        i18n.LocalizationService localizationService = Mockito.mock(i18n.LocalizationService.class);
        Mockito.when(localizationService.locale(country1))
                .thenReturn("Welcome");

        geo.GeoService geoService = Mockito.mock(geo.GeoService.class);
        Mockito.when(geoService.byIp(ipEn))
                .thenReturn(location);

        sender.MessageSenderImpl messageSender = new sender.MessageSenderImpl(geoService, localizationService);
        String result = messageSender.send(headers);

        assertEquals("Welcome", result);
    }
}
