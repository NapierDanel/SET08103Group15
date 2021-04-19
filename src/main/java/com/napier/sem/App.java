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


        // City Reports with limits

        uc.exportCSV("allCitiesInWorldReport", city.getAllCitiesInWorld("20"));
        uc.exportCSV("citiesInContinentReport", city.getCitiesInContinent("Asia","20"));
        uc.exportCSV("citiesInRegionReport", city.getCitiesInRegion("Southern Europe","20"));
        uc.exportCSV("citiesInCountryReport", city.getCitiesInCountry("Singapore","20"));
        uc.exportCSV("citiesInDistrictReport", city.getCitiesInDistrict("Abu Dhabi","20"));

        // City Reports without limits

        uc.exportCSV("allCitiesInWorldReportNoLimit", city.getAllCitiesInWorld("0"));
        uc.exportCSV("citiesInContinentReportNoLimit", city.getCitiesInContinent("Asia","0"));
        uc.exportCSV("citiesInRegionReportNoLimit", city.getCitiesInRegion("Southern Europe","0"));
        uc.exportCSV("citiesInCountryReportNoLimit", city.getCitiesInCountry("Singapore","0"));
        uc.exportCSV("citiesInDistrictReportNoLimit", city.getCitiesInDistrict("Abu Dhabi","0"));



        // Country Report
        uc.exportCSV("LIMIT_countryReportsGetCountriesByPopulationDESC", country.getCountriesByPopulationDESC(20));
        uc.exportCSV("LIMIT_countryReportsGetCountriesInRegionByPopulationDESC", country.getCountriesInRegionByPopulationDESC(20, "North America"));
        uc.exportCSV("LIMIT_countryReportsGetCountriesOnContinentByPopulationDESC", country.getCountriesOnContinentByPopulationDESC(20, "Africa"));
        uc.exportCSV("countryReportsGetCountriesByPopulationDESC", country.getCountriesByPopulationDESC(0));
        uc.exportCSV("countryReportsGetCountriesInRegionByPopulationDESC", country.getCountriesInRegionByPopulationDESC(0,"North America"));
        uc.exportCSV("countryReportsGetCountriesOnContinentByPopulationDESC", country.getCountriesOnContinentByPopulationDESC(0, "Africa"));

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
        uc.exportCSV("continentPopulationProportionInCities", population.getContinentPopulationProportionInCities("Europe"));
        uc.exportCSV("regionPopulationProportionInCities", population.getRegionPopulationProportionInCities("North America"));
        uc.exportCSV("countryPopulationProportionInCities", population.getCountryPopulationProportionInCities("BGR"));
        uc.exportCSV("populationOfLanguageSpeakers", population.getPopulationOfLanguageSpeakers());

        // Disconnect from database
        db.disconnect();



    }




}