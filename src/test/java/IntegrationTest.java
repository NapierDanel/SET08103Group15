import com.napier.sem.CapitalCity;
import com.napier.sem.Country;
import com.napier.sem.Population;
import com.napier.sem.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IntegrationTest {
    static Population population;
    static Country county;
    static CapitalCity capitalcity;
    static City city;

    @BeforeAll
    static void init() {
        population = new Population();
        county = new Country();
        capitalcity = new CapitalCity();
        city = new City();
    }

    /**
    * Country Tests
    **/
    @Test
    @DisplayName("Provides all the countries in the world organised by largest population to smallest")
    void getCountriesByPopulationDESCTest() throws SQLException {
        assertNotNull(county.getCountriesByPopulationDESC(0));
    }

    @Test
    @DisplayName("All the countries in a continent organised by largest population to smallest.")
    void getCountriesOnContinentByPopulationDESCTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(0,"Asia"));
    }

    @Test
     @DisplayName("All the countries in a region organised by largest population to smallest.")
    void getCountriesInRegionByPopulationDESCTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(0,"Middle East"));
    }

    @Test
     @DisplayName("The top N populated countries in the world where N is provided by the user.")
    void getCountriesOnContinentByPopulationDESCWithLimitTest(){
        assertNotNull(county.getCountriesByPopulationDESC(3));
    }

    @Test
     @DisplayName("The top N populated countries in a continent where N is provided by the user.")
    void getCountriesOnContinentByPopulationDESCTestWithLimitTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(3,"Asia"));
    }

    @Test
     @DisplayName("The top N populated countries in a region where N is provided by the user.")
    void getCountriesInRegionByPopulationDESCTestWithLimitTest(){
        assertNotNull(county.getCountriesInRegionByPopulationDESC(4,"Middle East"));
    }

    @Test
    @DisplayName("Return the continent population proportion of people living in cities.")
    void getContinentPopulationProportionInCitiesTest() throws SQLException  {
        assertNotNull(population.getContinentPopulationProportionInCities("Europe"));
    }

    @Test
    @DisplayName("Return the region population proportion of people living in cities.")
    void getRegionPopulationProportionInCitiesTest() throws SQLException {
        assertNotNull(population.getRegionPopulationProportionInCities("Southeast Asia"));
    }

    @Test
    @DisplayName("Return the country population proportion of people living in cities.")
    void getCountryPopulationProportionInCities() {
        assertNotNull(population.getCountryPopulationProportionInCities("SAU"));
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
    @DisplayName("Return the region population.")
    void getRegionPopulationTest() {
        assertNotNull(population.getRegionPopulation("Eastern Europe"));
    }

    @Test
    @DisplayName("Return the country population.")
    void getCountryPopulationTest() {
        assertNotNull(population.getCountryPopulation("HKG"));
    }

    @Test
    @DisplayName("Return the district population.")
    void getDistrictPopulationTest() {
        assertNotNull(population.getDistrictPopulation("Rio Grande do Norte"));
    }

    @Test
    @DisplayName("Return the city population.")
    void getCityPopulationTest() {
        assertNotNull(population.getCityPopulation(293));
    }

    // Capital City Tests
    @Test
    @DisplayName("Display the highest to lowest populated capital cities in the world.")
    void getCapCityWorldPop()
    {
        assertNotNull(capitalcity.getCapCityWorldPop());
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given continent.")
    void getCapCityContPop()
    {
        assertNotNull(capitalcity.getCapCityContPop("Asia"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given region.")
    void getCapCityRegPop()
    {
        assertNotNull(capitalcity.getCapCityRegPop("Eastern Europe"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a the world with a set limit.")
    void getCapCityWorldPopLimit()
    {
        assertNotNull(capitalcity.getCapCityWorldPopLimit("10"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given continent with a set limit.")
    void getCapCityContPopLimit()
    {
        assertNotNull(capitalcity.getCapCityContPopLimit("Asia", "10"));
    }

    @Test
    @DisplayName("Display the highest to lowest populated capital cities in a given region with a set limit.")
    void get CapCityRegPopLimit()
    {
        assertNotNull(capitalcity.getCapCityRegPopLimit("Eastern Europe", "10"));
    }

    // City Tests
    @Test
    void getCityTest()
    {
        assertNotNull(city.getCity(1));
    }

    @Test
    void getAllCitiesInWorldDescTest()
    {
        assertNotNull(city.getAllCitiesInWorld("20"));
    }

    @Test
    void getCitiesInContinentDESCTest()
    {
        assertNotNull(city.getCitiesInContinent("Asia", "20"));
    }

    @Test
    void getCitiesInRegionDESCTest()
    {
        assertNotNull(city.getCitiesInRegion("Western Europe", "10"));
    }

    @Test
    void getCitiesInCountryDESCTest()
    {
        assertNotNull(city.getCitiesInCountry("Belgium", "10"));
    }

    @Test
    void getCitiesInDistrictDESCTest()
    {
        assertNotNull(city.getCitiesInDistrict("Distrito Federal", "2"));
    }


}
