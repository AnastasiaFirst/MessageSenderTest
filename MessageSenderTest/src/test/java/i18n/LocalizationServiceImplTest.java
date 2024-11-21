package i18n;

import com.example.SpringBootApp.entity.Country;
import com.example.SpringBootApp.i18n.LocalizationServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void locale() {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String result = service.locale(Country.RUSSIA);
        assertEquals(result, "Добро пожаловать");
    }
}