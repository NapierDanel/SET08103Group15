package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Used to create the population reports
 */
public class Population {

    /**
     * Output the population of people on the continent living in cities and living outside of cities in numbers and percentages
     * @param continent the continent name
     */
    public void getContinentPopulationProportionInCities(String continent) {
        int continentPopulation = getContinentPopulation(continent);
        int populationInCities = getCityPopulationInContinent(continent);
        int populationOutsideCities = continentPopulation - populationInCities;
        float percentInCities = (populationInCities * 100.0f) / continentPopulation;
        float percentOutsideCities = ((populationOutsideCities * 100.0f) / continentPopulation);
        System.out.println(continent + "    " +
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
    public void getRegionPopulationProportionInCities(String region) {
        int regionPopulation = getRegionPopulation(region);
        int populationInCities = getCityPopulationInRegion(region);
        int populationOutsideCities = regionPopulation - populationInCities;
        float percentInCities = (populationInCities * 100.0f) / regionPopulation;
        float percentOutsideCities = ((populationOutsideCities * 100.0f) / regionPopulation);
        System.out.println(region + "    " +
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
    public void getCountryPopulationProportionInCities(String code) {
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
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("name") + "    " +
                        rset.getInt("population") + "    " +
                        rset.getInt("inCities") + "    " +
                        rset.getFloat("inCitiesPer") + "    " +
                        rset.getInt("notInCities") + "    " +
                        rset.getFloat("notInCitiesPer"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }

    /**
     * Return the population of people in the region living in cities
     * @param region the region name
     * @return the city population in given region
     */
    public int getCityPopulationInRegion(String region){
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
            // Return new employee if valid.
            // Check one is returned
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
            // Return new employee if valid.
            // Check one is returned
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
    public void getWorldPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS population "
                            + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getLong("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    /**
     * Return the population of the continent
     * @param continentName the continent name
     * @return the continent population
     */
    public int getContinentPopulation(String continentName) {
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
            // Return new employee if valid.
            // Check one is returned
            if (rset.next()) {
                int population = rset.getInt("population");
                System.out.println(rset.getString("continent") + "    " + population);
                return population;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
        return 0;
    }

    /**
     * Return the population of the region
     * @param regionName the region name
     * @return the region population
     */
    public int getRegionPopulation(String regionName) {
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
            // Return new employee if valid.
            // Check one is returned
            if (rset.next()) {
                population = rset.getInt("population");
                System.out.println(rset.getString("region") + "    " + population);
                return population;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
        return 0;
    }

    /**
     * Output the population of the continent
     * @param code the country code
     */
    public void getCountryPopulation(String code) {
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
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("name") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }

    /**
     * Output the population of the district
     * @param districtName the district name
     */
    public void getDistrictPopulation(String districtName) {
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
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("district") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    /**
     * Output the population of the city
     * @param id the city id
     */
    public void getCityPopulation(int id) {
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
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("name") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

}
