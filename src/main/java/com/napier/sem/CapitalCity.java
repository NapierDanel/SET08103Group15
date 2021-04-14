package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// This class will create the CapitalCity objects, for later use
public class CapitalCity extends City {

    /**
     * Output the highest to lowest populated capital cities in the world
     */
    public ResultSet getCapCityWorldPop()
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY ci.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return null;
    }

    /**
     * Output the highest to lowest populated capital cities in a given continent
     * @param continentName
     */
    public ResultSet getCapCityContPop(String continentName)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + " WHERE continent = " + '\'' + continentName + '\''
                            + "ORDER BY ci.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return null;
    }

    /**
     * Output the highest to lowest populated capital cities in a given region
     * @param regionName
     */
    public ResultSet getCapCityRegPop(String regionName)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + " WHERE region = " + '\'' + regionName + '\''
                            + "ORDER BY ci.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return null;
    }

    /**
     * Output the highest to lowest populated capital cities in a the world with a set limit
     * @param limitInput
     */
    public ResultSet getCapCityWorldPopLimit(String limitInput)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limit = Integer.parseInt(limitInput);

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', Population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
        }
        return null;
    }

    /**
     * Output the highest to lowest populated capital cities in a given continent with a set limit
     * @param continentName
     * @param limitInput
     */
    public ResultSet getCapCityContPopLimit(String continentName, String limitInput)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limit = Integer.parseInt(limitInput);

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + " WHERE continent = " + '\'' + continentName + '\''
                            + "ORDER BY ci.population DESC "
                            + "LIMIT " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
        }
        return null;
    }

    /**
     * Output the highest to lowest populated capital cities in a given region with a set limit
     * @param regionName
     * @param limitInput
     */


    public ResultSet getCapCityRegPopLimit(String regionName, String limitInput)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limit = Integer.parseInt(limitInput);

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + " WHERE continent = " + '\'' + regionName + '\''
                            + "ORDER BY ci.population DESC "
                            + "LIMIT " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
        }
        return null;
    }
}


