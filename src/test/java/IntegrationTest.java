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
    void getContinentPopulationProportionInCitiesTest() throws SQLException  {
        assertNotNull(population.getContinentPopulationProportionInCities("Europe"));
    }

    @Test
    void getRegionPopulationProportionInCitiesTest() throws SQLException {
        assertNotNull(population.getRegionPopulationProportionInCities("Southeast Asia"));
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

    @Test
    void getCapCityContPop()
    {
        assertNotNull(capitalcity.getCapCityContPop("Asia"));
    }

    @Test
    void getCapCityRegPop()

    {
        assertNotNull(capitalcity.getCapCityRegPop("Eastern Europe"));
    }

    @Test
    void getCapCityWorldPopLimit() { assertNotNull(capitalcity.getCapCityWorldPopLimit("10")); }

    @Test
    void getCapCityContPopLimit()

    {
        assertNotNull(capitalcity.getCapCityContPopLimit("Asia", "10"));
    }


    // City Tests
    @Test
    @DisplayName("Get a city by its ID")
    void getCityTest()
    {
        assertNotNull(city.getCity(1));
    }

    @Test
    @DisplayName("Provides all the cities in the world organised by largest population to smallest")
    void getAllCitiesInWorldDescTest()
    {
        assertNotNull(city.getAllCitiesInWorld("20"));
    }

    @Test
    @DisplayName("Provides all the cities in a continent organised by largest population to smallest")
    void getCitiesInContinentDESCTest()
    {
        assertNotNull(city.getCitiesInContinent("Asia", "20"));
    }

    @Test
    @DisplayName("Provides all the cities in a region organised by largest population to smallest")
    void getCitiesInRegionDESCTest()
    {
        assertNotNull(city.getCitiesInRegion("Western Europe", "10"));
    }

    @Test
    @DisplayName("Provides all the cities in a country organised by largest population to smallest")
    void getCitiesInCountryDESCTest()
    {
        assertNotNull(city.getCitiesInCountry("Belgium", "10"));
    }

    @Test
    @DisplayName("Provides all the cities in a district organised by largest population to smallest")
    void getCitiesInDistrictDESCTest()
    {
        assertNotNull(city.getCitiesInDistrict("Distrito Federal", "2"));
    }


}
