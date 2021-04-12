package com.napier.sem;

import java.sql.*;

/**
 * The main class where all other classes are instantiated
 */
public class App {

    /**
     * The main instantiates the main classes and creates a link to the database
     * @param args     Currently not in use
     */
    public static void main(String[] args)
    {

        // Create a new DatabaseLink class, containing connect and disconnect functionality, and database interactions
        DatabaseLink db = new DatabaseLink();

        // Create a new UtilityClass class, containing some useful methods
        UtilityClass uc = new UtilityClass();

        // Connects to the database
        DatabaseLink.connInstance();

        // The following code gives an example of how the ResultSet datatype will be accessed
        City city = new City();
        Country country = new Country();
        CapitalCity capitalCity = new CapitalCity();
        Population population = new Population();


        // City Reports

        uc.exportCSV("noice", city.getAllCitiesInWorld("20"));



        // Country Report

        // CapitalCity Reports
        uc.exportCSV("capCityWorldPop", capitalCity.getCapCityWorldPop());
        uc.exportCSV("capCityContPop", capitalCity.getCapCityContPop("Africa"));
        uc.exportCSV("capCityRegPop", capitalCity.getCapCityRegPop("North America"));
        uc.exportCSV("capCityWorldPopLimit", capitalCity.getCapCityWorldPopLimit("10"));
        uc.exportCSV("capCityContPopLimit", capitalCity.getCapCityContPopLimit("Africa", "10"));
        uc.exportCSV("capCityRegPopLimit", capitalCity.getCapCityRegPopLimit("North America", "10"));


        // Population Reports
        uc.exportCSV("worldPopulation", population.getWorldPopulation());
        uc.exportCSV("continentPopulation", population.getContinentPopulation("Africa"));
        uc.exportCSV("regionPopulation", population.getRegionPopulation("North America"));
        uc.exportCSV("countryPopulation", population.getCountryPopulation("BGR"));
        uc.exportCSV("districtPopulation", population.getDistrictPopulation("Noord-Holland"));
        uc.exportCSV("cityPopulation", population.getCityPopulation("25"));
        uc.exportCSV("continentPopulationProportionInCities", population.getContinentPopulationProportionInCities("Africa"));
        uc.exportCSV("regionPopulationProportionInCities", population.getRegionPopulationProportionInCities("North America"));
        uc.exportCSV("countryPopulationProportionInCities", population.getCountryPopulationProportionInCities("BGR"));

        // Disconnect from database
        db.disconnect();



    }




}