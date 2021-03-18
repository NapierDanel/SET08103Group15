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
    public String getContinentPopulationProportionInCities(String continent) throws SQLException {
        int continentPopulation = getContinentPopulation(continent).getInt("population");
        int populationInCities = getCityPopulationInContinent(continent);
        int populationOutsideCities = continentPopulation - populationInCities;
        float percentInCities = (populationInCities * 100.0f) / continentPopulation;
        float percentOutsideCities = ((populationOutsideCities * 100.0f) / continentPopulation);
        return(continent + "    " +
                continentPopulation + "    " +
                populationInCities + "    " +
                percentInCities + "    " +
                populationOutsideCities + "    " +
                percentOutsideCities);
    }

    /**
     * Output the population of people in the region living in cities and living outside of cities in numbers and percentages
     * @param region the region name
     */
    public String getRegionPopulationProportionInCities(String region) throws SQLException {
        int regionPopulation = getRegionPopulation(region).getInt("population");
        int populationInCities = getCityPopulationInRegion(region).getInt("population");
        int populationOutsideCities = regionPopulation - populationInCities;
        float percentInCities = (populationInCities * 100.0f) / regionPopulation;
        float percentOutsideCities = ((populationOutsideCities * 100.0f) / regionPopulation);
        return (region + "    " +
                regionPopulation + "    " +
                populationInCities + "    " +
                percentInCities + "    " +
                populationOutsideCities + "    " +
                percentOutsideCities);
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
                    "SELECT co.name, co.population, SUM(ci.Population) AS 'inCities', (SUM(ci.Population) * 100 / co.Population) AS 'inCitiesPer', (co.Population - SUM(ci.Population)) AS 'notInCities', ((co.Population - SUM(ci.Population)) * 100 / co.Population) AS 'notInCitiesPer'"
                            + "FROM country co, city ci "
                            + "WHERE co.code = " + '\'' + code + '\''
                            + "AND co.Code = ci.CountryCode";
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
     * Return the population of people in the region living in cities
     * @param region the region name
     * @return the city population in given region
     */
    public ResultSet getCityPopulationInRegion(String region){
        try {
            int population;
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(ci.Population) AS population "
                            + "FROM country co, city ci "
                            + "WHERE co.region = " + '\''+ region + '\''
                            + "AND co.Code = ci.CountryCode";
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
     * Return the population of people in the continent living in cities
     * @param continent the continent name
     * @return the city population in given continent
     */
    public int getCityPopulationInContinent(String continent){
        try {
            int population;
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(ci.Population) AS population "
                            + "FROM country co, city ci "
                            + "WHERE co.continent = " + '\''+ continent + '\''
                            + "AND co.Code = ci.CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                return rset.getInt("population");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return 0;
        }
        return 0;
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
        }
        return null;
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
        }
        return null;
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
        }
        return null;
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
        }
        return null;
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
        }
        return null;
    }

    /**
     * Output the population of the city
     * @param id the city id
     */
    public ResultSet getCityPopulation(int id) {
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
        }
        return null;
    }

}
