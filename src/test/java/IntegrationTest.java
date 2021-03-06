import com.napier.sem.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    static Population population;
    static Country county;
    static CapitalCity capitalcity;
    static City city;
    static UtilityClass utilityClass;

    @BeforeAll
    static void init() {
        population = new Population();
        county = new Country();
        capitalcity = new CapitalCity();
        city = new City();
        utilityClass = new UtilityClass();
    }

    @Test
    @DisplayName("The export csv file exists")
    void testCSV() {
        utilityClass.exportCSV("bar", population.getContinentPopulation("Frankreich"));
        File tmpDir = new File("./bar.csv");
        assertTrue(tmpDir.exists());
    }

    @Test
    @DisplayName("Provides all the countries in the world organised by largest population to smallest")
    void getCountriesByPopulationDESCTest() throws SQLException {
        assertNotNull(county.getCountriesByPopulationDESC("0"));
    }

    @Test
    @DisplayName("All the countries in a region organised by largest population to smallest.")
    void getCountriesInRegionByPopulationDESCTest() {
        assertNotNull(county.getCountriesInRegionByPopulationDESC("0", "Middle East"));
    }

    @Test
    @DisplayName("The top N populated countries in the world where N is provided by the user.")
    void getCountriesOnContinentByPopulationDESCWithLimitTest() {
        assertNotNull(county.getCountriesByPopulationDESC("3"));
    }

    @Test
    @DisplayName("The top N populated countries in a continent where N is provided by the user.")
    void getCountriesOnContinentByPopulationDESCTestWithLimitTest() {
        assertNotNull(county.getCountriesInRegionByPopulationDESC("3", "Asia"));
    }

    @Test
    @DisplayName("Print country Test")
    void printCountryTest() {

    }

    @Test
    @DisplayName("Provides All the countries in a continent organised by largest population to smallest. getCountriesOnContinentByPopulationDESC ")
    void getCountriesOnContinentByPopulationDESCTest() {
        assertNotNull(county.getCountriesOnContinentByPopulationDESC("10", "Europe"));
    }

    @Test
    @DisplayName("Provides All the countries in a continent organised by largest population to smallest. getCountriesOnContinentByPopulationDESC ")
    void getCountriesOnContinentByPopulationDESCTestNull() {
        assertNull(county.getCountriesOnContinentByPopulationDESC(null, "Europe"));
    }

    @Test
    @DisplayName("The top N populated countries in a region where N is provided by the user.")
    void getCountriesInRegionByPopulationDESCTestWithLimitTest() {
        assertNotNull(county.getCountriesInRegionByPopulationDESC("4", "Middle East"));
    }

    // Population Test

    @Test
    @DisplayName("Return the population of language speakers.")
    void getPopulationOfLanguageSpeakersTest() {
        assertNotNull(population.getPopulationOfLanguageSpeakers());
    }

    @Test
    @DisplayName("Return the continent population proportion of people living in cities.")
    void getContinentPopulationProportionInCitiesTest() {
        assertNotNull(population.getContinentPopulationProportionInCities("Europe"));
    }

    @Test
    @DisplayName("Return the continent population proportion of people living in cities.")
    void getContinentPopulationProportionInCitiesException() {
        assertNull(population.getContinentPopulationProportionInCities(null));
    }

    @Test
    @DisplayName("Return the region population proportion of people living in cities.")
    void getRegionPopulationProportionInCitiesTest() {
        assertNotNull(population.getRegionPopulationProportionInCities("Southeast Asia"));
    }

    @Test
    @DisplayName("Return the region population proportion of people living in cities.")
    void getRegionPopulationProportionInCitiesException() {
        assertNull(population.getRegionPopulationProportionInCities(null));
    }

    @Test
    @DisplayName("Return the country population proportion of people living in cities.")
    void getCountryPopulationProportionInCities() {
        assertNotNull(population.getCountryPopulationProportionInCities("SAU"));
    }

    @Test
    @DisplayName("Return the country population proportion of people living in cities.")
    void getCountryPopulationProportionInCitiesException() {
        assertNull(population.getCountryPopulationProportionInCities(null));
    }

    @Test
    @DisplayName("Return world population.")
    void getWorldPopulationTest() {
        assertNotNull(population.getWorldPopulation());
    }

    @Test
    @DisplayName("Return the continent population.")
    void getContinentPopulationTest() {
        assertNotNull(population.getContinentPopulation("Europe"));
    }

    @Test
    @DisplayName("Test the continent population exceptions")
    void testGetContinentPopulationExceptions() {
        assertNull(population.getContinentPopulation(null));
    }

    @Test
    @DisplayName("Return the region population.")
    void getRegionPopulationTest() {
        assertNotNull(population.getRegionPopulation("Eastern Europe"));
    }

    @Test
    @DisplayName("Test the region population exceptions")
    void testGetRegionPopulationExceptions() {
        assertNull(population.getRegionPopulation(null));
    }

    @Test
    @DisplayName("Return the country population.")
    void getCountryPopulationTest() {
        assertNotNull(population.getCountryPopulation("HKG"));
    }

    @Test
    @DisplayName("Test the country population exceptions")
    void testGetCountryPopulationExceptions() {
        assertNull(population.getCountryPopulation(null));
    }

    @Test
    @DisplayName("Return the district population.")
    void getDistrictPopulationTest() {
        assertNotNull(population.getDistrictPopulation("Distrito Federal"));
    }

    @Test
    @DisplayName("Test the district population exceptions")
    void testGetDistrictPopulationExceptions() {
        assertNull(population.getDistrictPopulation(null));
    }

    @Test
    @DisplayName("Return the city population.")
    void getCityPopulationTest() {
        assertNotNull(population.getCityPopulation("5"));
    }

    @Test
    @DisplayName("Test the city population exceptions")
    void testGetCityPopulationExceptions() {
        assertNull(population.getCityPopulation(null));
    }

    // Capital City Tests
    @Test
    @DisplayName("Display the highest to lowest populated capital cities in the world.")
    void getCapCityWorldPop() {
        assertNotNull(capitalcity.getCapCityWorldPop());
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given continent.")
    void getCapCityContPop() {
        assertNotNull(capitalcity.getCapCityContPop("Asia"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given continent.")
    void getFailCapCityContPop() {
        assertNull(capitalcity.getCapCityContPop(null));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given region.")
    void getCapCityRegPop() {
        assertNotNull(capitalcity.getCapCityRegPop("Eastern Europe"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given region.")
    void getFailCapCityRegPop() {
        assertNull(capitalcity.getCapCityRegPop(null));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a the world with a set limit.")
    void getCapCityWorldPopLimit() {
        assertNotNull(capitalcity.getCapCityWorldPopLimit("10"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a the world with a set limit.")
    void getFailCapCityWorldPopLimit() {
        assertNull(capitalcity.getCapCityWorldPopLimit(null));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given continent with a set limit.")
    void getCapCityContPopLimit() {
        assertNotNull(capitalcity.getCapCityContPopLimit("Asia", "10"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given continent with a set limit.")
    void getFailCapCityContPopLimit() {
        assertNull(capitalcity.getCapCityContPopLimit(null, null));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given region with a set limit.")
    void getCapCityRegPopLimit() {
        assertNotNull(capitalcity.getCapCityRegPopLimit("Eastern Europe", "10"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given region with a set limit.")
    void getFailCapCityRegPopLimit() {
        assertNull(capitalcity.getCapCityRegPopLimit(null, null));
    }

    // City Tests

    @Test
    @DisplayName("Provides all the cities in the world organised by largest population to smallest")
    void getAllCitiesInWorldDescTest() {
        assertNotNull(city.getAllCitiesInWorld("20"));
    }

    @Test
    @DisplayName("Provides all the cities in the world organised by largest population to smallest with Bad Input")
    void getAllCitiesInWorldDescTestExceptions() {
        assertNull(city.getAllCitiesInWorld(null));
    }


    @Test
    @DisplayName("Provides all the cities in a continent organised by largest population to smallest")
    void getCitiesInContinentDESCTest() {
        assertNotNull(city.getCitiesInContinent("Asia", "20"));
    }

    @Test
    @DisplayName("Provides all the cities in a continent organised by largest population to smallest with bad Input")
    void getCitiesInContinentDESCTestExceptions() {
        assertNull(city.getCitiesInContinent(null, null));
    }


    @Test
    @DisplayName("Provides all the cities in a region organised by largest population to smallest")
    void getCitiesInRegionDESCTest() {
        assertNotNull(city.getCitiesInRegion("Western Europe", "10"));
    }

    @Test
    @DisplayName("Provides all the cities in a region organised by largest population to smallest with bad input")
    void getCitiesInRegionDESCTestExceptions() {
        assertNull(city.getCitiesInRegion(null, null));
    }


    @Test
    @DisplayName("Provides all the cities in a country organised by largest population to smallest")
    void getCitiesInCountryDESCTest() {
        assertNotNull(city.getCitiesInCountry("Belgium", "10"));
    }

    @Test
    @DisplayName("Provides all the cities in a country organised by largest population to smallest with bad input")
    void getCitiesInCountryDESCTestExceptions() {
        assertNull(city.getCitiesInCountry(null, null));
    }


    @Test
    @DisplayName("Provides all the cities in a district organised by largest population to smallest")
    void getCitiesInDistrictDESCTest() {
        assertNotNull(city.getCitiesInDistrict("Distrito Federal", "2"));
    }

    @Test
    @DisplayName("Provides all the cities in a district organised by largest population to smallest with bad input")
    void getCitiesInDistrictDESCTestExceptions() {
        assertNull(city.getCitiesInDistrict(null, null));
    }

}
