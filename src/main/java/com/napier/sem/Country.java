package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

// Still to be used this class
class Country {
    public String code;
    public String name;
    public String continent;
    public String region;
    public int population;
    public double surfaceArea;
    public double lifeExpectancy;
    public double gnp;
    public double gnpOld;
    public String localName;
    public String governmentForm;
    public String headOfState;
    public int capital;
    public String code2;

    /**
     * Prints the given country
     *
     * @param country
     */
    private void printCountry(Country country) {
        System.out.println(country.code + "\t" + country.name + "\t" + country.continent + "\t" + country.region);
    }


    private void makeDatabaseCall(String strSelect) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

                printCountry(country);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    /**
     * Provides all the countries in the world organised by largest population to smallest.
     */
    public void getCountriesByPopulationDESC() {

        String strSelect =
                "SELECT code, name, continent, region, population, capital "
                        + "FROM country "
                        + "ORDER BY Population DESC";

        makeDatabaseCall(strSelect);
    }

    /**
     * Provides All the countries in a continent organised by largest population to smallest.
     */
    public void getCountriesOnContinentByPopulationDESC() {
        String strSelect =
                "SELECT code, name, continent, region, population, capital "
                        + "FROM country "
                        + "ORDER BY Population DESC";

        makeDatabaseCall(strSelect);
    }


}