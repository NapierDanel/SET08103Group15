package com.napier.sem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Used to create the population reports
 */
public class Population {

    /**
     * Output the population of people on the continent living in cities and living outside of cities in numbers and percentages
     * @param continent the continent name
     */
    public ResultSet getContinentPopulationProportionInCities(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT co.Continent, continentPop.Population, cityPop.Population AS 'LivingInCities', (cityPop.Population * 100 / continentPop.Population) AS 'LivingInCitiesPercent', (continentPop.Population - cityPop.Population) AS 'LivingOutsideCities', ((continentPop.Population - cityPop.Population) * 100 / continentPop.Population) AS 'LivingOutsideCitiesPercent'"
                            + "FROM country co, city ci, (SELECT SUM(ci.population) AS Population FROM country co, city ci WHERE co.continent =  " + '\'' + continent + '\'' + " AND co.Code = ci.CountryCode) AS cityPop, (SELECT SUM(population) AS Population FROM country WHERE continent = " + '\'' + continent + '\'' + ") AS continentPop "
                            + "WHERE co.Continent = " + '\'' + continent + '\''
                            + "AND co.Code = ci.CountryCode "
                            + "LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent details");
        }
        return null;
    }

    /**
     * Output the population of people in the region living in cities and living outside of cities in numbers and percentages
     * @param region the region name
     */
    public ResultSet getRegionPopulationProportionInCities(String region) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT co.Region, regionPop.Population, cityPop.Population AS 'LivingInCities', (cityPop.Population * 100 / regionPop.Population) AS 'LivingInCitiesPercent', (regionPop.Population - cityPop.Population) AS 'LivingOutsideCities', ((regionPop.Population - cityPop.Population) * 100 / regionPop.Population) AS 'LivingOutsideCitiesPercent'"
                            + "FROM country co, city ci, (SELECT SUM(ci.population) AS Population FROM country co, city ci WHERE co.region ="  + '\'' + region + '\'' + " AND co.Code = ci.CountryCode) AS cityPop, (SELECT SUM(population) AS Population FROM country WHERE region = "  + '\'' + region + '\'' + " ) AS regionPop "
                            + "WHERE co.Region = " + '\'' + region + '\''
                            + "AND co.Code = ci.CountryCode "
                            + "LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region details");
        }
        return null;
    }

    /**
     * Output the population of people in the country living in cities and living outside of cities in numbers and percentages
     * @param code the country code
     */
    public ResultSet getCountryPopulationProportionInCities(String code) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT co.name, co.population, ci.Population AS 'LivingInCities', (SUM(ci.Population) * 100 / co.Population) AS 'LivingInCitiesPercent', (co.Population - SUM(ci.Population)) AS 'LivingOutsideCities', ((co.Population - SUM(ci.Population)) * 100 / co.Population) AS 'LivingOutsideCitiesPercent'"
                            + "FROM country co, city ci "
                            + "WHERE co.code = " + '\'' + code + '\''
                            + "AND co.Code = ci.CountryCode "
                            + "LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
        return null;
    }

    /**
     * Output the world population
     */
    public ResultSet getWorldPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS population "
                            + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Return the population of the continent
     * @param continentName the continent name
     * @return the continent population
     */
    public ResultSet getContinentPopulation(String continentName) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT continent, SUM(population) AS population "
                            + "FROM country "
                            + "WHERE continent = " + '\''+ continentName + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return  rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Return the population of the region
     * @param regionName the region name
     * @return the region population
     */
    public ResultSet getRegionPopulation(String regionName) {
        try {
            int population;
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT region, SUM(population) AS population "
                            + "FROM country "
                            + "WHERE region = " + '\''+ regionName + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Output the population of the continent
     * @param code the country code
     */
    public ResultSet getCountryPopulation(String code) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE code = " + '\''+ code + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Output the population of the district
     * @param districtName the district name
     */
    public ResultSet getDistrictPopulation(String districtName) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT district, SUM(population) AS population "
                            + "FROM city "
                            + "WHERE district = " + '\''+ districtName + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Output the population of the city
     * @param id the city id
     */
    public ResultSet getCityPopulation(String id) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "WHERE id = " + id;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

}
