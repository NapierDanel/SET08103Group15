package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

// Still to be used this class
public class Country {

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
     * @param country the country who
     */
    public String printCountry(Country country) {
        System.out.println(country.code + "\t" + country.name + "\t" + country.continent + "\t" + country.region);
        return country.name;
    }


    /**
     * Make a database call and  print attributes
     *
     * @param strSelect SQL query
     */
    private ResultSet makeDatabaseCall(String strSelect) {

        ResultSet rset;

        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
        return null;
    }

    /**
     * Provides all the countries in the world organised by largest population to smallest.
     */
    public ResultSet getCountriesByPopulationDESC(String limitInput) {

        if (limitInput == null) {
            return null;
        }

        int limit;

        try {
            limit = Integer.parseInt(limitInput);
        } catch (NumberFormatException e) {
            return null;
        }

        String strSelect;

        if (limit == 0) {
            strSelect = "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "ORDER BY Population DESC";
        } else {
            strSelect = "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "ORDER BY Population DESC "
                    + "LIMIT " + limit;
        }
        return makeDatabaseCall(strSelect);
    }

    /**
     * Provides All the countries in a continent organised by largest population to smallest.
     */
    public ResultSet getCountriesOnContinentByPopulationDESC(String limitInput, String continent) {


        if (limitInput == null) {
            return null;
        }

        String strSelect;
        int limit;

        try {
            limit = Integer.parseInt(limitInput);
        } catch (NumberFormatException e) {
            return null;
        }

        if (limit == 0) {
            strSelect = "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "where continent = " + '\'' + continent + '\''
                    + " "
                    + "ORDER BY Population DESC";
        } else {
            strSelect = "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "where continent = " + '\'' + continent + '\''
                    + " "
                    + "ORDER BY Population DESC "
                    + "LIMIT " + limit;
        }
        return makeDatabaseCall(strSelect);
    }

    /**
     * Provides all the countries in a region organised by largest population to smallest.
     */
    public ResultSet getCountriesInRegionByPopulationDESC(String limitInput, String region) {

        if (limitInput == null) {
            return null;
        }

        String strSelect;
        int limit;

        try {
            limit = Integer.parseInt(limitInput);
        } catch (NumberFormatException e) {
            return null;
        }


        if (limit == 0) {
            strSelect = "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "where region = " + '\'' + region + '\''
                    + " "
                    + "ORDER BY Population DESC ";
        } else {
            strSelect = "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "where region = " + '\'' + region + '\''
                    + " "
                    + "ORDER BY Population DESC "
                    + "LIMIT " + limit;
        }
        return makeDatabaseCall(strSelect);
    }
}