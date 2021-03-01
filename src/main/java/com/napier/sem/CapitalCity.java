package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// This class will create the CapitalCity objects, for later use
class CapitalCity extends City {
    /**
     *
     * @param id
     * @return
     */

    public CapitalCity getCapitalcity(int id) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT id, name, countryCode, district, population "
                            + "FROM city "
                            + "WHERE id = " + id;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next()) {
                CapitalCity capcity = new CapitalCity();
                capcity.id = rset.getInt("id");
                capcity.name = rset.getString("name");
                capcity.countryCode = rset.getString("countryCode");
                capcity.population = rset.getInt("population");


                return capcity;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }

    public void getCapCityWorldPop()
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
            // Check one is returned
//            while (rset.next())
//            {
//                System.out.println(rset.getString("CityName") + " " +
//                        rset.getString("CountryName") + " " +
//                        rset.getInt("population"));
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void getCapCityContPop(String continentName)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population, "
                            + "FROM city ci "
                            + "WHERE continent = " + '\'' + continentName + '\''
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY ci.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
            // Check one is returned
//            while (rset.next())
//            {
//                System.out.println(rset.getString("CityName") + " " +
//                        rset.getString("CountryName") + " " +
//                        rset.getDouble("population"));
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return 0;
    }

    public void getCapCityRegPop(String regionName)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population, "
                            + "FROM city ci "
                            + "WHERE region = " + '\'' + regionName + '\''
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY ci.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
            // Check one is returned
//            while (rset.next())
//            {
//                System.out.println(rset.getString("CityName") + " " +
//                        rset.getString("CountryName") + " " +
//                        rset.getDouble("population"));
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return 0;
    }

    public void getCapCityWorldPopLimit(String limit)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limit = Integer.parseInt(limit);

            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC "
                            + "LIMIT " limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
            // Check one is returned
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
        }
        return 0;
    }

    public void getCapCityContPop(String continentName, String limit)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limit = Integer.parseInt(limit);

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population, "
                            + "FROM city ci "
                            + "WHERE continent = " + '\'' + continentName + '\''
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY ci.population DESC "
                            + "LIMIT " limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
            // Check one is returned
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
        }
        return 0;


    }

    public void getCapCityContPop(String regiontName, String limit)
    {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limit = Integer.parseInt(limit);

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population, "
                            + "FROM city ci "
                            + "WHERE continent = " + '\'' + regionName + '\''
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY ci.population DESC "
                            + "LIMIT " limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            return rset;
            // Check one is returned
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
        }
        return 0;

    }
}


