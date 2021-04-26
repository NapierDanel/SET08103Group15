import com.napier.sem.Country;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UnitTest {

    static Country wakanda;

    @BeforeAll
    static void init(){

        wakanda = new Country();
    }

    @Test
    @DisplayName("Creates a Country object, populates it then attempts to access it with exisiting methods")
    void testCountry(){

        wakanda.code = "WAK";
        wakanda.name = "Wakanda";
        wakanda.continent = "Africa";
        wakanda.region = "East Africa";

        assertEquals("Wakanda", wakanda.printCountry(wakanda));

    }

    @Test
    @DisplayName("Test country exceptions")
    void testCountyExceptions() {
        assertThrows(NullPointerException.class, () -> {
            wakanda.printCountry(null);
        });
    }
}
