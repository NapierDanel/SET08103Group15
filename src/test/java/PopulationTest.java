import com.napier.sem.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class PopulationTest {
    static Population population;

    @BeforeAll
    static void init() {
        population = new Population();
    }

    @Test
    void getContinentPopulationProportionInCitiesTest() throws SQLException {
        //assertNotNull(population.getContinentPopulationProportionInCities("Africa"));
    }

    @Test
    void getRegionPopulationProportionInCitiesTest() throws SQLException {
        //assertNotNull(population.getRegionPopulationProportionInCities("Southeast Asia"));
    }

    @Test
    void getCountryPopulationProportionInCities() {
        //assertNotNull(population.getCountryPopulationProportionInCities("SAU"));
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
}
