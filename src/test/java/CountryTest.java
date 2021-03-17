import com.napier.sem.Country;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CountryTest {

    static Country county;

    @BeforeAll
    static void init(){
        county = new Country();
    }

    @Test
    @DisplayName("Provides all the countries in the world organised by largest population to smallest")
    void getCountriesByPopulationDESCTest() throws SQLException {
        assertNotNull(county.getCountriesByPopulationDESC(0));
    }

    @Test
    void getCountriesOnContinentByPopulationDESCTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(0,"Asia"));
    }

    @Test
    void getCountriesInRegionByPopulationDESCTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(0,"Middle East"));
    }

    @Test
    void getCountriesOnContinentByPopulationDESCWithLimitTest(){
        assertNotNull(county.getCountriesByPopulationDESC(3));
    }

    @Test
    void getCountriesOnContinentByPopulationDESCTestWithLimitTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(3,"Asia"));
    }

    @Test
    void getCountriesInRegionByPopulationDESCTestWithLimitTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(4,"Middle East"));
    }

}
