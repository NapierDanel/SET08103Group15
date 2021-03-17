import com.napier.sem.CapitalCity;
import com.napier.sem.Country;
import com.napier.sem.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    static Population population;
    static Country county;
    static CapitalCity capitalcity;

    @BeforeAll
    static void init() {
        population = new Population();
        county = new Country();
        capitalcity = new CapitalCity();
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
    void getContinentPopulationProportionInCitiesTest() throws SQLException  {
        //assertNotNull(population.getContinentPopulationProportionInCities("Africa"));
    }

    @Test
    void getRegionPopulationProportionInCitiesTest() throws SQLException {
        //assertNotNull(population.getRegionPopulationProportionInCities("Southeast Asia"));
    }

    @Test
    void getCountryPopulationProportionInCities() {
        assertNotNull(population.getCountryPopulationProportionInCities("SAU"));
    }

    @Test
    void getWorldPopulationTest() {
        assertNotNull(population.getWorldPopulation());
    }

    @Test
    void getContinentPopulationTest() {
        assertNotNull(population.getContinentPopulation("Europe"));
    }

    @Test
    void getRegionPopulationTest() {
        assertNotNull(population.getRegionPopulation("Eastern Europe"));
    }

    @Test
    void getCountryPopulationTest() {
        assertNotNull(population.getCountryPopulation("HKG"));
    }

    @Test
    void getDistrictPopulationTest() {
        assertNotNull(population.getDistrictPopulation("Rio Grande do Norte"));
    }

    @Test
    void getCityPopulationTest() {
        assertNotNull(population.getCityPopulation(293));
    }

    @Test
    void getCapCityWorldPop()

    {
        assertNotNull(capitalcity.getCapCityWorldPop());
    }

}
