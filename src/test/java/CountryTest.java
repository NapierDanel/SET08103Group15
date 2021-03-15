import com.napier.sem.Country;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CountryTest {

    static Country county;

    @BeforeAll
    static void init(){
        county = new Country();
    }

    @Test
    @DisplayName("Provides all the countries in the world organised by largest population to smallest")
    void getCountriesByPopulationDESCTest(){
        assertNotNull(county.getCountriesByPopulationDESC(0),"Asia");
    }

    @Test
    void getCountriesOnContinentByPopulationDESCTest(){

    }

    @Test
    void getCountriesInRegionByPopulationDESCTest(){

    }

    @Test
    void getCountriesOnContinentByPopulationDESCWithLimitTest(){

    }

    @Test
    void getCountriesOnContinentByPopulationDESCTestWithLimitTest(){

    }

    @Test
    void getCountriesInRegionByPopulationDESCTestWithLimitTest(){

    }

}
