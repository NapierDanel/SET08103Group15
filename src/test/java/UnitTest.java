import com.napier.sem.Country;

import com.napier.sem.UtilityClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


public class UnitTest {

    static Country wakanda;
    static UtilityClass utilityClass;

    @BeforeAll
    static void init(){
        utilityClass = new UtilityClass();
        wakanda = new Country();
    }

    @Test
    @DisplayName("Test if the method return false if no ResultSet is inserted")
    void testCSV(){
        assertFalse(utilityClass.exportCSV("foo", null));
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
